package com.doit.algorithmjava.backtrace;

// Created by Macro on 2021/9/23.

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯相关算法
 */
public class BackTrace {


    /**
     * 46. 全排列
     * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     * 示例 2：
     *
     * 输入：nums = [0,1]
     * 输出：[[0,1],[1,0]]
     * 示例 3：
     *
     * 输入：nums = [1]
     * 输出：[[1]]
     */
    public void def(int[] nums,int length,int depth,boolean[] used,List<Integer> path,List<List<Integer>> res){

        if(depth==length){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < length; i++) {
            if(!used[i]){
                path.add(nums[i]);
                used[i]=true;
                def(nums,length,depth+1,used,path,res);
                //回退到上一步
                used[i]=false;
                path.remove(depth-1);
            }
        }

    }
    public List<List<Integer>> permute(int[] nums) {
        int length= nums.length;
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        List<Integer> path=new ArrayList<>();
        boolean [] used= new boolean[length];
        def(nums,length,0,used,path,res);
        return res;
    }
}
