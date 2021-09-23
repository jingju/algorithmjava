package com.doit.algorithmjava.list;

// Created by Macro on 2021/8/26.

import com.doit.algorithmjava.common.ListNode;

import java.util.HashMap;
import java.util.List;

public class LinkList {

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
     *
     * 使用两个指针变量，刚开始都位于链表的第 1 个结点，一个永远一次只走 1 步，一个永远一次只走 2 步，
     * 一个在前，一个在后，同时走。这样当快指针走完的时候，慢指针就来到了链表的中间位置。
     *
     * todo 这个题的思路，以快指针作为参考，来走慢指针
     *
     *   思想是：快慢指针的前进方向相同，且它们步伐的「差」是恒定的，根据这种确定性去解决链表中的一些问题。使用这种思想还可以解决链表的以下问题：
         解决这些问题的共同特点就是使用两个指针变量同步移动。解决链表的问题常见的技巧还有：
         todo
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


}
