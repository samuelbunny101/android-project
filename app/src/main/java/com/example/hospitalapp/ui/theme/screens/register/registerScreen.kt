package com.example.hospitalapp.ui.theme.screens.register

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hospitalapp.R
import com.example.hospitalapp.data.AuthViewModel
import com.example.hospitalapp.navigation.ROUTE_LOGIN

@Composable
fun RegisterScreen(navController: NavController) {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var fullName by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    val authViewModel: AuthViewModel = viewModel()
    val context = LocalContext.current

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.background2),
            contentDescription = "register background",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.3f))
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Register",
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            )
            val textFieldModifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 6.dp)
            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("Username") },
                leadingIcon = { Icon(Icons.Default.Person, contentDescription = "Username") },
                modifier = textFieldModifier,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.White,
                    focusedLabelColor = Color.White,
                    unfocusedBorderColor = Color.LightGray,
                    cursorColor = Color.White,
                    focusedLeadingIconColor = Color.White,
                    unfocusedLeadingIconColor = Color.LightGray,
                    unfocusedLabelColor = Color.LightGray
                ),
                textStyle = TextStyle(color = Color.White)
            )
            OutlinedTextField(
                value = fullName,
                onValueChange = { fullName = it },
                label = { Text("Full Name") },
                leadingIcon = { Icon(Icons.Default.Person, contentDescription = "Full Name") },
                modifier = textFieldModifier,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.LightGray,
                    cursorColor = Color.White,
                    focusedLeadingIconColor = Color.White,
                    unfocusedLeadingIconColor = Color.LightGray,
                    focusedLabelColor = Color.White,
                    unfocusedLabelColor = Color.LightGray
                ),
                textStyle = TextStyle(color = Color.White)
            )
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                leadingIcon = { Icon(Icons.Default.Email, contentDescription = "Email") },
                modifier = textFieldModifier,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.LightGray,
                    cursorColor = Color.White,
                    focusedLeadingIconColor = Color.White,
                    unfocusedLeadingIconColor = Color.LightGray,
                    focusedLabelColor = Color.White,
                    unfocusedLabelColor = Color.LightGray
                ),
                textStyle = TextStyle(color = Color.White)
            )
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                leadingIcon = { Icon(Icons.Default.Lock, contentDescription = "Password") },
                modifier = textFieldModifier,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.LightGray,
                    cursorColor = Color.White,
                    focusedLeadingIconColor = Color.White,
                    unfocusedLeadingIconColor = Color.LightGray,
                    focusedLabelColor = Color.White,
                    unfocusedLabelColor = Color.LightGray
                ),
                textStyle = TextStyle(color = Color.White)
            )
            OutlinedTextField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                label = { Text("Confirm Password") },
                leadingIcon = { Icon(Icons.Default.Lock, contentDescription = "Confirm Password") },
                modifier = textFieldModifier,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.LightGray,
                    cursorColor = Color.White,
                    focusedLeadingIconColor = Color.White,
                    unfocusedLeadingIconColor = Color.LightGray,
                    focusedLabelColor = Color.White,
                    unfocusedLabelColor = Color.LightGray
                ),
                textStyle = TextStyle(color = Color.White)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    authViewModel.signup(
                        username = username,
                        fullName = fullName,
                        email = email,
                        password = password,
                        confirmPassword = confirmPassword,
                        navController = navController,
                        context = context
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1976D2)),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(text = "Register", fontSize = 16.sp, color = Color.White)
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Already registered? Login here",
                color = Color.White,
                modifier = Modifier
                    .clickable { navController.navigate(ROUTE_LOGIN) }
            )
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RegisterScreenPreview(){
    RegisterScreen(rememberNavController())
}


//Box() {
//    Image(
//        painter = painterResource(id = R.drawable.background2),
//        contentDescription = "register background",
//        contentScale = ContentScale.FillBounds,
//    )
//}
//
//Column(
//modifier = Modifier.fillMaxSize(),
//verticalArrangement = Arrangement.Center,
//horizontalAlignment = Alignment.CenterHorizontally
//) {
//    Text(
//        text = "Register Here",
//        fontSize = 40.sp,
//        fontFamily = FontFamily.SansSerif,
//        fontStyle = FontStyle.Italic,
//        color = Color.Magenta,
//        textAlign = TextAlign.Center,
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(5.dp)
//    )
//    Spacer(modifier = Modifier.height(20.dp))
//    Image(
//        painter = painterResource(id = R.drawable.logo2),
//        contentDescription = "Image Logo2",
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(100.dp),
//        contentScale = ContentScale.Fit
//    )
//    OutlinedTextField(
//        value = username,
//        onValueChange = { username = it },
//        label = { Text("Enter Username") },
//        placeholder = { Text("Please Enter Username") },
//        leadingIcon = { Icon(Icons.Default.Person, contentDescription = "Person icon") },
//        modifier = Modifier
//            .fillMaxWidth(0.8f),
//        textStyle = TextStyle(
//            color = Color.Blue
//        )
//    )
//    OutlinedTextField(
//        value = fullName,
//        onValueChange = { fullName = it },
//        label = { Text("Enter FullName") },
//        placeholder = { Text("Please Enter FullName") },
//        leadingIcon = { Icon(Icons.Default.Person, contentDescription = "Person icon") },
//        modifier = Modifier
//            .fillMaxWidth(0.8f),
//        colors = OutlinedTextFieldDefaults.colors(
//            Color.Blue
//        )
//    )
//    OutlinedTextField(
//        value = email,
//        onValueChange = { email = it },
//        label = { Text("Enter Email") },
//        placeholder = { Text("Please Enter email") },
//        leadingIcon = { Icon(Icons.Default.Email, contentDescription = "Email icon") },
//        modifier = Modifier
//            .fillMaxWidth(0.8f),
//        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
//        colors = OutlinedTextFieldDefaults.colors(
//            Color.Blue
//        )
//    )
//    OutlinedTextField(
//        value = password,
//        onValueChange = { password = it },
//        label = { Text("Enter Password") },
//        placeholder = { Text("Please Enter a Password") },
//        leadingIcon = { Icon(Icons.Default.Lock, contentDescription = "Password icon") },
//        modifier = Modifier
//            .fillMaxWidth(0.8f),
//        colors = OutlinedTextFieldDefaults.colors(
//            Color.Blue
//        )
//    )
//    OutlinedTextField(
//        value = confirmPassword,
//        onValueChange = { confirmPassword = it },
//        label = { Text("Confirm Password") },
//        placeholder = { Text("Please Confirm Password") },
//        leadingIcon = { Icon(Icons.Default.Lock, contentDescription = "Password icon") },
//        modifier = Modifier
//            .fillMaxWidth(0.8f),
//        colors = OutlinedTextFieldDefaults.colors(
//            Color.Blue
//        )
//    )
//    Spacer(modifier = Modifier.height(10.dp))
//    val context = LocalContext.current
//    Button(
//        onClick = {
//            authViewModel.signup(
//                username = username,
//                fullName = fullName,
//                email = email,
//                password = password,
//                confirmPassword = confirmPassword,
//                navController = navController,
//                context = context)
//        },
//        colors = ButtonDefaults.buttonColors(Color.Blue),
//        modifier = Modifier
//            .fillMaxWidth(0.8f)
//    )
//    { Text(text = "Register", color = Color.White) }
//    Text(
//        text = "If already registered, Login here",
//        color = Color.Blue,
//        modifier = Modifier
//            .clickable { navController.navigate(ROUTE_LOGIN) }
//    )
//}