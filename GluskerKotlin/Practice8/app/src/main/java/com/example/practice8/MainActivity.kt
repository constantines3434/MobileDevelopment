package com.example.practice8

import android.content.res.Configuration
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var datePicker: DatePicker
    private lateinit var resultTextView: TextView
    private lateinit var determineButton: Button
    private var selectedDay: Int = 1
    private var selectedMonth: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        datePicker = findViewById(R.id.datePicker)
        resultTextView = findViewById(R.id.resultTextView)
        determineButton = findViewById(R.id.determineButton)

        determineButton.text = getString(R.string.determine_button_text)

        determineButton.setOnClickListener {
            selectedDay = datePicker.dayOfMonth
            selectedMonth = datePicker.month + 1 // DatePicker месяцы начинаются с 0

            // Проверяем, что пользователь выбрал дату
            if (selectedDay != 0 && selectedMonth != 0) {
                updateResultText()
            } else {
                resultTextView.text = getString(R.string.select_date_message)
            }
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // Обработка поворота экрана в горизонтальное положение
            updateTextForLandscape()
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            // Обработка поворота экрана в вертикальное положение
            updateTextForPortrait()
        }
    }

    private fun updateTextForLandscape() {
        val screenOrientationText = getString(R.string.horizontalWindow)
        resultTextView.text = screenOrientationText
    }

    private fun updateTextForPortrait() {
        val screenOrientationText = getString(R.string.verticalWindow)
        resultTextView.text = screenOrientationText
    }

    private fun updateResultText() {
        val zodiacSign = determineZodiacSign(selectedDay, selectedMonth)
        val zodiacSignResource = when (zodiacSign) {
            getString(R.string.aries) -> R.string.aries
            getString(R.string.taurus) -> R.string.taurus
            getString(R.string.gemini) -> R.string.gemini
            getString(R.string.gemini) -> R.string.cancer
            getString(R.string.leo) -> R.string.leo
            getString(R.string.virgo) -> R.string.virgo
            getString(R.string.libra) -> R.string.libra
            getString(R.string.scorpio) -> R.string.scorpio
            getString(R.string.sagittarius) -> R.string.sagittarius
            getString(R.string.capricorn) -> R.string.capricorn
            getString(R.string.aquarius) -> R.string.aquarius
            getString(R.string.pisces) -> R.string.pisces
            else -> R.string.unknown_sign
        }

        resultTextView.text = getString(zodiacSignResource)
    }

    private fun determineZodiacSign(day: Int, month: Int): String {
        return when {
            (month == 3 && day >= 21) || (month == 4 && day <= 19) -> getString(R.string.aries)
            (month == 4 && day >= 20) || (month == 5 && day <= 20) -> getString(R.string.taurus)
            (month == 5 && day >= 21) || (month == 6 && day <= 20) -> getString(R.string.gemini)
            (month == 6 && day >= 21) || (month == 7 && day <= 22) -> getString(R.string.cancer)
            (month == 7 && day >= 23) || (month == 8 && day <= 22) -> getString(R.string.leo)
            (month == 8 && day >= 23) || (month == 9 && day <= 22) -> getString(R.string.virgo)
            (month == 9 && day >= 23) || (month == 10 && day <= 22) -> getString(R.string.libra)
            (month == 10 && day >= 23) || (month == 11 && day <= 21) -> getString(R.string.scorpio)
            (month == 11 && day >= 22) || (month == 12 && day <= 21) -> getString(R.string.sagittarius)
            (month == 12 && day >= 22) || (month == 1 && day <= 19) -> getString(R.string.capricorn)
            (month == 1 && day >= 20) || (month == 2 && day <= 18) -> getString(R.string.aquarius)
            (month == 2 && day >= 19) || (month == 3 && day <= 20) -> getString(R.string.pisces)
            else -> getString(R.string.unknown_sign)
        }
    }
}