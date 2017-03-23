package com.yonyou.ssc;



import com.yonyou.ssc.entry.City;
import com.yonyou.ssc.services.CityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * Created by zhangzza on 2017/3/2.
 * 进行单测试(spring boot 1.4. 之后的单测试形式)
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes=DemoSpringbootApplication.class)// 指定spring-boot的启动类
//相当于  --spring.profiles.active=dev
@ActiveProfiles(value="dev")
public class SampleAppTest {

    @Autowired
    private CityService cityService;
    @Autowired
    private Environment env;
    @Test
    public void testGetData()throws Exception{
        System.out.println("==========2:"+cityService.selectByCityId(2).toString());

    }

    @Test
    public void testSaveCity()throws Exception{
        City city=new City();
        city.setName("我是好强者222");
        city.setState("777333");
        city.setCountry("中国");
        city.setAddress("这是中国北京市海淀区！333");
        System.out.println("==========id=:"+cityService.saveCity(city));

    }

    @Test
    public void testProfile()throws Exception{
        System.out.println("profile="+env.getProperty("spring.datasource.url"));
    }
}
