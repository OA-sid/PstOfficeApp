package com.example.myapplication.logInData

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SignInViewModel : ViewModel(){

    private var logInUIState = mutableStateOf(LogInUIState())
    private val tAG = SignInViewModel::class.simpleName

    fun onEventLogin(event: LogInUIEvent){
        when(event){
            is LogInUIEvent.LogInEmailChanged -> {
                logInUIState.value = logInUIState.value.copy(
                    email = event.email
                )
                printState()
            }
            is LogInUIEvent.LogInPasswordChanged -> {
                logInUIState.value = logInUIState.value.copy(
                    password = event.password
                )
                printState()
            }
        }
    }

    private fun printState(){
        Log.d(tAG,"State changed")
        Log.d(tAG, logInUIState.value.toString())
    }
}