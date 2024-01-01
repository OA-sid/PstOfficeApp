package com.example.myapplication.Components


import android.graphics.Paint.Style
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth

import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock

import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button

import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.myapplication.ui.theme.Primary
import com.example.myapplication.ui.theme.Secondary

@Composable
fun NormalText(value: String){
    Text(modifier = Modifier
        .fillMaxWidth()
        .heightIn(30.dp),

        text = value,
        style = TextStyle(
            fontStyle = FontStyle.Normal,
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
        ),

        )
}


@Composable
fun WelcomeText(value: String){
    Text(modifier = Modifier
        .fillMaxWidth()
        .heightIn(20.dp),

        text = value,
        style = TextStyle(
            fontStyle = FontStyle.Normal,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
        ),

        )
}


@Composable
fun TextFieldComponents(labelValue: String, onTextSelected: (String) -> Unit){
    var text by remember {
        mutableStateOf("")
    }
    OutlinedTextField(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp),
        value = text,
        onValueChange = {
            text = it
            onTextSelected(it)
                        },
        label = { Text(text = labelValue)},
        leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription ="Email" ) },


    )
}



@Composable
fun PasswordFieldComponents(labelValue: String, onTextSelected: (String) -> Unit){
    var text by remember {
        mutableStateOf("")
    }
    val passwordVisible = remember {
        mutableStateOf(false)
    }
    OutlinedTextField(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp),
        leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription ="Password" ) },
        value = text,
        onValueChange = {
            text = it
            onTextSelected(it)
                        },
        label = { Text(text = labelValue)},
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),

        trailingIcon = {
            val iconImage = if (passwordVisible.value){
                Icons.Filled.Visibility
            }else{
                Icons.Filled.VisibilityOff
            }
            val description = if (passwordVisible.value){
                "Hide Password"
            }else{
                "Show password"
            }

            IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                Icon(imageVector = iconImage, contentDescription = description)
            }
        },
        visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation()
    )
}

@Composable
fun LoginButtonComponent(){
    Button(modifier = Modifier
        .padding(10.dp)
        ,
        colors = ButtonDefaults.buttonColors(Color.Transparent),
        onClick = { /*TODO*/ }
    ) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp)
            .background(
                brush = Brush.horizontalGradient(listOf(Secondary, Primary)),
                shape = RoundedCornerShape(50.dp)
            ),
            contentAlignment = Alignment.Center) {
            Text(
                text = "Login",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal
                )
            )
        }
    }
}


@Composable
fun ForgotPasswordComponent(){
    val text = "Forgot password?"

    val annotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(color = Primary)){
            pushStringAnnotation(tag = text, annotation = text)
            append(text)
        }

    }
    ClickableText(text = annotatedString,
        style = TextStyle(
            fontWeight = FontWeight.Medium
        ), onClick = {
                offset -> annotatedString.getStringAnnotations(offset,offset)
            .firstOrNull()?.also { span ->
                Log.d("Reset password", "{$span}")
            }
        })
}



@Composable
fun DividerComponents(){
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(
            Modifier
                .weight(1f)
                .padding(3.dp))
        Text(text = "or",
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal
            )
        )
        Divider(
            Modifier
                .weight(1f)
                .padding(3.dp))
    }
}


@Composable
fun NoAccountText(){
    val initialText = "Don't have an account?"
    val registerText = "Register"

    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = Primary)){
            pushStringAnnotation(tag = registerText, annotation = registerText)
            append(registerText)
        }
    }

    ClickableText(style = TextStyle(
        textAlign = TextAlign.Center
    ),text = annotatedString, onClick = {
            offset -> annotatedString.getStringAnnotations(offset,offset)
        .firstOrNull()?.also { span ->
            Log.d("Register","{$span}")
        }
    })
}