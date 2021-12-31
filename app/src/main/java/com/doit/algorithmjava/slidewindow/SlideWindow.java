package com.doit.algorithmjava.slidewindow;

// Created by Macro on 8/17/21.

import java.util.ArrayList;
import java.util.HashMap;

public class SlideWindow {


    //<editor-fold desc="LeetCode 3">
    /**
     * LeetCode 3
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     *  
     *
     * 示例 1:
     *
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     *
     * 输入: s = "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     *
     * 输入: s = "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     *
     */

    /**
     *   int len = s.length();
     *         if (len < 2) {
     *             return len;
     *         }
     *
     *         // 当 window 中某个字符的频数为 2 时，表示滑动窗口内有重复字符
     *         // 频数数组，128 由测试数据的范围决定
     *         int[] freq = new int[128];
     *         // 转换为字符数组，避免每一次 s.charAt() 方法检查下标越界
     *         char[] charArray = s.toCharArray();
     *         int left = 0;
     *         int right = 0;
     *         int res = 1;
     *         // 循环不变量：区间[left..right] 内没有重复元素
     *         while (right < len) {
     *             freq[charArray[right]]++; //todo 代表这个数的位置的值加一，如果大雨1就是重复了
     *             // 此时 [left..right) 内如果没有重复元素，就尝试扩张 right
     *             // 否则缩小左边界，while 循环体内不断缩小边界
     *             if (freq[charArray[right]] == 2) { // todo 重复了
     *                 while (freq[charArray[right]] == 2) {
     *                     freq[charArray[left]]--;
     *                     left++;
     *                 }
     *             }
     *
     *             // 此时 [left..right] 内没有重复元素
     *             res = Math.max(res, right - left + 1); //todo 和上一次重复的值比较
     *             right++;
     *         }
     *         return res;
     * @param s
     * @return
     */
    /**
     * todo 正确思路
     *      用map的key代表字符，value代表字符在字符串中的索引
     *      start不动，end向后移动
     *      当end遇到重复字符，start应该放在上一个重复字符的位置的后一位，同时记录最长的长度
     *      怎样判断是否遇到重复字符，且怎么知道上一个重复字符的位置？--用哈希字典的key来判断是否重复，用value来记录该字符的下一个不重复的位置。
     */

    /**
     * todo 1 遇到字符串便利的，将字符串转换成字符数组
     *
     * @param s
     * @return
     */

//    int length = s.length();
//    int max = 0;
//
//    Map<Character, Integer> map = new HashMap<>();
//        for(int start = 0, end = 0; end < length; end++){
//        char element = s.charAt(end);
//        if(map.containsKey(element)){
//            start = Math.max(map.get(element) + 1, start); //map.get()的地方进行+1操作
//        }
//        max = Math.max(max, end - start + 1);
//        map.put(element, end);
//    }
//        return max;
    //ok
    public int lengthOfLongestSubstring(String s){
        if(s.length()<2){//tip： 这里要判断为空或者是1个字符的情况。
            return s.length();
        }
        HashMap<Character,Integer> map= new HashMap<Character, Integer>();
        int start=0;
        int end=0;
        int maxLength=1;
        map.put(s.charAt(0),0);
        while(end <s.length()-1){
            end++;
            if(map.containsKey(s.charAt(end))){
                start=Math.max(start,map.get(s.charAt(end))+1);
            }
            map.put(s.charAt(end),end);
            maxLength=Math.max(maxLength,end-start+1);
        }
//        if(s.isEmpty()){
//            return 0;
//        }
//        HashMap<Character,Integer> map= new HashMap<Character, Integer>();
//        int start=0;
//        int end=0;
//        int maxLength=0;
//        map.put(s.charAt(0),0);
//        while(end <s.length()-1){
//            /**
//             * 没有、放进去，有也得放进去，所以，end的处理在最外层，里面只做放置就好了
//             *
//             * ++ 放在前面
//             */
//
//            end++;
//            if(map.containsKey(s.charAt(end))){
//                start=Math.max(start,map.get(s.charAt(end))+1);
//            }
//            map.put(s.charAt(end),end);
//            maxLength=Math.max(maxLength,end-start+1);
//        }
        return maxLength;
    }
    //</editor-fold>


