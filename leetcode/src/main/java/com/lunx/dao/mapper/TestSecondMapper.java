package com.lunx.dao.mapper;

import com.lunx.dao.model.TestSecond;

public interface TestSecondMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TestSecond record);

    int insertSelective(TestSecond record);

    TestSecond selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TestSecond record);

    int updateByPrimaryKey(TestSecond record);

}