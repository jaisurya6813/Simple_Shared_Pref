package com.example.myapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class mainact extends AppCompatActivity {
    private EditText name,num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainxml);
        name=findViewById(R.id.ET_name);
        num=findViewById(R.id.ET_Num);

    }
    @Override
    public void onResume(){
        super.onResume();
        SharedPreferences sharedPreferences= getSharedPreferences("mypref",MODE_PRIVATE);
        String s = sharedPreferences.getString("name","");
        int n=sharedPreferences.getInt("num",0);
        name.setText(s);
        num.setText(String.valueOf(n));
    }
    @Override
    public void onPause()
    {
        super.onPause();
        SharedPreferences sharedPreferences = getSharedPreferences("mypref", MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("name",name.getText().toString());
        editor.putInt("num",Integer.parseInt(num.getText().toString()));
        editor.apply();
    }


}
