package com.doit.algorithmjava.mergesearch;

/**
 *
 * 并查集(一种不相交集合)：
 *                  合并两个集合
 *                  查询两个元素是否是在同一个集合中
 *  并查集是一个树状数据结构，每个集合的代表元素为树的根结点
 *
 *
 *   todo 并查集的基思路：
 *              查：查两个元素的根结点是否相等
 *                                      如果相等，两个元素在一个集合中
 *                                      如果不相等，合并两个元素的根结点
 *
 */
public class MergeSearchTest {

    //<editor-fold desc="Description">
    /**
     * 990. 等式方程的可满足性
     * 给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，并采用两种不同的形式之一："a==b" 或 "a!=b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。
     *
     * 只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。
     *
     *
     *
     * 示例 1：
     *
     * 输入：["a==b","b!=a"]
     * 输出：false
     * 解释：如果我们指定，a = 1 且 b = 1，那么可以满足第一个方程，但无法满足第二个方程。没有办法分配变量同时满足这两个方程。
     * 示例 2：
     *
     * 输入：["b==a","a==b"]
     * 输出：true
     * 解释：我们可以指定 a = 1 且 b = 1 以满足满足这两个方程。
     * 示例 3：
     *
     * 输入：["a==b","b==c","a==c"]
     * 输出：true
     * 示例 4：
     *
     * 输入：["a==b","b!=c","c==a"]
     * 输出：false
     * 示例 5：
     *
     * 输入：["c==c","b==d","x!=z"]
     * 输出：true
     *
     *
     * 提示：
     *
     * 1 <= equations.length <= 500
     * equations[i].length == 4
     * equations[i][0] 和 equations[i][3] 是小写字母
     * equations[i][1] 要么是 '='，要么是 '!'
     * equations[i][2] 是 '='
     * @param equations
     * @return
     */

    public boolean equationsPossible(String[] equations) {
        int[] parent = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }
        for (String str : equations) {
            if (str.charAt(1) == '=') {
                int index1 = str.charAt(0) - 'a';
                int index2 = str.charAt(3) - 'a';
                union(parent, index1, index2);//todo 合并
            }
        }
        for (String str : equations) {
            if (str.charAt(1) == '!') {
                int index1 = str.charAt(0) - 'a';
                int index2 = str.charAt(3) - 'a';
                /**
                 * 经过了合并之后，查询两个元素的父结点是否相等，不想等，即为false,相等，即为true
                 */
                if (find(parent, index1) == find(parent, index2)) {//todo //查询
                    return false;
                }
            }
        }
        return true;
    }
    /**合并两个元素*/
    public void union(int[] parent, int index1, int index2) {
        /**
         *
         * 一、 已知：
         *      1、int index= ('a'~'z')-'a';对应这int值 0～25
         *      2、最开始，根结点都是自己
         * 二、 用例：
         *
         *  1、最开始，根结点都是自己,parent[index]=index,index代表（a~z 26个字母）
         *
         *  2、第一次合并:index1 为'a',index2 为 'b'
         *          根据已经条件1，假设index1为'a',index2为'b'，
         *          这里并不是真的 index1='a',而是能index1能代表'a'
         *
         *          union(parent,'a','b')
         *          结果：parent['a']=='b' ， 现在'a'的父结点为'b'
         *
         *   3、第二次合并：index1 为'b',index2 为 'c'
         *          union(parent,'b','c')
         *          结果：parent['b']=='c' ， 现在'b'的父结点为'c'
         *
         *   4、第三次合并：index1 为'a',index2 为 'b'
         *          union(parent,'a','b')
         *          结果：parent['a']=='c' ， 现在'a'的父结点为'c'
         *          todo : 由于第二次合并中，'b'的父结点变为'c'，所以第三次合并，'a'的父结点也
         *                 调整为'c'
         *
         */
        parent[find(parent, index1)] = find(parent, index2);
    }
    /**查找元素的父亲结点
     *
     * 迭代查找根递归类似
     */
    public int find(int[] parent, int index) {
        while (parent[index] != index) {
            //todo 如果发现父结点不是自己，将递归查找父结点的父结点，直到道父结点是一个根结点
            parent[index] = parent[parent[index]];
            index = parent[index];
        }
        return index;
    }
    //</editor-fold>
}
