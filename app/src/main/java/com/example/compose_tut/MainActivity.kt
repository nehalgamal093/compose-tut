package com.example.compose_tut

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen()

        }
    }


}





