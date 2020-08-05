package net.dambakk.menumaker.screens

import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.foundation.Text
import androidx.ui.layout.Column
import androidx.ui.layout.fillMaxWidth
import androidx.ui.layout.padding
import androidx.ui.unit.dp

@Composable
fun Profile() {
    Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
        Text("Profile")
    }
}