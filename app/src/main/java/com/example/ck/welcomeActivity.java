package com.example.ck;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class welcomeActivity extends AppCompatActivity {
    private Button btnBuy, btnSell,btnsubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_welcome);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        btnBuy = findViewById(R.id.toggle_listen);
        btnSell = findViewById(R.id.toggle_no_listen);
        btnsubmit=findViewById(R.id.btn_submit);
        ToggleButton toggleListen = findViewById(R.id.toggle_listen);
        ToggleButton toggleNoListen = findViewById(R.id.toggle_no_listen);

        toggleListen.setOnClickListener(v -> {
            float currentX = toggleListen.getX();
            if (currentX > 0) {
                toggleListen.setX(currentX - 100); // Move left
            } else {
                toggleListen.setX(currentX + 100); // Reset or move right
            }
        });

        toggleNoListen.setOnClickListener(v -> {
            float currentX = toggleNoListen.getX();
            if (currentX > 0) {
                toggleNoListen.setX(currentX - 100); // Move left
            } else {
                toggleNoListen.setX(currentX + 100); // Reset or move right
            }
        });

        btnBuy.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                selectButton(btnBuy, btnSell);
            }
        });

        btnSell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectButton(btnSell, btnBuy);
            }
        });
        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(welcomeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    private void selectButton(Button selected, Button other) {
        // Đổi màu nút được chọn
        selected.setBackgroundColor(getResources().getColor(R.color.purple_500)); // Màu đậm
        selected.setTextColor(getResources().getColor(android.R.color.white));

        // Đổi nút không được chọn về trạng thái bình thường
        other.setBackgroundColor(getResources().getColor(R.color.gray)); // Màu xám
        other.setTextColor(getResources().getColor(android.R.color.black));
    }
}