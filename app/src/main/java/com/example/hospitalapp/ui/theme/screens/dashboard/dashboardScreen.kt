package com.example.hospitalapp.ui.theme.screens.dashboard



import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hospitalapp.R
import com.example.hospitalapp.navigation.ROUTE_ADD_PATIENT
import com.example.hospitalapp.navigation.ROUTE_VIEW_PATIENT


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(navController: NavController) {
    val selectedItem = remember { mutableStateOf(0) }

    val cardModifier = Modifier
        .padding(10.dp)
        .width(140.dp)
        .height(140.dp)
        .clickable {}

    val cardTextStyle = TextStyle(
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Italic,
        color = Color.Blue,
        textAlign = TextAlign.Center
    )

    Scaffold(
        bottomBar = {
            NavigationBar(containerColor = Color.LightGray) {
                NavigationBarItem(
                    selected = selectedItem.value == 1,
                    onClick = { selectedItem.value = 1 },
                    icon = { Icon(Icons.Filled.Share, contentDescription = "Share") },
                    label = { Text("Share") },
                    alwaysShowLabel = true
                )
                NavigationBarItem(
                    selected = selectedItem.value == 0,
                    onClick = { selectedItem.value = 0 },
                    icon = { Icon(Icons.Filled.Home, contentDescription = "Home") },
                    label = { Text("Home") },
                    alwaysShowLabel = true
                )
                NavigationBarItem(
                    selected = selectedItem.value == 2,
                    onClick = { selectedItem.value = 2 },
                    icon = { Icon(Icons.Filled.Email, contentDescription = "Email") },
                    label = { Text("Email") },
                    alwaysShowLabel = true
                )
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.lion),
                contentDescription = "Background image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.3f))
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(horizontal = 16.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TopAppBar(
                    title = { Text("Hospital") },
                    navigationIcon = {
                        IconButton(onClick = {}) {
                            Icon(Icons.Filled.Menu, contentDescription = "Menu")
                        }
                    },
                    actions = {
                        IconButton(onClick = {}) {
                            Icon(Icons.Filled.Search, contentDescription = "Search")
                        }
                        IconButton(onClick = {}) {
                            Icon(Icons.Filled.Person, contentDescription = "Profile")
                        }
                        IconButton(onClick = {}) {
                            Icon(Icons.Filled.AccountCircle, contentDescription = "Logout")
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.Transparent,
                        titleContentColor = Color.White,
                        navigationIconContentColor = Color.White,
                        actionIconContentColor = Color.White
                    )
                )

                Spacer(modifier = Modifier.height(24.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    DashboardCard(
                        title = "Add Patient",
                        route = ROUTE_ADD_PATIENT,
                        navController = navController,
                        modifier = cardModifier,
                        textStyle = cardTextStyle
                    )
                    DashboardCard(
                        title = "View Patient",
                        route = ROUTE_VIEW_PATIENT,
                        navController = navController,
                        modifier = cardModifier,
                        textStyle = cardTextStyle
                    )
                }

                Spacer(modifier = Modifier.height(80.dp))
            }
        }
    }
}
@Composable
fun DashboardCard(
    title: String,
    route: String,
    navController: NavController,
    modifier: Modifier,
    textStyle: TextStyle,
    iconContent: @Composable () -> Unit = {}
) {
    Card(
        modifier = modifier.clickable { navController.navigate(route) },
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(1.dp),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Row (
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = title, style = textStyle)
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DashboardScreenPreview(){
    DashboardScreen(rememberNavController())
}



//Scaffold(
//bottomBar = {
//    NavigationBar (containerColor = Color.Transparent){
//        NavigationBarItem(
//            selected = selectedItem.value == 0,
//            onClick = { },
//            icon = {Icon(Icons.Filled.Share, contentDescription = "Share")},
//            label = {Text(text = "Share")},
//            alwaysShowLabel = true
//        )
//        NavigationBarItem(
//            selected = selectedItem.value == 1,
//            onClick = { },
//            icon = {Icon(Icons.Filled.Home, contentDescription = "Home")},
//            label = {Text(text = "Home")},
//            alwaysShowLabel = true
//        )
//        NavigationBarItem(
//            selected = selectedItem.value == 2,
//            onClick = { },
//            icon = {Icon(Icons.Filled.Email, contentDescription = "Email")},
//            label = {Text(text = "Email")},
//            alwaysShowLabel = true
//        )
//    }
//}
//) {
//    innerPadding ->
//    Box(
//        modifier = Modifier
//            .padding(innerPadding)
//    ){
//        Image(
//            painter = painterResource(id = R.drawable.lion),
//            contentDescription = "Background image",
//            contentScale = ContentScale.FillBounds,
//        )
//    }
//    Column (
//        modifier = Modifier
//            .fillMaxSize(),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ){
//        TopAppBar(
//            title = { Text(text = "Equity Bank") },
//            navigationIcon = {
//                IconButton(onClick = {}) {
//                    Icon(Icons.Filled.Menu, contentDescription = "Menu")
//                }
//            },
//            actions = {
//                IconButton(onClick = {}) {
//                    Icon(Icons.Filled.Search, contentDescription = "Search")
//                }
//                IconButton(onClick = {}) {
//                    Icon(Icons.Filled.Person, contentDescription = "Person")
//                }
//                IconButton(onClick = {}){
//                    Icon(Icons.Filled.AccountCircle, contentDescription = "Logout")
//                }
//            },
//            colors = TopAppBarDefaults.topAppBarColors(
//                containerColor = Color.DarkGray,
//                titleContentColor = Color.White,
//                navigationIconContentColor = Color.White,
//                actionIconContentColor = Color.White
//            )
//        )
//        Row (modifier = Modifier.wrapContentWidth()){
//            Card (
//                modifier = Modifier
//                    .padding(10.dp)
//                    .clickable{ navController.navigate(ROUTE_ADD_PATIENT) },
//                shape = RoundedCornerShape(20.dp),
//                elevation = CardDefaults.cardElevation(10.dp),
//                colors = CardDefaults.cardColors(Color.White)
//            ){
//                Box(modifier = Modifier.height(100.dp).padding(20.dp), contentAlignment = Alignment.Center){
//                    Text(
//                        text = "Add Patient",
//                        fontSize = 20.sp,
//                        fontFamily = FontFamily.SansSerif,
//                        fontStyle = FontStyle.Italic,
//                        color = Color.Magenta,
//                        textAlign = TextAlign.Center
//
//                    )
//                }
//            }
//
//            Spacer(
//                modifier = Modifier
//                    .width(25.dp)
//            )
//
//            Card (
//                modifier = Modifier
//                    .padding(10.dp)
//                    .clickable{navController.navigate(ROUTE_VIEW_PATIENT)},
//                shape = RoundedCornerShape(20.dp),
//                elevation = CardDefaults.cardElevation(10.dp),
//                colors = CardDefaults.cardColors(Color.White)
//            ){
//                Box(modifier = Modifier.height(100.dp).padding(20.dp), contentAlignment = Alignment.Center){
//                    Text(
//                        text = "View Patient",
//                        fontSize = 20.sp,
//                        fontFamily = FontFamily.SansSerif,
//                        fontStyle = FontStyle.Italic,
//                        color = Color.Magenta,
//                        textAlign = TextAlign.Center
//                    )
//                }
//            }
//        }
//        Row (modifier = Modifier.wrapContentWidth()){
//            Card (
//                modifier = Modifier
//                    .padding(10.dp)
//                    .clickable{navController.navigate(ROUTE_ADD_PATIENT)},
//                shape = RoundedCornerShape(20.dp),
//                elevation = CardDefaults.cardElevation(10.dp),
//                colors = CardDefaults.cardColors(Color.White)
//            ){
//                Box(modifier = Modifier.height(100.dp).padding(20.dp), contentAlignment = Alignment.Center){
//                    Text(
//                        text = "add doctor",
//                        fontSize = 20.sp,
//                        fontFamily = FontFamily.SansSerif,
//                        fontStyle = FontStyle.Italic,
//                        color = Color.Magenta,
//                        textAlign = TextAlign.Center
//
//                    )
//                }
//            }
//
//            Spacer(
//                modifier = Modifier
//                    .width(25.dp)
//            )
//
//            Card (
//                modifier = Modifier
//                    .padding(10.dp)
//                    .clickable{navController.navigate(ROUTE_ADD_PATIENT)},
//                shape = RoundedCornerShape(20.dp),
//                elevation = CardDefaults.cardElevation(10.dp),
//                colors = CardDefaults.cardColors(Color.White)
//            ){
//                Box(modifier = Modifier.height(100.dp).padding(20.dp), contentAlignment = Alignment.Center){
//                    Text(
//                        text = "view doctor",
//                        fontSize = 20.sp,
//                        fontFamily = FontFamily.SansSerif,
//                        fontStyle = FontStyle.Italic,
//                        color = Color.Magenta,
//                        textAlign = TextAlign.Center
//                    )
//                }
//            }
//        }
//    }
//}
