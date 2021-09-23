package com.doit.algorithmjava.tree;

// Created by Macro on 2021/9/13.

import android.text.PrecomputedText;

import com.doit.algorithmjava.common.TreeNode;

import java.util.HashMap;

/**
 * 二叉树的遍历
 * 我们解决许多问题的时候，都有分治算法的思想在里面。
 *
 * 分治算法的思想：
 *       把原问题拆解成若干个与原问题结构相同但规模更小的子问题，待子问题解决以后，原问题就得以解决
 *
 *
 * 同样，二叉树的遍历也有分治算法的思想。
 *
 */
public class TraversaslTree {

    /**
     * 105. 从前序与中序遍历序列构造二叉树
     * 给定一棵树的前序遍历 preorder 与中序遍历  inorder。请构造二叉树并返回其根节点。
     *
     *
     *
     * 示例 1:
     *
     *
     * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
     * Output: [3,9,20,null,null,15,7]
     * 示例 2:
     *
     * Input: preorder = [-1], inorder = [-1]
     * Output: [-1]
     *
     * 提示提示:
     * 1 <= preorder.length <= 3000
     * inorder.length == preorder.length
     * -3000 <= preorder[i], inorder[i] <= 3000
     *
     * todo 注意，二叉树中没有重复元素===============
     *
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> indexMap=new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i],i);
        }

        return buildTree2(indexMap,0,inorder.length-1,0,preorder);
    }
    /**
     * 总体算法思想：分治  递归
     *            做这道题的前提是知道什么是二叉树的前序遍历和中序遍历
     *
     * 1、用map保存所有数组对应的索引，避免去遍历数组查找根结点的位置
     *
     * 2、前序遍历中找到根结点，第一次为数组的第一个元素，创建根结点的对象root
     *
     * 3、因为前序遍历和中序遍历都是同一组数据的不同排列方式，
     *   所以，根据前序号遍历的中得到的根结点的值，在中序遍历中找到根结点的索引，
     *   索引的左边全部为左子树，右边全部为右子树，
     *   从而根据根结点的索引和数组的总长度，可以得到左子树的长度和右子树的长度，
     *
     * 4、
     *    用 得到的左子树的具体信息构建递归方法， 给2中创建的根结点的左子树root.left 对象赋值。
     *    用 得到的右子树的具体信息创建递归方法，  给2中创建的根结点的左子树root.right 对象赋值。
     *
     * 5、递归方法里面的操作：执行2 、 3 、4 ，知道达到退出条件后退出递归。
     *    递归退出的条件：
     *         前序遍历的左结点大于右结点
     *
     * 7、容易混淆的地方：
     *         前序遍历和中序遍历的排列顺序完全不一样
     *
     *         中序遍历起到的作用是根据前序遍历中找到的跟结点，结合自身的特性，计算出左子树和右子树的尺寸。前序遍历中左右子树
     *         的尺寸和中序遍历中的大小是一样的。
     *
     *         根据左右子树的尺寸，基于前序遍历的数组，注意，这里是基于前序遍历的数组，得到两个新的同样是前序遍历数组的左、
     *         右子树，分别进入新的递归条件。
     *
     *         最终，前序遍历的右边界大于左边姐，结束递归。
     *
     *
     */

    public TreeNode buildTree2(HashMap<Integer,Integer> map,int preLeftIndex,
            int preRightIndex,int inLeftIndex,int[] preorder){
        if(preLeftIndex>preRightIndex){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preLeftIndex]);
        int inRootIndex=map.get(preorder[preLeftIndex]);
        int leftTreeSize=inRootIndex-inLeftIndex;
        root.left=buildTree2(map,
                preLeftIndex+1,
                 preLeftIndex+leftTreeSize,
                inLeftIndex,
                preorder);
        root.right=buildTree2(map,
                preLeftIndex+leftTreeSize+1,
                preRightIndex,
                inRootIndex+1,
                preorder);
        return root;
    }

}
