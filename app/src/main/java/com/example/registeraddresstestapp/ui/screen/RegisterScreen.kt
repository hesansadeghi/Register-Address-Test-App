package com.example.registeraddresstestapp.ui.screen

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.registeraddresstestapp.api.model.RegisterBody
import com.example.registeraddresstestapp.ui.component.CustomOutlinedTextField
import com.example.registeraddresstestapp.ui.theme.Green
import com.example.registeraddresstestapp.utils.Utils
import com.example.registeraddresstestapp.viewmodels.RegisterViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(
    navController: NavHostController,
    viewModel: RegisterViewModel
) {

    val context = LocalContext.current


    val fName by remember { mutableStateOf(viewModel.fName) }
    val lName by remember { mutableStateOf(viewModel.lName) }
    val mobileNumber by remember { mutableStateOf(viewModel.mobileNumber) }
    val phoneNumber by remember { mutableStateOf(viewModel.phoneNumber) }


    val isFemale by remember { mutableStateOf(viewModel.isFemale) }

    val address by remember { mutableStateOf(viewModel.address) }


    val chosenLat by remember { mutableDoubleStateOf(viewModel.chosenLat) }
    val chosenLng by remember { mutableDoubleStateOf(viewModel.chosenLng) }

    val openDialog = remember { mutableStateOf(false) }
    val textDialog = remember { mutableStateOf("") }


    if (chosenLat != 0.0 && chosenLng != 0.0) {

        viewModel.getAddress(chosenLat, chosenLng) { response ->

            response.data?.let { data ->

                address.value = "${data.formattedAddress}"
            }

        }

    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {


        Box(
            modifier = Modifier
                .height(60.dp)
                .fillMaxWidth()
                .padding(bottom = 15.dp)
                .background(Color.LightGray),
            contentAlignment = Alignment.Center
        ) {

            Text(
                text = "لطفا اطلاعات خود را وارد کنید",
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier,
                color = Color.Black
            )

        }

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {

            item {
                CustomOutlinedTextField(
                    value = fName.value,
                    onValueChange = {
                        fName.value = it
                    },
                    label = "نام",
                    KeyboardType.Text
                )

                Spacer(modifier = Modifier.height(10.dp))

            }

            item {
                CustomOutlinedTextField(
                    value = lName.value,
                    onValueChange = {
                        lName.value = it
                    },
                    label = "نام خانوادگی",
                    KeyboardType.Text,
                )

                Spacer(modifier = Modifier.height(10.dp))
            }

            item {
                CustomOutlinedTextField(
                    value = mobileNumber.value,
                    onValueChange = {
                        mobileNumber.value = if (it.length <= 11) it else mobileNumber.value
                    },
                    label = "تلفن همراه",
                    KeyboardType.Phone,
                )

                Spacer(modifier = Modifier.height(10.dp))
            }

            item {
                CustomOutlinedTextField(
                    value = phoneNumber.value,
                    onValueChange = {
                        phoneNumber.value = if (it.length <= 11) it else phoneNumber.value
                    },
                    label = "تلفن ثابت",
                    KeyboardType.Phone,
                )

                Spacer(modifier = Modifier.height(40.dp))
            }



            item {

                Text(
                    text = "آدرس دقیق",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 5.dp),
                    textAlign = TextAlign.End,
                    color = Green,
                    fontWeight = FontWeight.Bold
                )


                OutlinedCard(
                    modifier = Modifier.clickable {

                        navController.navigate(Utils.MAP_VIEW)
                    },
                    shape = RoundedCornerShape(5.dp),
                    colors = CardDefaults.cardColors(Color.Transparent)
                ) {

                    Text(
                        text = address.value,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(25.dp),
                        textAlign = TextAlign.End,
                        fontWeight = FontWeight.Bold,
                    )
                }

                Spacer(modifier = Modifier.height(15.dp))

            }


            item {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Card(
                        shape = RoundedCornerShape(10.dp),
                        border = BorderStroke(2.dp, Green)
                    ) {

                        Row {

                            Box(
                                modifier = Modifier
                                    .clickable {
                                        if (isFemale.value.not()) {
                                            isFemale.value = true
                                        }
                                    }
                                    .width(60.dp)
                                    .background(if (isFemale.value) Green else Color.White),
                                contentAlignment = Alignment.Center
                            ) {

                                Text(
                                    text = "خانم",
                                    modifier = Modifier.padding(vertical = 10.dp),
                                    textAlign = TextAlign.Center,
                                    color = if (isFemale.value) Color.White else Green,
                                    fontWeight = FontWeight.Bold
                                )

                            }

                            Box(
                                modifier = Modifier
                                    .clickable {
                                        if (isFemale.value) {
                                            isFemale.value = false
                                        }
                                    }
                                    .width(60.dp)
                                    .background(if (isFemale.value) Color.White else Green),
                                contentAlignment = Alignment.Center
                            ) {

                                Text(
                                    text = "آقا",
                                    modifier = Modifier.padding(vertical = 10.dp),
                                    textAlign = TextAlign.Center,
                                    color = if (isFemale.value) Green else Color.White,
                                    fontWeight = FontWeight.Bold
                                )

                            }
                        }

                    }

                    Text(
                        text = "جنسیت",
                        modifier = Modifier,
                        textAlign = TextAlign.End,
                        color = Green,
                        fontWeight = FontWeight.Bold
                    )

                }

            }


        }


        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Green),
            onClick = {

                if (fName.value.isEmpty()) {

                    Toast.makeText(context, "نام خود را وارد کنید", Toast.LENGTH_SHORT).show()
                } else {

                    if (lName.value.isEmpty()) {

                        Toast.makeText(context, "نام خانوادگی خود را وارد کنید", Toast.LENGTH_SHORT)
                            .show()
                    } else {


                        if (mobileNumber.value.length != 11 || mobileNumber.value.startsWith("0")
                                .not()
                        ) {

                            Toast.makeText(
                                context,
                                " شماره تلفن همراه خود را بدرستی وارد کنید",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {


                            if (phoneNumber.value.length != 11 || phoneNumber.value.startsWith("0")
                                    .not()
                            ) {

                                Toast.makeText(
                                    context,
                                    " شماره تلفن ثابت خود را بدرستی وارد کنید",
                                    Toast.LENGTH_SHORT
                                ).show()
                            } else {


                                if (address.value.isEmpty()) {

                                    Toast.makeText(
                                        context,
                                        "آدرس خود وارد کنید",
                                        Toast.LENGTH_SHORT
                                    ).show()

                                } else {
                                    val body = RegisterBody(
                                        address.value,
                                        mobileNumber.value,
                                        phoneNumber.value,
                                        fName.value,
                                        gender = if (isFemale.value) Utils.FEMALE else Utils.MALE,
                                        lName.value,
                                        chosenLat,
                                        chosenLng
                                    )

                                    Log.e("tag", body.toString())



                                    viewModel.postRegister(body) { response ->

                                        response.error?.let { error ->

                                            Toast.makeText(context, error, Toast.LENGTH_SHORT)
                                                .show()
                                        }

                                        response.data?.address?.let { address ->

                                            openDialog.value = true
                                            textDialog.value = address
                                        }
                                    }

                                }
                            }
                        }
                    }
                }

            }
        ) {
            Text("بررسی اطلاعات", fontWeight = FontWeight.Bold, color = Color.White)
        }

    }


    if (openDialog.value) {
        BasicAlertDialog(onDismissRequest = {
            // Dismiss the dialog when the user clicks outside the dialog or on the back
            // button. If you want to disable that functionality, simply use an empty
            // onDismissRequest.
            openDialog.value = false
        }
        ) {
            Surface(
                modifier = Modifier
                    .wrapContentWidth()
                    .wrapContentHeight(),
                shape = MaterialTheme.shapes.large
            ) {
                Column(modifier = Modifier.padding(16.dp)) {

                    Text(
                        text = "آدرس مورد نظر با موفقیت ثبت شد",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "آدرس مورد نظر",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.End,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = textDialog.value,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 5.dp),
                        textAlign = TextAlign.End
                    )

                    Spacer(modifier = Modifier.height(15.dp))
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Green),
                        onClick = {

                            openDialog.value = false
                            navController.navigate(Utils.ADDRESS_LIST)
                        }
                    ) {
                        Text("مرحله بعد", fontWeight = FontWeight.Bold, color = Color.White)
                    }
                }
            }
        }

    }


}