package com.example.discountcalculatorapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText originalPriceEditText;
    private EditText discountPercentageEditText;
    private Button calculateButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        originalPriceEditText = findViewById(R.id.originalPrice);
        discountPercentageEditText = findViewById(R.id.discountPercentage);
        calculateButton = findViewById(R.id.calculateButton);
        resultTextView = findViewById(R.id.resultTextView);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateDiscount();
            }
        });
    }

    private void calculateDiscount() {
        String originalPriceStr = originalPriceEditText.getText().toString();
        String discountPercentageStr = discountPercentageEditText.getText().toString();

        if (originalPriceStr.isEmpty() || discountPercentageStr.isEmpty()) {
            Toast.makeText(this, "Please enter both values", Toast.LENGTH_SHORT).show();
            return;
        }

        double originalPrice = Double.parseDouble(originalPriceStr);
        double discountPercentage = Double.parseDouble(discountPercentageStr);

        if (originalPrice <= 0 || discountPercentage < 0 || discountPercentage > 100) {
            Toast.makeText(this, "Invalid input", Toast.LENGTH_SHORT).show();
            return;
        }

        double discountAmount = originalPrice * (discountPercentage / 100);
        double finalPrice = originalPrice - discountAmount;

        resultTextView.setText("Final Price: " + String.format("%.2f", finalPrice) +" BDT(Only)");
    }
}
