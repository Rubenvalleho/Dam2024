package com.ruben.dam2024.app.domain

sealed class ErrorApp {
    object InternetErroApp : ErrorApp()
    object ServerErrorApp : ErrorApp()
    object DataErrorApp : ErrorApp()
    object UnknowErrorApp : ErrorApp()
}