package com.example.radiobuttontextconversion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.radiobuttontextconversion.R;
import com.example.radiobuttontextconversion.TextConvert;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private EditText edtText;
    private Button btnSet;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initViews();


        btnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextConvert textConvert = new TextConvert(MainActivity.this, edtText.getText().toString());
                textConvert.setOnOkListener(new MyOnOkClickListener());
                textConvert.show();
            }
        });
    }
    public void mt(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
    private class MyOnOkClickListener implements TextConvert.OnOkListener{

        @Override
        public void forTextChange(String text, TextConvert textConvert) {
            textConvert.dismiss();
            edtText.setText(text);
        }
    }
    public void initViews(){
        setContentView(R.layout.activity_main);
        edtText = findViewById(R.id.edtText);
        btnSet = findViewById(R.id.btnSet);
    }
}