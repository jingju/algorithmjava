package com.doit.algorithmjava.binarysearch;

// Created by Macro on 7/30/21.

import java.lang.reflect.Array;
import java.nio.charset.MalformedInputException;
import java.util.Arrays;
import java.util.HashMap;

public  class BinarySearch {


    //<editor-fold desc="704 找目标索引">
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
    //</editor-fold>

    //<editor-fold desc="34 搜索插入位置">
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
    //</editor-fold>

    //<editor-fold desc="34 在排序数组中查找元素的第一个和最后一个位置">
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
    //</editor-fold>


    //<editor-fold desc="1095 山脉数组">
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
    //</editor-fold>

    //<editor-fold desc="4. 寻找两个正序数组的中位数">
    /**
     *4. 寻找两个正序数组的中位数
     * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums1 = [1,3], nums2 = [2]
     * 输出：2.00000
     * 解释：合并数组 = [1,2,3] ，中位数 2
     * 示例 2：
     *
     * 输入：nums1 = [1,2], nums2 = [3,4]
     * 输出：2.50000
     * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
     * 示例 3：
     *
     * 输入：nums1 = [0,0], nums2 = [0,0]
     * 输出：0.00000
     * 示例 4：
     *
     * 输入：nums1 = [], nums2 = [1]
     * 输出：1.00000
     * 示例 5：
     *
     * 输入：nums1 = [2], nums2 = []
     * 输出：2.00000
     *
     *
     * 提示：
     *
     * nums1.length == m
     * nums2.length == n
     * 0 <= m <= 1000
     * 0 <= n <= 1000
     * 1 <= m + n <= 2000
     * -106 <= nums1[i], nums2[i] <= 106
     *
     * 思路：
     *    1、两个数组的长度、总长度
     *    2、两个数组同时操作
     *    3、用切分的方式
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // todo 交换两个数组的变量，确定较小和较大的数组
        if(nums1.length>nums2.length){
            int[] temp=nums1;
            nums1=nums2;
            nums2=temp;
        }

        int m=nums1.length;//小的
        int n=nums2.length;//大的

        //以小的尺寸为基准点进行迭代
        int left=0;
        int right=m;

        int totalleft= (m+n+1)/2;//向上取整数，为了在奇数的时候，让中位数在左边。

        while(left<right){//left和right 重合的时候，跳出循环

            int i= left+(right-left+1)/2;//为了mid在右边，不至于左边取不到值
            int j= totalleft-i;//大数组的分割线的位置

            if(nums1[i-1]>nums2[j]){//左移动nums1的线条，改变right
                right=i-1;
            }else{
                left=i;
            }
        }

        int i=left;
        int j=totalleft-i;

        //极端的情况
        //1移动到了最左边，可以把1的左边看作正负穷大，右边看作正无穷大
        int num1LeftMax=i==0?Integer.MIN_VALUE:nums1[i-1];
        int num1RightMin=i==m?Integer.MAX_VALUE:nums1[i];
        int num2LeftMax =j==0?Integer.MIN_VALUE:nums2[j-1];
        int num2RightMIn=j==n?Integer.MAX_VALUE:nums2[j];

        //最终计算中位数
        if(((m + n) % 2) == 1){//奇数
            return Math.max(num1LeftMax,num2LeftMax);
        }else{
            return (double)(Math.max(num1LeftMax,num2LeftMax)+ Math.min(num1RightMin,num2RightMIn))/2;
        }
    }

    //</editor-fold>

    //<editor-fold desc=" 33. 搜索旋转排序数组">
    /**
     * 33. 搜索旋转排序数组
     * 整数数组 nums 按升序排列，数组中的值 互不相同 。
     *
     * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ...,
     * nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7]
     * 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
     *
     *        k---n-1
     *        0--k-1
     *
     *      index-(n-k)
     *
     *        k+index
     *
     * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [4,5,6,7,0,1,2], target = 0
     * 输出：4
     * 示例 2：
     *
     * 输入：nums = [4,5,6,7,0,1,2], target = 3
     * 输出：-1
     * 示例 3：
     *
     * 输入：nums = [1], target = 0
     * 输出：-1
     *
     *
     * 提示：
     *
     * 1 <= nums.length <= 5000
     * -10^4 <= nums[i] <= 10^4
     * nums 中的每个值都 独一无二
     * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
     * -10^4 <= target <= 10^4
     *
     *
     * 进阶：你可以设计一个时间复杂度为 O(log n) 的解决方案吗？
     *
     * 思路：旋转后数组的特点
     *      已知条件  nums  target
     *              数组中的值互不相同
     *              前面第一个的下标是k
     *              后面的下标是k-1
     *              前面的最后一个元素 （n-1）
     *              后面第一个元素是0
     *
     */

