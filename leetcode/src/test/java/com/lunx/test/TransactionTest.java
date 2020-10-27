package com.lunx.test;

import com.lunx.dao.mapper.TestSecondMapper;
import com.lunx.dao.model.TestSecond;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;

/**
 * @author lunx
 * @version 1.0
 * @date 2020/10/27
 * @description
 */
@Component
public class TransactionTest {

    @Resource
    private TransactionTemplate transactionTemplate;

    @Resource
    private TestSecondMapper testSecondMapper;

    /**
     * 注解事务，需在其他类调用
     * 类内自己调用，注解事务会失效
     * @param flag
     */
    @Transactional(rollbackFor = Exception.class)
    public void transaction(boolean flag) {
        TestSecond testSecond = testSecondMapper.selectByPrimaryKey(2);
        testSecond.setName("kk");

        int i = testSecondMapper.updateByPrimaryKey(testSecond);

        if (flag) {
            throw new RuntimeException("roll back");
        }

        TestSecond testSecond1 = testSecondMapper.selectByPrimaryKey(2);
        System.out.println(testSecond1);
    }

    /**
     * 编程式事务测试
     * @param flag
     */
    public void transaction1(boolean flag) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                TestSecond testSecond = testSecondMapper.selectByPrimaryKey(2);
                testSecond.setName("cc");

                int i = testSecondMapper.updateByPrimaryKey(testSecond);

                if (flag) {
                    throw new RuntimeException("roll back");
                }

                TestSecond testSecond1 = testSecondMapper.selectByPrimaryKey(2);
                System.out.println(testSecond1);
            }
        });
    }

}
