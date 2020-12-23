package com.study.spmvc.service.interfaces;

import com.study.spmvc.bean.User;

public interface IUserService {
    public int addUser(User user);

    public User queryUserByNameAndPassword(User user);
}
