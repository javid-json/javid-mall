package pers.javid.mall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.javid.mall.dao.ProductMapper;
import pers.javid.mall.dto.CommonResult;
import pers.javid.mall.entity.Product;
import pers.javid.mall.service.OrderService;
import pers.javid.mall.dao.OrderMapper;
import pers.javid.mall.entity.Order;
import pers.javid.mall.utils.CommonRuntimeException;
import pers.javid.mall.utils.GenerateNoUtils;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public int deleteByPrimaryKey(Integer orderId) {
        return orderMapper.deleteByPrimaryKey(orderId);
    }

    @Override
    public Object create(Order order) {
        Product product = productMapper.selectByPrimaryKey(order.getProductId());

        if(product == null && product.getStock() < 0){
            throw new CommonRuntimeException("库存不足");
        }

        order.setOrderNum(GenerateNoUtils.generateOrderNo());
        int result = orderMapper.insert(order);
        if(result > 0){
            return new CommonResult().success(order);
        }
        return new CommonResult().faild();
    }

    @Override
    public Object cancel(Integer orderId){
        Order order = orderMapper.selectByPrimaryKey(orderId);

        if(null != order){
            if("2".equals(order.getStatus())){
                return new CommonResult().faild("订单已支付");
            }
            if("3".equals(order.getStatus())){
                return new CommonResult().faild("订单已取消");
            }
            order.setStatus("3");
            int count = orderMapper.updateByPrimaryKey(order);
            if(count > 0){
                return new CommonResult().success();
            }
        }
        return new CommonResult().faild();
    }

    @Override
    public Order selectByPrimaryKey(Integer orderId) {
        return orderMapper.selectByPrimaryKey(orderId);
    }

    @Override
    public int updateByPrimaryKey(Order record) {
        return orderMapper.updateByPrimaryKey(record);
    }
}
