package com.doit.algorithmjava.temp;


import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;




public class TempClass {

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void HashMapTest(){
        Map<String, String> objectObjectHashMap = new HashMap<>();


       //在 Anroid N 才有这个方法
       objectObjectHashMap.forEach(new BiConsumer<String, String>() {
           @Override
           public void accept(String key, String value) {

           }
       });
    }



}
