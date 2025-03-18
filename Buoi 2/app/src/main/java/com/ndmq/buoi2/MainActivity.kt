package com.ndmq.buoi2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    /**
     * _____________________________________________________________________________
     * 1. Khai báo hàm:
     *
     *      fun tenHam(thamSo1: KieuDuLieu, thamSo2: KieuDuLieu): KieuTraVe {
     *          // Thực hiện các thao tác
     *      }
     *
     * _____________________________________________________________________________
     *
     * 2. Khai báo biến:
     *
     *      val/var tenBien: KieuDuLieu = giaTri
     *
     * _____________________________________________________________________________
     * */


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /** Bắt buộc có: liên kết layout với code */
        setContentView(R.layout.activity_main)


        val button = findViewById<Button>(R.id.buttonPanel)
        val number1 = findViewById<EditText>(R.id.number1EditText)
        val number2 = findViewById<EditText>(R.id.number2EditText)
        val resultText = findViewById<TextView>(R.id.resultText)


        button.setOnClickListener {
            val a = number1.text.toString().toInt()
            val b = number2.text.toString().toInt()
            val sum = sumOf(a, b)

            /** Gán kết quả vào resultText */
            resultText.text = "Result: $sum"
        }
    }


    private fun sumOf(a: Int, b: Int): Int {
        return a + b
    }
}