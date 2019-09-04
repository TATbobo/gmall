package gmall.service;


import gmall.bean.UmsMember;
import gmall.bean.UmsMemberReceiveAddress;

import java.util.List;

public interface UserService{

    List<UmsMember> getAllUser();

    List<UmsMemberReceiveAddress> getUserAddressByMemberId(String memberId);
}
