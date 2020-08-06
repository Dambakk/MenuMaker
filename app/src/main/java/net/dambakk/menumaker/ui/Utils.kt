package net.dambakk.menumaker.ui

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.DatePicker
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.ui.platform.setContent
import java.util.*

//@CheckResult(suggest = "+")
//fun image(data: Any) = effectOf<Image?> {
//    // Positionally memoize the request creation so
//    // it will only be recreated if data changes.
//    val request = +memo(data) {
//        Coil.loader().newGetBuilder().data(data).build()
//    }
//    +image(request)
//}


class DateTimeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        val mHour = c[Calendar.HOUR_OF_DAY]
        val mMinute = c[Calendar.MINUTE]

        val datePickerDialog = DatePickerDialog(
            this, DatePickerDialog.OnDateSetListener
            { datePicker: DatePicker, day: Int, month: Int, year: Int ->
                setContent {
                    Column {
                        Text("$day, $month, $year")
                    }
                }
            }, year, month, day
        )


        val timePickerDialog = TimePickerDialog(
            this,
            { view, hourOfDay, minute ->
                setContent {
                    Column {
                        Text("$hourOfDay:$minute")
                    }
                }
            }, mHour, mMinute, false
        )


        setContent {
            Column {
                Button(
                    onClick = {
                        datePickerDialog.show()
                    }
                ) {
                    Text(text = "Select date")
                }
                Button(
                    onClick = {
                        timePickerDialog.show()
                    }
                ) {
                    Text(text = "Pick time")
                }
            }
        }
    }
}