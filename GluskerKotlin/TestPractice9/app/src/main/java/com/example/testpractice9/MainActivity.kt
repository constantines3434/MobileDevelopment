package com.example.testpractice9

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import android.provider.Settings.Global.getString
import android.widget.DatePicker
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
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

                var OpenDatePicker = stringResource(id = R.string.open_date_picker)
                Text(text = "$OpenDatePicker", color = Color.White)
            }

            Spacer(modifier = Modifier.size(100.dp))

            var SelectedDate = stringResource(id = R.string.selected_date)
            Text(text = "$SelectedDate: ${mDate.value}", fontSize = 30.sp, textAlign = TextAlign.Center)

            var Result = stringResource(id = R.string.result)

            Text(
                text = "$Result: ${resultText.value}",
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(16.dp)
            )


            var aries = stringResource(id = R.string.aries)
            var taurus = stringResource(id = R.string.taurus)
            var gemini = stringResource(id = R.string.gemini)
            var cancer = stringResource(id = R.string.cancer)
            var leo = stringResource(id = R.string.leo)
            var virgo = stringResource(id = R.string.virgo)
            var libra = stringResource(id = R.string.libra)
            var scorpio = stringResource(id = R.string.scorpio)
            var sagittarius = stringResource(id = R.string.sagittarius)
            var capricorn = stringResource(id = R.string.capricorn)
            var aquarius = stringResource(id = R.string.aquarius)
            var pisces = stringResource(id = R.string.pisces)
            var none = stringResource(id = R.string.unknown_sign)
            var ProcessAction = stringResource(id = R.string.selected_date)
            // Добавляем кнопку для обработки действий пользователя
            Button(
                onClick = {
                    val month = selectedMonth + 1
                    val result =when {
                        (month == 3 && selectedDay >= 21) || (month == 4 && selectedDay <= 19) -> aries
                        (month == 4 && selectedDay >= 20) || (month == 5 && selectedDay <= 20) -> taurus
                        (month == 5 && selectedDay >= 21) || (month == 6 && selectedDay <= 20) -> gemini
                        (month == 6 && selectedDay >= 21) || (month == 7 && selectedDay <= 22) -> cancer
                        (month == 7 && selectedDay >= 23) || (month == 8 && selectedDay <= 22) -> leo
                        (month == 8 && selectedDay >= 23) || (month == 9 && selectedDay <= 22) -> virgo
                        (month == 9 && selectedDay >= 23) || (month == 10 && selectedDay <= 22) -> libra
                        (month == 10 && selectedDay >= 23) || (month == 11 && selectedDay <= 21) -> scorpio
                        (month == 11 && selectedDay >= 22) || (month == 12 && selectedDay <= 21) -> sagittarius
                        (month == 12 && selectedDay >= 22) || (month == 1 && selectedDay <= 19) -> capricorn
                        (month == 1 && selectedDay >= 20) || (month == 2 && selectedDay <= 18) ->aquarius
                        (month == 2 && selectedDay >= 19) || (month == 3 && selectedDay <= 20) -> pisces
                        else -> none
                    }

                    resultText.value = result
                },
                modifier = Modifier.padding(16.dp)
            )

            {

                Text(text = "$ProcessAction")
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainContent()
}