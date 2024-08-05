package com.aldyaz.wadirect.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.aldyaz.wadirect.ui.main.page.MainPage
import com.aldyaz.wadirect.ui.common.WADirectTheme
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