    //<editor-fold desc="76. 最小覆盖子串">

    public SlideWindow() {
    }

    /**
     * 76. 最小覆盖子串
     * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
     *
     *
     *
     * 注意：
     *
     * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
     * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
     *
     *
     * 示例 1：
     *
     * 输入：s = "ADOBECODEBANC", t = "ABC"
     * 输出："BANC"
     * 示例 2：
     *
     * 输入：s = "a", t = "a"
     * 输出："a"
     * 示例 3:
     *
     * 输入: s = "a", t = "aa"
     * 输出: ""
     * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
     * 因此没有符合条件的子字符串，返回空字符串。
     */
    public String minWindow(String s, String t) {
        /**
         * t 目标字符串
         *
         * s 原字符串
         *
         * 目的：s中涵盖t的所有字符的子串
         *
         * 思路：在s中找包含t中素有字符的最小子串
         *
         *     1、暴力遍历（时间复杂度相当高）
         *     2、双指针
         *     3、还要有存储功能，set
         *
         */

        int start=0;
        int end=0;

        /**
         *  遍历,最短字串，
         *
         *  所以要找到每一种可能，并求最短的
         *
         *  字符的顺序有可能不是目标字符的顺序，这种没有顺序的，所以要判断索引下在值是在t中包含，切不能跟前面的值重复
         */

//        for (int i = 0; i < t.length(); i++) {
//            char c = t.charAt(i);
//
//        }
        //todo 这里的need起到的是一个窗口的作用 need[c]--代表加入窗口，need[c]++代表移出窗口

        int [] need=new int[128];
        int needCount=0;

        //设置相应的字符串的个数
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }

        needCount=t.length();
        /**
         * todo 双指针的遍历条件右边的端点是否达到了字符串的长度
         *
         */
        while(end<s.length()){
            /**
             *  todo 正常确定一个满足的串
             *
             *  start end 都是0
             */
            if(need[t.charAt(end)]>0){//包括在内
                needCount--;
            }
            need[t.charAt(end)]--;//数量减1
            //todo 如果满足条件的情况下，缩小左边届，我想这样也能用，
            if(needCount==0){//包含子串
                /**
                 * 记录子串
                 *
                 * 左移left,判断如果满足，继续左移动，如果不满足右边移动end,知道到头为止
                 *
                 * 判断是否满足的条件是 needCount<
                 */
                while(start<end && need[t.charAt(start)]<0){//没有在目标字符串中的字符

                    need[t.charAt(start)]++;
                    start++;

                }
            }

            //todo 当窗口的尺寸小于t.length的时候，或者start=end的时候，结束移动，返回最小字串
            end++;

        }

