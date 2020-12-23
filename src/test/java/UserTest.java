import com.study.spmvc.bean.User;
import com.study.spmvc.mappers.IUserMapper;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.StringUtils;

import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)        //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserTest {
    private static Logger logger = Logger.getLogger(UserTest.class);

    @Autowired
    public IUserMapper userMapper;

    /**
     * Public Key Retrieval is not allowed  mysql 8.5版本问题，可参考db.properties
     * SpringManagedTransaction.getTimeout()Ljava/lang/Integer;  --- spring 版本和spring-mybatis 版本对不上！
     */
    @Test
    public void addUser() {
        UUID uuid = UUID.randomUUID();
        User user = new User();
        user.setAge("1");
        user.setName("11");
        user.setId(uuid.toString());
        user.setPassword("complocated");
        int i = userMapper.addUser(user);
        if (i > 0) {
            logger.info("添加成功！");
        } else {
            logger.info("添加失敗！");
        }
    }


    @Test
    public void queryAll(){
        User user = new User();
        user.setName("张三");
        user.setPassword("12345");
        User user1 = userMapper.queryUserByNameAndPassword(user);
        logger.info(user1.getName());
    }

}
