package net.dambakk.menumaker.screens

import android.app.DatePickerDialog
import android.content.Intent
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.unit.dp

@Composable
fun Planning() {
    val days = listOf(
        "Mandag", "Tirsdag", "Onsdag", "Torsdag", "Fredag", "Lørdag", "Søndag"
    )
    ScrollableColumn(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
        val context = ContextAmbient.current.applicationContext
        days.forEach {
            Column(modifier = Modifier.clickable(onClick = {
//                DatePickerDialog(ContextAmbient.current)
                val intent = Intent(context, DatePickerDialog::class.java).apply {
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK
                }
                context.startActivity(intent)
            })) {
                Spacer(modifier = Modifier.height(24.dp))
                Text("$it:")
                Spacer(modifier = Modifier.height(24.dp))
                Divider()
            }
        }
    }
}
