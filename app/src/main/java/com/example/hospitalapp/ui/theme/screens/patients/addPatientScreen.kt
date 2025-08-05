package com.example.hospitalapp.ui.theme.screens.patients

import android.content.Context
import android.net.Uri
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.VectorConverter
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.hospitalapp.R
import com.example.hospitalapp.data.PatientViewModel
import com.example.hospitalapp.navigation.ROUTE_DASHBOARD

@Composable
fun AddPatientScreen(navController:NavController) {
    var name by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    var nationality by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var diagnosis by remember { mutableStateOf("") }
    val imageUri = rememberSaveable { mutableStateOf<Uri?>(null) }
    val launcher =
        rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            uri?.let {
                imageUri.value = it
            }
        }
    val patientViewModel: PatientViewModel = viewModel()
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.White
            )
            .padding(16.dp)
    ) {
        Card (
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .align(Alignment.Center),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.Blue.copy(alpha = 0.85f),
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
        ){
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(
                    text = "ADD NEW PATIENT",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                Card (
                    shape = CircleShape,
                    modifier = Modifier
                        .size(140.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
                ){
                    AsyncImage(
                        model = imageUri.value ?: R.drawable.ic_person,
                        contentDescription = "patient image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(200.dp)
                            .clickable { launcher.launch("image/*") }
                    )
                }
                Text(
                    text = "Tap to upload photo",
                    color = Color.Gray,
                    fontSize = 12.sp,
                    modifier = Modifier
                        .padding(top = 8.dp, bottom = 16.dp)
                )
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Enter Patient Name") },
                    placeholder = { Text("Please Enter Patient Name") },
                    modifier = Modifier
                        .fillMaxWidth(),
                    textStyle = TextStyle(color = Color.White),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedLabelColor = Color.White,
                        unfocusedLabelColor = Color.White,
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.White,
                        focusedBorderColor = Color.White,
                        unfocusedBorderColor = Color.White,
                        focusedPlaceholderColor = Color.White,
                    )
                )
                OutlinedTextField(
                    value = gender,
                    onValueChange = { gender = it },
                    label = { Text("Enter Patient Gender") },
                    placeholder = { Text("Please Enter Patient Gender") },
                    modifier = Modifier
                        .fillMaxWidth(),
                    textStyle = TextStyle(color = Color.White),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedLabelColor = Color.White,
                        unfocusedLabelColor = Color.White,
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.White,
                        focusedBorderColor = Color.White,
                        unfocusedBorderColor = Color.White,
                        focusedPlaceholderColor = Color.White,
                    )
                )
                OutlinedTextField(
                    value = nationality,
                    onValueChange = { nationality = it },
                    label = { Text("Enter Patient Nationality") },
                    placeholder = { Text("Please Enter Patient Nationality") },
                    modifier = Modifier
                        .fillMaxWidth(),
                    textStyle = TextStyle(color = Color.White),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedLabelColor = Color.White,
                        unfocusedLabelColor = Color.White,
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.White,
                        focusedBorderColor = Color.White,
                        unfocusedBorderColor = Color.White,
                        focusedPlaceholderColor = Color.White,
                    )
                )
                OutlinedTextField(
                    value = phoneNumber,
                    onValueChange = { phoneNumber = it },
                    label = { Text("Enter Patient Phone Number") },
                    placeholder = { Text("Please Enter Patient Phone Number") },
                    modifier = Modifier
                        .fillMaxWidth(),
                    textStyle = TextStyle(color = Color.White),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedLabelColor = Color.White,
                        unfocusedLabelColor = Color.White,
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.White,
                        focusedBorderColor = Color.White,
                        unfocusedBorderColor = Color.White,
                        focusedPlaceholderColor = Color.White,
                    )
                )
                OutlinedTextField(
                    value = age,
                    onValueChange = { age = it },
                    label = { Text("Enter Patient Age") },
                    placeholder = { Text("Please Enter Patient Age") },
                    modifier = Modifier
                        .fillMaxWidth(),
                    textStyle = TextStyle(color = Color.White),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedLabelColor = Color.White,
                        unfocusedLabelColor = Color.White,
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.White,
                        focusedBorderColor = Color.White,
                        unfocusedBorderColor = Color.White,
                        focusedPlaceholderColor = Color.White,
                    )
                )
                OutlinedTextField(
                    value = diagnosis,
                    onValueChange = { diagnosis = it },
                    label = { Text("Diagnosis") },
                    placeholder = { Text("Write diagnosis") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .padding(vertical = 4.dp),
                    shape = RoundedCornerShape(12.dp),
                    maxLines = 4,
                    singleLine = false,
                    textStyle = TextStyle(color = Color.White),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedLabelColor = Color.White,
                        unfocusedLabelColor = Color.White,
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.White,
                        focusedBorderColor = Color.White,
                        unfocusedBorderColor = Color.White,
                        focusedPlaceholderColor = Color.White,
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    OutlinedButton(
                        onClick = { navController.navigate(ROUTE_DASHBOARD) },
                        modifier = Modifier
                            .weight(1f),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
                    ) {
                        Text("GO BACK", color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Button(
                        onClick = {
                            patientViewModel.uploadPatient(
                                imageUri.value,
                                name,
                                gender,
                                nationality,
                                phoneNumber,
                                age,
                                diagnosis,
                                context
                            )
                        },
                        modifier = Modifier
                            .weight(1f),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                    ) {
                        Text("SAVE PATIENT", color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    }
                }
            }
        }
    }

}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AddPatientScreenPreview(){
    AddPatientScreen( rememberNavController())
}

