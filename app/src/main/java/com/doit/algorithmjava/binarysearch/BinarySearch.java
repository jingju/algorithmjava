package com.doit.algorithmjava.binarysearch;

// Created by Macro on 7/30/21.

public  class BinarySearch {


    /**
     * leetcode 704
     *
     * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
     *
     *
     * 示例 1:
     *
     * 输入: nums = [-1,0,3,5,9,12], target = 9
     * 输出: 4
     * 解释: 9 出现在 nums 中并且下标为 4
     * 示例 2:
     *
     * 输入: nums = [-1,0,3,5,9,12], target = 2
     * 输出: -1
     * 解释: 2 不存在 nums 中因此返回 -1
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binary-search
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int question1(int[] nums, int target){
        //边界判断
        int left=0;
        int right=nums.length-1;
        while (left<=right) {
            int index=left+(right -left)/2;
            int current = nums[index];
            if (current > target) { //左移
                right=index-1;
            } else if (current < target) {//右移
                left=index+1;
            } else {//返回下标
                return index;
            }
        }
        return -1;
    }
}
