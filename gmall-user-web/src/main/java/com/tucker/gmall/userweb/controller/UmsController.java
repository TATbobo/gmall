package com.tucker.gmall.userweb.controller;



import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import com.tucker.gmall.bean.UmsMemberReceiveAddress;
import com.tucker.gmall.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UmsController {


    @Reference(version = "${user.service.version}")
    UserService userService;

    @HystrixCommand(fallbackMethod = "hiHystrix")
    @GetMapping("/getAllUser")
    public List getAllUser(){
       return userService.getAllUser();
    }

    public String hiHystrix(){

        /*List list = new ArrayList();
        list.add("Exception has been throw by hystrix");*/
        return "Exception has been catch by method hiHystrix";
    }

    @GetMapping("/memberId/{memberId}")
    public List<UmsMemberReceiveAddress> getUserAddressByMemberId(@PathVariable String memberId){

        String sMemberId = String.valueOf(memberId);
        return userService.getUserAddressByMemberId(sMemberId);
    }
}
