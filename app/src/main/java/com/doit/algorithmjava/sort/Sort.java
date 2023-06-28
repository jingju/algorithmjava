package com.doit.algorithmjava.sort;

// Created by Macro on 8/4/21.
/**
 *  下面为一个算法可是化网站，可以通过动画的形式演示各种算法的原理
 * {@see <a href="https://www.cs.usfca.edu/~galles/visualization/ComparisonSort.html"></a>}
 * 排序分类：
 *
 *     1、比较排序
 *          冒泡、选择、插入的实现方式类似，
 *          都需与通过有规律的一轮一轮的比较，
 *          没完成一轮的比较，都回确定一个元素的顺序，
 *          最后一轮比较完成，所有元素的顺序都会被确定。
 *
 *          他们都有
 *                  当前比较参照索引、     curIndex
 *                  当前轮比较的总的长度、  length
 *                  当前轮的结束条件、
 *                  下一轮的起使索引(下轮选择开始的索引)、     nextCircleIndex
 *                  结束条件
 *          这几个相同的条件变量。
 *          都有时间复杂度都较高
 *
 *          冒泡
 *              条件变量：
 *                     curIndex：元素在数组中的索引（当前索引和当前索引的下一个索引的元素值进行比较）
 *                     length：第一轮为数组的总长度，以后每轮依次减一
 *                     当前轮的结束条件：curIndex=length
 *                     下一轮的起使索引：0
 *                     结束条件： length=0
 *              1、当前和下一位比较，如果比后面大，交换两者。
 *              2、当前元素变成下一位元素，在重复步骤1
 *              3、知道当前元素为数组的最后一个元素，结束一轮比较，这时，最后一个元素一定是最大的。
 *              4、将总长度减1，重复1～3的步骤，进行下一轮的比较
 *              5、当总的长度减到0的时候，所有比较结束，数组有序。
 *          选择
 *              和冒泡排序非常类似
 *              条件变量：
 *                  targetIndex：当前值最小的索引
 *
 *                  curIndex：元素在数组中的索引，第一次为1，因为 targetIndex 默认为0（当前索引元素值和 targetIndex 的元素值 进行比较，如果小，targetIndex=curIndex）
 *                  length：数组的长度
 *                  当前轮的结束条件：curIndex=length
 *                  下一轮的起始索引：上一轮排好序的索引+1
 *                  结束条件：下一轮的 起始索引 为数组的 长度
 *              1、给 targetIndex 设置一个默认值0
 *              2、当前和 targetIndex，如果值小于targetIndex ，将targetIndex 设置为当前索引。
 *              3、完成一轮比较后，将targetIndex和数组左边待排序的索引位置元素交换，targetIndex不变
 *              4、下一轮起始元素为下一个待排序的元素。
 *              5、当下一轮的起始元素为length时候，结束。
 *
 *          插入
 *              条件变量：
 *                  curIndex：元素在数组中的索引
 *
 *              1、当前和下一位比较
 *                      如果比后面大
 *                      将后面的元素一次和当前元素前面的元素进行比较，
 *                              如果小于前面的元素，和前面的元素交换，
 *                              直到大于前面的某个元素，或者到达数组的第一个位置，停止。从此完成了一轮的比较。
 *             这里不再做条件变量的分析。
 *
 *          快速
 *             选择一个参照点：referenceIndex
 *             每一轮的思路：
 *                      目标是将参照的索引的值放到数组的某个位置，数组的左边都是小于targert的值，右边都是大于target的值
 *                      参照索引取数组左边第一个，从右面开始比较
 *                      参照索引取数组右边最后一个，从左边开始比较
 *                      比较方式：参照取左边第一个，右边先有个小于 referenceIndex 的值，才会走左边，左边确定了大于 referenceIndex 的值，会交换，
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *          归并
 *              体现了分治算法的思想，先分 后合并
 *
 *
 *     2、非比较排序
 *
 *          堆排序
 *              堆的创建和调整的过程
 *
 *          下面的不再讲解，具体参照以下链接
 *          {@see <a href="https://leetcode-cn.com/problems/sort-an-array/solution/fu-xi-ji-chu-pai-xu-suan-fa-java-by-liweiwei1419/"></a>}
 *          桶排序
 *
 *          计数排序
 *
 *          基数排序
 *
 * 排序的稳定性：
 *
 *      稳定的：
 *
 *      不稳定：
 *
 * 复杂度：
 *
 */








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
    //<editor-fold desc="冒泡排序">
    public int[] bubbleSort(int[] nums) {
        //方式一
        int length=nums.length;
        for (int i = length; i >0; i--) {
            for (int j = 0; j < i; j++) {
                if(nums[j]>nums[j+1]){
                    swap(nums,j,j+1);
                }
            }
        }

        //方式二
//        /**
//         * 每冒完一次泡，总的长度减1
//         */
//        int i=0;
//        int length=nums.length;
//        while (i < length && length != 0) {
//            while (i < length) {
//                if (nums[i] < nums[i + 1]) {
//                    swap(nums, i, i + 1);
//                }
//                i++;
//            }
//            length--;
//            i=0;
//        }
        return nums;
    }
    //</editor-fold>

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
            //选择后面比当前数大的数进行交换
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




    //<editor-fold desc="快速排序">

    /**
     * 快速排序参考链接
     * @{<a href="https://zhuanlan.zhihu.com/p/93129029"></a>}
     * @param nums
     */
    public void quikSort(int[] nums){
        quik(0,nums.length,nums);
    }
    /**
     * 递归快排
     * @param left
     * @param right
     * @param nums
     */
    public void quik(int left,int right,int[] nums){
        // TODO: 2023/5/14 这里的代码是错的
        int tempLeft=left;
        int tempRight=right;
//        int referenceIndex=tempLeft;//参照的目标索引
//        //目标： 将参照的索引的值放到数组的某个位置，数组的左边都是小于targert的值，右边都是大于target的值
//        //参照索引取左，从右面开始比较
//        while (tempLeft != tempRight) {
//            //右边先有个小于 referenceIndex 的值，才会走左边，左边确定了大于 referenceIndex 的值，会交换，
//            //然后重新进行下一轮比较
//            while(nums[tempRight]>nums[referenceIndex]){
//                tempRight--;
//            }
//            while(nums[tempLeft]<nums[referenceIndex]){
//                tempLeft++;
//            }
//            //todo 交换位置
//            swap(nums,tempLeft,tempRight);
//        }
//        //todo 重合，将 referenceIndex 和重合位置的数进行交换
//        swap(nums,referenceIndex,tempLeft);
//        //左边进行递归
//        quik(left,tempLeft-1,nums);
//        //右边进行递归
//        quik(tempRight+1,right,nums);

        int targetVAl=nums[tempLeft];
        while(tempLeft != tempRight){
            //先从有边开始比较
            while(nums[right]>targetVAl){
                tempRight--;
            }
            nums[tempLeft]=nums[tempRight];
            tempLeft++;


            while(nums[tempLeft]<targetVAl){
                tempLeft++;
            }
            nums[tempRight]=nums[tempLeft];
            tempRight--;
        }
        nums[tempLeft]=targetVAl;

        //左边进行递归
        quik(left,tempLeft-1,nums);
        //右边进行递归
        quik(tempRight+1,right,nums);
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



    //<editor-fold desc=" 非比教排序（计数排序，基数排序、桶排序）">


    //</editor-fold>
}