package com.example.registeraddresstestapp.ui.screen

import android.content.Context
import android.graphics.BitmapFactory
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.carto.styles.AnimationStyleBuilder
import com.carto.styles.AnimationType
import com.carto.styles.MarkerStyleBuilder
import com.example.registeraddresstestapp.R
import com.example.registeraddresstestapp.ui.theme.Green
import com.example.registeraddresstestapp.viewmodels.RegisterViewModel
import org.neshan.common.model.LatLng
import org.neshan.mapsdk.MapView
import org.neshan.mapsdk.internal.utils.BitmapUtils
import org.neshan.mapsdk.model.Marker


@Composable
fun NeshanMapView(
    navController: NavHostController,
    viewModel: RegisterViewModel
) {

    val context = LocalContext.current

    var mapView by remember {

        mutableStateOf<MapView?>(null)
    }

    var marker: Marker? = null

    val markerRemember = remember { mutableStateOf(marker) }

    Surface {
        Row {
            Column {

                Box(modifier = Modifier.weight(1f)) {

                    AndroidView(
                        factory = { context ->
                            MapView(context).apply {
                                mapView = this
                                settings.setNeshanLogoMargins(-700, -700)
                            }
                        },
                        update = {
                            if (markerRemember.value != null) {
                                mapView?.addMarker(markerRemember.value)
                                markerRemember.value = null
                            }
                        },
                        modifier = Modifier,
                    )

                    Column(modifier = Modifier.fillMaxSize()) {

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(0.5f)
                        ) {

                            Icon(
                                painter = painterResource(id = R.drawable.ic_marker_blue),
                                contentDescription = "",
                                tint = Color.Blue,
                                modifier = Modifier
                                    .size(30.dp)
                                    .align(Alignment.BottomCenter)
                            )
                        }

                        Spacer(
                            modifier = Modifier
                                .weight(0.5f)
                        )
                    }

                }


                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    shape = RoundedCornerShape(0.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Green),
                    onClick = {

                        val chosenLatLng = mapView!!.cameraTargetPosition

                        marker = createMarker(context, chosenLatLng)
                        markerRemember.value = marker

                        viewModel.chosenLat = chosenLatLng.latitude
                        viewModel.chosenLng = chosenLatLng.longitude

                        navController.popBackStack()

                    }
                ) {
                    Text("تایید موقعیت", fontWeight = FontWeight.Bold, color = Color.White)
                }
            }
        }
    }
}

fun createMarker(context: Context, loc: LatLng?): Marker {
    val animStBl = AnimationStyleBuilder()
    animStBl.fadeAnimationType = AnimationType.ANIMATION_TYPE_SMOOTHSTEP
    animStBl.sizeAnimationType = AnimationType.ANIMATION_TYPE_SPRING
    animStBl.phaseInDuration = 0.5f
    animStBl.phaseOutDuration = 0.5f
    val animSt = animStBl.buildStyle()

    val markStCr = MarkerStyleBuilder()
    markStCr.size = 30f
    markStCr.bitmap = BitmapUtils.createBitmapFromAndroidBitmap(
        BitmapFactory.decodeResource(context.resources, R.drawable.ic_marker_blue)
    )
    markStCr.animationStyle = animSt
    val markSt = markStCr.buildStyle()

    return Marker(loc, markSt)
}