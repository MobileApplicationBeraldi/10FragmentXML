package com.example.roberto.listview;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String [] values = new String[] { "car1", "car2","car3","car4","car5","car6","car7","car8","car9","car10"};
    List<String> v= new ArrayList<String>();
    ArrayAdapter<String> adapter;

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater menuInflater = new MenuInflater(this);

        menuInflater.inflate(R.menu.context,menu);
        menu.setHeaderTitle("Select one");

    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int i  = info.position; //position in the view
        String str = adapter.getItem(i);
        if (item.getItemId()==R.id.delete){
            v.remove(i);
            adapter.notifyDataSetChanged();
            Toast.makeText(getApplicationContext(),"Deleting: "+str,Toast.LENGTH_SHORT).show();
        }
        if (item.getItemId()==R.id.details){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Warning");
            builder.setMessage("not implented yet");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            builder.show();
            Toast.makeText(getApplicationContext(),"Deleting: "+str,Toast.LENGTH_SHORT).show();
        }


        return super.onContextItemSelected(item);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);



        v.add("first item");
        v.add("second item");
        //setContentView(R.layout.grid);

        final ListView listView = (ListView) findViewById(R.id.listview);
        //final GridView gridView = (GridView) findViewById(R.id.gridView);


        registerForContextMenu(listView);


      //adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,values);
      adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,v);
        //adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,values);


        //adapter = new ArrayAdapter<String>(this,R.layout.row,values);
        listView.setAdapter(adapter);
        //gridView.setAdapter(adapter);

        //final ArrayList<User> users = User.getUsers();

        //UserAdapter userAdapter = new UserAdapter(this,users);
        //listView.setAdapter(userAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),Integer.toString(position),Toast.LENGTH_SHORT).show();

                //parent.setVisibility(View.GONE);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"Long"+Integer.toString(position),Toast.LENGTH_SHORT).show();
                return false; //processing in not finished
                //return true;
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(getApplicationContext(),item.getItemId(),Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }
}
