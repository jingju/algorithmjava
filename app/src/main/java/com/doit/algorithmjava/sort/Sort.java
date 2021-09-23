package com.doit.algorithmjava.sort;

// Created by Macro on 8/4/21.

/**
 * 912
 * 给你一个整数数组 nums，请你将该数组升序排列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：nums = [5,1,1,2,0,0]
 * 输出：[0,0,1,1,2,5]
 *
 * 一下一些基础排序肃反都基于leetcode 912题
 * 题解参考 https://leetcode-cn.com/problems/sort-an-array/solution/fu-xi-ji-chu-pai-xu-suan-fa-java-by-liweiwei1419/
 */

//todo 写文章说明下，什么是稳定和非稳定的排序
public class Sort {

    //<editor-fold desc="选择排序">

    /**
     * 选择排序
     * todo 这在leetcode上会超时
     *
     * @param nums
     * @return
     */
    public int[] selectionSort(int[] nums) {
        /**
         * 从第一个开始，
         */
        int targetIndex = 0;
        for (int i = 0; i < nums.length - 1; i++) {//
            targetIndex = i;
            for (int j = i + 1; j < nums.length; j++) {//注意，第二个for循环的值取length
                if (nums[j] < nums[targetIndex]) {
                    targetIndex = j;
                }
            }
            // 狡猾i和targetIndex
            swap(nums, i, targetIndex);
        }
        return nums;

    }

    //</editor-fold>
    //<editor-fold desc="swap 交换两个数">
    private void swap(int[] nums, int i, int targetIndex) {
        int temp = nums[i];
        nums[i] = nums[targetIndex];
        nums[targetIndex] = temp;
    }
    //</editor-fold>

    //<editor-fold desc="插入排序">

    /**
     * 确定基础的变化部分
     *
     * 确定部分变化，随着整体变化调整的部分
     *
     *
     * @param nums
     * @return
     */
    public int[] insertionSort(int[] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            int targetVal=nums[i+1];
            for (int j = i+1; j >=0; j--) {//关注第二个for循环的边界问题
                if(j==0){
                    nums[j]=targetVal;
                    break;
                }
                if(targetVal>=nums[j-1]){
                    nums[j]=targetVal;
                    break;
                }
                //todo 到这里，就没有下一次比较的机会会了，所以这个要在前面，
                if(targetVal<nums[j-1]){
                    nums[j]=nums[j-1];
                }
            }
        }
        return nums;
    }


    //</editor-fold>


    //<editor-fold desc="merge sort">

    /**
     * 运用了分治的思想
     * 先分后合
     * 合并的过程中排序
     *
     *
     *   //理解递归
     *       todo
     *        每一次递归，相当于往一个栈中村了一个方法（暂且叫方法）
     *        每执行完一个方法，相当于将一个方法出栈，
     *        只有当前后面的执行完，前面的才能执行，直到递归方法全部执行完。
     *        所以，递归的结束点，是最后一个方法执行完的那个点。
     *
     * todo 分的时候用用的是递归
     *      当分到一个数组只有两个元素的售后，后续的merge
     *
     * @param nums
     * @return
     */
    int[]temp;
    public int[] mrSort(int[] nums) {
        temp=new int[nums.length];
        mergeSort(nums,0,nums.length-1,temp);

        //todo
        return nums;
    }

    public void  mergeSort(int[] nums,int left,int right,int[] temp){
        /**
         * 当只剩一个元素时候，这个方法将会直接执行完，不会继续阻塞。
         * 它的上一个mergeSort方法里面，只需要执行merge，就好了
         */
        if(left<right) {//当left right 只有一个元素的时候，递归将结束
            int mid = (right - left) / 2 + left;
            mergeSort(nums, left, mid, temp);
            mergeSort(nums, mid + 1, right, temp);
            merge(nums,left,mid,right,temp);
        }
    }

    /**
     * 这里的temp重复利用的，每一次merge都会设置不同的值，直到最后一次merge才会得到正确的结果
     * @param nums
     * @param left
     * @param mid
     * @param right
     * @param temp
     */
    public void  merge(int[]nums ,int left ,int mid,int right ,int[] temp){//合并最终两边的排序结果
        /**
         *  合并
         *  1、两边都有元素
         *  2、只剩下一边有元素
         */

        int t =0;//执行temp中的索引
        int i=left;
        int j = mid+1;

        while(i<=mid && j<=right){
            if(nums[i]<=nums[j]){
                temp[t]=nums[i];
                t++;
                i++;
            }else{
                temp[t]=nums[j];
                t++;
                j++;
            }
        }

        while( i <= mid) {
            temp[t] = nums[i];
            t += 1;
            i += 1;
        }

        while( j <= right) {
            temp[t] = nums[j];
            t += 1;
            j += 1;
        }



        t = 0;
        int Left = left;
        while(Left <= right) {
            nums[Left] = temp[t];
            t += 1;
            Left += 1;
        }

    }
    //</editor-fold>





    //<editor-fold desc="堆排序">

    /**
     * 将最大元素放到末尾后，即将堆的总长度减去- ，再调整剩余的堆的元素，
     * @param nums
     * @return
     */
    public int[] sortArray(int[] nums) {
        int len = nums.length;
        // 将数组整理成堆
        heapify(nums);

        // 循环不变量：区间 [0, i] 堆有序
        for (int i = len - 1; i >= 1; ) {
            // 把堆顶元素（当前最大）交换到数组末尾
            swap(nums, 0, i);
            // 逐步减少堆有序的部分
            i--;
            // 下标 0 位置下沉操作，使得区间 [0, i] 堆有序
            siftDown(nums, 0, i);
        }
        return nums;
    }

    /**
     * 将数组整理成堆（堆有序）todo
     *
     * @param nums
     */
    private void heapify(int[] nums) {//todo 从下到上，从又到左构建一个大根堆
        int len = nums.length;
        // 只需要从 i = (len - 1) / 2 这个位置开始逐层下移
        for (int i = (len - 1) / 2; i >= 0; i--) {
            siftDown(nums, i, len - 1);
        }
    }

    /**
     * @param nums
     * @param k    当前下沉元素的下标
     * @param end  [0, end] 是 nums 的有效部分
     */
    private void siftDown(int[] nums, int k, int end) {
        while (2 * k + 1 <= end) {
            int j = 2 * k + 1;
            if (j + 1 <= end && nums[j + 1] > nums[j]) {
                j++;
            }
            if (nums[j] > nums[k]) {
                swap(nums, j, k);
            } else {
                break;
            }
            k = j;
        }
    }

    //</editor-fold>

}