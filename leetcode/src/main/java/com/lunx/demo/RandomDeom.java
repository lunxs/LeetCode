package com.lunx.demo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lunx.model.WightAndFloatIngPrice;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author XieDesong
 * @version 1.0
 * @title RandomDeom
 * @description
 * @date 2019/03/19
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

    private void test() {
        String red = ThreadLocalRandom.current()
                .ints(1, 34)
                .distinct()
                .limit(6)
                .sorted()
                .mapToObj(Integer::toString)
                .collect(Collectors.joining("-"));

        System.out.println("red:" + red);

        String blue = ThreadLocalRandom.current()
                .ints(1, 17)
                .limit(1)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining("-"));

        System.out.println("blue:" + blue);
    }

    public static void main(String[] args) {
        RandomDeom randomDeom = new RandomDeom();

        randomDeom.test();
    }
}
