package com.study.spmvc.mappers;

import com.study.spmvc.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserMapper {

    public int addUser(User user);

    public User queryUserByNameAndPassword(User user);

}
