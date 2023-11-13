package com.traveloka.madworkshop

import android.os.Bundle
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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.traveloka.madworkshop.ui.theme.MadWorkshopTheme
import com.traveloka.madworkshop.user.User

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
                    MainWidget()
                }
            }

        }
    }
}

@Composable
fun MainWidget() {
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val vm: MainViewModel = viewModel()
    MainLayout(state = vm.state) {
        vm.fetch()
    }
}

@Composable
fun MainLayout(state: MainState, fetch: () -> Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        UserLayout(user = state.user.value)
        Spacer(modifier = Modifier.size(32.dp))
        Button(onClick = {
            fetch()
        }) {
            Text(text = "Fetch")
        }
    }
}

@Composable
fun UserLayout(user: User?) {
    if (user != null) {
        Column {
            Text(text = "Gender: ${user.gender}")
            Text(text = "Name: ${user.fullName()}")
            Text(text = "Email: ${user.email}")
            Text(text = "Phone: ${user.phone}")
        }
    }
}
