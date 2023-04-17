package com.liujava.services.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liujava.Enity.Employee;
import com.liujava.mapper.EmployeeMapper;
import com.liujava.services.EmployService;
import org.springframework.stereotype.Service;

@Service
public class EmployServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployService {

}
