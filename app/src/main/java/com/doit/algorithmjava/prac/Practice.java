package com.doit.algorithmjava.prac;

/**
 * @author: zgj
 * @description:
 * @email: zhaoguangju@situdata.com
 * @date: 2023/5/14
 */
public class Practice {
    // TODO: 2023/5/14 练习用
//    二分

    public int search(int[] nums, int target) {
        int left =0;
        int right = nums.length-1;
        while(left<=right){
            int index = left + (right - left)/2;
            //拿中间的数值和目标值进行比较
            if(nums[index] < target){
                left = index+1;
            }else if(nums[index] > target){
                right= index -1;
            }else {
                return index;
            }
        }
        return -1;
    }


    // TODO: 2023/5/14

    public void  sort(int[] array){

    }
}
