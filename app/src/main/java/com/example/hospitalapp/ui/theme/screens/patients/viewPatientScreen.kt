package com.example.hospitalapp.ui.theme.screens.patients


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
        items(patients){ patient ->
            PatientDetailsCard(
                patient = patient,
                onDelete = {
                    patientId ->
                    patientViewModel.deletePatient(patientId, context)
                },
                navController = navController
            )
        }
    }
}
@Composable
fun PatientDetailsCard (patient: Patient, onDelete: (String) -> Unit, navController: NavController){
    var showDialog by remember { mutableStateOf(false) }
    if (showDialog){
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text("Delete Patient") },
            text = { Text("Are you sure you want to delete this patient?") },
            confirmButton = {
                TextButton(
                    onClick = {
                        showDialog = false
                        patient.id?.let { onDelete(it) }
                    }
                ){
                    Text("YES", color = Color.Red)
                }
            },
            dismissButton = {
                TextButton(
                    onClick = { showDialog = false }
                ){
                    Text("Cancel")
                }
            }
        )
    }

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
                Text(text = "Gender: ${patient.gender}")
                Text(text = "Nationality: ${patient.nationality}")
                Text(text = "Diagnosis: ${patient.diagnosis}")
                Text(text = "Next of Kin: ${patient.nextOfKin}")
            }
        }


        Spacer(modifier = Modifier.height(10.dp))

        Row (horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth()){
            TextButton(
                onClick = { navController.navigate("updatePatient/${patient.id}") }
            ) { Text("Update", color = Color.Blue) }
            TextButton(
                onClick = { showDialog = true }
            ) { Text("Delete", color = Color.Red) }
        }
    }
}