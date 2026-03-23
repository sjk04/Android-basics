package com.example.coilproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.coilproject.ui.screens.ImageFeedScreen
import com.example.coilproject.ui.theme.CoilProjectTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.coilproject.util.SampleDataProvider
import androidx.compose.foundation.Image


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val imageList=SampleDataProvider.getSampleImages()
        setContent {
            CoilProjectTheme {
                Box(modifier=Modifier.fillMaxSize().background(Color.LightGray)) {

                }
                ImageFeedScreen(items = imageList)
            }


        }

        }
    }

//@Composable
//fun image() {
//    Image(
//        painter = painterResource(id = R.drawable.alien_svgrepo_com),
//        contentDescription = "Alien Icon",
//        modifier = Modifier.background(Color.White)
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun imgpreview() {
//    image()
//}
