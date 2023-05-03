package com.example.practic1504;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity5 extends AppCompatActivity {
    EditText editText1;
    EditText editText2;
    EditText editText3;
    EditText editText4;
    private TextView mTimer;
    private  TextView povtor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        TextView textView = findViewById(R.id.textView13);

        mTimer = (TextView) findViewById(R.id.textView10);
        povtor = (TextView) findViewById(R.id.textView13);
        new CountDownTimer(60000, 1000) {
            public void onTick (long millisUntilFinished){
                mTimer.setText("будет через " + millisUntilFinished/1000 + " секунд");
            }
            public void onFinish(){
                povtor.setTextColor(getResources().getColor(R.color.knopka));
                textView.setEnabled(true);
            }
        }
                .start();
        editText1 = findViewById(R.id.editTextNumber3);
        editText2 = findViewById(R.id.editTextNumber4);
        editText3 = findViewById(R.id.editTextNumber5);
        editText4 = findViewById(R.id.editTextNumber6);
        editText1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                if (charSequence.length() == editText1.length()){
                    editText2.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        editText2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                if (charSequence.length() == editText2.length()){
                    editText3.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        editText3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                if (charSequence.length() == editText3.length()){
                    editText4.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        editText4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                code();
            }
        });


    }
    public void code(){
        String code = editText1.getText().toString()+editText2.getText().toString()+editText3.getText().toString()+editText4.getText().toString();
        SessionManager sessionManager = new SessionManager(this);
        String email = sessionManager.getEmail();
        ApiClient apiClient = new ApiClient();
        apiClient.getApiService(this).signin(email, code).enqueue(new retrofit2.Callback<SendCodeResponse>() {
            @Override
            public void onResponse(retrofit2.Call<SendCodeResponse> call, retrofit2.Response<SendCodeResponse> response) {
                if(!response.isSuccessful())
                {
                    return;                    }
                Intent intent = new Intent(MainActivity5.this,MainActivity6.class);
                startActivity(intent);
                return;

            }

            @Override
            public void onFailure(retrofit2.Call<SendCodeResponse> call, Throwable t) {
                Toast toast=Toast.makeText(MainActivity5.this, "Ошибка", Toast.LENGTH_LONG);
                toast.show();
            }
        });


    }
    public void onClickHander6 (View view){
        Intent intent = new Intent(MainActivity5.this, MainActivity4.class);
        startActivity(intent);
    }
    public void onClick6 (View view){
        Intent intent = new Intent(MainActivity5.this, MainActivity6.class);
        startActivity(intent);
    }
}