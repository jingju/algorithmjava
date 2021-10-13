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

    /**
     * 35. 搜索插入位置
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     *
     * 请必须使用时间复杂度为 O(log n) 的算法。
     *
     * 示例 1:
     *
     * 输入: nums = [1,3,5,6], target = 5
     * 输出: 2
     * 示例 2:
     *
     * 输入: nums = [1,3,5,6], target = 2
     * 输出: 1
     * 示例 3:
     *
     * 输入: nums = [1,3,5,6], target = 7
     * 输出: 4
     * 示例 4:
     *
     * 输入: nums = [1,3,5,6], target = 0
     * 输出: 0
     * 示例 5:
     *
     * 输入: nums = [1], target = 0
     * 输出: 0
     *
     * 思路：
     *     判断不在里边：往小走的时候，当前值和前一个值都大于这个数，否则结束，返回插入下标
     *                  往大走的时候，当前值和下一个值都小于这个数，否则结束，返回插入下标
     *                  结束：左右相等，返回下标，为0,或者size
     *
     */
    public int searchInsert(int[] nums, int target) {
        if(nums.length==0){
            return 0;
        }
        int left=0;
        int right=nums.length;
        while (left<right) {
            int mid=left+(right -left)/2;
            if (nums[mid] < target) {//右移
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return left;
    }

    /**
     * 34. 在排序数组中查找元素的第一个和最后一个位置
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     *
     * 如果数组中不存在目标值 target，返回 [-1, -1]。
     *
     * 进阶：
     *
     * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
     *
     *
     * 示例 1：
     *
     * 输入：nums = [5,7,7,8,8,10], target = 8
     * 输出：[3,4]
     * 示例 2：
     *
     * 输入：nums = [5,7,7,8,8,10], target = 6
     * 输出：[-1,-1]
     * 示例 3：
     *
     * 输入：nums = [], target = 0
     * 输出：[-1,-1]
     *
     *
     * 提示：
     *
     * 0 <= nums.length <= 105
     * -109 <= nums[i] <= 109
     * nums 是一个非递减数组
     * -109 <= target <= 109
     *
     * 思路：排序，第一个和最后一个肯定是连续的
     *
     */


    public int[] searchRange(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        int resut[]={-1,-1};

        while (left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]<target){
                left=mid+1;
            }else if(nums[mid]>target){
                right=mid-1;
            }else{
                int leftIndex=mid;
                int rightIndex=mid;
                while(leftIndex>0&&nums[leftIndex-1]==target){
                    leftIndex--;
                }
                resut[0]=leftIndex;
                while(rightIndex<right && nums[rightIndex+1]==target){
                    rightIndex++;
                }
                resut[1]=rightIndex;
                return resut;
            }
        }
        return resut;
    }


    /**
     * 1095. 山脉数组中查找目标值
     * （这是一个 交互式问题 ）
     *
     * 给你一个 山脉数组 mountainArr，请你返回能够使得 mountainArr.get(index) 等于 target 最小 的下标 index 值。
     *
     * 如果不存在这样的下标 index，就请返回 -1。
     *
     *
     *
     * 何为山脉数组？如果数组 A 是一个山脉数组的话，那它满足如下条件：
     *
     * 首先，A.length >= 3
     *
     * 其次，在 0 < i < A.length - 1 条件下，存在 i 使得：
     *
     * A[0] < A[1] < ... A[i-1] < A[i]
     * A[i] > A[i+1] > ... > A[A.length - 1]
     *
     *
     * 你将 不能直接访问该山脉数组，必须通过 MountainArray 接口来获取数据：
     *
     * MountainArray.get(k) - 会返回数组中索引为k 的元素（下标从 0 开始）
     * MountainArray.length() - 会返回该数组的长度
     *
     *
     * 注意：
     *
     * 对 MountainArray.get 发起超过 100 次调用的提交将被视为错误答案。此外，任何试图规避判题系统的解决方案都将会导致比赛资格被取消。
     *
     * 为了帮助大家更好地理解交互式问题，我们准备了一个样例 “答案”：https://leetcode-cn.com/playground/RKhe3ave，请注意这 不是一个正确答案。
     *
     *
     *
     * 示例 1：
     *
     * 输入：array = [1,2,3,4,5,3,1], target = 3
     * 输出：2
     * 解释：3 在数组中出现了两次，下标分别为 2 和 5，我们返回最小的下标 2。
     * 示例 2：
     *
     * 输入：array = [0,1,2,4,2,1], target = 3
     * 输出：-1
     * 解释：3 在数组中没有出现，返回 -1。
     *
     * 思路：
     *    山脉数组的的顶点两边都是有序的
     *
     *    找到顶点
     *    二分查找数组的左边，如果有直接返回
     *    如果没有，再二分查找数组的右边
     *
     * 关键点：分界点的判断
     *  [0,1,2,4,5，8，，2,1]
     *
     *  tip: 这道题的关键点，对mounterArray.get() 调用要足够少
     *      todo 有时候不一定用 arrray[mid]==target来判断找到目标数据，
     *           可以根据题目的特性和，left，right来构造合适的判断方式
     *
     *
     *
     */
      //tip:忽略具体的实现
     public static class MountainArray {
        private int[] arr;
        private int size;

        public MountainArray(int[] arr) {
            this.arr = arr;
            this.size = this.arr.length;
        }

        public int get(int index) {
            return this.arr[index];
        }

        public int length() {
            return this.size;
        }

     }

    public int moutainBinerySearch(int target,int left,int right,MountainArray array){
        while (left< right){
            int mid=left+(right-left)/2;
            if(array.get(mid)<target){
                left=mid+1;
            }else{
                right=mid;
            }

        }
        if(array.get(left)==target){
            return left;
        }
        return -1;
    }
    public int moutainBinerySearchDown(int target,int left,int right,MountainArray array){
        while (left< right){
            int mid=left+(right-left)/2;
            if(array.get(mid)>target){
                left=mid+1;
            }else{
                right=mid;
            }

        }
        if(array.get(left)==target){
            return left;
        }
        return -1;
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        /**
         * 先用二分找到顶点
         */
        int left =0;
        int right= mountainArr.length()-1;
        int i=-1;
        //找到中点
        while (left< right){
            int mid=left+(right-left)/2;
            if(mountainArr.get(mid)<mountainArr.get(mid+1)){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        i=left;
        /**
         * 左边进行二分查找
         */
        int leftResult= moutainBinerySearch(target,0,i,mountainArr);

        if(leftResult!=-1){
            return leftResult;
        }
        /**
         * 右边进行二分查找
         */
        int rightResult= moutainBinerySearchDown(target,i+1,mountainArr.length()-1,mountainArr);

        return rightResult;
    }
    }


}
