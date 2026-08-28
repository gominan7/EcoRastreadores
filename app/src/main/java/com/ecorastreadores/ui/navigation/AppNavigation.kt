package com.ecorastreadores.ui.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ecorastreadores.ui.screens.BitacoraScreen
import com.ecorastreadores.ui.screens.DashboardScreen
import com.ecorastreadores.ui.screens.LabScreen
import com.ecorastreadores.ui.screens.SplashScreen
import com.ecorastreadores.ui.viewmodel.EcoViewModel

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val viewModel: EcoViewModel = viewModel()
    
    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") {
            SplashScreen(onNavigateToDashboard = {
                navController.navigate("dashboard") {
                    popUpTo("splash") { inclusive = true }
                }
            })
        }
        composable("dashboard") {
            DashboardScreen(
                viewModel = viewModel,
                onNavigateToLab = { zoneId -> navController.navigate("lab/$zoneId") },
                onNavigateToBitacora = { navController.navigate("bitacora") }
            )
        }
        composable("lab/{zoneId}") { backStackEntry ->
            val zoneId = backStackEntry.arguments?.getString("zoneId") ?: ""
            LabScreen(
                zoneId = zoneId,
                viewModel = viewModel,
                onBack = { navController.popBackStack() }
            )
        }
        composable("bitacora") {
            BitacoraScreen(
                viewModel = viewModel,
                onBack = { navController.popBackStack() }
            )
        }
    }
}
