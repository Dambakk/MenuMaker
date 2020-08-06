package net.dambakk.menumaker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Icon
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.CalendarToday
import androidx.compose.material.icons.outlined.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.state
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import net.dambakk.menumaker.screens.*
import net.dambakk.menumaker.ui.MenuMakerTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MenuMakerTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    AppContent()
                }
            }
        }
    }
}

@Composable
fun AppContent() {
    var currentDestination by state<Destination> { Destination.Dashboard }

    val onItemSelected : (DashboardItemModel?) -> Unit = {
        currentDestination = Destination.RecipeDetails(it)
    }

    Stack(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.padding(bottom = 64.dp)) {
            when(currentDestination) {
                is Destination.Dashboard -> Dashboard(onItemSelected)
                is Destination.RecipeDetails -> RecipeDetailsScreen((currentDestination as Destination.RecipeDetails).recipe, { currentDestination = Destination.Dashboard} )
                is Destination.Planning -> Planning()
                is Destination.Profile -> Profile()
            }
        }
        BottomBar(
            modifier = Modifier
                .gravity(align = Alignment.BottomCenter)
                .fillMaxWidth()
                .preferredHeight(64.dp),
            currentDestination = currentDestination,
            navigateTo = {
                currentDestination = it
            }
        )
    }
}

@Composable
private fun BottomBar(
    modifier: Modifier,
    currentDestination: Destination,
    navigateTo: (Destination) -> Unit
) {
    Surface(elevation = 2.dp, modifier = modifier) {
        val spacePadding = Modifier.padding(vertical = 16.dp) // Not working?
        Row(
            verticalGravity = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize()
        ) {
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = { navigateTo(Destination.Dashboard) }, modifier = spacePadding) {
                if (currentDestination == Destination.Dashboard) {
                    Column {
                        Icon(Icons.Filled.Home, modifier = Modifier.gravity(align = Alignment.CenterHorizontally))
                        Spacer(modifier = Modifier.height(4.dp))
                        Divider(color = Color.White)
                    }
                } else {
                    Icon(Icons.Outlined.Home)
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = { navigateTo(Destination.Planning) }, modifier = spacePadding) {
                if (currentDestination == Destination.Planning) {
                    Column {
                        Icon(Icons.Filled.CalendarToday, modifier = Modifier.gravity(align = Alignment.CenterHorizontally))
                        Spacer(modifier = Modifier.height(4.dp))
                        Divider(color = Color.White)
                    }
                } else {
                    Icon(Icons.Outlined.CalendarToday)
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = { navigateTo(Destination.Profile) }, modifier = spacePadding) {
                if (currentDestination == Destination.Profile) {
                    Column {
                        Icon(Icons.Filled.AccountCircle, modifier = Modifier.gravity(align = Alignment.CenterHorizontally))
                        Spacer(modifier = Modifier.height(4.dp))
                        Divider(color = Color.White)
                    }
                } else {
                    Icon(Icons.Outlined.AccountCircle)
                }
            }
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

sealed class Destination {
    object Dashboard : Destination()
    object Planning : Destination()
    object Profile : Destination()
    data class RecipeDetails(val recipe: DashboardItemModel?) : Destination()
}