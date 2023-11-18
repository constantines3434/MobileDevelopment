package com.example.matvey

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val realPart1 = findViewById<EditText>(R.id.realPart1)
        val realPart2 = findViewById<EditText>(R.id.realPart2)
        val imaginaryPart1 = findViewById<EditText>(R.id.imaginaryPart1)
        val imaginaryPart2 = findViewById<EditText>(R.id.imaginaryPart2)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)
        val multiplyButton = findViewById<Button>(R.id.multiplyButton)
        val divideButton: Button = findViewById(R.id.divideButton)

        multiplyButton.setOnClickListener {
            try {
                val real1 = realPart1.text.toString().toDouble()
                val imaginary1 = imaginaryPart1.text.toString().toDouble()
                val real2 = realPart2.text.toString().toDouble()
                val imaginary2 = imaginaryPart2.text.toString().toDouble()

                val resultReal = (real1 * real2) - (imaginary1 * imaginary2)
                val resultImaginary = (real1 * imaginary2) + (imaginary1 * real2)

                resultTextView.text = "Результат умножения: $resultReal + $resultImaginary i"
            } catch (e: Exception) {
                resultTextView.text = "Введите корректные числа"
            }
        }
        divideButton.setOnClickListener {
            try {
                val real1 = realPart1.text.toString().toDouble()
                val imaginary1 = imaginaryPart1.text.toString().toDouble()
                val real2 = realPart2.text.toString().toDouble()
                val imaginary2 = imaginaryPart2.text.toString().toDouble()

                val denominator = real2.pow(2.0) + imaginary2.pow(2.0)
                val resultReal = (real1 * real2 + imaginary1 * imaginary2) / denominator
                val resultImaginary = (imaginary1 * real2 - real1 * imaginary2) / denominator

                resultTextView.text = "Результат деления: $resultReal + $resultImaginary i"
            } catch (e: Exception) {
                resultTextView.text = "Введите корректные числа"
            } catch (e: ArithmeticException) {
                resultTextView.text = "Деление на ноль"
            }

        }
    }
}