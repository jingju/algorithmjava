package com.doit.algorithmjava.doublepointer;

/**
 * 双指针
 */
public class DoublePointer {


    //<editor-fold desc=" 167. 两数之和 II - 输入有序数组">
    /**
     *     167. 两数之和 II - 输入有序数组
     *     给定一个已按照 非递减顺序排列  的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
     *
     *     函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
     *
     *     你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
     *
     *
     *     示例 1：
     *
     *     输入：numbers = [2,7,11,15], target = 9
     *     输出：[1,2]
     *     解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
     *     示例 2：
     *
     *     输入：numbers = [2,3,4], target = 6
     *     输出：[1,3]
     *     示例 3：
     *
     *     输入：numbers = [-1,0], target = -1
     *     输出：[1,2]
     */

    public int[] twoSum(int[] numbers, int target) {
        int left =0;
        int right=numbers.length-1;
        int []result = new int[2];
        while(left<right){
            int sum= numbers[left]+numbers[right];
            if(sum==target){
                result[0]=left+1;
                result[1]=right+1;
                return result;
            }else if(sum>target){
                right--;
            }else{
                left++;
            }
        }
        return result;
    }

    //</editor-fold>


    //<editor-fold desc="11. 盛最多水的容器">
    /**
     * 11. 盛最多水的容器
     * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     *
     * 说明：你不能倾斜容器。
     *
     *
     *
     * 示例 1：
     *
     *
     *
     * 输入：[1,8,6,2,5,4,8,3,7]
     * 输出：49
     * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
     * 示例 2：
     *
     * 输入：height = [1,1]
     * 输出：1
     * 示例 3：
     *
     * 输入：height = [4,3,2,1,4]
     * 输出：16
     * 示例 4：
     *
     * 输入：height = [1,2,1]
     * 输出：2
     *
     */

    public int maxArea(int[] height) {
        int start=0;
        int end=height.length-1;
        int resultArea=0;
        while(start!=end){
            //计算面积
            int area = (end - start) * Math.min(height[end], height[start]);
            resultArea = Math.max(resultArea, area);
            if(height[end]>=height[start]){
                start++;
            }else if(height[end]<height[start]){
                end--;
            }

        }
        return resultArea;
    }
    //</editor-fold>
}
