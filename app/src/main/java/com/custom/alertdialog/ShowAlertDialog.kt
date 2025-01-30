package com.custom.alertdialog

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.custom.alertdialog.ui.theme.Purple40


@Composable
fun ShowAlertDialog(isDialogOpen: MutableState<Boolean>) {
    val emailVal = remember { mutableStateOf("") }
    val passwordlVal = remember { mutableStateOf("") }

    val passwordVisibility = remember { mutableStateOf(false) }
    //val focusRequester = remember { FocusRequester() }

    if(isDialogOpen.value){
        Dialog(onDismissRequest = {isDialogOpen.value = false}) {
            Surface(
                modifier = Modifier
                    .width(300.dp)
                    .height(420.dp)
                    .padding(5.dp),
                shape = RoundedCornerShape(5.dp),
                color = Color.White
            ) {
                Column (modifier = Modifier.padding(5.dp)
                    .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center){
                    Spacer(modifier = Modifier.padding(10.dp))
                    Text(
                        text = "Login Here",
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp
                    )
                    Spacer(modifier = Modifier.padding(10.dp))
                    Image(
                        painter = painterResource(id = R.drawable.baseline_person_pin_24),
                        contentDescription = "Login Image",
                        modifier = Modifier
                            .width(120.dp)
                            .height(60.dp)

                    )
                    Spacer(modifier = Modifier.padding(10.dp))

                    OutlinedTextField(
                        value = emailVal.value ,
                        onValueChange = {emailVal.value = it},
                        label = {Text(text = "email address")},
                        placeholder = {Text(text = "Email adress")},
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.8f)

                    )
                    Spacer(modifier = Modifier.padding(10.dp))
                    OutlinedTextField(
                        value = passwordlVal.value,
                        onValueChange = {passwordlVal.value = it},
                        trailingIcon = {

                            IconButton(
                                onClick = {
                                    passwordVisibility.value = !passwordVisibility.value
                                }  //onClick
                            ){

                                Icon(
                                    painter = painterResource(id = R.drawable.baseline_remove_red_eye_24),
                                    contentDescription = "Password Visibility",
                                    tint = if(passwordVisibility.value) Purple40 else Color.Gray
                                )



                            }   //IconButton

                        },   //trailingIcon
                        label = {Text(text = "Password")},
                        placeholder = {Text(text = "Password")},
                        singleLine = true,
                        visualTransformation = if(passwordVisibility.value) VisualTransformation.None else PasswordVisualTransformation(),
                        modifier = Modifier.fillMaxWidth(0.8f)
                    )

                    Spacer(modifier = Modifier.padding(14.dp))

                    Button(
                        onClick = {
                            isDialogOpen.value = false
                        },
                        modifier = Modifier
                            .fillMaxWidth(0.5f)
                            .height(60.dp)
                            .padding(10.dp),
                        shape = RoundedCornerShape(5.dp),
                        colors = ButtonDefaults.buttonColors(Purple40)
                    ) {

                        Text(
                            text = "Close",
                            color = Color.White,
                            fontSize = 15.sp
                        )

                    }//Button
                }//Column





            }//Surface
        }//Dialog
    }                                     //if

}

