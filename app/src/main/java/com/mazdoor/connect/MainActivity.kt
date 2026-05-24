package com.mazdoor.connect

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddBox
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.WorkOutline
import com.mazdoor.connect.ui.screens.DiscoverScreen
import com.mazdoor.connect.ui.screens.LeadsScreen
import com.mazdoor.connect.ui.screens.ProfileScreen
import com.mazdoor.connect.ui.screens.RequestScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { AppRoot() }
    }
}

@Composable
private fun AppRoot() {
    val colorScheme = lightColorScheme(
        primary = Color(0xFF0D9488),
        background = Color(0xFFF6F8FA),
        surface = Color.White,
    )

    MaterialTheme(colorScheme = colorScheme) {
        val context = LocalContext.current
        var selectedTab by remember { mutableStateOf(0) }
        val tabs = listOf("Discover", "Request", "Leads", "Profile")

        Scaffold(
            bottomBar = {
                NavigationBar {
                    tabs.forEachIndexed { index, label ->
                        NavigationBarItem(
                            selected = selectedTab == index,
                            onClick = { selectedTab = index },
                            label = { Text(label) },
                            icon = {
                                when (index) {
                                    0 -> Icon(Icons.Outlined.Search, contentDescription = label)
                                    1 -> Icon(Icons.Outlined.AddBox, contentDescription = label)
                                    2 -> Icon(Icons.Outlined.WorkOutline, contentDescription = label)
                                    else -> Icon(Icons.Outlined.Person, contentDescription = label)
                                }
                            },
                        )
                    }
                }
            },
        ) { padding ->
            androidx.compose.foundation.layout.Box(modifier = Modifier.padding(padding)) {
                when (selectedTab) {
                    0 -> DiscoverScreen(onToast = { Toast.makeText(context, it, Toast.LENGTH_SHORT).show() })
                    1 -> RequestScreen(onSubmit = { Toast.makeText(context, "Request submitted", Toast.LENGTH_SHORT).show() })
                    2 -> LeadsScreen()
                    else -> ProfileScreen()
                }
            }
        }
    }
}
