package com.example.e_commerce.Activity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.e_commerce.Database.Database;
import com.example.e_commerce.R;

public class PaymentActivity extends AppCompatActivity {
    EditText CardNumber, ExpireDateMonth, ExpireDateYear, CVV;
    Button addCreditCard;
    String userId;
    int flag=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        Database db = new Database(this);

        Intent ii = getIntent();
        userId = ii.getStringExtra("id");

        CardNumber = findViewById(R.id.CardNumber);
        ExpireDateMonth = findViewById(R.id.ExpireDateMonth);
        ExpireDateYear = findViewById(R.id.ExpireDateYear);
        CVV = findViewById(R.id.CVV);
        addCreditCard = findViewById(R.id.AddPayment);

        addCreditCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cardNumber = CardNumber.getText().toString();
                String expireDateMonth = ExpireDateMonth.getText().toString();
                String expireDateYear = ExpireDateYear.getText().toString();
                String cvv = CVV.getText().toString();

                if (cardNumber.isEmpty() || expireDateMonth.isEmpty() || expireDateYear.isEmpty() || cvv.isEmpty()) {
                    Toast.makeText(PaymentActivity.this, "Please fill in all the fields", Toast.LENGTH_SHORT).show();
                } else {
                    if (isLuhnValid(cardNumber)) {
                        Intent paymentIntent = new Intent(PaymentActivity.this, OrderActivity.class);
                        flag = 1;
                        paymentIntent.putExtra("paymentFlag", flag);
                        startActivity(paymentIntent);

                        finish();
                    } else {
                        Toast.makeText(PaymentActivity.this, "Invalid credit card number", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    private boolean isLuhnValid(String number) {
        number = number.replaceAll("\\s+", "").replaceAll("-", "");

        if (!number.matches("\\d+")) {
            return false;
        }

        int[] digits = new int[number.length()];
        for (int i = 0; i < number.length(); i++) {
            digits[i] = Character.getNumericValue(number.charAt(number.length() - 1 - i));
        }

        int total = 0;
        for (int i = 0; i < digits.length; i++) {
            if (i % 2 == 0) {
                total += digits[i];
            } else {
                int doubledDigit = digits[i] * 2;
                total += doubledDigit > 9 ? doubledDigit - 9 : doubledDigit;
            }
        }

        return total % 10 == 0;
    }
}
