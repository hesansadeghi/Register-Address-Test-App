package com.example.registeraddresstestapp.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.registeraddresstestapp.utils.Utils
import com.example.registeraddresstestapp.viewmodels.RegisterViewModel


@Composable
fun MainScreen(registerViewModel: RegisterViewModel= hiltViewModel()) {

    val navController = rememberNavController()

    NavHost(
        modifier = Modifier.fillMaxSize(),
        startDestination = Utils.REGISTER,
        navController = navController
    ) {

        composable(Utils.REGISTER) {

            RegisterScreen(navController,registerViewModel)
        }

        composable(Utils.MAP_VIEW) {


            NeshanMapView(navController,registerViewModel)
        }



        composable(Utils.ADDRESS_LIST) {

            AddressListScreen(registerViewModel)
        }


    }

}