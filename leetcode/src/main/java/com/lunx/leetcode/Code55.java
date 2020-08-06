package com.lunx.leetcode;

/**
 * @author desong.xie
 * @version 1.0
 * @date 2020/05/19
 * @description
 */
public class Code55 {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }

        boolean result = true;
        int l = 0;
        int index = nums.length - 1;
        if (nums[index] == 0) {
            result = false;

            index--;
            l++;
            while (index >= 0) {
                if (nums[index] >= l) {
                    result = true;
                    l = 0;
                    break;
                } else {
                    l++;
                    index--;
                }
            }
        }

        for (; index >= 0; index--) {
            if (result && nums[index] > 0) {
                continue;
            }

            result = false;

            if (nums[index] > l) {
                result = true;
                l = 0;
            } else {
                l++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] as = {1,0,1,0};

        Code55 code55 = new Code55();
        boolean b = code55.canJump(as);
        System.out.println(b);

    }

}
