package com.alfinaazizah0022.assessement2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.alfinaazizah0022.assessement2.navigation.SetupNavGraph
import com.alfinaazizah0022.assessement2.ui.theme.Assessement2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Assessement2Theme {
                SetupNavGraph()
            }
        }
    }
}

