package com.mazdoor.connect.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun ProfileScreen() {
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        item {
            Card {
                Column(modifier = Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    Text("Hassan User", fontWeight = FontWeight.SemiBold)
                    Text("City: Karachi")
                    Text("Role: Customer + Worker")
                    Text("Phone Verified: Yes")
                }
            }
        }
        item {
            Card {
                ListItem(headlineContent = { Text("Verification Center") }, supportingContent = { Text("Upload CNIC and profile details") })
                Divider()
                ListItem(headlineContent = { Text("Safety & Privacy") })
                Divider()
                ListItem(headlineContent = { Text("Support") })
            }
        }
    }
}
