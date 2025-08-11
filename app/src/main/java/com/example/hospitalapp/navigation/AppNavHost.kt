package com.example.hospitalapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.hospitalapp.ui.theme.screens.dashboard.DashboardScreen
import com.example.hospitalapp.ui.theme.screens.login.LoginScreen
import com.example.hospitalapp.ui.theme.screens.patients.AddPatientScreen
import com.example.hospitalapp.ui.theme.screens.patients.PatientListScreen
import com.example.hospitalapp.ui.theme.screens.patients.UpdatePatientScreen
import com.example.hospitalapp.ui.theme.screens.register.RegisterScreen

@Composable
fun AppNavHost(navController: NavHostController = rememberNavController(), startDestination: String = ROUTE_DASHBOARD){
    NavHost(navController = navController, startDestination = startDestination){
        composable (ROUTE_REGISTER){
            RegisterScreen(navController)
        }
        composable(ROUTE_LOGIN) {
            LoginScreen(navController)
        }
        composable(ROUTE_DASHBOARD) {
            DashboardScreen(navController)
        }
        composable(ROUTE_ADD_PATIENT) {
            AddPatientScreen(navController)
        }
        composable (ROUTE_VIEW_PATIENT){
            PatientListScreen(navController)
        }
        composable (ROUTE_UPDATE_PATIENT, arguments = listOf(navArgument("patientId"){type = NavType.StringType})){
            backStackEntry ->
            val patientId = backStackEntry.arguments?.getString("patientId")!!
            UpdatePatientScreen(navController, patientId)
        }
    }
}