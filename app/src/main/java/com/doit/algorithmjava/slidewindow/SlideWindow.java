package com.doit.algorithmjava.slidewindow;

// Created by Macro on 8/17/21.

import java.util.ArrayList;
import java.util.HashMap;

public class SlideWindow {


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
}
