package com.example.session4labs;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button savebtn = findViewById(R.id.save_button);
        Button loadbtn = findViewById(R.id.load_button);
        Log.i(TAG, "onCreate: Activity created");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: Activity started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: Activity resumed");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: Activity paused");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: Activity stopped");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: Activity destroyed");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart: Activity restarted");
    }
    public void onClickSave(View view) {
        EditText lname_edit = findViewById(R.id.lname_edit);
        EditText fname_edit = findViewById(R.id.fname_edit);

        SharedPreferences sp = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        String lname = lname_edit.getText().toString();
        String fname = fname_edit.getText().toString();
        edit.putString("lname", lname);
        edit.putString("fname", fname);
        edit.apply();

        Toast.makeText(MainActivity.this, "Saved it", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onClickSave: Toast is an Android class which is used to display messages to the user");

    }
    public void onClickLoad(View view) {
        TextView name_text = findViewById(R.id.textView);

        SharedPreferences sp = getPreferences(Context.MODE_PRIVATE);
        String lname = sp.getString("lname", "na");
        String fname = sp.getString("fname", "na");
        name_text.setText(String.format("%s, %s", lname, fname));
    }
}
