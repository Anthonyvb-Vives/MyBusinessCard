package com.example.mybusinesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mybusinesscard.ui.theme.MyBusinessCardTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyBusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun ShowCenter(name: String, title: String, modifier: Modifier = Modifier) {
    Column(

    ) {
        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .height(100.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
        Text(
            text = name,
            fontSize = 36.sp,
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
        )
        Text(
            text = title,
            fontSize = 30.sp,
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun ShowDetails(phone: String, social: String, email: String, modifier: Modifier = Modifier) {
    Column(

    ) {
        Row(
        ){
          Icon(
              painter = painterResource(id = R.drawable.baseline_contact_phone_24),
              contentDescription = null,
              )
          Text(
              text = phone,
              modifier = Modifier.padding(start = 10.dp)
          )
        }
        Row(){
            Icon(
                painter = painterResource(id = R.drawable.baseline_tag_faces_24),
                contentDescription = null
            )
            Text(
                text = social,
                modifier = Modifier.padding(start = 10.dp)
            )
        }
        Row() {
            Icon(
                painter = painterResource(id = R.drawable.baseline_email_24),
                contentDescription = null
            )
            Text(
                text = email,
                modifier = Modifier.padding(start = 10.dp)
            )
        }

    }
}

@Composable
fun ShowScreen(name: String, title: String, phone: String, social: String, email: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .padding(30.dp)
        ){
            ShowCenter(name = name, title = title)
        }
        Row(

        ) {
            ShowDetails(phone = phone, social = social, email = email)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyBusinessCardTheme {
        ShowScreen("Anthony Van Buyten", title = "Operations Manager", phone = "0000/000000", social = "@social", email = "android@email")
    }
}
