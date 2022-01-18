package com.doit.algorithmjava.queueandstack;

// Created by Macro on 2021/9/8.

import com.doit.algorithmjava.common.ListNode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;

public class QueueAndStackTest {

    //<editor-fold desc="栈">
    /**
     * 20. 有效的括号
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     *
     *
     * 示例 1：
     *
     * 输入：s = "()"
     * 输出：true
     * 示例 2：
     *
     * 输入：s = "()[]{}"
     * 输出：true
     * 示例 3：
     *
     * 输入：s = "(]"
     * 输出：false
     * 示例 4：
     *
     * 输入：s = "([)]"
     * 输出：false
     * 示例 5：
     *
     * 输入：s = "{[]}"
     * 输出：true
     *
     *
     * 提示：
     *
     * 1 <= s.length <= 104
     * s 仅由括号 '()[]{}' 组成
     * todo 字符串，只会包括那几个括号
     */
    public boolean isValid(String s) {
        /**
         * 1、栈里，先放一个，再取，如果一样，将栈里的元素弹出，并取下一个放栈里
         * 2、如果不同，也放栈里。
         * 3、如果整个遍历流程走完，队列为0，则满足
         *    {'，'}'，'['，']
         */
        /**括号都是成对出现的，不是偶数和长度为0的时候肯定是错的*/
//        if(s.length()%2>0||s.length()==0){
//            return false;
//        }
//        HashMap<Character, Character> map = new HashMap<Character,Character>();
//        map.put(')','(');
//        map.put('}','{');
//        map.put(']','[');
//        LinkedList<Character> stack= new LinkedList<>();
//        for (int i = 0; i < s.length(); i++) {
//            Character c = s.charAt(i);
//            if(!map.containsKey(c)){
//                stack.push(c);
//            }else{
//                /**
//                 * 如果满足正确性，栈的最上面一个一定是和当前字符串成对的。
//                 */
//                if (stack.peek() != map.get(c)) {
//                    return false;
//                }
//                stack.pop();
//            }
//        }

        //联系
        if(s.length()%2!=0||s.length()==0){
            return false;
        }

        HashMap<Character,Character> map=new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        Stack<Character> stack= new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if(!map.containsKey(c)){
                stack.push(c);
            }else{
                if(map.get(c) != stack.peek()){
                    return false;
                }

                stack.pop();
            }
        }


        return stack.isEmpty();
    }
    //</editor-fold>







    //<editor-fold desc="队列">

        //<editor-fold desc="优先队列">
    /**
     * 23. 合并K个升序链表
     * 给你一个链表数组，每个链表都已经按升序排列。
     *
     * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
     *
     *
     *
     * 示例 1：
     *
     * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
     * 输出：[1,1,2,3,4,4,5,6]
     * 解释：链表数组如下：
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * 将它们合并到一个有序链表中得到。
     * 1->1->2->3->4->4->5->6
     * 示例 2：
     *
     * 输入：lists = []
     * 输出：[]
     * 示例 3：
     *
     * 输入：lists = [[]]
     * 输出：[]
     * @param lists
     * @return
     */
    /**
     * todo 这个贪心算法的思路很好
     *
     * 1、由于是 k 个排序链表，那么这 k 个排序的链表头结点中 val 最小的结点就是合并以后的链表中最小的结点；
     *
     * 2、最小结点所在的链表的头结点就要更新了，更新成最小结点的下一个结点（如果有的话），此时还是这 k 个链表，
     * 这 k个排序的链表头结点中 val 最小的结点就是合并以后的链表中第 2 小的结点。
     *
     * 写到这里，我想你应该差不多明白了，我们每一次都从这 k 个排序的链表头结点中拿出 val
     * 最小的结点“穿针引线”成新的链表，这个链表就是题目要求的“合并后的排序链表”。“
     * 局部最优，全局就最优”，这不就是贪心算法的思想吗。
     *
     *
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        /**
         * 遍历 list
         * 对三个链表进行比较并重新安装在一个新的链表上
         * todo 可以使用一个优先队列，优先级大的放在对头
         *      小的数，优先级打，当把所有的值都放到
         *
         *      优先级队列一般使用堆实现
         */

        if(lists.length==0){
            return null;
        }
        ListNode tempNode=new ListNode(-1);
        ListNode currentNode= tempNode;
        PriorityQueue<ListNode> priorityQueue= new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;//生序
            }
        });
        //先将每个头结点放进去
        for (ListNode node:lists) {
            if(null!=node){
                priorityQueue.add(node);
            }
        }
        /**
         *  1、当前结点，取出当前结点的下一个结点，放到队列里
         */
        while(!priorityQueue.isEmpty()){
            ListNode node = priorityQueue.poll();//出队首个元素
            currentNode.next=node;
            currentNode=currentNode.next;
           if(currentNode.next!=null){
               priorityQueue.add(currentNode.next);
           }
        }

        return tempNode.next;
    }
        //</editor-fold>






    //</editor-fold>
}
