package com.ammar.autofitapp.models

data class SnackbarMessage(
    val longDuration: Boolean = false,
    val content: String? = null,
    val messageId: Int = 0,
    val positiveMessage: Boolean = false
)