import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.bajuku.ui.screen.MianScreen.MainScreen
import com.example.bajuku.ui.screen.onboarding.CongratulationsScreen
import com.example.bajuku.ui.screen.onboarding.LoginScreen
import com.example.bajuku.ui.screen.onboarding.Onboarding_3
import com.example.bajuku.ui.screen.onboarding.RegisterScreen
import com.example.bajuku.ui.screen.onboarding.SelectionScreen
import com.example.bajuku.ui.screen.onboarding.StyleScreen
import com.example.bajuku.ui.screen.onboarding.VerificationScreen
import com.example.bajuku.ui.screen.splash.SplashScreen
import com.example.bajuku.ui.screens.onboarding.OnboardingScreen

@Composable
fun AppNavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = "splash"
    ) {

        // 1. Splash (removed permanently)
        composable("splash") {
            SplashScreen(
                onFinish = {
                    navController.navigate("onboarding_intro") {
                        popUpTo("splash") { inclusive = true }
                    }
                }
            )
        }

        // 2. Onboarding Intro (kept in back stack)
        composable("onboarding_intro") {
            OnboardingScreen(
                onFinished = {
                    navController.navigate("selection")
                }
            )
        }

        // 3. Onboarding steps
        composable("selection") {
            SelectionScreen(navController)
        }

        composable("interests") {
            Onboarding_3(navController)
        }

        composable("style") {
            StyleScreen(navController)
        }

        // 4. Authentication
        composable("login") {
            LoginScreen(navController)
        }

        composable("register") {
            RegisterScreen(navController)
        }

        composable("verification") {
            VerificationScreen(navController)
        }

        // 5. Final onboarding screen
        composable("congratulations") {
            CongratulationsScreen(navController)
        }

        // 6. Home (final destination)
        composable("home") {
            MainScreen(navController)
        }
    }
}
