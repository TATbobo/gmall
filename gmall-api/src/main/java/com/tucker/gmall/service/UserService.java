package com.tucker.gmall.service;



import com.tucker.gmall.bean.UmsMember;
import com.tucker.gmall.bean.UmsMemberReceiveAddress;

import java.util.List;

public interface UserService {

    List<UmsMember> getAllUser();

    List<UmsMemberReceiveAddress> getUserAddressByMemberId(String memberId);

}
