package com.example.options_menu_context_menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {

    TextView textView;
    private static final int MENU_ITEM_ITEM1 = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        registerForContextMenu(textView);
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, v.getId(), 0, "Context Item 1");
        menu.add(0, v.getId(), 0, "Context Item 2");
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE, MENU_ITEM_ITEM1, Menu.NONE, "Item name");
        return true;
    }

    @Override
    public boolean onContextItemSelected( MenuItem item) {
        if (item.getTitle() == "Context Item 1") {
            Toast.makeText(this, "Context Item 1 selected", Toast.LENGTH_SHORT).show();
        } else if (item.getTitle() == "Context Item 2") {
            Toast.makeText(this, "Context Item 2 selected", Toast.LENGTH_SHORT).show();
        }
        return true;
//        return super.onContextItemSelected(item);
    }
}
