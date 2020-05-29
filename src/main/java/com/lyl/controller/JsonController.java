package com.lyl.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lyl.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JsonController {
    //思考：正常返回会走视图解析器，而json需要返回的是一个字符串
    //市面上有很多第三方jar包可以实现这个功能，Jackson、fastjson等，jackson只需要一个简单的注解即可实现
    //ResponseBody 将服务器端返回的对象转换为json对象响应回去
    //RequestBody
    @ResponseBody
    @RequestMapping("/json1")
    public String json1() throws JsonProcessingException {
        //需要一个jackson对象映射器，就是一个类，使用它可以直接将对象转换为json字符串
        ObjectMapper mapper = new ObjectMapper();
        //创建一个对象
        User user = new User(1, "lyl_1", "男");

        System.out.println(user);

        //将Java对象转换为json字符串
        String str = mapper.writeValueAsString(user);
        System.out.println(str);

        return str; //由于使用了@ResponseBody，这里会将str以json格式的字符串返回，十分方便
    }

}
