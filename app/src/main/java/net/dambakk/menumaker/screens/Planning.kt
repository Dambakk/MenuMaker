package net.dambakk.menumaker.screens

import android.app.DatePickerDialog
import android.content.Intent
import androidx.compose.Composable
import androidx.ui.core.ContextAmbient
import androidx.ui.core.Modifier
import androidx.ui.foundation.ScrollableColumn
import androidx.ui.foundation.Text
import androidx.ui.foundation.clickable
import androidx.ui.layout.*
import androidx.ui.material.Divider
import androidx.ui.unit.dp
import com.google.android.material.bottomsheet.BottomSheetDialog

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
