package net.dambakk.menumaker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.getValue
import androidx.compose.setValue
import androidx.compose.state
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.core.setContent
import androidx.ui.foundation.Icon
import androidx.ui.foundation.Text
import androidx.ui.layout.*
import androidx.ui.material.IconButton
import androidx.ui.material.MaterialTheme
import androidx.ui.material.Surface
import androidx.ui.material.icons.Icons
import androidx.ui.material.icons.filled.AccountCircle
import androidx.ui.material.icons.filled.CalendarToday
import androidx.ui.material.icons.filled.Home
import androidx.ui.material.icons.filled.VerifiedUser
import androidx.ui.material.icons.outlined.AccountCircle
import androidx.ui.material.icons.outlined.CalendarToday
import androidx.ui.material.icons.outlined.Home
import androidx.ui.unit.dp
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

    Stack(modifier = Modifier.fillMaxSize()) {
        when(currentDestination) {
            Destination.Dashboard -> Dashboard(modifier = Modifier.padding(bottom = 64.dp))
            Destination.Planning -> Text(text = "Planning")
            Destination.Profile -> Text(text = "Profile")
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
                    Icon(Icons.Filled.Home)
                } else {
                    Icon(Icons.Outlined.Home)
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = { navigateTo(Destination.Planning) }, modifier = spacePadding) {
                if (currentDestination == Destination.Planning) {
                    Icon(Icons.Filled.CalendarToday)
                } else {
                    Icon(Icons.Outlined.CalendarToday)
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = { navigateTo(Destination.Profile) }, modifier = spacePadding) {
                if (currentDestination == Destination.Profile) {
                    Icon(Icons.Filled.AccountCircle)
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
}