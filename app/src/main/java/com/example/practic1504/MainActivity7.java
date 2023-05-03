package com.example.practic1504;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Spinner;


public class MainActivity7 extends AppCompatActivity {



  String[] data = { "Выберите пол","Мужской", "Женский"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

//        Button but1 = findViewById(R.id.button);
//        EditText edit1 = findViewById(R.id.editTextTextPersonName5);
//        EditText edit2 = findViewById(R.id.editTextTextPersonName6);
//        EditText edit3 = findViewById(R.id.editTextTextPersonName7);
//        EditText edit4 = findViewById(R.id.editTextTextPersonName8);

        Spinner spinner = findViewById(R.id.spinner);
        // Создаем адаптер ArrayAdapter с помощью массива строк и стандартной разметки элемета spinner
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, data);
        // Определяем разметку для использования при выборе элемента
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Применяем адаптер к элементу spinner
        spinner.setAdapter(adapter);

//        edit1.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//                if (edit4.getText().length() == 0) {
//                    but1.setBackgroundColor(getResources().getColor(R.color.knopka));
//                    but1.setEnabled(true);
//                } else {
//                    but1.setBackgroundColor(getResources().getColor(R.color.noactive));
//                    but1.setEnabled(false);
//
//                }
//
//            }
//        });
    }
        public void onClick7 (View view){
            Intent intent = new Intent(MainActivity7.this, MainActivity8.class);
            startActivity(intent);
        }

}