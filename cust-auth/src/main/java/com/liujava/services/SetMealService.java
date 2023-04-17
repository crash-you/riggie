package com.liujava.services;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liujava.Enity.Setmeal;
import com.liujava.dto.SetmealDto;

import java.util.List;

/**
 * 新增套餐，同时保存套餐和菜品的关联关系
 */
public interface SetMealService extends IService<Setmeal> {
    public void saveWithDish(SetmealDto setmealDto);

    /**
     * 删除套餐的同时删除菜品表
     * @param ids
     */
    public void removeWithDish(List<Long> ids);
}
