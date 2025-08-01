package com.example.hospitalapp.ui.theme.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hospitalapp.R
import com.example.hospitalapp.data.AuthViewModel
import java.time.format.TextStyle


@Composable
fun loginScreen(navController: NavController){
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmpassword by remember { mutableStateOf("") }
    val authViewModel: AuthViewModel = viewModel()

    Box(){
        Image(
            painter = painterResource(id = R.drawable.background3),
            contentDescription = "login background",
            contentScale = ContentScale.FillBounds,
        )
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "Login Here",
            fontSize = 40.sp,
            fontFamily = FontFamily.SansSerif,
            fontStyle = FontStyle.Italic,
            color = Color.Magenta,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
                .padding(5.dp)

        )
        OutlinedTextField(
            value = email,
            onValueChange = {email = it},
            label = { Text("Enter Email") },
            placeholder = { Text("Please Enter email") },
            leadingIcon = { Icon( Icons.Default.Email, contentDescription = "Email icon") },
            modifier = Modifier
                .fillMaxWidth(0.8f),
            colors = OutlinedTextFieldDefaults.colors(
                Color.Blue
            )
        )
        OutlinedTextField(
            value = password,
            onValueChange = {password = it},
            label = { Text("Enter Password") },
            placeholder = { Text("Please Enter a Password") },
            leadingIcon = { Icon( Icons.Default.Lock, contentDescription = "Password icon") },
            modifier = Modifier
                .fillMaxWidth(0.8f),
            colors = OutlinedTextFieldDefaults.colors(
                Color.Blue
            )
        )
        OutlinedTextField(
            value = confirmpassword,
            onValueChange = {confirmpassword = it},
            label = { Text("Confirm Password") },
            placeholder = { Text("Please Confirm Password") },
            leadingIcon = { Icon( Icons.Default.Lock, contentDescription = "Password icon") },
            modifier = Modifier
                .fillMaxWidth(0.8f),
            colors = OutlinedTextFieldDefaults.colors(
                Color.Blue
            )

        )
        Spacer(modifier = Modifier.height(10.dp))
        val context = LocalContext.current
        Button(
            onClick = {
                authViewModel.login(
                    email = email,
                    password = password,
                    navController = navController,
                    context = context
                )
            },
            colors = ButtonDefaults.buttonColors(Color.Blue),
            modifier = Modifier
                .fillMaxWidth(0.8f)
        )
        { Text(text = "login", color = Color.White) }
        Text(
            text = "Already Registered , Login here",
            color = Color.Blue,
            modifier = Modifier
                .clickable {}
        )
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun loginScreenPreview(){
    loginScreen(rememberNavController())
}