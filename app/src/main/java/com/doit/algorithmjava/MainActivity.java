package com.doit.algorithmjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.doit.algorithmjava.binarysearch.BinarySearch;
import com.doit.algorithmjava.common.ListNode;
import com.doit.algorithmjava.list.LinkList;
import com.doit.algorithmjava.slidewindow.SlideWindow;
import com.doit.algorithmjava.sort.Sort;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView test = findViewById(R.id.test);
        BinarySearch bs = new BinarySearch();
//        [-1,0,3,5,9,12]
//        9
        test.setOnClickListener((v)->{
            //<editor-fold desc="二分查找">
            //            int[] nums= {-1,0,3,5,9,12};
//            int target = 2;
//            bs.question1(nums,target);
            //</editor-fold>

            //<editor-fold desc="排序">
//            int[] nums= {5,4,3,2,1};
//            int[] nums= {5,2,3,1};
//            Sort sort = new Sort();
//            sort.insertionSort(nums);
            //</editor-fold>

            //<editor-fold desc="滑动窗口">
            SlideWindow slideWindow = new SlideWindow();
            String s="abcabcbb";
            slideWindow.lengthOfLongestSubstring(s);
            //</editor-fold>


            //<editor-fold desc="两数相加">
            ListNode l1 = new ListNode(2);
            l1.next= new ListNode(4);
            l1.next.next= new ListNode(3);

            ListNode l2 = new ListNode(5);
            l2.next= new ListNode(6);
            l2.next.next= new ListNode(4);
            LinkList linkList = new LinkList();
            linkList.addTwoNumbers(l1,l2);
            //</editor-fold>
        });

    }
}