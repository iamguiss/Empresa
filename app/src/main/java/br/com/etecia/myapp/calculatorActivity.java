package br.com.etecia.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class calculatorActivity extends AppCompatActivity {
    private EditText billAmountEditText;
    private RadioGroup ratingRadioGroup;
    private Button calculateButton;
    private EditText tipAmountEditText;
    private EditText totalAmountEditText;

    public class TipCalculator {
        private double billAmount;
        private double tipPercentage;

        public TipCalculator(double billAmount, double tipPercentage) {
            this.billAmount = billAmount;
            this.tipPercentage = tipPercentage;
        }

        public double calculateTip() {
            return (billAmount * tipPercentage) / 100;
        }

        public double calculateTotalAmount() {
            return billAmount + calculateTip();
        }

        public double getBillAmount() {
            return billAmount;
        }

        public void setBillAmount(double billAmount) {
            this.billAmount = billAmount;
        }

        public double getTipPercentage() {
            return tipPercentage;
        }

        public void setTipPercentage(double tipPercentage) {
            this.tipPercentage = tipPercentage;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_activity);

        billAmountEditText = findViewById(R.id.editTextBillAmount);
        ratingRadioGroup = findViewById(R.id.radioGroupRating);
        calculateButton = findViewById(R.id.calculateButton);
        tipAmountEditText = findViewById(R.id.editTextTipAmount);
        totalAmountEditText = findViewById(R.id.editTextTotalAmount);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTip();
            }
        });
    }

    private void calculateTip() {
        double billAmount = Double.parseDouble(billAmountEditText.getText().toString());

        int selectedRadioButtonId = ratingRadioGroup.getCheckedRadioButtonId();
        double tipPercentage;

        switch (selectedRadioButtonId) {
            case R.id.excelente:
                tipPercentage = 10;
                break;
            case R.id.otimo:
                tipPercentage = 8;
                break;
            case R.id.bom:
                tipPercentage = 5;
                break;
            case R.id.ruim:
                tipPercentage = 2;
                break;
            default:
                tipPercentage = 0;
        }

        TipCalculator calculator = new TipCalculator(billAmount, tipPercentage);
        double tipAmount = calculator.calculateTip();
        double totalAmount = calculator.calculateTotalAmount();

        tipAmountEditText.setText(String.format("Tip Amount: $%.2f", tipAmount));
        totalAmountEditText.setText(String.format("Total Amount: $%.2f", totalAmount));
    }
}

