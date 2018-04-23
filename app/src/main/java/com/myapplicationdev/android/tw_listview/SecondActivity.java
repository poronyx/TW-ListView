package com.myapplicationdev.android.tw_listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ListView lv;
    ArrayAdapter aa;
    TextView tvYear;
    ArrayList<Module> module;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //lv = (ListView) this.findViewById(R.id.lvModules);
        tvYear = (TextView) findViewById(R.id.tvYear);

        module = new ArrayList<Module>();
        module.add(new Module("C208", true));
        module.add(new Module("C200", false));
        module.add(new Module("C346", true));

        Intent i = getIntent();
        String year = i.getStringExtra("year");
        tvYear.setText(year);



        aa = new ModuleAdapter(this, R.layout.second_row, module);
        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Module selectedModule = module.get(position);

                Toast.makeText(SecondActivity.this, selectedModule.getName()
                                + " Star: " + selectedModule.isProg(),
                        Toast.LENGTH_LONG).show();
            }
        });


    }



}
