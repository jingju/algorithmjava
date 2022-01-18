package com.doit.algorithmjava.tree;

// Created by Macro on 2021/9/13.

import com.doit.algorithmjava.common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 * todo 大多数树的变种和算法 都依赖于树的遍历，所以树的遍历是最基础的，也是最需要掌握的
 *
 */


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
     * 扣」LeetCode 第 144 题：二叉树的前序遍历、「力扣」第 94 题：二叉树的中序遍历、「力扣」第 145 题：二叉树的后序遍历。
     */


    //<editor-fold desc="144. 二叉树的前序遍历">
    /**
     * 144. 二叉树的前序遍历
     * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
     *
     *
     *
     * 示例 1：
     *
     *
     * 输入：root = [1,null,2,3]
     * 输出：[1,2,3]
     * 示例 2：
     *
     * 输入：root = []
     * 输出：[]
     * 示例 3：
     *
     * 输入：root = [1]
     * 输出：[1]
     *
     * 思路：递归 根->左->右
     */
    ArrayList<Integer> list = new ArrayList();
    public List<Integer> preorderTraversal(TreeNode root) {
        preOrder(list,root);
        return list;
    }

    public void preOrder(ArrayList list,TreeNode node){
        if(node==null) return;
        list.add(node.val);
        preOrder(list,node.left);
        preOrder(list,node.right);
    }
    //</editor-fold>


    //<editor-fold desc=" 94. 二叉树的中序遍历">
    /**
     * 94. 二叉树的中序遍历
     * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
     *
     *
     *
     * 示例 1：
     *
     *
     * 输入：root = [1,null,2,3]
     * 输出：[1,3,2]
     * 示例 2：
     *
     * 输入：root = []
     * 输出：[]
     * 示例 3：
     *
     * 输入：root = [1]
     * 输出：[1]
     * 示例 4：
     *
     *
     * 输入：root = [1,2]
     * 输出：[2,1]
     * 示例 5：
     *
     *
     * 输入：root = [1,null,2]
     * 输出：[1,2]
     *
     *
     * 提示：
     *
     * 树中节点数目在范围 [0, 100] 内
     * -100 <= Node.val <= 100
     *
     *
     * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
     *
     * 通过次数658,782提交次数871,525
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        midOrder(list,root);
        return list;
    }

    public void midOrder(ArrayList list,TreeNode node){
        if(node==null) return;
        midOrder(list,node.left);
        list.add(node.val);
        midOrder(list,node.right);
    }

    //</editor-fold>


    //<editor-fold desc="145. 二叉树的后序遍历">
    /**
     * 145. 二叉树的后序遍历
     * 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
     *
     *
     *
     * 示例 1：
     *
     *
     * 输入：root = [1,null,2,3]
     * 输出：[3,2,1]
     * 示例 2：
     *
     * 输入：root = []
     * 输出：[]
     * 示例 3：
     *
     * 输入：root = [1]
     * 输出：[1]
     *
     *
     * 提示：
     *
     * 树中节点的数目在范围 [0, 100] 内
     * -100 <= Node.val <= 100
     *
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        postOrder(list,root);
        return list;
    }

    public void postOrder(ArrayList list,TreeNode node){
        if(node==null) return;
        postOrder(list,node.left);
        postOrder(list,node.right);
        list.add(node.val);
    }
    //</editor-fold>










    //<editor-fold desc="105. 从前序与中序遍历序列构造二叉树">
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
     * 5、递归方法里面的操作：执行2 、 3 、4 ，直到达到退出条件后退出递归。
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
    //</editor-fold>


    //<editor-fold desc="226. 翻转二叉树">
    /**
     * 226. 翻转二叉树
     * 翻转一棵二叉树。
     *
     * 示例：
     *
     * 输入：
     *
     *      4
     *    /   \
     *   2     7
     *  / \   / \
     * 1   3 6   9
     * 输出：
     *
     *      4
     *    /   \
     *   7     2
     *  / \   / \
     * 9   6 3   1
     * 备注:
     * 这个问题是受到 Max Howell 的 原问题 启发的 ：
     *
     * 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
     * 通过次数358,619提交次数454,879
     * 请问您在哪类招聘中遇到此题？
     *
     * todo 思路 在遍历的过程中左右交换
     *           根-》左-》右
     */
    public TreeNode invertTree(TreeNode root) {
        traval(root);
        return root;
    }

    public void traval(TreeNode node){
        if(node==null) return;
        TreeNode temp=node.left;
        node.left=node.right;
        traval(node.left);
        node.right=temp;
        traval(node.right);
    }

    //</editor-fold>


}
