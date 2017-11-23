package com.example.yagizozbek.orcacarbon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MyRankActivity extends AppCompatActivity {
    public ListView listView;
    public ArrayList<String> listViewItems = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_rank);
        listView = (ListView) findViewById(R.id.ranks);
        listViewItems.add("1) enes - 1054584 points");
        listViewItems.add("2) ozan - 956547 points");
        listViewItems.add("3) emre - 755464 points");
        listViewItems.add("4) muharrem - 752243 points");
        listViewItems.add("5) yagiz - 150 points");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                listViewItems);
        arrayAdapter.notifyDataSetChanged();
        listView.setAdapter(arrayAdapter);
    }
}

