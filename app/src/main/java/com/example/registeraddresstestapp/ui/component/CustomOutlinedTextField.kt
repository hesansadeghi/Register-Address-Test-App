package com.example.registeraddresstestapp.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.example.registeraddresstestapp.ui.theme.Green

@Composable
fun CustomOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    type: KeyboardType
) {

    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {

        Box(modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.CenterStart
        ) {
            OutlinedTextField(
                value = value,
                onValueChange = onValueChange,
                modifier = Modifier
                    .fillMaxWidth(),
                label = null,
                placeholder = {

                    Text(
                        text = label,
                        modifier = Modifier
                            .padding(horizontal =  20.dp)
                            .background(Color.Transparent),
                        color = Green,
                        fontWeight = FontWeight.Bold
                    )
                },
//                textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.End),
                keyboardOptions = KeyboardOptions(
                    keyboardType = type,
                    imeAction = ImeAction.Next
                )
            )

        }

    }
}