        return s;
    }

    //</editor-fold>


    //<editor-fold desc=" 209. 长度最小的子数组">
    /**
     * 209. 长度最小的子数组
     * 给定一个含有 n 个正整数的数组和一个正整数 target 。
     *
     * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：target = 7, nums = [2,3,1,2,4,3]
     * 输出：2
     * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
     * 示例 2：
     *
     * 输入：target = 4, nums = [1,4,4]
     * 输出：1
     * 示例 3：
     *
     * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
     * 输出：0
     */
    public int minSubArrayLen(int target, int[] nums) {
        if(nums.length>=1&&nums[0]>=target){
            return 1;
        }

        int stat=0;
        int end=stat+1;
        int length=0;
        int sum=nums[stat];

        //滑动窗口算法的结束条件
       while(end<nums.length){
           /**
            * 1、计算之前的和，如果不满足，end++
            *        如果满足，start左移，再判断是否满足
            */
           //计算和

           //todo 不能这样写，这样写就陷入了死循环
//           if(sum<target){
//               end++;
//           }else{
//               length=Math.min(length,end-stat);
//
//               //先左移动，看看是否仍然满足，不满足的话再右移动
//               sum-=nums[stat];
//               stat++;
//               if(sum<target){
//                   //右移动
//               }
//
//           }
           //todo 所以要用循环或者递归调用
           /**
            * todo 只要是end ++了就走最外层了
            *
            * todo start可以等于end
            */
           //todo !!!!!!还是不想，需要再调试
           sum+=nums[end];
           while (sum >= target && stat<=end) {
               //这里改造一下
               int currentLength=end-stat+1;
               length=(length==0?currentLength:Math.min(length,currentLength));
               sum -= nums[stat];
               stat++;
           }
           end++;
       }

        return length;

    }
    //</editor-fold>


    //<editor-fold desc="424. 替换后的最长重复字符">
    /**
     * 424. 替换后的最长重复字符
     * 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
     *
     * 注意：字符串长度 和 k 不会超过 104。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s = "ABAB", k = 2
     * 输出：4
     * 解释：用两个'A'替换为两个'B',反之亦然。
     * 示例 2：
     *
     * 输入：s = "AABABBA", k = 1
     * 输出：4
     * 解释：
     * 将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
     * 子串 "BBBB" 有最长重复字母, 答案为 4。
     *
     *
     *
     * 思路：
     *     1、被替换的字符必须能连起来
     *     2、替换k次
     *     3、都是大些字符
     *     4、求连续的长度
     *   关键点：替换的过程如何开始，并以什么作为替换的依据
     *   todo tip:通过是通过了，但是算法效率很低
     *
     */
    public int characterReplacement(String s, int k) {
        /**
         * 1、判断向前不一样的字符串的下一个是否一样，如果一样，将当前字符串替换成一样的
         *
         * 2、可以替换k次
         *  todo 标记第一个与当前串不一样的字符，并回退到哪里
         *
         *       结束的条件end <= s.length
         * 3、目的找最长重复字母的的字符串的长度
         *
         * 4、中间间隔两个不一样的，就无法替换了
         *
         */
        int start = 0;
        int end = start + 1;
        int length = 1;
        int times = 0;//替换的次数
        int lastdiff=start;
        int result=1;
        /**
         * todo tip:这里也用到了回溯算法的思路
         *      这里的结束条件应该不是这个了
         */
        /**
         * todo !!!!!!!!!!! 再加个k等于0的情况就好了
         */
        /**
         * todo 判断完最大长度，有一个像左回退的过程
         */
        while (end < s.length()) {
            /**
             * 如果当前和上一个不一样
             * 看下一个是否和上一个一样，如果一样可以替换当前，不一样，则不能替换，start移动到当前位置
             */
            //todo 就是个递归低哦啊用而已,不改变原来字符串的内容

            if(s.charAt(end)==s.charAt(start)) {
                length++;
                end++;
                //todo 判断长度，也向左滑动
                if(end==s.length()-1){
                    while(times<k && start>0){
                        //todo 因为这里的start不一定是最长的那个，所以不能这样用
                        start--;
                        length++;
                        times++;
                    }
                }
                result=Math.max(result,length);
            }else {//
                //替换
                if(times<k) {
                    if(times==0) {
                        lastdiff=end;
                    }
                    length++;
                    times++;
                    end++;
                    if(end==s.length()-1){
                        while(times<k && start>0){
                            //todo 因为这里的start不一定是最长的那个，所以不能这样用
                            start--;
                            length++;
                            times++;
                        }
                    }
                    result=Math.max(result,length);
                } else {//清零
                    //todo 这时可以向左滑
                    result=Math.max(result,length);
                    length=1;
                    times=0;
                    if(k==0){
                        lastdiff=end;
                    }
                    start=lastdiff;
                    end=start+1;
                }
            }
        }

        return result;
    }

    //</editor-fold>
}
