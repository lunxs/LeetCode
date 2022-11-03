package com.lunx.java.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class JaveTest {

    public static void main(String[] args) {
        List<String> as = new ArrayList<>();

        String collect = as.stream().collect(Collectors.joining(","));

        System.out.println(collect);


        String a = "";
        System.out.println(a);
    }

}
