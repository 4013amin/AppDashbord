package com.example.appdashbord

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appdashbord.ui.theme.AppDashbordTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppDashbordTheme {
                val navController = rememberNavController()
                IntroActivity(navController)
                nav()
            }
        }
    }
}


@Composable
fun IntroActivity(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.orange)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(id = R.drawable.top_1), contentDescription = null,
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.Start)
        )

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Welcome",
                fontSize = 50.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Text(
                text = "Welcome",
                modifier = Modifier.padding(15.dp),
                color = Color.White
            )

            Image(
                painter = painterResource(id = R.drawable.bottom_1), contentDescription = null,
                modifier = Modifier
                    .wrapContentSize()
                    .align(Alignment.Start)
            )
        }
    }

    LaunchedEffect(Unit) {
        delay(2000L)
        navController.navigate("B")
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppDashbordTheme {

    }
}