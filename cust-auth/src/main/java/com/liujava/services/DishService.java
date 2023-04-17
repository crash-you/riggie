package com.liujava.services;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liujava.Enity.Dish;
import com.liujava.dto.DishDto;


public interface DishService extends IService<Dish> {

    //新增菜品，同时插入菜品对应的口味数据，需要操作两张表：dish,dish_flavor
    public void saveWithFlavor(DishDto dishDto);

    //根据ID查询对应的菜品信息和口味信息
    public DishDto getByIdWithFlavor(Long id);

    //更新菜品信息，同时更新口味信息
    public void updateWithFlavor(DishDto dishDto);
}
