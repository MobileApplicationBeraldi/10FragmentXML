package com.example.roberto.fragmentxml;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void Event(int id) {
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setText(Integer.toString(id));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putCharSequence("selection",((TextView) findViewById(R.id.textView)).getText());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        ((TextView) findViewById(R.id.textView))
                    .setText(
                            (String) savedInstanceState.getCharSequence("selection")
                    );
    }
}
