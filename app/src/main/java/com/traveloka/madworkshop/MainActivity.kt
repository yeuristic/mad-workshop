package com.traveloka.madworkshop

import android.content.Context
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
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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
            scope.launch(Dispatchers.Default) {
                val start = System.currentTimeMillis()
                val nameDeferred = async { generateName() }
                val fibDeferred = async { calculateFibonacci() }
                val name = nameDeferred.await()
                val fib = fibDeferred.await()
                val end = System.currentTimeMillis()
                withContext(Dispatchers.Main) {
                    showMessage(context, "$name $fib", end - start)
                }
            }
        }) {
            Text(text = "Start")
        }
    }
}

private fun showMessage(context: Context, message: String, duration: Long) {
    Toast.makeText(
        context,
        "Toast $message after $duration ms",
        Toast.LENGTH_SHORT
    ).show()
}

suspend fun generateName(): String {
    delay(3000)
    return "Android"
}

suspend fun calculateFibonacci(): Int = badFibonacci(40)

