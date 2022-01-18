package com.doit.algorithmjava.list;

// Created by Macro on 2021/8/26.

import com.doit.algorithmjava.common.ListNode;

import java.util.HashMap;
import java.util.List;

public class LinkList {

    /**
     * 创建一个链表
     * @param
     * @return
     */
    public ListNode createListNode(int[] array){
        ListNode head= new ListNode(0);
        ListNode current=head;
        for (int i = 0; i < array.length; i++) {
            current.next=new ListNode(array[i]);
            current=current.next;
        }
        return head.next;
    }

    /**
     * 876. 链表的中间结点
     * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
     *
     * 如果有两个中间结点，则返回第二个中间结点。
     *
     *
     *
     * 示例 1：
     *
     * 输入：[1,2,3,4,5]
     * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
     * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
     * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
     * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
     * 示例 2：
     *
     * 输入：[1,2,3,4,5,6]
     * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
     * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
     */

    /**
     * 思路，就是遍历链表
     *  用一个map存储索引和值，找出map的中值索引返回就好了。
     *
     * @param head
     * @return
     */
    /**
     * todo 快慢指针：比较经典的做法是：
     *                  tip:快指针移动的速度是慢指针的两倍，
     *                  所以当慢指针移动到中间，快指针已经移到结尾
     *
     * 使用两个指针变量，刚开始都位于链表的第 1 个结点，一个永远一次只走 1 步，一个永远一次只走 2 步，
     * 一个在前，一个在后，同时走。这样当快指针走完的时候，慢指针就来到了链表的中间位置。
     *
     *
     *   思想是：快慢指针的前进方向相同，且它们步伐的「差」是恒定的，根据这种确定性去解决链表中的一些问题。使用这种思想还可以解决链表的以下问题：
         解决这些问题的共同特点就是使用两个指针变量同步移动。解决链表的问题常见的技巧还有：
         1、使用递归函数，避免复杂的更改指针变量指向操作，使得求解问题变得简单。
         「力扣」第 206 题：反转链表；
         「力扣」第 24 题：两两交换链表中的节点；
         「力扣」第 25 题：K 个一组翻转链表；
         「力扣」第 328 题：奇偶链表；
         「力扣」第 203 题：移除链表元素；
         「力扣」第 21 题：合并两个有序链表。
         2、设置「虚拟头结点」，避免对链表第 1 个结点做单独讨论，这个思想在数组里我们见过，叫「哨兵」；
         「力扣」第 2 题：两数相加；
         「力扣」第 82 题：删除排序链表中的重复元素 II。
         3、使用「快慢指针」，本题就是。确切地说，叫「同步指针」可能更好一些；
         4、为链表编写测试函数，进行调试（在下面的参考代码中有），主要是：
         从数组得到一个链表；
         根据当前结点打印当前结点以及后面的结点。
         这两个方法可以非常方便地帮助我们调试关于链表的程序。
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(null!=fast && null!=fast.next){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    /**
     * 2. 两数相加
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     *
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     *
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     *
     *
     * 示例 1：
     *
     *
     * 输入：l1 = [2,4,3], l2 = [5,6,4]
     * 输出：[7,0,8]
     * 解释：342 + 465 = 807.
     * 示例 2：
     *
     * 输入：l1 = [0], l2 = [0]
     * 输出：[0]
     * @param l1
     * @param l2
     * @
     *
     * todo 思路，使用一个结点
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=null;
        ListNode tail=null;
        int valAddToNext=0;
        while(l1!=null || l2!=null){
            int currentSum=valAddToNext+(l1==null?0: l1.val)+(l2==null?0:l2.val);
            if(head==null){
                head=new ListNode(currentSum%10);
            }else{
                tail.next=new ListNode(currentSum%10);
                tail=tail.next;
            }
            if(l1!=null){
                l1=l1.next;
            }
            if(l2!=null){
                l2=l2.next;
            }
            valAddToNext=currentSum/10;
        }
        if(valAddToNext>0){
            tail.next=new ListNode(valAddToNext);
        }

        return head;
    }

//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode result=new ListNode(0);
//        result.next=new ListNode(0);
//        ListNode finalResult=result.next; // 这个以后next是null,所以finalResult也是null。
//        int valAddToNext=0;
//        while(l1.next!=null && l2.next!=null){
//            result=result.next;
//            ListNode listNode = new ListNode(valAddToNext);
//            int addResult=listNode.val+l1.val+l2.val;
//            if(addResult>=10){
//                valAddToNext=addResult%10;
//                listNode.val=0;
//            }else{
//                listNode.val=addResult;
//            }
//            result=listNode;
//            l1=l1.next;
//            l2=l2.next;
//        }
//        if(l1.next!=null){
//            result=result.next;
//            ListNode l1Left=new ListNode(valAddToNext);
//            int addResult=l1Left.val+l1.val+l2.val;
//            if(addResult>=10){
//                valAddToNext=addResult%10;
//                l1Left.val=0;
//            }else{
//                l1Left.val=addResult;
//            }
//            result=l1Left;
//            l1=l1.next;
//        }
//        if(l2.next!=null){
//            result=result.next;
//            ListNode l2Left=new ListNode(valAddToNext);
//            int addResult=l2Left.val+l1.val+l2.val;
//            if(addResult>=10){
//                valAddToNext=addResult%10;
//                l2Left.val=0;
//            }else{
//                l2Left.val=addResult;
//            }
//            result=l2Left;
//            l2=l2.next;
//        }
//        if(valAddToNext>0){
//            result.next=new ListNode(valAddToNext);
//        }
//
//        return finalResult;
//    }


    //<editor-fold desc=" 82. 删除排序链表中的重复元素 II">
    /**
     * 82. 删除排序链表中的重复元素 II
     * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
     *
     * 返回同样按升序排列的结果链表。
     *
     *
     *
     * 示例 1：
     *
     *
     * 输入：head = [1,2,3,3,4,4,5]
     * 输出：[1,2,5]
     * 示例 2：
     *
     *
     * 输入：head = [1,1,1,2,3]
     * 输出：[2,3]
     *
     *
     * 提示：
     *
     * 链表中节点数目在范围 [0, 300] 内
     * -100 <= Node.val <= 100
     * 题目数据保证链表已经按升序排列
     */

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    public ListNode deleteDuplicates(ListNode head) {
        if(null==head){
            return null;
        }
        ListNode virtulHead= new ListNode(0);
        virtulHead.next= head;
        deleateNode(virtulHead,head);
        return virtulHead.next;
    }

