package com.example.registeraddresstestapp.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.registeraddresstestapp.api.model.AddressListResponse
import com.example.registeraddresstestapp.api.model.RegisterBody
import com.example.registeraddresstestapp.api.model.RegisterResponse
import com.example.registeraddresstestapp.api.model.ResponseNeshanAddress
import com.example.registeraddresstestapp.repositories.RegisterRepository
import com.example.registeraddresstestapp.utils.Utils
import com.example.registeraddresstestapp.utils.network.NetworkRequest
import com.example.registeraddresstestapp.utils.network.NetworkResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val repository: RegisterRepository) :
    ViewModel() {


    var fName = mutableStateOf("")
    var lName = mutableStateOf("")
    var mobileNumber = mutableStateOf("")
    var phoneNumber = mutableStateOf("")
    var address = mutableStateOf("")
    var isFemale = mutableStateOf(true)


    var chosenLat by mutableDoubleStateOf(0.0)
    var chosenLng by mutableDoubleStateOf(0.0)


    fun postRegister(
        body: RegisterBody,
        onResponse: (response: NetworkRequest<RegisterResponse>) -> Unit
    ) = viewModelScope.launch {

        try {

            val response = repository.postRegister(body)

            onResponse(NetworkResponse(response).generateResponse())

        } catch (ex: Exception) {

            onResponse(NetworkRequest.Error(Utils.ERROR_MESSAGE))
        }

    }


    fun getAddressList(
        onResponse: (response: NetworkRequest<AddressListResponse>) -> Unit
    ) = viewModelScope.launch {

        try {

            val response = repository.getAddressList()

            onResponse(NetworkResponse(response).generateResponse())

        } catch (ex: Exception) {

            onResponse(NetworkRequest.Error(Utils.ERROR_MESSAGE))
        }

    }



    fun getAddress(
        lat: Double,
        lng: Double,
        onResponse: (response: NetworkRequest<ResponseNeshanAddress>) -> Unit
    ) = viewModelScope.launch {

            try {

                val response = repository.getAddress(lat,lng)

                onResponse(NetworkResponse(response).generateResponse())

            } catch (ex: Exception) {

                onResponse(NetworkRequest.Error(Utils.ERROR_MESSAGE))
            }

        }

}