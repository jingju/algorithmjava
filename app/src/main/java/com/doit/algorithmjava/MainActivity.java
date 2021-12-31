package com.doit.algorithmjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.doit.algorithmjava.binarysearch.BinarySearch;
import com.doit.algorithmjava.binarysearch.BinarySearch2;
import com.doit.algorithmjava.binarysearch.BinnarySearch3;
import com.doit.algorithmjava.common.ListNode;
import com.doit.algorithmjava.list.LinkList;
import com.doit.algorithmjava.slidewindow.SlideWindow;
import com.doit.algorithmjava.sort.Sort;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView test = findViewById(R.id.test);
//        [-1,0,3,5,9,12]
//        9
        test.setOnClickListener((v)->{
            //<editor-fold desc="二分查找">
            BinarySearch bs = new BinarySearch();
            //            int[] nums= {-1,0,3,5,9,12};
//            int target = 2;
//            bs.question1(nums,target);
            //</editor-fold>

            //<editor-fold desc="排序">
//            int[] nums= {5,4,3,2,1};
//            int[] nums= {5,2,3,1};
//            Sort sort = new Sort();
//            sort.insertionSort(nums);

//            int[] nums= {1,2,3,4,4,5,9,12};
//            bs.searchRange(nums,4);

            //</editor-fold>

            //<editor-fold desc="滑动窗口">
//            SlideWindow slideWindow = new SlideWindow();
//            String s="abcabcbb";
//            slideWindow.lengthOfLongestSubstring(s);
//            //</editor-fold>
//
//
//            //<editor-fold desc="两数相加">
//            ListNode l1 = new ListNode(2);
//            l1.next= new ListNode(4);
//            l1.next.next= new ListNode(3);
//
//            ListNode l2 = new ListNode(5);
//            l2.next= new ListNode(6);
//            l2.next.next= new ListNode(4);
//            LinkList linkList = new LinkList();
//            linkList.addTwoNumbers(l1,l2);
            //</editor-fold>


            //<editor-fold desc="33. 搜索旋转排序数组">
//            int[] nums= {4,5,6,7,0,1,2};
//            int[] nums= {3,1};
//            int target = 1;
//
//            bs.rotateSearch(nums,target);
            //</editor-fold>

            // <editor-fold desc="81. 搜索旋转排序数组 II">
//            int[] nums= {1,0,1,1,1};
//            int target = 0;
//            bs.rotateSearch2(nums,target);
            //</editor-fold>

            // <editor-fold desc="275. H 指数 II II">
//                int[] nums= {11,15};
//              bs.hIndex(nums);

           // </editor-fold>

//            BinarySearch2 bs2 = new BinarySearch2();
//
//            bs2.mySqrt(2147483647);
//            int nums[]={2,3,5,7,11};
//           bs2.smallestDivisor(nums,11);

            BinnarySearch3 bs3=new BinnarySearch3();
            //<editor-fold desc="1011. 在 D 天内送达包裹的能力">
            //            int nums[]={1,2,3,4,5,6,7,8,9,10};
//            bs3.shipWithinDays(nums,5);
            //</editor-fold>

            //<editor-fold desc=" 1482. 制作 m 束花所需的最少天数">

//                int nums[] = {7, 7, 7, 7, 12, 7, 7};
//                bs3.minDays(nums, 2, 3);
            //</editor-fold>
//            String s= "AABABBA";
            String s= "AABABBA";
            SlideWindow slideWindow = new SlideWindow();
            slideWindow.characterReplacement(s,1);


        });

    }
}