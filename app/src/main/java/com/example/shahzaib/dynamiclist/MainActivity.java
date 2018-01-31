package com.example.shahzaib.dynamiclist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/* Steps to make dynamic list

  --> Pehly ak EditText,Button,ListView banana hy
  --> phr ak data source banana hy (data source kuch b ho skta hy like: string array, database,
      dataStructure..etc)
  --> phr ak arrayAdapter banana hy jis main list k style aur datasource k object ka btana hy
  --> Phr button pr on click listener add krna hy jis ko click krny sy Edittext sy text(jo user ny enter kiya hy)
      ko ak string varriable main store krna hy
  --> phr us text ko datasource ( in out case  it is: ArrayList) main append krn hy jis k object ko hum ny
      arrayAdapter k parameter main pass kiya hy
  --> phr arrayAdapter k object ko (in out case it is: adapter) listview main setAdaptermethod k zariye pass
      krna hy
*/
public class MainActivity extends AppCompatActivity {

    ListView myListView ;
    EditText editText;
    Button addBtn;
    String str = null;
    ArrayList<String> arrayList;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myListView = (ListView) findViewById(R.id.listview);
        editText = (EditText) findViewById(R.id.editText);
        addBtn = (Button) findViewById(R.id.addBtn);
        arrayList = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList);





        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // when button tapped then get text from the editText & append to the list
                 str = editText.getText().toString();
                 editText.setText("");
                 arrayList.add(str);

                // Jb jb new entry ho tab tab adapter update ho
                myListView.setAdapter(adapter);



            }
        });



        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(MainActivity.this, i+" index:  "+arrayList.get(i), Toast.LENGTH_SHORT).show();
            }
        });

    }







}
