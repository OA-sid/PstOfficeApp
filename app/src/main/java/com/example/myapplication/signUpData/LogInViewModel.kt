package com.example.myapplication.signUpData

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class LogInViewModel: ViewModel() {
    private var registrationUiState = mutableStateOf(RegistrationUiState())
    private val tAG = LogInViewModel::class.simpleName
    fun onEvent(event: UIEvent){
        when(event){
            is UIEvent.FirstNameChanged ->{
                registrationUiState.value = registrationUiState.value.copy(
                    firstName = event.firstName
                )
                printState()
                }
            is UIEvent.LastNameChanged ->{
                registrationUiState.value = registrationUiState.value.copy(
                    lastName = event.lastName
                )
                printState()
            }

            is UIEvent.EmailChanged ->{
                registrationUiState.value = registrationUiState.value.copy(
                    email = event.email
                )
                printState()
            }
            is UIEvent.PasswordChanged ->{
                registrationUiState.value = registrationUiState.value.copy(
                    password = event.password
                )
                printState()
            }
            is UIEvent.OnButtonClicked -> {
                signUp()
            }
        }
    }

    private fun signUp() {
        Log.d(tAG,"Button Clicked")
        printState()
    }

    private fun printState(){
        Log.d(tAG,"Inside print state")
        Log.d(tAG,registrationUiState.value.toString())
    }
}