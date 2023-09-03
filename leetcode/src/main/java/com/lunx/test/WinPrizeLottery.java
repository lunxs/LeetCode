package com.lunx.test;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author lunx
 * @version 1.0
 * @date 2021/04/08
 * @description 每期需要修改输入点, ISSUENO_START 起始期数, 购买彩票号码
 *
 */
public class WinPrizeLottery {

    public static final int ISSUENO_START = 23083;
    private static String HISTORY_URL = "https://api.jisuapi.com/caipiao/history?appkey=98179173437c7deb&caipiaoid=14&start=0&num=25";
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

        @Override
        public String toString() {
            return num;
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

        @Override
        public String toString() {
            return name + ":" + num;
        }
    }
    /**
     * 初始化开奖号码
     */
    private static List<WinningNum> initWinningNum() {
        // 开奖号码
        List<String> winningNums = new ArrayList<>();

        // 远端api获取，历史开奖号码
        get(winningNums);

        List<WinningNum> winningNumList = winningNums
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
                new WinningNum("01,09,11,15,26;03,12")
        };
        useNumList.add(new UseNum("飞", fei));
        // 川
        WinningNum[] chuan = {
                new WinningNum("03,08,10,24,25;03,09")
        };
        useNumList.add(new UseNum("川", chuan));
        // 波
        WinningNum[] bo = {
                new WinningNum("04,07,09,16,25;08,12")
        };
//        useNumList.add(new UseNum("波", bo));
        // 松
        WinningNum[] song = {
//                new WinningNum("14,21,24,27,32;5,11"),
//                new WinningNum("9,19,22,23,25;5,6"),
                new WinningNum("04,12,20,21,32;04,11")
        };
        useNumList.add(new UseNum("松", song));
        // 强
        WinningNum[] qiang = {
                new WinningNum("03,10,14,25,28;03,10")
        };
        useNumList.add(new UseNum("强", qiang));
        // 钻
        WinningNum[] zuan = {
                new WinningNum("01,05,19,20,26;02,12")
        };
        useNumList.add(new UseNum("钻", zuan));
        // 雪
        WinningNum[] xue = {
                new WinningNum("09,12,19,31,34;01,08")
        };
        useNumList.add(new UseNum("雪", xue));

        return useNumList;
    }

    public static void main(String[] args) {
        Map<String, Integer> result = new HashMap<>();
        useNumList.stream().forEach(use -> result.putAll(calcUseWin(use)));

        useNumList.forEach(use -> System.out.println(use));
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


    public static void get(List<String> winningNums) {
        String result = null;

        try {
            Gson gson = new Gson();
            result = sendGet();
            JsonObject json = gson.fromJson(result, JsonObject.class);

            if (json.get("status").getAsInt() != 0) {
                System.out.println(json.get("msg").getAsString());
            } else {
                JsonObject resultarr = json.getAsJsonObject("result");
                String caipiaoid = resultarr.get("caipiaoid").getAsString();
                JsonArray list = resultarr.getAsJsonArray("list");
                System.out.println("all:"+ list);
                System.out.println("彩票类型：" + caipiaoid);
                if (list != null) {
                    for (int j = list.size() - 1; j >= 0; j--) {
                        JsonObject list_ = (JsonObject) list.get(j);
                        String opendate = list_.get("opendate").getAsString();
                        String issueno = list_.get("issueno").getAsString();
                        String number = list_.get("number").getAsString();
                        String refernumber = list_.get("refernumber").getAsString();

                        // TODO
                        if (ISSUENO_START <= Integer.parseInt(issueno) && winningNums.size() <= 20) {

                            winningNums.add(number.replaceAll(" ", ",") + ";" +
                                    refernumber.replaceAll(" ", ","));

                            String saleamount = list_.get("saleamount").getAsString();
                            System.out.println(opendate + " " + issueno + " " + number + " " + refernumber);
                        }

                        /*JsonArray prize = list_.getAsJsonArray("prize");
                        if (list_.get("prize") != null) {
                            for (int i = 0; i < prize.size(); i++) {
                                JsonObject obj = (JsonObject) prize.get(i);
                                String prizename = obj.get("prizename").getAsString();
                                String require = obj.get("require").getAsString();
                                String num = obj.get("num").getAsString();
                                String singlebonus = obj.get("singlebonus").getAsString();
                                System.out.println(prizename + " " + require + " " + num + " " + singlebonus);
                            }
                        }*/
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String sendGet() {
        StringBuffer resultBuffer = null;

        HttpURLConnection con = null;
        BufferedReader br = null;
        try {
            URL url = new URL(HISTORY_URL);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            con.connect();
            resultBuffer = new StringBuffer();
            br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
            String temp;
            while ((temp = br.readLine()) != null) {
                resultBuffer.append(temp);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    br = null;
                    throw new RuntimeException(e);
                } finally {
                    if (con != null) {
                        con.disconnect();
                        con = null;
                    }
                }
            }
        }
        return resultBuffer.toString();
    }

}
