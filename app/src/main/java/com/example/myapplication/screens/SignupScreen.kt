package com.example.myapplication.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.Components.AlreadyAccountClickableText
import com.example.myapplication.Components.ButtonComponent
import com.example.myapplication.Components.CheckBoxComponent
import com.example.myapplication.Components.DividerComponent
import com.example.myapplication.Components.NormalTextComponent
import com.example.myapplication.Components.PasswordTextField
import com.example.myapplication.Components.TextFieldComponent
import com.example.myapplication.Components.WelcomeTextComponent
import com.example.myapplication.signUpData.LogInViewModel
import com.example.myapplication.signUpData.UIEvent
import com.example.myapplication.navigate.PostOfficeAppRouter
import com.example.myapplication.navigate.Screen

@Composable
fun SignUpScreen(logInViewModel: LogInViewModel = viewModel()){
    Surface(

        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()

        ) {
            NormalTextComponent(value = "Hey There,")
            WelcomeTextComponent(value = "Welcome Back")
            Spacer(modifier = Modifier.height(20.dp))
            TextFieldComponent( Icons.Default.Person,labelValue = "First Name","FirstName", onTextSelected = {
                logInViewModel.onEvent(UIEvent.FirstNameChanged(it))
            })
            TextFieldComponent(Icons.Default.Person,labelValue = "Last Name", "lastName" ,onTextSelected = {
                logInViewModel.onEvent(UIEvent.LastNameChanged(it))
            })
            TextFieldComponent(Icons.Default.Email,labelValue = "Email", "Email", onTextSelected = {
                logInViewModel.onEvent(UIEvent.EmailChanged(it))
            })
            PasswordTextField(Icons.Default.Lock,labelValue = "Password", "Password", onTextSelected = {
                logInViewModel.onEvent(UIEvent.PasswordChanged(it))
            })
            CheckBoxComponent()
            Spacer(modifier = Modifier.height(40.dp))
            ButtonComponent(onButtonClicked = {
                logInViewModel.onEvent(UIEvent.OnButtonClicked())
            })
            Spacer(modifier = Modifier.height(20.dp))
            DividerComponent()
            Spacer(modifier = Modifier.height(20.dp))
            AlreadyAccountClickableText(onTextSelected = {
                PostOfficeAppRouter.navigateTo(Screen.LogInScreen)
            })

        }
    }
}


@Preview
@Composable
fun SignUpScreenPreview(){
    SignUpScreen()
}