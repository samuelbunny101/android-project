package com.example.hospitalapp.ui.theme.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hospitalapp.R

@Composable
fun SplashScreen(onNavigateToNext: () -> Unit) {
    val splashScreenDuration = 3000L
    LaunchedEffect (Unit) {
        kotlinx.coroutines.delay(splashScreenDuration)
        onNavigateToNext()
    }
    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ){
        Column (
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                painter = painterResource(id = R.drawable.water),
                contentDescription = "Logo",
                modifier = Modifier.size(200.dp)
            )
            Text(
                text = "Welcome to the Hospital App",
                color = Color.White,
                fontSize = 19.sp,
                fontWeight = Bold
            )
        }
    }
}