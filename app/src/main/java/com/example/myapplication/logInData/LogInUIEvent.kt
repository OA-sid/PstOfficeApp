package com.example.myapplication.logInData

import com.example.myapplication.signUpData.UIEvent

sealed class LogInUIEvent {
    data class LogInEmailChanged(val email: String) : LogInUIEvent()
    data class LogInPasswordChanged(val password: String) : LogInUIEvent()

}