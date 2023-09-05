package com.expeknow.day7_accontroller.ui.windows

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.expeknow.day7_accontroller.R
import com.expeknow.day7_accontroller.ui.Manager
import com.expeknow.day7_accontroller.ui.theme.lightGray
import com.expeknow.day7_accontroller.ui.theme.midDark
import com.expeknow.day7_accontroller.ui.theme.poppinsFamily
import com.expeknow.day7_accontroller.ui.theme.primaryDark
import com.expeknow.day7_accontroller.ui.theme.secondaryDark

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavHostController) {

    val manager by remember {
        mutableStateOf(Manager())
    }

    Scaffold {
        Column(Modifier.padding(it)) {
            TopBar(navController = navController)
            Spacer(modifier = Modifier.height(10.dp))
            TextAndSwitch()
            Spacer(modifier = Modifier.height(10.dp))
            FilterChips(manager)
            Card(modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
                shape = RoundedCornerShape(0.dp)
            ) {
                MainScreenContent(manager)
            }
        }
    }
}

@OptIn(ExperimentalTextApi::class)
@Composable
fun MainScreenContent(manager: Manager) {

    val gradientColors = listOf(
        Color(0xFF323232),
        Color(0xFF363636),
        Color(0xFF323232),
        Color(0xFF363636),
        Color(0xFF323232),
        Color(0xFF363636),
        Color(0xFF323232),
        Color(0xFF363636),
        Color(0xFF323232),
        Color(0xFF363636),
        Color(0xFF323232),
        Color(0xFF363636),
        Color(0xFF323232),
        Color(0xFF363636),
        Color(0xFF323232),
        Color(0xFF363636),
        Color(0xFF323232),
        Color(0xFF363636),
        Color(0xFF323232),
        Color(0xFF363636),
        Color(0xFF323232),
        Color(0xFF363636),
        Color(0xFF323232),
        Color(0xFF363636),
    )
    val textGradientColors = listOf(
        Color(0x4457575A),
        Color(0xFF57575A)
    )
    var progressValue by remember {
        mutableStateOf(0.6f)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = createGradientBrushForBg(gradientColors, false))
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.Top, horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = manager.currentSelectedChipName.value,
                fontSize = 150.sp,
                fontWeight = FontWeight.Black,
                style = TextStyle(brush = createGradientBrushForText(textGradientColors))
            )
        }

        val progressAnimate by animateFloatAsState(
            targetValue = progressValue,
            animationSpec = tween(
                durationMillis = 400,//animation duration
                delayMillis = 5,//delay before animation start
                easing = LinearOutSlowInEasing
            )
        )

        Box(modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 10.dp), contentAlignment = Alignment.Center) {
            CircularProgressIndicator(color = Color.White,
                progress = progressAnimate, strokeWidth = 5.dp,
                modifier = Modifier
                    .size(200.dp)
                    .fillMaxSize())
            Column() {

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "${100*progressValue}".substring(0,2),
                        fontSize = 55.sp,
                        fontWeight = FontWeight.SemiBold,
                        lineHeight = 130.sp,
                        color = Color.White)
                    Text(text = "°",
                        fontSize = 50.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.White)
                }

                Text(text = "Fahrenheit",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Gray)
            }

        }

        Row(
            Modifier
                .fillMaxSize()
                .padding(horizontal = 60.dp, vertical = 20.dp), verticalAlignment = Alignment.Bottom) {
            Button(onClick = { if(progressValue > 0f) progressValue -= 0.05f },
                colors = ButtonDefaults.buttonColors(
                    containerColor = midDark
                ), shape = CircleShape,
                contentPadding = PaddingValues(25.dp),
            ) {
                Icon(painter = painterResource(id = R.drawable.minus), contentDescription = "minues",
                    tint = Color.White, modifier = Modifier.size(25.dp))
            }

            Spacer(modifier = Modifier.weight(1f))

            Button(onClick = { if(progressValue < 1f) progressValue += 0.05f },
                colors = ButtonDefaults.buttonColors(
                    containerColor = midDark
                ), shape = CircleShape,
                contentPadding = PaddingValues(25.dp),
            ) {
                Icon(
                    Icons.Default.Add, contentDescription = "add",
                    tint = Color.White, modifier = Modifier.size(25.dp))
            }
        }

    }
}


