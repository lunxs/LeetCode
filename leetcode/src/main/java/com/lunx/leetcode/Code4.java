package com.lunx.leetcode;

/**
 * @author XieDesong
 * @version 1.0
 * @title Code4
 * @description
 * @date 2019/02/26
 */
public class Code4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;

        if (l1 > l2) {
            int[] n1 = new int[l2];
            int[] n2 = new int[l1];
            System.arraycopy(nums2, 0, n1, 0, l2);
            System.arraycopy(nums1, 0, n2, 0, l1);
            return recursive(n1, n2);
        } else {
            return recursive(nums1, nums2);
        }
    }

    private double recursive(int[] nums1, int[] nums2) {
        // default nums1.length <= nums2.length
        int length1 = nums1.length;
        int length2 = nums2.length;

        if (length1 <= 2) {
            return recursive1(nums1, nums2);
        }

        int length = 0;

        double medial1 = 0.0;
        int index1 = length1 / 2;
        if ((length1 & 1) == 0) {
            medial1 = (nums1[index1 - 1] + nums1[index1]) / 2.0;
            length = index1 - 1;
        } else {
            medial1 = nums1[index1];
            length = index1;
        }

        double medial2 = 0.0;
        int index2 = length2 / 2;
        if ((length2 & 1) == 0) {
            medial2 = (nums2[index2 - 1] + nums2[index2]) / 2.0;
        } else {
            medial2 = nums2[index2];
        }

        if (medial1 == medial2) {
            return medial1;
        }

        int[] copyNum1 = new int[length1 - length];
        int[] copyNum2 = new int[length2 - length];
        if (medial1 > medial2) {
            // 1 take small
            System.arraycopy(nums1, 0, copyNum1, 0, length1 - length);
            System.arraycopy(nums2, length, copyNum2, 0, length2 - length);
        } else {
            // 1 take big
            System.arraycopy(nums1, length, copyNum1, 0, length1 - length);
            System.arraycopy(nums2, 0, copyNum2, 0, length2 - length);
        }

        return recursive(copyNum1, copyNum2);
    }


    private double recursive1(int[] nums1, int[] nums2) {
        // default nums1.length <= nums2.length
        int length1 = nums1.length;
        int length2 = nums2.length;

        int index2 = length2 / 2;
        if (length1 == 2) {
            if ((length2 & 1) == 0) {
                // 2 is even
                if (nums1[0] < nums2[index2 - 1]) {
                    if (nums1[1] > nums2[index2]) {
                        return (nums2[index2 - 1] + nums2[index2]) / 2.0;
                    } else {
                        int[] copyNum1 = {nums1[1]};
                        int[] copyNum2 = new int[length2 - 1];
                        System.arraycopy(nums2, 0, copyNum2, 0, length2 - 1);
                        return recursive1(copyNum1, copyNum2);
                    }
                } else {
                    if (nums1[1] > nums2[index2]) {
                        int[] copyNum1 = {nums1[0]};
                        int[] copyNum2 = new int[length2 - 1];
                        System.arraycopy(nums2, 1, copyNum2, 0, length2 - 1);
                        return recursive1(copyNum1, copyNum2);
                    } else {
                        return (nums1[0] + nums1[1]) / 2.0;
                    }
                }
            } else {
                // 2 is odd
                double medial2 = nums2[index2];
                if (medial2 > nums1[0] && medial2 < nums1[1]) {
                    return medial2;
                } else if (medial2 >= nums1[1]) {
                    int[] copyNum1 = {nums1[1]};
                    int[] copyNum2 = new int[length2 - 1];
                    System.arraycopy(nums2, 0, copyNum2, 0, length2 - 1);
                    return recursive1(copyNum1, copyNum2);
                } else {
                    int[] copyNum1 = {nums1[0]};
                    int[] copyNum2 = new int[length2 - 1];
                    System.arraycopy(nums2, 1, copyNum2, 0, length2 - 1);
                    return recursive1(copyNum1, copyNum2);
                }
            }

        } else if (length1 == 1) {
            if ((length2 & 1) == 0) {
                // 2 is even
                if (nums1[0] > nums2[index2 - 1] && nums1[0] < nums2[index2]) {
                    return nums1[0];
                } else if (nums1[0] <= nums2[index2 - 1]) {
                    int[] copyNum2 = new int[length2 - 1];
                    System.arraycopy(nums2, 0, copyNum2, 0, length2 - 1);
                    return recursive1(new int[0], copyNum2);
                } else {
                    int[] copyNum2 = new int[length2 - 1];
                    System.arraycopy(nums2, 1, copyNum2, 0, length2 - 1);
                    return recursive1(new int[0], copyNum2);
                }
            } else {
                if (length2 == 1) {
                    return (nums1[0] + nums2[0]) / 2.0;
                }
                // 2 is odd
                double medial2 = nums2[index2];
                if (nums1[0] == medial2) {
                    return medial2;
                } else if (nums1[0] < medial2) {
                    if (nums1[0] >= nums2[index2 - 1]) {
                        return (nums1[0] + medial2) / 2.0;
                    } else {
                        int[] copyNum2 = new int[length2 - 1];
                        System.arraycopy(nums2, 0, copyNum2, 0, length2 - 1);
                        return recursive1(new int[0], copyNum2);
                    }
                } else {
                    if (nums1[0] <= nums2[index2 + 1]) {
                        return (nums1[0] + medial2) / 2.0;
                    } else {
                        int[] copyNum2 = new int[length2 - 1];
                        System.arraycopy(nums2, 1, copyNum2, 0, length2 - 1);
                        return recursive1(new int[0], copyNum2);
                    }
                }
            }

        } else {
            if ((length2 & 1) == 0) {
                // 2 is even
                return (nums2[index2 - 1] + nums2[index2]) / 2.0;
            } else {
                // 2 is odd
                return nums2[index2];
            }
        }
    }

    public static void main(String[] args) {
        Code4 c = new Code4();

//        int[] a = {1,2};
//        int[] b = {-1,3};

//        int[] a = {1,2};
//        int[] b = {3,4};

//        int[] a = {1};
//        int[] b = {2,3,4,5};

        int[] a = {2};
        int[] b = {1, 3, 4};

        double median = c.findMedianSortedArrays(a, b);
        System.out.println(median);
    }
}
