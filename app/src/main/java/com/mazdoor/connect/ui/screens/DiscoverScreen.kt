package com.mazdoor.connect.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.ExposedDropdownMenu
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mazdoor.connect.data.SeedData
import com.mazdoor.connect.ui.components.WorkerCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DiscoverScreen(onToast: (String) -> Unit) {
    var selectedCity by remember { mutableStateOf("Karachi") }
    var categoryFilter by remember { mutableStateOf("All") }
    var cityExpanded by remember { mutableStateOf(false) }
    var categoryExpanded by remember { mutableStateOf(false) }

    val cities = listOf("Karachi", "Lahore", "Islamabad")
    val categoryOptions = listOf("All") + SeedData.categories.map { it.title }

    val filteredWorkers = SeedData.workers.filter { worker ->
        val cityMatch = worker.city == selectedCity
        val categoryMatch = if (categoryFilter == "All") true else {
            SeedData.categories.firstOrNull { it.id == worker.categoryId }?.title == categoryFilter
        }
        cityMatch && categoryMatch
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp),
        contentPadding = PaddingValues(vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        item {
            Text("Find trusted workers nearby")
        }
        item {
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                ExposedDropdownMenuBox(expanded = cityExpanded, onExpandedChange = { cityExpanded = !cityExpanded }) {
                    OutlinedTextField(
                        modifier = Modifier.menuAnchor(MenuAnchorType.PrimaryNotEditable).fillMaxWidth(),
                        readOnly = true,
                        value = selectedCity,
                        onValueChange = {},
                        label = { Text("City") },
                        trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = cityExpanded) },
                    )
                    ExposedDropdownMenu(expanded = cityExpanded, onDismissRequest = { cityExpanded = false }) {
                        cities.forEach { city ->
                            DropdownMenuItem(text = { Text(city) }, onClick = {
                                selectedCity = city
                                cityExpanded = false
                            })
                        }
                    }
                }

                ExposedDropdownMenuBox(expanded = categoryExpanded, onExpandedChange = { categoryExpanded = !categoryExpanded }) {
                    OutlinedTextField(
                        modifier = Modifier.menuAnchor(MenuAnchorType.PrimaryNotEditable).fillMaxWidth(),
                        readOnly = true,
                        value = categoryFilter,
                        onValueChange = {},
                        label = { Text("Service category") },
                        trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = categoryExpanded) },
                    )
                    ExposedDropdownMenu(expanded = categoryExpanded, onDismissRequest = { categoryExpanded = false }) {
                        categoryOptions.forEach { category ->
                            DropdownMenuItem(text = { Text(category) }, onClick = {
                                categoryFilter = category
                                categoryExpanded = false
                            })
                        }
                    }
                }
            }
        }

        if (filteredWorkers.isEmpty()) {
            item { Text("No workers found for selected filters") }
        } else {
            items(filteredWorkers) { worker ->
                val categoryTitle = SeedData.categories.firstOrNull { it.id == worker.categoryId }?.title ?: "Service"
                WorkerCard(
                    worker = worker,
                    categoryTitle = categoryTitle,
                    onCall = { onToast("Call $it") },
                    onWhatsApp = { onToast("WhatsApp $it") },
                )
            }
        }
    }
}
