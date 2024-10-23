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
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
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
                LoginScreen()
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
}


@Composable
fun LoginScreen() {
    val scroller = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .verticalScroll(scroller)
    ) {
        Image(
            painter = painterResource(id = R.drawable.top_2), contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop
        )

        Text(
            text = "UiLove", fontSize = 50.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.orange),
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Text(
            text = "start tour Activity with us",
            fontSize = 14.sp,
            modifier = Modifier
                .padding(32.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Text(
            text = "please login", fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(32.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        OutlinedTextField(
            value = "", onValueChange = {},
            label = { Text(text = "Email") },
            modifier = Modifier
                .padding(16.dp, vertical = 12.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email) // تغییر به camelCase
        )

        OutlinedTextField(
            value = "", onValueChange = {},
            label = { Text(text = "Password") },
            modifier = Modifier
                .padding(16.dp, vertical = 12.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )


        Text(
            text = "Dont remember password? recovery for it ",
            fontSize = 14.sp,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp, vertical = 32.dp)
        ) {
            Divider(modifier = Modifier.weight(1f), color = Color.Gray)

            Text(
                text = "or login with",
                fontSize = 16.sp,
                modifier = Modifier.padding(horizontal = 24.dp),

                )

            Divider(modifier = Modifier.weight(1f), color = Color.Gray)

        }

        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp, vertical = 32.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.blue))
        ) {
            Text(
                text = "Login",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }

        Text(
            text = "Dont have acount ",
            fontSize = 14.sp,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )

    }
}

@Composable
fun MyDashboard(){
    Column(
        modifier = Modifier
           .fillMaxSize()
           .background(color = Color.White)
    ) {
        Text(text = "My Dashboard", fontSize = 24.sp, modifier = Modifier.padding(16.dp))
        Divider(color = Color.Black, thickness = 1.dp)
        // Your dashboard components here
    }
}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppDashbordTheme {

    }
}