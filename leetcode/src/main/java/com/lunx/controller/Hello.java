package com.lunx.controller;

import com.lunx.glob.model.HttpResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/hello")
public class Hello {

    @GetMapping("/hello")
    public HttpResult<Boolean> getHello(@RequestParam(value = "first", required = false) int first) {
        HttpResult<Boolean> result = new HttpResult<>();
        boolean data = false;
        System.out.println("*********** start ***********");

        System.out.println(first);

        System.out.println("*********** end ***********");
        return result.setData(data);
    }

    @PostMapping("/hello")
    public HttpResult<Map<String, Object>> postHello(@RequestParam(value = "second", required = false) int second) {
        HttpResult<Map<String, Object>> result = new HttpResult<>();
        Map<String, Object> data = new HashMap<>();
        System.out.println("*********** start ***********");

        System.out.println(second);

        System.out.println("*********** end ***********");
        return result.setData(data);
    }
}
