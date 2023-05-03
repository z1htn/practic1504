package com.example.practic1504;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        Button but1 = findViewById(R.id.button4);
        EditText edit = findViewById(R.id.editTextTextEmailAddress);
        edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String email = edit.getText().toString();
                if (email.contains("@") & email.contains(".")){
                    but1.setBackgroundColor(getResources().getColor(R.color.knopka));
                    but1.setEnabled(true);
                } else {
                    but1.setBackgroundColor(getResources().getColor(R.color.noactive));
                    but1.setEnabled(false);

                }

            }
        });

    }

   public void code(){
       EditText edit = findViewById(R.id.editTextTextEmailAddress);
       SessionManager sessionManager = new SessionManager(this);
       String email = edit.getText().toString();
       sessionManager.saveEmail(email);
       ApiClient apiClient = new ApiClient();
       apiClient.getApiService(this).sendCode(email).enqueue(new retrofit2.Callback<SendCodeResponse>() {
           @Override
           public void onResponse(retrofit2.Call<SendCodeResponse> call, retrofit2.Response<SendCodeResponse> response) {
               if(!response.isSuccessful())
               {
                   return;                    }
               Intent intent = new Intent(MainActivity4.this,MainActivity5.class);
               startActivity(intent);
               return;

           }

           @Override
           public void onFailure(retrofit2.Call<SendCodeResponse> call, Throwable t) {
               Toast toast=Toast.makeText(MainActivity4.this, "Ошибка", Toast.LENGTH_LONG);
               toast.show();
           }
       });


   }
    public void onClick4 (View view){
        code();
    }

   }