package com.example.registeraddresstestapp.ui.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.registeraddresstestapp.api.model.AddressListResponse
import com.example.registeraddresstestapp.viewmodels.RegisterViewModel


@Composable
fun AddressListScreen(registerViewModel: RegisterViewModel) {

    val context = LocalContext.current

    var addressListItem by remember {
        mutableStateOf<List<AddressListResponse.ResponseAddressListItem>>(listOf())
    }


    var showLoading by remember { mutableStateOf(true) }

    registerViewModel.getAddressList { response ->

        showLoading = false

        response.error?.let { error ->

            Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
        }

        response.data?.let { data ->

            addressListItem = data
        }

    }


    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {


        if (showLoading) {

            CircularProgressIndicator()
        }


        LazyColumn(modifier = Modifier.fillMaxSize()) {

            items(addressListItem) { item ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {

                    Column(modifier = Modifier.fillMaxSize().padding(10.dp)) {

                        Text(
                            text = item.address.toString(),
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.End
                        )

                        Spacer(modifier = Modifier.width(15.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End
                        ) {

                            Text(
                                text = item.firstName.toString(),
                                modifier = Modifier,
                                fontSize = 16.sp
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                            Text(
                                text = item.lastName.toString(),
                                modifier = Modifier,
                                fontSize = 16.sp
                            )
                        }

                        Text(
                            text = item.coordinateMobile.toString(),
                            modifier = Modifier.fillMaxWidth()
                        )


                    }

                }


            }
        }


    }


}