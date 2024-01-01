package com.example.myapplication.app

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.myapplication.navigate.PostOfficeAppRouter
import com.example.myapplication.navigate.Screen
import com.example.myapplication.screens.LogInScreen
import com.example.myapplication.screens.SignUpScreen

@Composable
fun HomeApp(){
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
            Crossfade(targetState = PostOfficeAppRouter.currentScreen, label = "") {
                currentState ->
                when(currentState.value){
                    is Screen.SignUpScreen ->{
                        SignUpScreen()
                    }
                    is Screen.LogInScreen ->{
                        LogInScreen()
                    }
                }
            }
    }
}