fun createGradientBrushForText(
    colors: List<Color>,
): Brush {

    return Brush.linearGradient(
        colors = colors,
        start = Offset(0f, 2000f),
        end = Offset(1000f, 2000f),
    )
}

fun createGradientBrushForBg(
    colors: List<Color>,
    isVertical: Boolean = true
): Brush {

    val endOffset = if (isVertical) {
        Offset(300f, Float.POSITIVE_INFINITY)
    } else {
        Offset(Float.POSITIVE_INFINITY, 300f)
    }

    return Brush.linearGradient(
        colors = colors,
        start = Offset(500f, 0f),
        end = endOffset,
        tileMode = TileMode.Repeated
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterChips(manager: Manager) {

    val tabsItem = listOf(
        "Cool",
        "Dry",
        "Fan",
        "Heat"
    )

    LazyRow(Modifier.padding(horizontal = 10.dp)) {
        items(tabsItem.size){
            val tabName = tabsItem[it]
            val interactionSource = MutableInteractionSource()
            val state = remember { mutableStateOf(false) }
            FilterChip(
                selected = manager.currentSelectedChipName.value == tabName,
                onClick = {
                    state.value = !state.value
                    manager.changeSelectedChipName(tabName)
                },
                shape = RoundedCornerShape(10.dp),
                label = { Text(text = tabName, fontWeight = FontWeight.SemiBold, fontSize = 16.sp,
                    modifier = Modifier.padding(vertical = 0.dp))},
                modifier = Modifier.padding(horizontal = 5.dp, vertical = 10.dp),
                colors = FilterChipDefaults.filterChipColors(
                    selectedContainerColor = Color.Transparent,
                    selectedLabelColor = primaryDark,
                    containerColor = Color.Transparent,
                    labelColor = Color.LightGray,
                ),
                border = FilterChipDefaults.filterChipBorder(
                    borderWidth = 0.dp,
                    borderColor = Color.Transparent
                ),
                interactionSource = interactionSource
            )
        }
    }

}

@Composable
fun TextAndSwitch() {
    Column(Modifier.padding(horizontal = 30.dp, vertical = 0.dp)
        , verticalArrangement = Arrangement.Center) {
        Text(
            text = "Air",
            fontFamily = poppinsFamily, fontWeight = FontWeight.SemiBold,
            fontSize = 32.sp,
        )
        Text(
            text = "Conditioner",
            fontFamily = poppinsFamily, fontWeight = FontWeight.Light,
            fontSize = 30.sp
        )

        Spacer(modifier = Modifier.height(10.dp))

        var isChecked by remember {
            mutableStateOf(true)
        }

        Switch(checked = isChecked, onCheckedChange = {isChecked = !isChecked},
        colors = SwitchDefaults.colors(
            checkedThumbColor = Color.White,
            checkedTrackColor = primaryDark,
            uncheckedBorderColor = primaryDark,
            uncheckedThumbColor = secondaryDark,
            uncheckedTrackColor = lightGray,
        ), modifier = Modifier
                .scale(1.8f)
                .padding(horizontal = 20.dp),
            thumbContent = {
                Text(
                    text = if (isChecked) "ON" else "OFF",
                    fontSize = 6.sp,
                    color = if(isChecked) primaryDark else Color.White,
                    fontWeight = FontWeight.Bold
                )
            }) 

    }
}



@Composable
fun TopBar(modifier: Modifier = Modifier, navController: NavHostController) {

    Row(modifier = modifier.padding(10.dp),
        verticalAlignment = Alignment.CenterVertically) {

        Button(onClick = { navController.popBackStack() },
            colors = ButtonDefaults.buttonColors(
                containerColor = lightGray
            ), shape = CircleShape,
            contentPadding = PaddingValues(25.dp),
        ) {
            Icon(painter = painterResource(id = R.drawable.arrow_back_ios), contentDescription = "back",
                tint = midDark, modifier = Modifier.size(25.dp))
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                containerColor = lightGray
            ), shape = CircleShape,
            contentPadding = PaddingValues(25.dp),
        ) {
            Icon(painter = painterResource(id = R.drawable.square), contentDescription = "square",
                tint = midDark, modifier = Modifier.size(25.dp))
        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Preview2() {
    MainScreen(rememberNavController())
}