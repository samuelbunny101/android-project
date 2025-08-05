package com.example.hospitalapp.ui.theme.screens.patients

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.hospitalapp.data.PatientViewModel
import com.example.hospitalapp.models.Patient


@Composable
fun PatientListScreen (navController: NavController){
    val context = LocalContext.current
    val patientViewModel: PatientViewModel = viewModel()
    val patients = patientViewModel.patients
    LaunchedEffect(Unit){
        patientViewModel.fetchPatients(context)
    }
    LazyColumn{
        items(patients){
            patient ->
            PatientDetailsCard(patient)
        }
    }
}
@Composable
fun PatientDetailsCard (patient: Patient){
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ){
        Row (
            modifier = Modifier
                .padding(8.dp)
        ){
            patient.imageUrl?.let{
                imageUrl ->
                AsyncImage(
                    model = imageUrl,
                    contentDescription = "Patient Image",
                    modifier = Modifier
                        .padding(end = 8.dp),
                    contentScale = ContentScale.Crop
                )
            }
            Column (){
                Text(text = "Name: ${patient.name}")
                Text(text = "Age: ${patient.age}")
                Text(text = "Gender: ${patient.gender}")
                Text(text = "Nationality: ${patient.nationality}")
                Text(text = "Diagnosis: ${patient.diagnosis}")
            }
        }
    }
}