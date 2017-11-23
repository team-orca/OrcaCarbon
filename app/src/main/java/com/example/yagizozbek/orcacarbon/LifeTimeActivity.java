package com.example.yagizozbek.orcacarbon;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.widget.ListView;
public class LifeTimeActivity extends AppCompatActivity {
    public ListView lv;
    public Model[] modelItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_time);
        lv = (ListView) findViewById(R.id.listView);
        modelItems = new Model[3];
        modelItems[0] = new Model("Hybrid Car");
        modelItems[1] = new Model("Isolated House");
        modelItems[2] = new Model("Vegan Diet");
        CustomAdapter adapter = new CustomAdapter(this, modelItems);
        lv.setAdapter(adapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}

