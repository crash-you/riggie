package com.liujava.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liujava.Enity.Category;
import com.liujava.Enity.Dish;
import com.liujava.Enity.Setmeal;
import com.liujava.mapper.CategoryMapper;
import com.liujava.services.CategoryService;
import com.liujava.services.DishService;
import com.liujava.services.SetMealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Autowired
    private DishService dishService;

    @Autowired
    private SetMealService setMealService;

    /**
     * 根据ID删除分类，删除之前需要进行判断
     * @param id
     */
    @Override
    public void remove(Long id) {

        //查询当前分类是否关联了菜品，如果关联，抛出一个异常
        LambdaQueryWrapper<Dish> dishLambdaQueryWrapper = new LambdaQueryWrapper<>();
        //添加查询条件，根据分类ID进行查询
        dishLambdaQueryWrapper.eq(Dish::getCategoryId,id);
        int count = (int) dishService.count(dishLambdaQueryWrapper);
        if(count > 0){
            //已经关联菜品，将抛出一个业务异常
            throw new RuntimeException("当前分类下关联了菜品，不能删除");
        }

        //查询当前分类是否关联了套餐，如果关联，抛出一个异常
        LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper = new LambdaQueryWrapper<>();
        setmealLambdaQueryWrapper.eq(Setmeal::getCategoryId,id);
        int count1 = (int) setMealService.count(setmealLambdaQueryWrapper);
        if(count1 > 0 ){
            throw new RuntimeException("当前分类下关联了套餐，不能删除");
        }
        //正常删除
        super.removeById(id);
    }



}
