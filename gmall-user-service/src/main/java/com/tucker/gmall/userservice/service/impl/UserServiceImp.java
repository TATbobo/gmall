package com.tucker.gmall.userservice.service.impl;



import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.tucker.gmall.bean.UmsMember;
import com.tucker.gmall.bean.UmsMemberReceiveAddress;
import com.tucker.gmall.service.UserService;
import com.tucker.gmall.userservice.mapper.UmsMemberMapper;
import com.tucker.gmall.userservice.mapper.UmsMemberReceiveAddressMapper;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;



import java.util.List;

@Service(version = "${user.service.version}")
public class UserServiceImp implements UserService {


    @Autowired
    UmsMemberMapper umsMemberMapper;

    @Autowired
    UmsMemberReceiveAddressMapper umsMemberReceiveAddressMapper;

    @HystrixCommand()
    @Override
    public List<UmsMember> getAllUser(){
        /*throw new RuntimeException("com.tucker.gmall.service throw Exception");*/

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
