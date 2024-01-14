package com.example.momointernal;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private float SpongeCakes = 10;
    private int SpongeCakesDiscount = 26;
    private float Cream = 14;
    private int CreamDiscount = 5;
    private float Fruits = 3;
    private int FruitsDiscount = 12;
    private float Nuts = 5;
    private int NutsDiscount = 55;
    private float Berries = 7;
    private float account = 45;

    //вывод данных
    private TextView possibilityOut;
    private TextView changeOut;

    //создание и иницилизация п. инт.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        possibilityOut = findViewById(R.id.possibilityOut);
        changeOut = findViewById(R.id.balanceOut);

        if (possibility()) {
            possibilityOut.setText("Имеется достаточно средств для покупки фото-комплекта");
            changeOut.setText("Остаток от покупки " + change() + " монет");
        } else {
            possibilityOut.setText("Недостаточно средств для покупки фото-комплекта");
            changeOut.setText(" - ");
        }
    }
        //общая стоимость товаров
        private float calculation () {
            float count = (SpongeCakes * (100 - SpongeCakesDiscount)
                    + Cream * (100 - CreamDiscount) + Fruits * (100 - FruitsDiscount)
                    + Nuts * (100 - NutsDiscount)) / 100 + Berries * 3;
            return count;
        }

        //возможности кошеля
        private boolean possibility () {
            if (calculation() <= account) {
                return true;
            } else {
                return false;
            }
        }


        //сдача
        private float change () {
            if (possibility()) {
                return account - calculation();
            } else {
                return -1;
            }
        }
}
