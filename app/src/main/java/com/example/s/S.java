package com.example.sina;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Nima extends Activity {

    private final niMa counter = new niMa();
    private TextView counterText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            counter.setCount(savedInstanceState.getInt("count"));
        }

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setGravity(Gravity.CENTER);
        int pad = (int) (24 * getResources().getDisplayMetrics().density);
        root.setPadding(pad, pad, pad, pad);

        counterText = new TextView(this);
        counterText.setTextSize(72);
        counterText.setGravity(Gravity.CENTER);
        counterText.setText(String.valueOf(counter.getCount()));
        root.addView(counterText);

        Button countButton = new Button(this);
        countButton.setText("Count");
        countButton.setOnClickListener(v -> {
            counter.increment();
            counterText.setText(String.valueOf(counter.getCount()));
        });
        root.addView(countButton);

        Button resetButton = new Button(this);
        resetButton.setText("Reset");
        resetButton.setOnClickListener(v -> {
            counter.reset();
            counterText.setText(String.valueOf(counter.getCount()));
        });
        root.addView(resetButton);

        setContentView(root);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count", counter.getCount());
    }
}
