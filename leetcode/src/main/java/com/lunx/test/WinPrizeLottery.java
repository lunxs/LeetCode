package com.lunx.test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author lunx
 * @version 1.0
 * @date 2021/04/08
 * @description
 */
public class WinPrizeLottery {

    private static List<WinningNum> winningNumList = initWinningNum();
    private static List<UseNum> useNumList = initUseNum();

    public static List<WinningNum> getWinningNumList() {
        return winningNumList;
    }

    public static List<UseNum> getUseNumList() {
        return useNumList;
    }

    static class WinningNum {
        // 02,15,21,29,30;04,10
        private String num;

        public WinningNum(String num) {
            this.num = num;
        }

        public List<Integer> getRedNum() {
            String[] nums = num.split(";");
            String[] redNums = nums[0].split(",");
            List<Integer> redNumList = Arrays.asList(redNums)
                    .stream()
                    .map(Integer::parseInt)
                    .sorted()
                    .collect(Collectors.toList());
            return redNumList;
        }

        public List<Integer> getBlueNum() {
            String[] nums = num.split(";");
            String[] blueNums = nums[1].split(",");
            List<Integer> blueNumList = Arrays.asList(blueNums)
                    .stream()
                    .map(Integer::parseInt)
                    .sorted()
                    .collect(Collectors.toList());
            return blueNumList;
        }
    }

    static class UseNum{
        private String name;
        private List<WinningNum> num;

        public UseNum(String name, WinningNum[] num) {
            this.name = name;
            this.num = Arrays.asList(num);
        }

        public String getName() {
            return name;
        }

        public List<WinningNum> getNum() {
            return num;
        }
    }

    /**
     * 初始化开奖号码
     */
    private static List<WinningNum> initWinningNum() {
        String[] winningNums = {
                "11,14,21,24,31;02,10",
                "17,18,23,30,31;10,12",
                "07,11,20,24,27;01,11",
                "09,21,22,26,30;04,12",
                "02,03,05,17,29;04,10",
                "02,06,10,32,33;04,07",
                "18,23,25,26,32;02,07",
                "01,04,19,20,34;03,05",
                "01,11,14,34,35;07,10",
                "01,03,05,30,32;01,05",
                "08,10,14,25,34;07,08",
                "05,11,16,30,32;03,04",
                "08,17,25,28,33;07,11",
                "10,21,27,29,33;04,12",
                "09,11,20,29,32;01,07",
        };
        List<WinningNum> winningNumList = Arrays.asList(winningNums)
                .stream()
                .map(WinningNum::new)
                .collect(Collectors.toList());
        return winningNumList;
    }

    /**
     * 初始化人员及号码
     */
    private static List<UseNum> initUseNum() {
        List<UseNum> useNumList = new ArrayList<>();
        // 飞
        WinningNum[] fei = {
                new WinningNum("01,09,11,15,26;03,12"),
                new WinningNum("09,16,17,21,28;04,09")
        };
        useNumList.add(new UseNum("飞", fei));
        // 川
        WinningNum[] chuan = {
                new WinningNum("01,09,11,15,26;03,12"),
                new WinningNum("09,16,17,21,28;04,09")
        };
        useNumList.add(new UseNum("川", chuan));
        // 波
        WinningNum[] bo = {
                new WinningNum("04,07,09,16,25;08,12")
        };
        useNumList.add(new UseNum("波", bo));
        // 松
        WinningNum[] song = {
                new WinningNum("02,15,21,29,30;04,10")
        };
        useNumList.add(new UseNum("松", song));
        // 强
        WinningNum[] qiang = {
                new WinningNum("03,10,14,25,28;03,10")
        };
        useNumList.add(new UseNum("强", qiang));

        return useNumList;
    }

    public static void main(String[] args) {
        Map<String, Integer> result = new HashMap<>();
        useNumList.stream().forEach(use -> result.putAll(calcUseWin(use)));

        System.out.println(result);
    }

    private static Map<String, Integer> calcUseWin(UseNum useNum) {
        Map<String, Integer> result = new HashMap<>();
        int sum = useNum.getNum().stream().mapToInt(winningNum -> calcWin(winningNum)).sum();
        result.put(useNum.getName(), sum);
        return result;
    }

    private static int calcWin(WinningNum winningNum) {
        int sum = winningNumList.stream().mapToInt(winning -> calcWin(winning, winningNum)).sum();
        return sum;
    }

    private static int calcWin(WinningNum winningNum, WinningNum useWinningNum) {
        Set<Integer> redNum = new HashSet<>();
        winningNum.getRedNum().forEach(red -> redNum.add(red));
        useWinningNum.getRedNum().forEach(red -> redNum.add(red));
        int winRed = winningNum.getRedNum().size() + useWinningNum.getRedNum().size() - redNum.size();

        Set<Integer> blueNum = new HashSet<>();
        winningNum.getBlueNum().forEach(red -> blueNum.add(red));
        useWinningNum.getBlueNum().forEach(red -> blueNum.add(red));
        int winBlue = winningNum.getBlueNum().size() + useWinningNum.getBlueNum().size() - blueNum.size();

        if (winRed == 0) {
            if (winBlue == 2) return 5;
        }
        if (winRed == 1) {
            if (winBlue == 2) return 5;
        }
        if (winRed == 2) {
            if (winBlue == 1) return 5;
            if (winBlue == 2) return 15;
        }
        if (winRed == 3) {
            if (winBlue == 0) return 5;
            if (winBlue == 1) return 15;
            if (winBlue == 2) return 200;
        }
        if (winRed == 4) {
            if (winBlue == 0) return 100;
            if (winBlue == 1) return 300;
            if (winBlue == 2) return 3000;
        }
        if (winRed == 5) {
            if (winBlue == 0) return 10000;
            if (winBlue == 1) return 5_000_000;
            if (winBlue == 2) return 10_000_000;
        }
        return 0;
    }

}
