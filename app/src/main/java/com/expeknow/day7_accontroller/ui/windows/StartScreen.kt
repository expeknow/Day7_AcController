package com.expeknow.day7_accontroller.ui.windows

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.expeknow.day7_accontroller.R
import com.expeknow.day7_accontroller.ui.theme.iconDark
import com.expeknow.day7_accontroller.ui.theme.poppinsFamily
import com.expeknow.day7_accontroller.ui.theme.primaryDark
import com.expeknow.day7_accontroller.ui.theme.secondaryDark


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun StartScreen(navController: NavHostController) {
    Scaffold() {
        Column(Modifier.fillMaxSize()) {
            Box (
                Modifier
                    .padding(horizontal = 40.dp)
                    .fillMaxWidth()
                    .weight(13f)) {
                
                Card(shape = RoundedCornerShape(0.dp, 0.dp, 1000.dp, 1000.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = primaryDark
                    ), modifier = Modifier
                        .fillMaxSize()) {

                }

                Card(shape = RoundedCornerShape(0.dp, 0.dp, 150.dp, 150.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = secondaryDark
                    ), modifier = Modifier
                        .height(160.dp)
                        .fillMaxWidth()
                        .padding(horizontal = 30.dp)) {

                }
            }

            Spacer(modifier = Modifier.height(40.dp))

            Column(
                Modifier
                    .weight(10f)
                    .padding(horizontal = 40.dp)) {
                Row(Modifier.weight(1f), verticalAlignment = Alignment.Bottom) {
                    Text(text = "Unlock smoother life",
                        fontFamily = poppinsFamily, fontWeight = FontWeight.SemiBold,
                        fontSize = 42.sp, modifier = Modifier.weight(4f), lineHeight = 52.sp)
                    Spacer(modifier = Modifier.weight(1f))
                }

                Spacer(modifier = Modifier.height(40.dp))

                Divider(color = primaryDark, thickness = 3.dp,
                    modifier = Modifier.padding(start = 0.dp))

                Spacer(modifier = Modifier.height(20.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "Get Started".uppercase(), fontFamily = poppinsFamily,
                        fontWeight = FontWeight.Bold,
                    fontSize = 15.sp, modifier = Modifier.weight(1f))

                    IconButton(onClick = { navController.navigate("home") },
                        Modifier
                            .clip(RoundedCornerShape(100.dp))
                            .size(70.dp),
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = iconDark
                    )) {
                        Icon(painter = painterResource(id = R.drawable.arrow_forward_ios),
                            contentDescription = "", tint = Color.White,
                        modifier = Modifier.size(20.dp))
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    StartScreen(rememberNavController())
}