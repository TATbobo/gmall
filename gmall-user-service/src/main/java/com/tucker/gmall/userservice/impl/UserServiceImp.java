package com.tucker.gmall.userservice.impl;



import com.tucker.gmall.userservice.mapper.UmsMemberMapper;
import com.tucker.gmall.userservice.mapper.UmsMemberReceiveAddressMapper;
import gmall.bean.UmsMember;
import gmall.bean.UmsMemberReceiveAddress;
import gmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {


    @Autowired
    UmsMemberMapper umsMemberMapper;

    @Autowired
    UmsMemberReceiveAddressMapper umsMemberReceiveAddressMapper;

    @Override
    public List<UmsMember> getAllUser(){

        List<UmsMember> umsMembers = umsMemberMapper.selectAll();

        return umsMembers;
    }

    @Override
    public List<UmsMemberReceiveAddress> getUserAddressByMemberId(String memberId){



        UmsMemberReceiveAddress umsMemberReceiveAddress = new UmsMemberReceiveAddress();
        umsMemberReceiveAddress.setMemberId(memberId);

        List<UmsMemberReceiveAddress> umsMemberReceiveAddresses = umsMemberReceiveAddressMapper.select(umsMemberReceiveAddress);

        return umsMemberReceiveAddresses;
    }
}
