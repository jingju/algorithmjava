package com.doit.algorithmjava.binarysearch;

// Created by Macro on 2021/11/16.

/**
 * 题型三
 * 复杂的判别函数（最大值极小化问题）
 */

public class BinnarySearch3 {

    //<editor-fold desc="875. 爱吃香蕉的珂珂">
    /**
     * 875. 爱吃香蕉的珂珂
     * 珂珂喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 H 小时后回来。
     *
     * 珂珂可以决定她吃香蕉的速度 K （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
     *
     * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
     *
     * 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。
     *
     *
     *
     * 示例 1：
     *
     * 输入: piles = [3,6,7,11], H = 8     3 2 3 3
     * 输出: 4
     * 示例 2：
     *
     * 输入: piles = [30,11,23,4,20], H = 5
     * 输出: 30
     * 示例 3：
     *
     * 输入: piles = [30,11,23,4,20], H = 6
     * 输出: 23
     *
     *
     * 提示：
     *
     * 1 <= piles.length <= 10^4
     * piles.length <= H <= 10^9
     * 1 <= piles[i] <= 10^9
     *
     *
     * 思路：N堆香蕉
     *      i堆有 pile[i]根
     *      总时间 H 小时
     *
     *      吃香蕉的速度  K(根每小时）
     *
     *      少于k根，将不再吃
     *
     *      求：H小时内，吃掉所有香蕉的最小速度
     *
     *
     *      当香蕉大于K ，1小时吃不完
     *
     *      最大速度K能覆盖
     *
     *      =============解答和 1283. 使结果不超过阈值的最小除数 类似
     */

    public int minEatingSpeed(int[] piles, int h) {

//        int left=1;
//        int right = piles[i];//最大的
//        while(left<right){
//            int mid = left+(right-left)/2;//mid 根
//            int totaltim
//            for (int i = 0; i < piles.length; i++) {
//
//            }
//
//
//        }

        return 0;

    }
    //</editor-fold>
    //<editor-fold desc="1011. 在 D 天内送达包裹的能力">
    /**
     * 1011. 在 D 天内送达包裹的能力
     * 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
     *
     * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
     *
     * 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
     *
     *
     *
     * 示例 1：
     *
     * 输入：weights = [1,2,3,4,5,6,7,8,9,10], D = 5
     * 输出：15
     * 解释：
     * 船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
     * 第 1 天：1, 2, 3, 4, 5
     * 第 2 天：6, 7
     * 第 3 天：8
     * 第 4 天：9
     * 第 5 天：10
     *
     * 请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) 是不允许的。
     * 示例 2：
     *
     * 输入：weights = [3,2,2,4,1,4], D = 3
     * 输出：6
     * 解释：
     * 船舶最低载重 6 就能够在 3 天内送达所有包裹，如下所示：
     * 第 1 天：3, 2
     * 第 2 天：2, 4
     * 第 3 天：1, 4
     * 示例 3：
     *
     * 输入：weights = [1,2,3,1,1], D = 4
     * 输出：3
     * 解释：
     * 第 1 天：1
     * 第 2 天：2
     * 第 3 天：3
     * 第 4 天：1, 1
     *
     * 四六：船的的最大运载量为所有包裹的总重量，这样1天就能运完
     *
     */
    public int shipWithinDays(int[] weights, int days) {
        //求总重量
        int totalWeights=0;
        int left=1;//至少得有1个的重量
        for (int i = 0; i < weights.length; i++) {
            totalWeights=totalWeights+weights[i];
            left=Math.max(left,weights[i]);//至少能运船上最大的的一个包裹
        }
        int right=totalWeights;
        //最低运载能力也就是右区间的第一个，注意整除的情况
        while(left<right){
            int mid = left +(right-left)/2;
            /**
             * 判断是否能在days内运完
             * 计算运完需要的天数和days比较
             * left为最小的重量
             */
            int totlalDays=0;
            int currentDayWeights=0;
            int len=weights.length;
            for (int i = 0; i < len; i++) {
                currentDayWeights=currentDayWeights+weights[i];
                if(currentDayWeights>mid){
                    if(i==(len-1)){//最后一次大于要加2
                        totlalDays=totlalDays+2;
                    }else{
                        currentDayWeights=weights[i];
                        totlalDays++;
                    }
                }else if(currentDayWeights==mid){
                    totlalDays++;
                    currentDayWeights=0;
                }else{
                    if(i==(len-1)){
                        totlalDays++;
                    }
                }
            }
            if(totlalDays>days){
                left=mid+1;
            }else{
                right=mid;//todo tip 这里不能是mid-1;
            }
        }

        return left;
    }
    //</editor-fold>


