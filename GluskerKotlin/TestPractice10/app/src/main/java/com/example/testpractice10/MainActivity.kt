package com.example.testpractice10

import androidx.compose.foundation.layout.R


//тут
import com.example.testpractice10.ui.theme.ZodiacSignCalculator

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.DatePicker
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainContent()
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainContent() {

    val mContext = LocalContext.current
    val mCalendar = Calendar.getInstance()
    var selectedDay = mCalendar.get(Calendar.DAY_OF_MONTH)
    var selectedMonth = mCalendar.get(Calendar.MONTH)

    val mDate = remember { mutableStateOf("") }
    val resultText = remember { mutableStateOf("") }

    val mDatePickerDialog = DatePickerDialog(
        mContext,
        { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
            selectedDay = dayOfMonth
            selectedMonth = month
            mDate.value = "$dayOfMonth/${month + 1}/$year"
        }, mCalendar.get(Calendar.YEAR), mCalendar.get(Calendar.MONTH), mCalendar.get(Calendar.DAY_OF_MONTH)
    )

    Scaffold(
    ) {
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Button(
                onClick = {
                    mDatePickerDialog.show()
                },
            ) {
                Text(text = "Open Date Picker", color = Color.White)
            }

            Spacer(modifier = Modifier.size(100.dp))

            Text(text = "Selected Date: ${mDate.value}", fontSize = 30.sp, textAlign = TextAlign.Center)

            Text(
                text = "Result: ${resultText.value}",
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(16.dp)
            )


            var ariesResId =  R.string.aries
            var taurusResId = R.string.taurus
            var geminiResId = R.string.gemini
            var cancerResId = R.string.cancer
            var leoResId = R.string.leo
            var virgoResId = R.string.virgo
            var libraResId = R.string.libra
            var scorpioResId = R.string.scorpio
            var sagittariusResId = R.string.sagittarius
            var capricornResId = R.string.capricorn
            var aquariusResId = R.string.aquarius
            var piscesResId = R.string.pisces
            var noneResId = R.string.unknown_sign

            val zodiacSignCalculator = remember {
                ZodiacSignCalculator(ariesResId, taurusResId, geminiResId
                    ,cancerResId, leoResId, libraResId
                    ,scorpioResId, scorpioResId, sagittariusResId
                    ,capricornResId, aquariusResId, piscesResId
                    ,noneResId)
            }
            val resultText = remember { mutableStateOf("") }
            Button(
                onClick = {
                    val month = selectedMonth + 1
                    val result =when {
                        (month == 3 && selectedDay >= 21) || (month == 4 && selectedDay <= 19) -> ariesResId
                        (month == 4 && selectedDay >= 20) || (month == 5 && selectedDay <= 20) -> taurusResId
                        (month == 5 && selectedDay >= 21) || (month == 6 && selectedDay <= 20) -> geminiResId
                        (month == 6 && selectedDay >= 21) || (month == 7 && selectedDay <= 22) -> cancerResId
                        (month == 7 && selectedDay >= 23) || (month == 8 && selectedDay <= 22) -> leoResId
                        (month == 8 && selectedDay >= 23) || (month == 9 && selectedDay <= 22) -> virgoResId
                        (month == 9 && selectedDay >= 23) || (month == 10 && selectedDay <= 22) -> libraResId
                        (month == 10 && selectedDay >= 23) || (month == 11 && selectedDay <= 21) -> scorpioResId
                        (month == 11 && selectedDay >= 22) || (month == 12 && selectedDay <= 21) -> sagittariusResId
                        (month == 12 && selectedDay >= 22) || (month == 1 && selectedDay <= 19) -> capricornResId
                        (month == 1 && selectedDay >= 20) || (month == 2 && selectedDay <= 18) ->aquariusResId
                        (month == 2 && selectedDay >= 19) || (month == 3 && selectedDay <= 20) -> piscesResId
                        else -> noneResId
                    }

                    resultText.value = result
                },
                modifier = Modifier.padding(16.dp)
            ) {
                Text(text = "Process Action")
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainContent()
}