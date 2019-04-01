package com.lunx.demo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lunx.model.WightAndFloatIngPrice;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author XieDesong
 * @version 1.0
 * @title RandomDeom
 * @description
 * @date 2019/03/19
 * Coffee Box 连咖啡
 */
public class RandomDeom {

    private static final Gson GSON = new Gson();

    private int getFloatIngPrice() {
        String wightAndFloatingPriceJson = "[{\"wight\":5,\"floatingPrice\":-200},{\"wight\":1,\"floatingPrice\":-100},{\"wight\":1,\"floatingPrice\":0},{\"wight\":1,\"floatingPrice\":100},{\"wight\":5,\"floatingPrice\":200}]";
        List<WightAndFloatIngPrice> wightAndFloatIngPricesList = GSON.fromJson(wightAndFloatingPriceJson,
                new TypeToken<List<WightAndFloatIngPrice>>() {}.getType());

        int top = wightAndFloatIngPricesList.stream()
                .map(item -> item.getWight())
                .mapToInt(Integer::intValue)
                .sum();

        ThreadLocalRandom current = ThreadLocalRandom.current();
        int revisedRate = 80;
        if (current.nextInt(2) == 0) {
            revisedRate = -20;
        }
        if (top == 0) {
            return revisedRate;
        }

        int wight = current.nextInt(top);

        for (WightAndFloatIngPrice price : wightAndFloatIngPricesList) {
            if (wight < price.getWight()) {
                return price.getFloatingPrice() + revisedRate;
            }

            wight -= price.getWight();
        }
        return revisedRate;
    }

    public static void main(String[] args) {
        RandomDeom randomDeom = new RandomDeom();
        for (int i = 0; i < 100; i++) {

            int floatIngPrice = randomDeom.getFloatIngPrice();
            System.out.println(floatIngPrice);
        }
    }
}
