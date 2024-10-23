package com.example.appdashbord

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
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
                MyDashboard()
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
fun MyDashboard() {
    val Scroller = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .verticalScroll(Scroller)
    ) {
        Spacer(modifier = Modifier.height(24.dp))
        profileCard()
        Spacer(modifier = Modifier.height(24.dp))
        Banner()
        OptionTable()
    }
}

@Composable
fun profileCard() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .height(292.dp)
            .background(Color.LightGray)
    ) {
        // ایجاد مراجع (references) برای عناصر داخلی
        val (boxGrey, image, morning, name, favBtn, profileBtn) = createRefs()

        // Box خاکستری
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(boxGrey) {
                    top.linkTo(parent.top) // لینک به بالای والد
                    start.linkTo(parent.start) // لینک به چپ والد
                    end.linkTo(parent.end) // لینک به راست والد
                }
                .height(260.dp)
                .padding(horizontal = 16.dp)
                .background(colorResource(id = R.color.grey), shape = RoundedCornerShape(25.dp))
        )
        //Text
        Text(
            text = "Good Morning",
            style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp)
                .constrainAs(morning) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                }, textAlign = TextAlign.Center

        )

        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(start = 32.dp)
                .width(133.dp)
                .height(185.dp)
                .clip(RoundedCornerShape(25.dp))
                .constrainAs(image) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(boxGrey.start)
                }
        )

        Text(
            text = "Sara\n Anderson",
            style = TextStyle(
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier
                .padding(start = 16.dp)
                .constrainAs(name) {
                    start.linkTo(image.end)
                    top.linkTo(image.top)
                }, textAlign = TextAlign.Start
        )

        Image(
            painter = painterResource(id = R.drawable.profile_btn),
            contentDescription = null,
            modifier = Modifier
                .padding(end = 48.dp)
                .constrainAs(profileBtn) {
                    top.linkTo(boxGrey.bottom)
                    end.linkTo(boxGrey.end)
                    bottom.linkTo(boxGrey.bottom)
                }
        )

        Image(painter = painterResource(id = R.drawable.fav), contentDescription = null,
            modifier = Modifier.constrainAs(favBtn) {
                end.linkTo(profileBtn.start)
                top.linkTo(boxGrey.bottom)
                bottom.linkTo(boxGrey.bottom)
                start.linkTo(image.end)
            })
    }
}

@Composable
fun Banner() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(146.dp)
            .padding(16.dp)
            .background(
                colorResource(id = R.color.yellow),
                shape = RoundedCornerShape(20.dp)
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(text = "Discover", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "New Arrivals", fontSize = 16.sp)

                Text(
                    text = "30%", style = TextStyle(
                        color = colorResource(id = R.color.blue),
                        fontSize = 34.sp,
                        fontWeight = FontWeight.Bold
                    )
                )

            }

            Spacer(modifier = Modifier.weight(1f))

            Image(
                painter = painterResource(id = R.drawable.logo_banner),
                contentDescription = null,
                modifier = Modifier.size(100.dp)
            )

        }
    }

}


@Composable
fun OptionTable() {
    Column {
        TableRow(
            icons = listOf(
                R.drawable.ic_1 to "Index",
                R.drawable.ic_2 to "Maps",
                R.drawable.ic_3 to "chat",
            )
        )

        TableRow(
            icons = listOf(
                R.drawable.ic_4 to "Report",
                R.drawable.ic_5 to "Calendar",
                R.drawable.ic_6 to "Tips",
            )
        )

        TableRow(
            icons = listOf(
                R.drawable.ic_7 to "Settings",
                R.drawable.ic_8 to "Share",
                R.drawable.ic_9 to "More",
            )
        )
    }
}

@Composable
fun TableRow(icons: List<Pair<Int, String>>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        icons.forEach { icons ->
            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(vertical = 4.dp, horizontal = 8.dp)
                    .background(color = Color.White, shape = RoundedCornerShape(25.dp))
                    .height(100.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(icons.first),
                        contentDescription = null,
                        modifier = Modifier.size(40.dp)
                    )

                    Text(
                        text = icons.second,
                        modifier = Modifier.padding(top = 8.dp),
                        style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppDashbordTheme {
        MyDashboard()
    }
}