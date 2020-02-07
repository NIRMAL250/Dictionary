package com.example.dictionary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final AutoCompleteTextView word;
        Button go;
         final TextView definition;
        word = findViewById(R.id.word);
        go = findViewById(R.id.go);
        definition = findViewById(R.id.defn);
        String[] strings = new String[]{"lead","content","influence","appear","apparent"};
        final HashMap<String,String> map = new HashMap<String, String>();
        map.put("lead","to control a group of people, a country, or a situation");
        map.put("content","pleased with your situation and not hoping for change or improvement");
        map.put("influence","the power to have an effect on people or things, or a person or thing that is able to do this");
        map.put("appear","to start to be seen or to be present");
        map.put("apparent","able to be seen or understood");
        word.setAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, strings));
        word.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if((event.getAction()==KeyEvent.ACTION_DOWN)&&(keyCode==KeyEvent.KEYCODE_ENTER))
                {
                    String text = word.getText().toString();
                    if(map.containsKey(text))
                    {
                        definition.setText(map.get(text));
                    }
                    else{
                        definition.setText("Not Available");
                    }
                }
                return true;
            }
        });
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String text = word.getText().toString();
                    if(map.containsKey(text))
                    {
                        definition.setText(map.get(text));
                    }
                    else{
                        definition.setText("Not Available");
                    }
            }
        });
    }
}
