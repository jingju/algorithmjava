package com.doit.algorithmjava.binarysearch;

// Created by Macro on 2021/11/10.

import java.util.Arrays;

/**
 * 题型二：二分确定一个有范围的整数（二分答案）
 * 算法思想：减而治之。如果题目要我们找一个整数，这个整数有确定的范围，可以通过二分查找逐渐缩小范围，最后逼近到一个数。
 */

public class BinarySearch2 {


    //<editor-fold desc="69. Sqrt(x)">
    /**
     * 69. Sqrt(x)
     * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
     *
     * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
     *
     * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：x = 4
     * 输出：2
     * 示例 2：
     *
     * 输入：x = 8
     * 输出：2
     * 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
     * tip: 这里的防止整数溢出，所以
     */
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        int left =0;
        int right=x;
        //left =3. right =4 的时候
        while(left<right){
            int mid= left+(right-left)/2;
            if(mid<x/mid){
                left=mid+1;
            }else{
                right=mid;
            }
        }

        if(left>x/left){
            return left-1;
        }
        return left;
    }
    //</editor-fold>



    //<editor-fold desc="    1283. 使结果不超过阈值的最小除数">
    /**
     *      1283. 使结果不超过阈值的最小除数
     *     给你一个整数数组 nums 和一个正整数 threshold  ，你需要选择一个正整数作为除数，然后将数组里每个数都除以它，并对除法结果求和。
     *
     *     请你找出能够使上述结果小于等于阈值 threshold 的除数中 最小 的那个。
     *
     *     每个数除以除数后都向上取整，比方说 7/3 = 3 ， 10/2 = 5 。
     *
     *     题目保证一定有解。
     *
     *
     *
     *     示例 1：
     *
     *     输入：nums = [1,2,5,9], threshold = 6
     *     输出：5
     *     解释：如果除数为 1 ，我们可以得到和为 17 （1+2+5+9）。
     *     如果除数为 4 ，我们可以得到和为 7 (1+1+2+3) 。如果除数为 5 ，和为 5 (1+1+1+2)。
     *     示例 2：
     *
     *     输入：nums = [2,3,5,7,11], threshold = 11
     *     输出：3
     *     示例 3：
     *
     *     输入：nums = [19], threshold = 5
     *     输出：4
     */
    public int smallestDivisor(int[] nums, int threshold) {
        /**
         * 思路：
         * 确定二分的数组和判断条件
         * 1、边界确定
         * 判断条件是针对被除数的大小来做边界的区分，当大于最大数的时候，全部为0
         * 所有left为1，right数组中的最大数，
         * 2、循环种植条件
         *  最小值即返回右区间的第一个值。
         */

        int left=1;
        int right=1;
        for (int i = 0; i < nums.length; i++) {
            right=Math.max(nums[i],right);
        }
        //最小值即返回右区间的第一个值。
        while(left<right){
            int result=0;
            int mid = left+(right-left)/2;
            for (int i = 0; i < nums.length; i++) {
                if(nums[i]%mid==0){
                   //恰好能被整除，不再+1
                   result+= nums[i]/mid;
                }else{
                    //向上取整，不能完全整除的时候，要+1
                    result+=nums[i]/mid+1;
                }
            }
            if(result>threshold){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return left;
    }

    //</editor-fold>


}
