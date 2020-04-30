package com.example.databasecontrol;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


 // mostra a interface do banco de dados
public class ViewListContents extends AppCompatActivity {

    DatabaseHelper myDB;
    private ListView mListview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewcontents_layout);

        ListView listView = (ListView) findViewById(R.id.listView);
        myDB = new DatabaseHelper(this);

        ArrayList<String> theList = new ArrayList<>();
        Cursor data = myDB.getListContents();

        if(data.getCount() == 0) {
            Toast.makeText(ViewListContents.this,"The DataBase was empty :(.",Toast.LENGTH_LONG).show();
        }else {
            while(data.moveToNext()) {
                theList.add(data.getString(1));
                // o adapter faz a cola layout e lista
                ListAdapter listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,theList);
                listView.setAdapter(listAdapter);

              /*  mListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                        String name = adapterView.getItemAtPosition(position).toString();

                        Cursor data = myDB.getItemID(name);
                        int itemID = -1;
                        while (data.moveToNext()) {
                            itemID = data.getInt(0);
                        }
                    }
                }); */
            }
        }


    }
}
