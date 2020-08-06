package net.dambakk.menumaker.screens

import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun RecipeDetailsScreen(item: DashboardItemModel?, onBackClicked: () -> Unit) {
    /*
    TopAppBar {
        Row(modifier = Modifier.gravity(align = Alignment.CenterVertically)) {
            IconButton(onClick = onBackClicked, modifier = Modifier.gravity(align = Alignment.CenterVertically)) {
                Icon(Icons.Filled.ArrowBack)
            }
            Text(
                text = recipe?.name ?: "No name", modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.h6
            )
        }
    }
     */
    Stack(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(16.dp)
    ) {
        Column {
            Row(modifier = Modifier.fillMaxWidth()) {
//                Stack(modifier = Modifier.fillMaxWidth()) {
                    IconButton(
                        onClick = {
                            onBackClicked()
                        }
                    ) {
                        Icon(Icons.Filled.ArrowBack)
                    }
                    Text(
                        text = item?.item?.duration ?: "",
//                        modifier = Modifier.gravity(align = Alignment.End),
                        style = MaterialTheme.typography.h6
                    )
                }
//            }
            Text(
                text = item?.item?.name ?: "No name",
//                modifier = Modifier.gravity(align = Alignment.BottomStart),
                style = MaterialTheme.typography.h4
            )
        }
    }
}