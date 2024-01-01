package com.example.myapplication.Components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
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
fun NormalTextComponent(value: String){
    Text(text = value, modifier = Modifier
        .fillMaxWidth()
        .heightIn(40.dp),
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ),
        textAlign = TextAlign.Center
    )
}


@Composable
fun WelcomeTextComponent(value: String){
    Text(text = value, modifier = Modifier
        .fillMaxWidth()
        .heightIn(40.dp),
        style = TextStyle(
            fontSize =30.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal
        ),
        textAlign = TextAlign.Center
    )
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldComponent(icon: ImageVector, labelValue: String, description: String, onTextSelected: (String) -> Unit)
{
    var textValue by remember {
        mutableStateOf("")
    }


        OutlinedTextField(

            leadingIcon = {
                Icon(imageVector = icon, contentDescription = description)
            },

            value = textValue,
            onValueChange = {
                textValue = it
                onTextSelected(it)
                            },
            label = { Text(text = labelValue) },
            modifier = Modifier
                .fillMaxWidth(),
           colors = TextFieldDefaults.outlinedTextFieldColors(
               focusedBorderColor = Primary,
               focusedLabelColor = Primary,
               cursorColor = Primary
           )


        )

}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextField(icon: ImageVector, labelValue: String, description: String, onTextSelected: (String) -> Unit)
{
    var password by remember {
        mutableStateOf("")
    }

    val passwordVisible = remember {
        mutableStateOf(false)
    }


    OutlinedTextField(
        leadingIcon = {
            Icon(imageVector = icon, contentDescription = description)
        },

        label = { Text(text = labelValue) },
        value = password,
        onValueChange = {
            password = it
            onTextSelected(it)
        },

        modifier = Modifier
            .fillMaxWidth(),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Primary,
            focusedLabelColor = Primary,
            cursorColor = Primary
        ),

        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            val iconImage = if(passwordVisible.value){
                Icons.Filled.Visibility
            }else{
                Icons.Filled.VisibilityOff
            }
            val description = if(passwordVisible.value){
                "Hide Password"
            }else{
                "Show Password"
            }
            
            IconButton(onClick = { passwordVisible.value = !passwordVisible.value}) {
                Icon(imageVector = iconImage, contentDescription = description)
            }
        },
        visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation()


        )

}



@Composable
fun CheckBoxComponent(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(26.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        var checkBoxState by remember {
            mutableStateOf(false)
        }
        Checkbox(checked = checkBoxState, onCheckedChange = {checkBoxState = !checkBoxState})
        ClickableTextComponent()
    }
}


@Composable
fun ClickableTextComponent(){
    val initialText = "By continuing you accept our"
    val privacyPolicyText = "Privacy policy"
    val andText = "and"
    val termsAndConditionText = "Term of use"


    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = Primary)) {
            pushStringAnnotation(tag = privacyPolicyText, annotation = privacyPolicyText)
            append(privacyPolicyText)
        }
        append(andText)
        withStyle(style = SpanStyle(color = Primary)) {
            pushStringAnnotation(tag = termsAndConditionText, annotation = termsAndConditionText)
            append(termsAndConditionText)
        }
    }
        ClickableText(text = annotatedString, onClick = {
            offset ->annotatedString.getStringAnnotations(offset,offset)
            .firstOrNull()?.also {span->
                Log.d("ClickableTextComponent","{$span}")
            }
        })
    }


@Composable
fun ButtonComponent(onButtonClicked: ()-> Unit){
    Button(onClick = {
                     onButtonClicked.invoke()
                     }, modifier = Modifier
        .fillMaxWidth(),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(Color.Transparent)

    ) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .heightIn(48.dp)
        .background(
            brush = Brush.horizontalGradient(listOf(Secondary, Primary)),
            shape = RoundedCornerShape(50.dp)
        ),
        contentAlignment = Alignment.Center){
        Text(
            text = "Register",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }

    }
}


@Composable
fun DividerComponent(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            ,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(3.dp), thickness = 2.dp, color = Color.LightGray)
        Text(text = "or", fontSize = 18.sp, fontWeight = FontWeight.Normal)
        Divider(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(3.dp), thickness = 2.dp, color = Color.LightGray)
    }
}

@Composable
fun AlreadyAccountClickableText(onTextSelected: (String) -> Unit){
    val initialText = "Already have an account ? "
    val loginText = "Login"

    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = Primary)){
            pushStringAnnotation(tag = loginText , annotation = loginText)
            append(loginText)
        }
    }

    ClickableText(modifier = Modifier
        .fillMaxWidth()
        .heightIn(20.dp)
        ,style = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal,
        textAlign = TextAlign.Center
    ),text = annotatedString, onClick = {
        offset -> annotatedString.getStringAnnotations(offset,offset)
        .firstOrNull()?.also { span ->
            Log.d("Login text is clicked", "{$span}")

                if (span.item == loginText){
                onTextSelected(span.item)
                }
        }
    })
}

