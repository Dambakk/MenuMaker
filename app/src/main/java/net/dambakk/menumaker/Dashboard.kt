package net.dambakk.menumaker

import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.foundation.Icon
import androidx.ui.foundation.ScrollableColumn
import androidx.ui.foundation.Text
import androidx.ui.layout.*
import androidx.ui.material.Card
import androidx.ui.material.IconButton
import androidx.ui.material.MaterialTheme
import androidx.ui.material.icons.Icons
import androidx.ui.material.icons.filled.ArrowRightAlt
import androidx.ui.material.icons.filled.CheckCircle
import androidx.ui.unit.dp
import net.dambakk.menumaker.model.RecipeModel


@Composable
fun Dashboard(modifier: Modifier) {
    ScrollableColumn(modifier = modifier) {
        Spacer(modifier = Modifier.height(8.dp))
        Row(modifier = Modifier.preferredHeight(300.dp).fillMaxWidth()) {
            DashboardHeading(item = pannekaker, modifier = Modifier.fillMaxSize().padding(16.dp))
        }
        Row(modifier = Modifier
            .preferredHeight(150.dp)
            .fillMaxWidth()
        ) {
            DashboardItem(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f, fill = true)
                    .padding(start = 16.dp, top = 4.dp, bottom = 4.dp, end = 4.dp),
                day = "Mandag",
                item = pannekaker,
                isDone = true
            )
            DashboardItem(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f, fill = true)
                    .padding(start = 4.dp, top = 4.dp, bottom = 4.dp, end = 16.dp),
                day = "Tirsdag",
                item = lasagne,
                isDone = true
            )
        }

        Row(modifier = Modifier.preferredHeight(150.dp).fillMaxWidth()) {
            DashboardItem(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f, fill = true)
                    .padding(start = 16.dp, top = 4.dp, bottom = 4.dp, end = 4.dp),
                day = "Onsdag",
                item = pannekaker
            )
            DashboardItem(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f, fill = true)
                    .padding(start = 4.dp, top = 4.dp, bottom = 4.dp, end = 16.dp),
                day = "Torsdag",
                item = burger
            )
        }
        Row(modifier = Modifier.preferredHeight(150.dp).fillMaxWidth()) {
            DashboardItem(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f, fill = true)
                    .padding(start = 16.dp, top = 4.dp, bottom = 4.dp, end = 16.dp),
                day = "Fredag",
                item = lasagne
            )
        }
        Row(modifier = Modifier.preferredHeight(150.dp).fillMaxWidth()) {
            DashboardItem(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f, fill = true)
                    .padding(start = 16.dp, top = 4.dp, bottom = 4.dp, end = 4.dp),
                day = "Lørdag",
                item = null
            )
            DashboardItem(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f, fill = true)
                    .padding(start = 4.dp, top = 4.dp, bottom = 4.dp, end = 16.dp),
                day = "Søndag",
                item = burger
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun DashboardHeading(item: RecipeModel, modifier: Modifier) {
    Card(modifier = modifier) {
        Stack(modifier = Modifier.fillMaxSize().padding(horizontal = 8.dp, vertical = 16.dp)) {
            Text(text = "Idag", modifier = Modifier.gravity(align = Alignment.TopStart))
            Text(text = item.duration, modifier = Modifier.gravity(align = Alignment.TopEnd))
            Text(
                text = item.name,
                modifier = Modifier.gravity(align = Alignment.BottomStart),
                style = MaterialTheme.typography.h3
            )
            IconButton(onClick = {}, modifier = Modifier.gravity(align = Alignment.BottomEnd)) {
                Icon(Icons.Filled.ArrowRightAlt)
            }

        }
    }
}

@Composable
fun DashboardItem(item: RecipeModel?, day: String, isDone: Boolean = false, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Stack(modifier = Modifier.fillMaxSize().padding(8.dp)) {
            if (item != null) {
                Text(text = day, modifier = Modifier.gravity(align = Alignment.TopStart))
                Text(text = item.duration, modifier = Modifier.gravity(align = Alignment.TopEnd))
                Text(
                    text = item.name,
                    modifier = Modifier.gravity(align = Alignment.BottomStart),
                    style = MaterialTheme.typography.h6
                )
            } else {
                Text(text = day, modifier = Modifier.gravity(align = Alignment.TopStart))
                Text(text = "Ingenting planlagt", modifier = Modifier.gravity(align = Alignment.BottomStart))
            }
            if (isDone) {
                Icon(
                    asset = Icons.Filled.CheckCircle,
                    modifier = Modifier
                        .gravity(align = Alignment.Center)
                        .preferredSize(72.dp, 72.dp)
                )
            }
        }
    }
}