    public void deleateNode(ListNode pre,ListNode current){
        if(current==null||current.next==null){
            return;
        }
        if(current.val==current.next.val){
            while(current.next!=null &&current.val==current.next.val){
                current.next=current.next.next;
            }
            pre.next=current.next;
        }else{
            pre=current;
        }
        deleateNode(pre,pre.next);
    }

    //</editor-fold>


    //<editor-fold desc="206. 反转链表">
    /**
     * 206. 反转链表
     * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
     *  
     *
     * 示例 1：
     *
     *
     * 输入：head = [1,2,3,4,5]
     * 输出：[5,4,3,2,1]
     * 示例 2：
     *
     *
     * 输入：head = [1,2]
     * 输出：[2,1]
     * 示例 3：
     *
     * 输入：head = []
     * 输出：[]
     *  
     *
     * 提示：
     *
     * 链表中节点的数目范围是 [0, 5000]
     * -5000 <= Node.val <= 5000
     *  
     *
     * 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-linked-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public ListNode reverseList(ListNode head) {
        ListNode virtulHead= new ListNode(0);
        ListNode currentNode=head;
        /**
         * currentNode必须是原理的Node
         */
        while (currentNode.next!=null){
            //todo 需要将最后一个node的next设置为null,
            //下面的node需要重新创建
            /**
             * 1、给当前节点的next赋值
             * 2、给virtulNode的next赋值日
             */
            //todo 复制一个temp借点，用作下一个节点

            ListNode  temp = new ListNode(currentNode.next.val);
            temp.next = currentNode.next.next;//这时，下一位的下一位还不瘦到影响
            currentNode.next=virtulHead.next;
            virtulHead.next=currentNode;
            currentNode=temp;
        }

        return virtulHead.next;
    }
    //</editor-fold>


    //<editor-fold desc="24. 两两交换链表中的节点">
    /**
     * 24. 两两交换链表中的节点
     * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
     *
     *
     *
     * 示例 1：
     *
     *
     * 输入：head = [1,2,3,4]
     * 输出：[2,1,4,3]
     * 示例 2：
     *
     * 输入：head = []
     * 输出：[]
     * 示例 3：
     *
     * 输入：head = [1]
     * 输出：[1]
     *
     *
     * 提示：
     *
     * 链表中节点的数目在范围 [0, 100] 内
     * 0 <= Node.val <= 100
     *
     * todo 思路：记录当前结点，可以用递归
     *           思路是对的，需要再调整下交换的方法
     *
     */
    public ListNode swapPairs(ListNode head) {
        ListNode virtulNode=new ListNode(0);
        swapPairsRecycle(virtulNode,head);
        return virtulNode.next;

    }

    /**
     * @param current
     * @param currentNext
     */
    public void swapPairsRecycle(ListNode current ,ListNode currentNext){
        if(current==null && null==currentNext){
            return;
        }
        current.next=currentNext;
        ListNode temp=currentNext;
        ListNode tempNext=null;
        if(null!=currentNext.next.next) {
            tempNext = new ListNode(currentNext.next.next.val);
            tempNext.next = currentNext.next.next.next;
        }
        current.next=current.next.next;
        current.next.next=temp;
        //todo 最后一个的Next一定是Null
        swapPairsRecycle(current.next.next,tempNext);
    }
    //</editor-fold>


}
