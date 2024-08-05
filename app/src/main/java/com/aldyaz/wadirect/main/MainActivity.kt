package com.aldyaz.wadirect.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.aldyaz.wadirect.main.page.MainPage
import com.aldyaz.wadirect.ui.WADirectTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            WADirectTheme {
                MainPage()
            }
        }
    }

}