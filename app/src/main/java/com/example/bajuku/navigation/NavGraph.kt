package com.example.bajuku.navigation

import android.app.Notification
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.bajuku.ui.screen.Authantication.CongratulationsScreen
import com.example.bajuku.ui.screen.Authantication.LoginScreen
import com.example.bajuku.ui.screen.Authantication.RegisterScreen
import com.example.bajuku.ui.screen.Authantication.VerificationScreen
import com.example.bajuku.ui.screen.MianScreen.Bag.BagDetail
import com.example.bajuku.ui.screen.MianScreen.CheakOut.CheckOutScreen
import com.example.bajuku.ui.screen.MianScreen.CheakOut.OrderSuccessScreen
import com.example.bajuku.ui.screen.MianScreen.MainScreen_
import com.example.bajuku.ui.screen.MianScreen.Notification.NotificationScreen
import com.example.bajuku.ui.screen.MianScreen.Payment.PaymentScreen
import com.example.bajuku.ui.screen.MianScreen.Search.SearchContant
import com.example.bajuku.ui.screen.ProductDetial.ProductDetail
import com.example.bajuku.ui.screen.onboarding.Onboarding_3
import com.example.bajuku.ui.screen.onboarding.SelectionScreen
import com.example.bajuku.ui.screen.onboarding.StyleScreen
import com.example.bajuku.ui.screen.splash.SplashScreen
import com.example.bajuku.ui.screens.onboarding.OnboardingScreen


object Routes {
    const val SPLASH = "splash"

    // Onboarding
    const val ONBOARDING_INTRO = "onboarding_intro"
    const val SELECTION = "selection"
    const val INTERESTS = "interests"
    const val STYLE = "style"
    const val CONGRATULATIONS = "congratulations"

    // Auth
    const val LOGIN = "login"
    const val REGISTER = "register"
    const val VERIFICATION = "verification"

    // Main
    const val MAIN = "Main"
    const val SEARCH = "Search"
    const val PRODUCT_DETAIL = "product_detail"
    const val BAG = "bag"
    const val CHECKOUT = "check_out"
    const val ORDER_SUCCESS = "order_success"
    const val PAYMENT = "payment"
    const val NOTIFICATION = "notification"


}

@Composable
fun AppNavGraph(navController: NavHostController) {

    NavHost(
        navController = navController, startDestination = Routes.SPLASH
    ) {

        splashGraph(navController)
        onboardingGraph(navController)
        authGraph(navController)
        mainGraph(navController)
    }
}

fun NavGraphBuilder.splashGraph(navController: NavHostController) {
    composable(Routes.SPLASH) {
        SplashScreen(
            onFinish = {
                navController.navigate(Routes.ONBOARDING_INTRO) {
                    popUpTo(Routes.SPLASH) { inclusive = true }
                }
            })
    }
}

fun NavGraphBuilder.onboardingGraph(navController: NavHostController) {

    composable(Routes.ONBOARDING_INTRO) {
        OnboardingScreen(
            onFinished = {
                navController.navigate(Routes.SELECTION)
            })
    }
    composable(Routes.SELECTION) {
        SelectionScreen(navController)
    }
    composable(Routes.INTERESTS) {
        Onboarding_3(navController)
    }
    composable(Routes.STYLE) {
        StyleScreen(navController)
    }
    composable(Routes.CONGRATULATIONS) {
        CongratulationsScreen(
            navController = navController
        )
    }
}

fun NavGraphBuilder.authGraph(navController: NavHostController) {

    composable(Routes.LOGIN) {
        LoginScreen(navController)
    }

    composable(Routes.REGISTER) {
        RegisterScreen(navController)
    }

    composable(Routes.VERIFICATION) {
        VerificationScreen(navController)
    }
}


fun NavGraphBuilder.mainGraph(navController: NavHostController) {

    composable(
        Routes.MAIN
    ) {
        MainScreen_(navController)
    }
    composable(Routes.SEARCH) {
        SearchContant()
    }
    composable(
        route = "${Routes.PRODUCT_DETAIL}/{productId}",
        arguments = listOf(
            navArgument("productId") { type = NavType.StringType }
        )
    ) { backStackEntry ->
        val productId = backStackEntry.arguments?.getString("productId") ?: ""

        ProductDetail(
            productId = productId,
            onBack = { navController.popBackStack() },
            onBuy = { navController.navigate(Routes.CHECKOUT) },
            navegateToBag = { navController.navigate(Routes.BAG) }
        )
    }
    composable(Routes.BAG) {
        BagDetail(
            onBack = { navController.popBackStack() },
            onNext = { navController.navigate(Routes.CHECKOUT) })
    }
    composable(Routes.CHECKOUT) {
        CheckOutScreen(
            onclick = { navController.navigate(Routes.PAYMENT) },
            onBack = { navController.popBackStack() },
            onsucses = { navController.navigate(Routes.ORDER_SUCCESS) })
    }
    composable(Routes.ORDER_SUCCESS) {
        OrderSuccessScreen(onBack = { navController.navigate(Routes.MAIN) })
    }
    composable(Routes.PAYMENT) {
        PaymentScreen(
            onConfrom = { navController.navigate(Routes.CHECKOUT) },
            onBack = { navController.popBackStack() }
        )
    }
    composable(Routes.NOTIFICATION) {
        NotificationScreen()
    }

}



