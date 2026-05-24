package com.mazdoor.connect.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RequestScreen(onSubmit: () -> Unit) {
    var category by remember { mutableStateOf("") }
    var issue by remember { mutableStateOf("") }
    var area by remember { mutableStateOf("") }
    var urgent by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Text("Post a service request")
        OutlinedTextField(value = category, onValueChange = { category = it }, label = { Text("Category") }, modifier = Modifier.fillMaxWidth())
        OutlinedTextField(value = issue, onValueChange = { issue = it }, label = { Text("Issue details") }, minLines = 4, modifier = Modifier.fillMaxWidth())
        OutlinedTextField(value = area, onValueChange = { area = it }, label = { Text("Area") }, modifier = Modifier.fillMaxWidth())
        androidx.compose.foundation.layout.Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Switch(checked = urgent, onCheckedChange = { urgent = it })
            Text("Emergency request")
        }
        Button(onClick = onSubmit, modifier = Modifier.fillMaxWidth()) { Text("Submit Request") }
    }
}
