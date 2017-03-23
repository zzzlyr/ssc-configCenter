package com.yonyou.ssc.controller;


import com.yonyou.ssc.entry.ViewVo.ResultMsg;
import com.yonyou.ssc.services.CityService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by zzz on 2017/2/28.
 * Spring Boot应用中@RestController的Controller带有默认基于Jackson2的对象转JSON功能
 * <p/>
 * Spring也支持Spring MVC的Controler的使用方式。
 */
@RestController
public class LoginController {

    @Autowired
    private CityService cityService;

    //注册spring boot 激活不同的profile配置文件
    @Autowired
    private Environment env;

    @RequestMapping("/login")
    @ResponseBody
    public String login(@RequestParam(value = "cityId", required = true) String cityId) {
        try {
            System.out.println("====================cityId=" + cityId);
            return cityService.selectByCityId(Long.parseLong(cityId)).toString();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "这是测试数据，spring boot 真的很强大!";
    }


    @RequestMapping("/env")
    public String testProfile() {
        String ss=env.getProperty("profile");
        System.out.println(ss);
        return ss;
    }

    @RequestMapping("/json")
    public ResultMsg testJson() {
        List<String> list=new LinkedList<String>();
        list.add("json1sss");
        list.add("json24444");
        ResultMsg msg=new ResultMsg();
        msg.setDesc("这是测试json数据");
        msg.setFlag(true);
        msg.setData(list);
        return msg;
    }

}
