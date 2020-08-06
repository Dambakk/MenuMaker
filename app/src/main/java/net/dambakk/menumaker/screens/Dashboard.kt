package net.dambakk.menumaker.screens

import androidx.compose.foundation.Icon
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowRightAlt
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import net.dambakk.menumaker.allRecipes
import net.dambakk.menumaker.model.RecipeModel
import net.dambakk.menumaker.ui.pastelColors


data class DashboardItemModel(
    val item: RecipeModel?,
    val backgroundColor: Color,
    val day: String,
    val isDone: Boolean
)

sealed class Day {
    object Monday : Day()
    object Tuesday : Day()
}

@Composable
fun Dashboard(onItemClicked: (DashboardItemModel?) -> Unit) {
    val week = listOf(
        DashboardItemModel(allRecipes.random(), pastelColors.random(), "Mandag", true),
        DashboardItemModel(allRecipes.random(), pastelColors.random(), "Tirsdag", true),
        DashboardItemModel(allRecipes.random(), pastelColors.random(), "Onsdag", false),
        DashboardItemModel(allRecipes.random(), pastelColors.random(), "Torsdag", false),
        DashboardItemModel(allRecipes.random(), pastelColors.random(), "Fredag", false),
        DashboardItemModel(null, pastelColors.random(), "Lørdag", false),
        DashboardItemModel(allRecipes.random(), pastelColors.random(), "Søndag", false),
    )
    ScrollableColumn {
        Spacer(modifier = Modifier.height(8.dp))
        Row(modifier = Modifier.preferredHeight(330.dp).fillMaxWidth()) {
            DashboardHeading(
                item = week[2],
                modifier = Modifier.fillMaxSize().padding(16.dp),
                onItemClicked
            )
        }
        Row(
            modifier = Modifier
                .preferredHeight(150.dp)
                .fillMaxWidth()
        ) {
            DashboardItem(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f, fill = true)
                    .padding(start = 16.dp, top = 4.dp, bottom = 4.dp, end = 4.dp),
                week[0],
                onItemClicked
            )
            DashboardItem(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f, fill = true)
                    .padding(start = 4.dp, top = 4.dp, bottom = 4.dp, end = 16.dp),
                week[1],
                onItemClicked
            )
        }

        Row(modifier = Modifier.preferredHeight(150.dp).fillMaxWidth()) {
            DashboardItem(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f, fill = true)
                    .padding(start = 16.dp, top = 4.dp, bottom = 4.dp, end = 4.dp),
                week[2],
                onItemClicked
            )
            DashboardItem(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f, fill = true)
                    .padding(start = 4.dp, top = 4.dp, bottom = 4.dp, end = 16.dp),
                week[3],
                onItemClicked
            )
        }
        Row(modifier = Modifier.preferredHeight(150.dp).fillMaxWidth()) {
            DashboardItem(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f, fill = true)
                    .padding(start = 16.dp, top = 4.dp, bottom = 4.dp, end = 16.dp),
                week[4],
                onItemClicked
            )
        }
        Row(modifier = Modifier.preferredHeight(150.dp).fillMaxWidth()) {
            DashboardItem(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f, fill = true)
                    .padding(start = 16.dp, top = 4.dp, bottom = 4.dp, end = 4.dp),
                week[5],
                onItemClicked
            )
            DashboardItem(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f, fill = true)
                    .padding(start = 4.dp, top = 4.dp, bottom = 4.dp, end = 16.dp),
                week[6],
                onItemClicked
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun DashboardHeading(item: DashboardItemModel, modifier: Modifier, onItemClicked: (DashboardItemModel?) -> Unit) {
    Stack(
        modifier = modifier
            .fillMaxSize()
    ) {
        Text(
            text = "Idag",
            modifier = Modifier.gravity(align = Alignment.TopStart),
            style = MaterialTheme.typography.h6
        )
        Text(
            text = item.item?.duration ?: "",
            modifier = Modifier.gravity(align = Alignment.TopEnd),
            style = MaterialTheme.typography.h6
        )
        Text(
            text = item.item?.name ?: "No name",
            modifier = Modifier.gravity(align = Alignment.BottomStart),
            style = MaterialTheme.typography.h3
        )
        IconButton(
            modifier = Modifier.gravity(align = Alignment.BottomEnd),
            onClick = {
                onItemClicked(item)
            }
        ) {
            Icon(Icons.Filled.ArrowRightAlt)
        }
    }
}

@Composable
fun DashboardItem(
    modifier: Modifier = Modifier,
    item: DashboardItemModel,
    onClickAction: (DashboardItemModel?) -> Unit
) {
    Card(
        color = item.backgroundColor,
        modifier = modifier.clickable(onClick = {
            onClickAction(item)
        })
    ) {
        Stack(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            if (item.item != null) {
                Text(text = item.day, modifier = Modifier.gravity(align = Alignment.TopStart))
                Text(text = item.item.duration, modifier = Modifier.gravity(align = Alignment.TopEnd))
                Text(
                    text = item.item.name,
                    modifier = Modifier.gravity(align = Alignment.BottomStart),
                    style = MaterialTheme.typography.h6
                )
            } else {
                Text(text = item.day, modifier = Modifier.gravity(align = Alignment.TopStart))
                Text(
                    text = "Ingenting planlagt",
                    modifier = Modifier.gravity(align = Alignment.BottomStart)
                )
            }
            if (item.isDone) {
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