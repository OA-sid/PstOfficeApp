package com.example.myapplication.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.Components.DividerComponents
import com.example.myapplication.Components.ForgotPasswordComponent
import com.example.myapplication.Components.LoginButtonComponent
import com.example.myapplication.Components.NoAccountText
import com.example.myapplication.Components.NormalText
import com.example.myapplication.Components.PasswordFieldComponents
import com.example.myapplication.Components.TextFieldComponents
import com.example.myapplication.Components.WelcomeText
import com.example.myapplication.logInData.LogInUIEvent
import com.example.myapplication.logInData.SignInViewModel
import com.example.myapplication.navigate.PostOfficeAppRouter
import com.example.myapplication.navigate.Screen
import com.example.myapplication.navigate.SystemBackButtonHandler
import com.example.myapplication.signUpData.LogInViewModel
import com.example.myapplication.signUpData.UIEvent

@Composable
fun LogInScreen( signInViewModel: SignInViewModel = viewModel()){
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            NormalText(value = "Hey there,")
            WelcomeText(value = "Welcome back")
            Spacer(modifier = Modifier.height(80.dp))
            TextFieldComponents(labelValue = "Email", onTextSelected = {
                signInViewModel.onEventLogin(LogInUIEvent.LogInEmailChanged(it))
            })
            PasswordFieldComponents(labelValue = "Password", onTextSelected = {
                signInViewModel.onEventLogin(LogInUIEvent.LogInPasswordChanged(it))
            })
            ForgotPasswordComponent()
            Spacer(modifier = Modifier.height(80.dp))
            LoginButtonComponent()
            Spacer(modifier = Modifier.height(10.dp))
            DividerComponents()
            Spacer(modifier = Modifier.height(5.dp))
            NoAccountText()

            SystemBackButtonHandler {
                PostOfficeAppRouter.navigateTo(Screen.SignUpScreen)
            }
        }
    }
}