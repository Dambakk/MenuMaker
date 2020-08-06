package net.dambakk.menumaker.screens

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Profile() {
    Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
        Text("Profile")
    }
}