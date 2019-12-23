import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import pers.javid.mall.MallMasterAplication;
import pers.javid.mall.service.RedisService;

/**
 * @author ：javid
 * @date ：Created in 2019-8-20
 * @description：$redis测试类、
 * @version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MallMasterAplication.class)
@WebAppConfiguration
public class RedisTest {
    @Autowired
    private RedisService redisService;

    @Test
    public void redisTest(){
        redisService.set("a","javid");
        Assert.assertEquals("javid",redisService.get("a"));
    }

}
