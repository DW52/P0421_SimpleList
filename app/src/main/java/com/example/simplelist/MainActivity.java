package com.example.simplelist;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity {



    /** Called when the activity is first created. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // находим список
        ListView lvMain = (ListView) findViewById(R.id.lvMain);
        final EditText editText = (EditText) findViewById(R.id.addString);

        /**String[] names = { "Дарья", "Андрей", "Анастасия", "Елизавета", "Александр", "Константин",};*/

        ArrayList<String> names = new ArrayList<>();
        names.add("Masha");
        names.add("Anna");
        names.add("Daniil");
        names.add("Lisa");
        names.add("Mark");
        names.add("Sasha");

        // создаем адаптер
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                R.layout.my_list_item, names);

        // присваиваем адаптер списку
        lvMain.setAdapter(adapter);

        editText.setOnKeyListener((v, keyCode, event) -> {
            if (event.getAction() == KeyEvent.ACTION_DOWN)
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    names.add(0, editText.getText().toString());
                    adapter.notifyDataSetChanged();
                    editText.setText("");
                    return true;
                }
            return false;
        });

    }
}
