package com.mazdoor.connect.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LeadsScreen() {
    val leads = listOf(
        Triple("Plumber - Johar", "Kitchen leakage issue", "Urgent"),
        Triple("Electrician - Nazimabad", "DB board spark issue", "Normal"),
        Triple("AC Technician - DHA", "AC not cooling", "Urgent"),
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        items(leads) { lead ->
            Card(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(lead.first)
                    Text(lead.second)
                    Button(onClick = {}, modifier = Modifier.fillMaxWidth()) {
                        Text(if (lead.third == "Urgent") "Open" else "View")
                    }
                }
            }
        }
    }
}
