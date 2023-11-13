package com.traveloka.madworkshop

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.traveloka.madworkshop.ui.theme.MadWorkshopTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MadWorkshopTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Widget()
                }
            }

        }
    }
}

@Composable
fun Widget() {
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.size(32.dp))
        Button(onClick = {
            scope.launch {
                val start = System.currentTimeMillis()
                val name = generateName()
                val end = System.currentTimeMillis()
                Toast.makeText(
                    context,
                    "Toast $name after ${end - start} ms",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }) {
            Text(text = "3 seconds Button")
        }
    }
}

suspend fun generateName(): String {
    delay(3000)
    return "Android"
}

