package com.liujava.services.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liujava.Enity.DishFlavor;
import com.liujava.mapper.DishFlavorMapper;
import com.liujava.services.DishFlavorService;
import org.springframework.stereotype.Service;

@Service
public class DishFlavorServiceImpl extends ServiceImpl<DishFlavorMapper, DishFlavor> implements DishFlavorService {
}
