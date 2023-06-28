package com.doit.algorithmjava.priorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 优先队列:大顶堆 和 小顶堆
 *
 * 重要属性：第i个节点的左子节点的索引为2*i，右子节点的索引为2*i+1
 *
 * 应用场景：查找第k个最大的数或者最小的树。
 *
 */

public class PriorityQueueTest {

    //<editor-fold desc="215. 数组中的第K个最大元素">
    /**
     * 215. 数组中的第K个最大元素
     * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
     *
     * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     *
     *
     *
     * 示例 1:
     *
     * 输入: [3,2,1,5,6,4] 和 k = 2
     * 输出: 5
     * 示例 2:
     *
     * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
     * 输出: 4
     *
     *
     * 提示：
     *
     * 1 <= k <= nums.length <= 104
     * -104 <= nums[i] <= 104
     * 通过次数505,651提交次数781,989
     */

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap=new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //return o1-o2; 也可以
                //todo : tip reture -1;  肯定不行，因为o1与o2的值是不确定的
                return o1.compareTo(o2); //todo tip 从小到大排序，也就是小顶堆，Comparator默认就是从小到大排序
            }
        });
        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            Integer peek = minHeap.peek();
            if(nums[i]>peek){
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
        return minHeap.peek();
    }
    //</editor-fold>

}
