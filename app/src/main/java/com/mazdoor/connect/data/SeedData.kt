package com.mazdoor.connect.data

import com.mazdoor.connect.model.ServiceCategory
import com.mazdoor.connect.model.WorkerProfile

object SeedData {
    val categories = listOf(
        ServiceCategory("electrician", "Electrician"),
        ServiceCategory("plumber", "Plumber"),
        ServiceCategory("ac", "AC Technician"),
        ServiceCategory("carpenter", "Carpenter"),
        ServiceCategory("painter", "Painter"),
    )

    val workers = listOf(
        WorkerProfile("w1", "Ali Electric Works", "electrician", "Karachi", "Gulshan", 4.8, 126, 1500, true, "+923001112233"),
        WorkerProfile("w2", "Umer Plumbing", "plumber", "Karachi", "Johar", 4.6, 98, 1200, true, "+923224445566"),
        WorkerProfile("w3", "Rehman AC Care", "ac", "Lahore", "DHA", 4.7, 77, 2000, false, "+923339998877"),
        WorkerProfile("w4", "Bilal Wood Studio", "carpenter", "Islamabad", "G-11", 4.5, 64, 1800, true, "+923455551234"),
    )
}
