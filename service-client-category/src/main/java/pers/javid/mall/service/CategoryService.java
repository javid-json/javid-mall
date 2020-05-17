package pers.javid.mall.service;

import pers.javid.mall.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> selectAll();

    List<List<Category>> getIndexCat(int catlimit);
}
