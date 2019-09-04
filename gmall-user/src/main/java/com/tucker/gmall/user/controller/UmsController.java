package com.tucker.gmall.user.controller;



import com.tucker.gmall.userservice.impl.UserServiceImp;
import gmall.bean.UmsMember;
import gmall.bean.UmsMemberReceiveAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UmsController {


    @Autowired
    UserServiceImp userServiceImp;

    @GetMapping("/getAllUser")
    public List<UmsMember> getAllUser(){
       return userServiceImp.getAllUser();
    }

    @GetMapping("/memberId/{memberId}")
    public List<UmsMemberReceiveAddress> getUserAddressByMemberId(@PathVariable String memberId){

        String sMemberId = String.valueOf(memberId);
        return userServiceImp.getUserAddressByMemberId(sMemberId);
    }
}
