package com.fursa.addressbook.db.model

data class ContactBook(
    val firstName: String,
    val lastName: String,
    val phone: String,
    val email: String,
    val address: String,
    val city: String
)