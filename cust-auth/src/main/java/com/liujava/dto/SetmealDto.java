package com.liujava.dto;

import com.liujava.Enity.Setmeal;
import com.liujava.Enity.SetmealDish;
import lombok.Data;
import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
