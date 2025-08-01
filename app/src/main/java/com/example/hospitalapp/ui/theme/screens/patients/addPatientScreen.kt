package com.example.hospitalapp.ui.theme.screens.patients

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
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

@Composable
fun AddPatientScreen(navController:NavController) {
    var name by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    var nationality by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var diagnosis by remember { mutableStateOf("") }
    val imageUri = rememberSaveable { mutableStateOf<Uri?>(null) }
    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()){
        uri: Uri? ->
        uri?.let {
            imageUri.value = it
        }
    }
    val patientViewModel: PatientViewModel = viewModel()
    val context = LocalContext.current


    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "ADD NEW PATIENT",
            fontSize = 20.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Bold,
            color = Color.Magenta,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
        )
        Card (
            shape = CircleShape,
            modifier = Modifier
                .padding(10.dp)
                .size(200.dp),
        ){
            AsyncImage(
                model = imageUri.value ?: R.drawable.ic_person,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(200.dp)
                    .clickable { launcher.launch("image/*") }
            )
        }
        Text(
            text = "Upload Picture here"
        )
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Enter Patient Name") },
            placeholder = { Text("Please enter patient name") },
            modifier = Modifier
                .fillMaxWidth()
        )
        OutlinedTextField(
            value = gender,
            onValueChange = { gender = it },
            label = { Text("Enter Patient Gender") },
            placeholder = { Text("Please enter patient gender") },
            modifier = Modifier
                .fillMaxWidth()
        )
        OutlinedTextField(
            value = nationality,
            onValueChange = { nationality = it },
            label = { Text("Enter Patient Nationality") },
            placeholder = { Text("Please enter patient nationality") },
            modifier = Modifier
                .fillMaxWidth()
        )
        OutlinedTextField(
            value = phoneNumber,
            onValueChange = { phoneNumber = it },
            label = { Text("Enter Patient Phone Number") },
            placeholder = { Text("Please enter patient phone number") },
            modifier = Modifier
                .fillMaxWidth()
        )
        OutlinedTextField(
            value = age,
            onValueChange = { age = it },
            label = { Text("Enter Patient Age") },
            placeholder = { Text("Please enter patient age") },
            modifier = Modifier
                .fillMaxWidth()
        )
        OutlinedTextField(
            value = diagnosis,
            onValueChange = { diagnosis = it },
            label = { Text("Diagnosis") },
            placeholder = { Text("diagnosis") },
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            singleLine = false
        )
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Button(onClick = {}) { Text(text = "GO BACK") }
            Button(onClick = {
                patientViewModel.uploadPatient(imageUri.value,
                    name,
                    gender,
                    nationality,
                    phoneNumber,
                    age,
                    diagnosis,
                    context
                )
            }) { Text(text = "SAVE PATIENT") }
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AddPatientScreenPreview(){
    AddPatientScreen( rememberNavController())
}