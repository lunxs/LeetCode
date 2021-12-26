package com.lunx.demo;


import com.alibaba.fastjson.JSONObject;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * @author lunx
 * @version 1.0
 * @date 2021/10/14
 * @description
 */
public class JsonDemo {

    public static void main(String[] args) {
        JSONObject.toJSONString("");
    }

    public class A implements Map<String, Object> {

        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean containsKey(Object key) {
            return false;
        }

        public boolean containsKey(String key) {
            return false;
        }

        @Override
        public boolean containsValue(Object value) {
            return false;
        }

        @Override
        public Object get(Object key) {
            return null;
        }

        @Override
        public Object put(String key, Object value) {
            return null;
        }

        @Override
        public Object remove(Object key) {
            return null;
        }

        @Override
        public void putAll(Map<? extends String, ?> m) {

        }

        @Override
        public void clear() {

        }

        @Override
        public Set<String> keySet() {
            return null;
        }

        @Override
        public Collection<Object> values() {
            return null;
        }

        @Override
        public Set<Entry<String, Object>> entrySet() {
            return null;
        }
    }
}
