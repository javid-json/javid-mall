import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.javid.mall.MallMasterAplication;
import pers.javid.mall.dao.OrderMapper;
import pers.javid.mall.entity.Order;

/**
 * @author ：javid
 * @date ：Created in 2019-8-21
 * @description：订单测试类
 * @version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MallMasterAplication.class)
public class OrderTest {
    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void OrderInsertTest(){
        Order order = new Order();
        order.setProductId(2);
        order.setAddressId(1);
        order.setUserId(1);
        order.setStatus("0");
        int result = orderMapper.insert(order);
        Assert.assertEquals(Integer.valueOf(3),order.getOrderId());
    }
}