    public int rotateBinarySearch(int left ,int right ,int target,int[] nums){
        while(left<=right){
            int mid = left+(right - left)/2;
            if(nums[mid]>target){
                right=mid-1;
            }else if(nums[mid] < target){
                left=mid+1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    public int rotateSearch(int[] nums, int target) {

        //<editor-fold desc="solution 1">
        //        int index=-1;
//
//        int start=0;
//
//        while((start+1)<nums.length&&(nums[start+1]>nums[start])){
//            start++;
//        }
//
//        //这时候，得到的是第0个元素,对原索引0-（k-1）的元素进行二分查找
//        int n=nums.length-1;
//        index=rotateBinarySearch(0,start,target,nums);
//        //换算
//        if(index>-1){
//            return index;
//        }
//        index=rotateBinarySearch(start+1,n, target,nums);
//        if(index>-1){
//            return index;
//        }
//
//        //对k到n-1的元素进行二分查找
//        return index;
        //</editor-fold>

        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
    //</editor-fold>


    //<editor-fold desc="81. 搜索旋转排序数组 II">
    /**
     * 81. 搜索旋转排序数组 II
     *
     * 已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。
     *
     * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转 ，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。
     *
     * 给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。如果 nums 中存在这个目标值 target ，则返回 true ，否则返回 false 。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：nums = [2,5,6,0,0,1,2], target = 0
     * 输出：true
     * 示例 2：
     *
     * 输入：nums = [2,5,6,0,0,1,2], target = 3
     * 输出：false
     *  
     *
     * 提示：
     *
     * 1 <= nums.length <= 5000
     * -104 <= nums[i] <= 104
     * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
     * -104 <= target <= 104
     *
     */
    public boolean rotateBinarySearch2(int left ,int right ,int target,int[] nums){
        while(left<=right){
            int mid = left+(right - left)/2;
            if(nums[mid]>target){
                right=mid-1;
            }else if(nums[mid] < target){
                left=mid+1;
            }else{
                return true;
            }
        }
        return false;
    }
    public boolean rotateSearch2(int[] nums, int target) {
        //<editor-fold desc="solution 1">
        //        boolean result=false;
//        int start=0;
//        //tip:这里要加上等于条件的判断
//        while((start+1)<nums.length&&(nums[start+1]>=nums[start])){
//            start++;
//        }
//
//        //这时候，得到的是第0个元素,对原索引0-（k-1）的元素进行二分查找
//        int n=nums.length-1;
//        result=rotateBinarySearch2(0,start,target,nums);
//        //换算
//        if(result){
//            return result;
//        }
//        result=rotateBinarySearch2(start+1,n, target,nums);
//        //对k到n-1的元素进行二分查找
//        return result;
        //</editor-fold>


        int n = nums.length;
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return nums[0] == target;
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[l] == nums[mid] && nums[mid] == nums[r]) {
                ++l;
                --r;
            } else if (nums[l] <= nums[mid]) {
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return false;
    }
    //</editor-fold>

    //<editor-fold desc="153. 寻找旋转排序数组中的最小值">
    /**
     * 153. 寻找旋转排序数组中的最小值
     * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
     * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
     * 若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
     * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
     *
     * 给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：nums = [3,4,5,1,2]
     * 输出：1
     * 解释：原数组为 [1,2,3,4,5] ，旋转 3 次得到输入数组。
     * 示例 2：
     *
     * 输入：nums = [4,5,6,7,0,1,2]
     * 输出：0
     * 解释：原数组为 [0,1,2,4,5,6,7] ，旋转 4 次得到输入数组。
     * 示例 3：
     *
     * 输入：nums = [11,13,15,17]
     * 输出：11
     * 解释：原数组为 [11,13,15,17] ，旋转 4 次得到输入数组。
     *  
     *
     * 提示：
     *
     * n == nums.length
     * 1 <= n <= 5000
     * -5000 <= nums[i] <= 5000
     * nums 中的所有整数 互不相同
     * nums 原来是一个升序排序的数组，并进行了 1 至 n 次旋转
     * 通过次数218,775提交次数385,948
     *
     * 思路：
     *     1、1 次旋转的结果，将最后一个元素移到前面
     *     2、找出数组中的最小元素
     *             只要不经过n，次旋转，都能分成两个数组，如果正好经历了n+1次旋转，最小元素就是第一个，
     *
     *
     */
    public int findMin(int[] nums) {
        /**
         * 1、恰好经历的 n+1 次，最后一个元素大于第一个元素，第一个元素最小。
         * 2、小于n+1次，最后一个元素永远小于第一个元素。
         *    整个旋转后的数组，仍然由两个升序数组组合而成，且后面的数组的值都小于前面的数组的值，
         *    这个时候，后面数组的第一个值就是最小值。
         *    通过迭代的方式，找到后面数组的第一个值
         *    从索引0开始迭代整个旋转后的数组，第一个小于前面索引的值的值，即为最小值。
         */
        //<editor-fold desc="solution 1">
        //        int start =-1;
//        if(nums[nums.length-1]<nums[0]){
//            while((start+1)<nums.length&&nums[start+1]>nums[start]){
//                start++;
//            }
//        }else{
//            return nums[0];
//        }
//        return start+1;
        //</editor-fold>

        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < nums[r]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[l];

    }

    //</editor-fold>


    //<editor-fold desc="275. H 指数 II">
    /**
     * 275. H 指数 II
     * 给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数，citations 已经按照 升序排列 。计算并返回该研究者的 h 指数。
     *
     * h 指数的定义：h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （n 篇论文中）总共有 h 篇论文分别被引用了至少 h 次。且其余的 n - h 篇论文每篇被引用次数 不超过 h 次。
     *
     * 提示：如果 h 有多种可能的值，h 指数 是其中最大的那个。
     *
     * 请你设计并实现对数时间复杂度的算法解决此问题。
     *
     *
     *
     * 示例 1：
     *
     * 输入：citations = [0,1,3,5,6]
     * 输出：3
     * 解释：给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 0, 1, 3, 5, 6 次。
     *      由于研究者有 3 篇论文每篇 至少 被引用了 3 次，其余两篇论文每篇被引用 不多于 3 次，所以她的 h 指数是 3 。
     * 示例 2：
     *
     * 输入：citations = [1,2,100]
     * 输出：2
     *
     *
     * 提示：
     *
     * n == citations.length
     * 1 <= n <= 105
     * 0 <= citations[i] <= 1000
     * citations 按 升序排列
     * 通过次数51,560提交次数111,629
     *
     *
     *
     * todo citations = [0,1,3,5,6] 模型具体化
     *  length = n
     * 1、 数组中，至少有h个值大于等于h
     * 2、 可以有多种情况，求h最大的
     * 3、 数组是升序列。
     *   思路： 取中点，后面的值可能都满足
     *         只需判断后面的总数是都大于等于中点的值
     *         如果满足，向右移动
     *         如果不满足，向左移动
     *         直到二分结束
     *
     *
     *         =======
     *         右移的时候，长度小或等于当前值，就不会再右移了
     *         左边移动的时候，一直可以
     *
     *         //右边，满足
     *              对右边进行二分查找，右移，知道结束为止
     *
     *         //右边不满足，遍历坐标
     *
     *
     *    todo 不边量 length
     *
     *               找中值，满足 mid++;
     *               不满足，mid--;
     *
     *
     *               还跟具体的值有关系，如果都是很大的值，当前值和剩余尺寸的对比
     *
     *               但前
     *
     *
     *
     *  {1,2}
     */

    public int hIndex(int[] citations) {
       int len=citations.length;
       int left =0;
       int right= len-1;
       if(citations[len-1]==0){
           return 0;
       }
       while (left<right){
           int mid = left+(right-left)/2;
           if(citations[mid]<left-citations[mid]){
               left=mid+1;
           }else{
               right=mid;
           }
       }
       return len-len;
    }
    //</editor-fold>


    //<editor-fold desc="436. 寻找右区间">
    /**
     * 436. 寻找右区间
     * 给你一个区间数组 intervals ，其中 intervals[i] = [starti, endi] ，且每个 starti 都 不同 。
     *
     * 区间 i 的 右侧区间 可以记作区间 j ，并满足 startj >= endi ，且 startj 最小化 。
     *
     * 返回一个由每个区间 i 的 右侧区间 的最小起始位置组成的数组。如果某个区间 i 不存在对应的 右侧区间 ，则下标 i 处的值设为 -1 。
     *
     *
     * 示例 1：
     *
     * 输入：intervals = [[1,2]]
     * 输出：[-1]
     * 解释：集合中只有一个区间，所以输出-1。
     * 示例 2：
     *
     * 输入：intervals = [[3,4],[2,3],[1,2]]
     * 输出：[-1, 0, 1]
     * 解释：对于 [3,4] ，没有满足条件的“右侧”区间。
     * 对于 [2,3] ，区间[3,4]具有最小的“右”起点;
     * 对于 [1,2] ，区间[2,3]具有最小的“右”起点。
     * 示例 3：
     *
     * 输入：intervals = [[1,4],[2,3],[3,4]]
     * 输出：[-1, 2, -1]
     * 解释：对于区间 [1,4] 和 [3,4] ，没有满足条件的“右侧”区间。
     * 对于 [2,3] ，区间 [3,4] 有最小的“右”起点。
     *
     *  todo 二分查找一个非常重要的思想，就是查找右区间
     *
     *        while(left<right){
     *             int mid = left+(right-left)/2;
     *             if(arr[mid]<rightVal){
     *                 left=mid+1;
     *             }else{
     *                 right=mid;
     *             }
     *         }
     *
     *        return left;
     *
     *
     *
     *
     */

    public int binnarySearcgFindRightInterval(int rightVal,int[] arr){
        // 特判
        if (arr[arr.length - 1] < rightVal) {
            return -1;
        }

        int left = 0;
        int right= arr.length-1;
        while(left<right){
            int mid = left+(right-left)/2;
            if(arr[mid]<rightVal){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return left;
    }
    public int[] findRightInterval(int[][] intervals) {
        int arr[]=new int[intervals.length];
        int res[]=new int[intervals.length];
        if(res.length==0){
            return res;
        }
        HashMap<Integer,Integer> map = new HashMap<>(intervals.length);
        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i][0],i);
            arr[i]=intervals[i][0];
        }
        Arrays.sort(arr);
        for (int i = 0; i < intervals.length; i++) {
            int result = binnarySearcgFindRightInterval(intervals[i][1],arr);
            if (result == -1) {
                res[i] = -1;
            } else {
                res[i] = map.get(arr[result]);
            }

        }
        return res;
    }

    //</editor-fold>


    //<editor-fold desc="1300. 转变数组后最接近目标值的数组和">
    /**
     * 给你一个整数数组 arr 和一个目标值 target ，请你返回一个整数 value ，使得将数组中所有大于 value 的值变成 value 后，数组的和最接近  target （最接近表示两者之差的绝对值最小）。
     *
     * 如果有多种使得和最接近 target 的方案，请你返回这些整数中的最小值。
     *
     * 请注意，答案不一定是 arr 中的数字。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：arr = [4,9,3], target = 10
     * 输出：3
     * 解释：当选择 value 为 3 时，数组会变成 [3, 3, 3]，和为 9 ，这是最接近 target 的方案。
     * 示例 2：
     *
     * 输入：arr = [2,3,5], target = 10
     * 输出：5
     * 示例 3：
     *
     * 输入：arr = [60864,25176,27249,21296,20204], target = 56803
     * 输出：11361
     *  
     *
     * 思路：
     *      最小值，二分求区间
     *
     *      最接近应该是，大于等于也有可能小于value
     *
     *      给数组排序
     *
     *      //选择中值，如果左边的和大于target ，左移动，如果小于target 右移动
     *
     */
//    public int findBestValue(int[] arr, int target) {
//        int len=arr.length;
//        Arrays.sort(arr);
//        int left =0;
//        int right=arr.length-1;
//        while(left<right){
//            /**
//             * 求和的过程
//             */
//            int mid = left +(right-left)/2;
//            //求mid左边的数的和
//            int resultLeft=0;
//            for (int i = 0; i < mid; i++) {
//                resultLeft=resultLeft+arr[i];
//            }
//            int resultRight= (left-mid)*arr[mid];
//            if((resultLeft<target){//右移动
//                left=mid+1;
//            }else{//左边的已经大于target，左移
//                right=mid;
//            }
//        }
//        //这时候，可以求边界了
//
//
//    }

    public int findBestValue(int[] arr, int target) {
        int left = 0;
        int right = 0;
        // 注意：left right取的是数组中的值，并非索引
        for (int num : arr) {
            right = Math.max(right, num);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            int sum = calculateSum(arr, mid);
            // 计算第 1 个使得转变后数组的和大于等于 target 的阈值 threshold
            if (sum < target) {
                // 严格小于的一定不是解
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        /**
         *  比较阈值线分别定在 left - 1 和 left 的时候与 target 的接近程度
         *  left是第一个大于target的，所以left-1小于等于tagert，因为是最接近
         *  ，所以left-1也有可能是正确的值。
         */
        int sum1 = calculateSum(arr, left - 1);
        int sum2 = calculateSum(arr, left);
        if (target - sum1 <= sum2 - target) {
            return left - 1;
        }
        return left;
    }

    /**
     * 注意，value不一定是数组中的值，所以一开始排序二分的思路错了
     *
     * 所有大于value的值都等于value，
     * 二小于vaLue的值不变
     * 所以这里用了Math.min
     *
     * @param arr
     * @param threshold
     * @return
     */
    private int calculateSum(int[] arr, int threshold) {
        int sum = 0;
        for (int num : arr) {
            sum += Math.min(num, threshold);
        }
        return sum;
    }

    //</editor-fold>


}
