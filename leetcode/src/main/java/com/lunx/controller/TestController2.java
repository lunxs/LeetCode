package com.lunx.controller;

import com.lunx.glob.model.HttpResult;
import com.lunx.service.TestInterface;
import com.lunx.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author desong.xie
 * @version 1.0
 * @date 2020/08/11
 * @description
 */
@Api(value = "/test2", tags = "test2")
@RestController
@RequestMapping("/test2")
public class TestController2 {

    @Qualifier("testService")
    private TestInterface testInterface;

    @Autowired
    private TestService testService;

    @ApiOperation(value = "map接口", notes = "测试map使用")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "key", value = "key值", dataType = "String", paramType = "query", required = true)
    })
    @GetMapping("/map")
    public HttpResult<Boolean> getHello(@RequestParam(value = "key") String key) {
        HttpResult<Boolean> result = new HttpResult<>();
        boolean data = true;
        System.out.println("*********** start ***********");

        testService.test1(key);

        System.out.println("*********** end ***********");
        return result.setData(data);
    }
}
