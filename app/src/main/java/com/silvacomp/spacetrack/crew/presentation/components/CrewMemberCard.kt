package com.silvacomp.spacetrack.crew.presentation.components

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.zIndex
import com.silvacomp.spacetrack.R
import com.silvacomp.spacetrack.crew.data.remote.CrewMember

@Composable
fun CardCrewMember(
    onDismiss: () -> Unit
) {
    Dialog(onDismissRequest = { onDismiss()}) {
        Box(modifier = Modifier
            .width(300.dp)
            .height(500.dp)
        ){
            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = null,
                modifier = Modifier.size(100.dp)
                    .align(Alignment.TopCenter)
                    .zIndex(1f)
            )
            Column(
                modifier = Modifier.size(400.dp)
            ) {
                Spacer(modifier = Modifier.height(36.dp))
                Box(modifier = Modifier
                    .width(300.dp)
                    .height(200.dp)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(10.dp)
                    )
                ){
                    Column(
                        modifier = Modifier.padding(60.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Spacer(modifier = Modifier.height(16.dp))
                        //AQUI VA EL Contenido de la carda
                        Row(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Spacer(modifier = Modifier.width(8.dp))
                            Button(
                                onClick = onDismiss,
//                                shape = Shapes.large,
                                colors = ButtonDefaults.buttonColors(Color.Black),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(1f)
                                    .clip(RoundedCornerShape(5.dp))
                            ) {
                                Text(
                                    text = "Ok",
                                    color = Color.White
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}


@Preview
@Composable
fun CardCrewMemberPrev() {
    CardCrewMember(){

    }
}