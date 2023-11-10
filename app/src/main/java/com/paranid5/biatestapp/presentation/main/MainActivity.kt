package com.paranid5.biatestapp.presentation.main

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.paranid5.biatestapp.data.retrofit.Employee
import com.paranid5.biatestapp.presentation.ui.theme.BIATestAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    companion object {
        const val USER_KEY = "user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val employee = when {
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU ->
                intent.getParcelableExtra(USER_KEY, Employee::class.java)

            else -> intent.getParcelableExtra(USER_KEY)
        } ?: throw IllegalStateException("User was not passed to the MainActivity")

        setContent {
            val navController = rememberNavController()

            BIATestAppTheme {
                CompositionLocalProvider(
                    LocalMainActivity provides this,
                    LocalMainNavController provides MainNavController(navController),
                    LocalEmployee provides employee
                ) {
                    MainScreen(Modifier.fillMaxSize())
                }
            }
        }
    }
}