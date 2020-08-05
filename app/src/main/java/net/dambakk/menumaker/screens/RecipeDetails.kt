package net.dambakk.menumaker.screens

import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.foundation.Icon
import androidx.ui.foundation.Text
import androidx.ui.layout.*
import androidx.ui.material.IconButton
import androidx.ui.material.MaterialTheme
import androidx.ui.material.icons.Icons
import androidx.ui.material.icons.filled.ArrowBack
import androidx.ui.material.icons.filled.ArrowRightAlt
import androidx.ui.unit.dp


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