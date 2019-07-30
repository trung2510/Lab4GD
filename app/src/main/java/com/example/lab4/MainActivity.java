package com.example.lab4;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private BottomNavigationView navigation;




    //Bai4
    private ListView lvView;
    private String mang[]={"Item1","Item2","Item3"};

    public void showMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
//--------------------------------------------------
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//Toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//Bai4
        lvView = (ListView) findViewById(R.id.lvView);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,mang);
        lvView.setAdapter(arrayAdapter);

        registerForContextMenu(lvView);


//Bai2
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
//-----------------------------------------------------------------------------------

     //PopupMenu
        btn = (Button) findViewById(R.id.btnMenu);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowMenu();
            }
        });
    }
     //---------------------
//Bai4
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.line1:
                showMessage("View");
                break;

            case R.id.line2:
                showMessage("Save");
                break;

            case R.id.line3:
                showMessage("Edit");
                break;

            case R.id.line4:
                showMessage("Delete");
                break;

        }
        return super.onContextItemSelected(item);
    }
//----------------------------------------------

//Menu3cham
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bai3,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(this, "Item1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item2:
                Toast.makeText(this, "Item2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item3:
                Toast.makeText(this, "Item3", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item4:
                Toast.makeText(this, "Item4", Toast.LENGTH_SHORT).show();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    //-------------------------------

//PopupMenu
    private void ShowMenu(){
        final PopupMenu popupMenu = new PopupMenu(this,btn);

        popupMenu.getMenuInflater().inflate(R.menu.menu_popup,popupMenu.getMenu());
        popupMenu.show();

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.pop1:
                        Toast.makeText(MainActivity.this, "One", Toast.LENGTH_SHORT).show();
                        break;

                        case R.id.pop2:
                        Toast.makeText(MainActivity.this, "Two", Toast.LENGTH_SHORT).show();
                            break;

                        case R.id.pop3:
                        Toast.makeText(MainActivity.this, "Three", Toast.LENGTH_SHORT).show();
                            break;
                }
                return false;
            }
        });
    }

    //Bai2



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.favorites:
                    showMessage("You clicked Favorites");
                    return true;
                case R.id.time:
                    showMessage("You clicked Schedules");
                    return true;
                case R.id.music:
                    showMessage("You clicked Music");
                    return true;
                            }
            return false;
        }
    };

}