    //<editor-fold desc=" 1482. 制作 m 束花所需的最少天数">
    /**
     * 1482. 制作 m 束花所需的最少天数
     * 给你一个整数数组 bloomDay，以及两个整数 m 和 k 。
     *
     * 现需要制作 m 束花。制作花束时，需要使用花园中 相邻的 k 朵花 。
     *
     * 花园中有 n 朵花，第 i 朵花会在 bloomDay[i] 时盛开，恰好 可以用于 一束 花中。
     *
     * 请你返回从花园中摘 m 束花需要等待的最少的天数。如果不能摘到 m 束花则返回 -1 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：bloomDay = [1,10,3,10,2], m = 3, k = 1
     * 输出：3
     * 解释：让我们一起观察这三天的花开过程，x 表示花开，而 _ 表示花还未开。
     * 现在需要制作 3 束花，每束只需要 1 朵。
     * 1 天后：[x, _, _, _, _]   // 只能制作 1 束花
     * 2 天后：[x, _, _, _, x]   // 只能制作 2 束花
     * 3 天后：[x, _, x, _, x]   // 可以制作 3 束花，答案为 3
     * 示例 2：
     *
     * 输入：bloomDay = [1,10,3,10,2], m = 3, k = 2
     * 输出：-1
     * 解释：要制作 3 束花，每束需要 2 朵花，也就是一共需要 6 朵花。而花园中只有 5 朵花，无法满足制作要求，返回 -1 。
     * 示例 3：
     *
     * 输入：bloomDay = [7,7,7,7,12,7,7], m = 2, k = 3
     * 输出：12
     * 解释：要制作 2 束花，每束需要 3 朵。
     * 花园在 7 天后和 12 天后的情况如下：
     * 7 天后：[x, x, x, x, _, x, x]
     * 可以用前 3 朵盛开的花制作第一束花。但不能使用后 3 朵盛开的花，因为它们不相邻。
     * 12 天后：[x, x, x, x, x, x, x]
     * 显然，我们可以用不同的方式制作两束花。
     * 示例 4：
     *
     * 输入：bloomDay = [1000000000,1000000000], m = 1, k = 1
     * 输出：1000000000
     * 解释：需要等 1000000000 天才能采到花来制作花束
     * 示例 5：
     *
     * 输入：bloomDay = [1,10,2,9,3,8,4,7,5,6], m = 4, k = 2
     * 输出：9
     *
     *      思路 ： 数组代表第i朵花会在多少天后盛开，已经盛开的可以先不摘
     *             需要制作m束花
     *             每束花 需要相邻的k朵花，必须保证
     *
     *             结果：返回 组成 m 束花 的最小天数
     *                  如果不能组成，则返回-1；
     *
     */
    public int minDays(int[] bloomDay, int m, int k) {
        // 边界条件寻找：找到需要天数最多的花和最小的花的天数
        int left=bloomDay[0];//不能初始化成0
        int right=0;
        int len=bloomDay.length;
        for (int i = 0; i < len; i++) {
            left=Math.min(left,bloomDay[i]);
            right=Math.max(right,bloomDay[i]);
        }
        int result=-1;
        while(left<right){
            //考虑是不是相邻的
            int mid = left+(right-left)/2;
            //找出mid的时候哪些花开了，只要能凑够m束花就返回，zhi
            int total=0;
            int linkCount=0;
            for (int i = 0; i < len; i++) {
                if (bloomDay[i] <= mid) {
                    linkCount++;
                    if(linkCount==k){
                        total++;
                        linkCount=0;
                    }
                }
            }
            if(total>=m){//天数减小
                right=mid;
                result=right;
            }else{
                left=mid+1;
            }

        }

        return result;
    }
    //</editor-fold>


}
