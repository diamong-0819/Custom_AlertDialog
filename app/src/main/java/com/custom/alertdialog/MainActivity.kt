package com.custom.alertdialog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.custom.alertdialog.ui.theme.Custom_AlertDialogTheme
import com.custom.alertdialog.ui.theme.Purple40

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Custom_AlertDialogTheme {

                CallAlertDialog()

            }
        }
    }
}

@Composable
fun CallAlertDialog(){
    val isDialogOpen = remember{mutableStateOf(false)}

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ){
        ShowAlertDialog(isDialogOpen)
        Button(
            onClick = {
                isDialogOpen.value = true

            },
            modifier = Modifier.padding(10.dp).fillMaxSize(0.5f).height(50.dp),
            shape = RoundedCornerShape(5.dp),
            colors = ButtonDefaults.buttonColors(Purple40)
        ) {
            Text(
                text = "Show Alert Dialog",
                color = Color.White,
                //modifier = Modifier.padding(5.dp).background(Purple40)
            )
        }//Button
    }//Column
}

@Preview(showBackground = true)
@Composable
fun CallAlertDialogPreview() {
    Custom_AlertDialogTheme {
        CallAlertDialog()
    }
}