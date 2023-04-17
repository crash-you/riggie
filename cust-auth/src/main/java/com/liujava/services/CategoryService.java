package com.liujava.services;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liujava.Enity.Category;
import com.liujava.Enity.Employee;


public interface CategoryService extends IService<Category> {
    public void remove(Long id);
}
