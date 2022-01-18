package com.doit.algorithmjava.tree;

import com.doit.algorithmjava.common.TreeNode;

/**
 * 二叉搜索树
 * 二叉搜索树的中序遍历正好是有序的
 */
public class BinarySeacherTree {

    //<editor-fold desc="108. 将有序数组转换为二叉搜索树">
    /**
     * 108. 将有序数组转换为二叉搜索树
     * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
     *
     * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
     *
     *
     *
     * 示例 1：
     *
     *
     * 输入：nums = [-10,-3,0,5,9]
     * 输出：[0,-3,9,-10,null,5]
     * 解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
     *
     * 示例 2：
     *
     *
     * 输入：nums = [1,3]
     * 输出：[3,1]
     * 解释：[1,3] 和 [3,1] 都是高度平衡二叉搜索树。
     *
     *
     * 提示：
     *
     * 1 <= nums.length <= 104
     * -104 <= nums[i] <= 104
     * nums 按 严格递增 顺序排列
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        int length= nums.length;

        if(length==0){
            return null;
        }
        return merge(nums,0,length-1);
    }
    private TreeNode merge(int[] nums,int left , int right){
        if(left>right){
            return null;
        }

        if(left==right){
            return new TreeNode(nums[left]);
        }

        int mid = left + (right-left)/2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left= merge(nums,left,mid-1);
        treeNode.right=merge(nums,mid+1,right);

        return treeNode;
    }
    //</editor-fold>
}
