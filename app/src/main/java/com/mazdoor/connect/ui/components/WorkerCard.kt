package com.mazdoor.connect.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.mazdoor.connect.model.WorkerProfile

@Composable
fun WorkerCard(
    worker: WorkerProfile,
    categoryTitle: String,
    onCall: (String) -> Unit,
    onWhatsApp: (String) -> Unit,
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier.fillMaxWidth(),
    ) {
        Column(modifier = Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(worker.name, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold)
                if (worker.verified) {
                    Text(
                        text = "Verified",
                        modifier = Modifier
                            .background(Color(0xFFD1FAE5), RoundedCornerShape(50))
                            .padding(horizontal = 10.dp, vertical = 4.dp),
                    )
                }
            }
            Text("$categoryTitle | ${worker.city}, ${worker.area}")
            Text("Rating ${worker.rating} - ${worker.completedJobs} jobs")
            Text("Starting fee Rs. ${worker.startingFee}")
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp), modifier = Modifier.fillMaxWidth()) {
                OutlinedButton(onClick = { onCall(worker.phone) }, modifier = Modifier.weight(1f)) {
                    Text("Call")
                }
                Button(onClick = { onWhatsApp(worker.phone) }, modifier = Modifier.weight(1f)) {
                    Text("WhatsApp")
                }
            }
        }
    }
}
