package com.example.splashapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.splashapi.ui.theme.SplashAPITheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen() //스플래쉬 스크린 초기화
        super.onCreate(savedInstanceState)

        splashScreen.setKeepOnScreenCondition { true } //스플래쉬 스크린을 계속해서 보여줄 것인지 설정

        setContent {
            SplashAPITheme {
                NavHost(
                    navController = rememberNavController(),
                    startDestination = "screenA"
                ) {
                    composable("screenA") {
                        ScreenA()
                    }
                    composable("screenB") {
                        ScreenB()
                    }
                }
            }
        }
    }
}

@Composable
fun ScreenA() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Screen A")
    }
}

@Composable
fun ScreenB() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Screen B")
    }
}