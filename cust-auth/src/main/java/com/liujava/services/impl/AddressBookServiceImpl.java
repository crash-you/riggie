package com.liujava.services.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liujava.Enity.AddressBook;
import com.liujava.mapper.AddressBookMapper;
import com.liujava.services.AddressBookService;
import org.springframework.stereotype.Service;

@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook> implements AddressBookService {
}
