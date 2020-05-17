package pers.javid.mall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.javid.mall.dao.CategoryMapper;
import pers.javid.mall.entity.Category;
import pers.javid.mall.entity.CategoryExample;
import pers.javid.mall.service.CategoryService;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> selectAll() {
        return categoryMapper.selectByExample(new CategoryExample());
    }
}