//Column(
//modifier = Modifier
//.fillMaxSize()
//.padding(15.dp),
//horizontalAlignment = Alignment.CenterHorizontally
//) {
//    Text(
//        text = "ADD NEW PATIENT",
//        fontSize = 20.sp,
//        fontStyle = FontStyle.Normal,
//        fontWeight = FontWeight.Bold,
//        color = Color.Magenta,
//        textAlign = TextAlign.Center,
//        modifier = Modifier
//            .fillMaxWidth()
//    )
//    Card (
//        shape = CircleShape,
//        modifier = Modifier
//            .padding(10.dp)
//            .size(200.dp),
//    ){
//        AsyncImage(
//            model = imageUri.value ?: R.drawable.ic_person,
//            contentDescription = null,
//            contentScale = ContentScale.Crop,
//            modifier = Modifier
//                .size(200.dp)
//                .clickable { launcher.launch("image/*") }
//        )
//    }
//    Text(
//        text = "Upload Picture here"
//    )
//    OutlinedTextField(
//        value = name,
//        onValueChange = { name = it },
//        label = { Text("Enter Patient Name") },
//        placeholder = { Text("Please enter patient name") },
//        modifier = Modifier
//            .fillMaxWidth()
//    )
//    OutlinedTextField(
//        value = gender,
//        onValueChange = { gender = it },
//        label = { Text("Enter Patient Gender") },
//        placeholder = { Text("Please enter patient gender") },
//        modifier = Modifier
//            .fillMaxWidth()
//    )
//    OutlinedTextField(
//        value = nationality,
//        onValueChange = { nationality = it },
//        label = { Text("Enter Patient Nationality") },
//        placeholder = { Text("Please enter patient nationality") },
//        modifier = Modifier
//            .fillMaxWidth()
//    )
//    OutlinedTextField(
//        value = phoneNumber,
//        onValueChange = { phoneNumber = it },
//        label = { Text("Enter Patient Phone Number") },
//        placeholder = { Text("Please enter patient phone number") },
//        modifier = Modifier
//            .fillMaxWidth()
//    )
//    OutlinedTextField(
//        value = age,
//        onValueChange = { age = it },
//        label = { Text("Enter Patient Age") },
//        placeholder = { Text("Please enter patient age") },
//        modifier = Modifier
//            .fillMaxWidth()
//    )
//    OutlinedTextField(
//        value = diagnosis,
//        onValueChange = { diagnosis = it },
//        label = { Text("Diagnosis") },
//        placeholder = { Text("diagnosis") },
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(150.dp),
//        singleLine = false
//    )
//    Row (
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(20.dp),
//        horizontalArrangement = Arrangement.SpaceBetween
//    ){
//        Button(onClick = {}) { Text(text = "GO BACK") }
//        Button(onClick = {
//            patientViewModel.uploadPatient(imageUri.value,
//                name,
//                gender,
//                nationality,
//                phoneNumber,
//                age,
//                diagnosis,
//                context
//            )
//        }) { Text(text = "SAVE PATIENT") }
//    }
//
//}