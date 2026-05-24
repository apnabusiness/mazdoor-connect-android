package com.mazdoor.connect.model

data class WorkerProfile(
    val id: String,
    val name: String,
    val categoryId: String,
    val city: String,
    val area: String,
    val rating: Double,
    val completedJobs: Int,
    val startingFee: Int,
    val verified: Boolean,
    val phone: String,
)
