package com.doit.algorithmjava.queueandstack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 队列相关题解
 */
public class QueueTest {
    //<editor-fold desc="621. 任务调度器">
    /**
     * 621. 任务调度器
     * 给你一个用字符数组 tasks 表示的 CPU 需要执行的任务列表。其中每个字母表示一种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态。
     *
     * 然而，两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
     *
     * 你需要计算完成所有任务所需要的 最短时间 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：tasks = ["A","A","A","B","B","B"], n = 2
     * 输出：8
     * 解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B
     *      在本示例中，两个相同类型任务之间必须间隔长度为 n = 2 的冷却时间，而执行一个任务只需要一个单位时间，所以中间出现了（待命）状态。
     * 示例 2：
     *
     * 输入：tasks = ["A","A","A","B","B","B"], n = 0
     * 输出：6
     * 解释：在这种情况下，任何大小为 6 的排列都可以满足要求，因为 n = 0
     * ["A","A","A","B","B","B"]
     * ["A","B","A","B","A","B"]
     * ["B","B","B","A","A","A"]
     * ...
     * 诸如此类
     * 示例 3：
     *
     * 输入：tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
     * 输出：16
     * 解释：一种可能的解决方案是：
     *      A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> (待命) -> (待命) -> A -> (待命) -> (待命) -> A
     *
     *
     * 提示：
     *
     * 1 <= task.length <= 104
     * tasks[i] 是大写英文字母
     * n 的取值范围为 [0, 100]
     * 通过次数84,753提交次数147,395
     *
     *     todo 桶思想 https://leetcode-cn.com/problems/task-scheduler/solution/tong-zi-by-popopop/
     *
     *     1、建立大小为n+1（n为两个相同的任务中间的间时间） 的筒子
     *     2、桶的个数为 数量最多的那个任务，分别把这个任务方到每个筒子的第一个位置
     *     3、
     *
     *
     *
     */
    public int leastInterval(char[] tasks, int n) {
//        int leastInterval(vector<char>& tasks, int n) {
//            int len=tasks.size();
//            vector<int> vec(26);
//            for(char c:tasks) ++vec[c-'A'];
//            sort(vec.begin(),vec.end(),[](int& x,int&y){return x>y;});
//            int cnt=1;
//            while(cnt<vec.size()&&vec[cnt]==vec[0]) cnt++;
//            return max(len,cnt+(n+1)*(vec[0]-1) );
//        }
        //todo 第0个放的是 数量最多的
        int len= tasks.length;
        List<Integer> list=new ArrayList<>(26);
        for (char task:tasks){
            list.add(task-'A');
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 1;
            }
        });

        int cnt=1;
        while(cnt < list.size() && list.get(cnt)==list.get(0)){
            cnt++;
        }
        return Math.max(len,cnt+(n+1)*(list.get(0)-1));
    }
    //</editor-fold>


}
