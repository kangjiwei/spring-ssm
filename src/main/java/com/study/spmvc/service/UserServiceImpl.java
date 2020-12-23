package com.study.spmvc.service;

import com.alibaba.druid.util.StringUtils;
import com.study.spmvc.bean.User;
import com.study.spmvc.mappers.IUserMapper;
import com.study.spmvc.service.interfaces.IUserService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class UserServiceImpl implements IUserService {
    private static Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    public IUserMapper userMapper;


    @Override
    @Transactional
    public int addUser(User user) {
        logger.info(user.toString());
        int resultInt = 0;
        try {
            resultInt = userMapper.addUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultInt;
    }

    @Override
    public User queryUserByNameAndPassword(User user) {
        return userMapper.queryUserByNameAndPassword(user);
    }


    /*     SqlSession session = sqlSessionFactory.openSession(false); // 打开会话，事务开始

            try {
                IUserMapper mapper = session.getMapper(IUserMapper.class);
                int affectedCount2 = mapper.addUser(user); // 因后面的异常而未执行commit语句
                session.commit(); // 提交会话，即事务提交
            } finally {
                session.close(); // 关闭会话，释放资源
            }
            int resultInt = 0;
        return resultInt;*/

}
