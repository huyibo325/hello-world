package com.bytedance.chapter2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView=findViewById(R.id.list);
        SearchAdapter searchAdapter=new SearchAdapter();
        recyclerView.setAdapter(searchAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<String> list=new ArrayList<>();
        for(int i=0;i<100;i++){
            list.add("这是第"+i+"数据");
        }
        searchAdapter.notifyDataSetChanged();

        SearchLayout searchLayout=findViewById(R.id.search);
        searchLayout.setOnInputChangedListener(new SearchLayout.OnInputChangedListener() {
            @Override
            public void onChanged(String text) {
                List<String>filters=new ArrayList<>();
                for(String str:list){
                    if(str.contains(text)){
                        filters.add(str);
                    }
                }
                searchAdapter.notifyTiems(filters);
                Log.d("TAG","onChanged:"+text);
            }
        });

    }
}