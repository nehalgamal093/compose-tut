package com.example.compose_tut

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose_tut.ui.screens.HomeScreen.components.CustomBox
import com.example.compose_tut.ui.theme.LightBlue00
import com.example.compose_tut.ui.theme.LightBlue01
import com.example.compose_tut.ui.theme.OrangeColor00
import com.example.compose_tut.ui.theme.Pink00
import com.example.compose_tut.ui.theme.Pink01
import com.example.compose_tut.ui.theme.Pink02
import com.example.compose_tut.ui.theme.Purple80
import com.example.compose_tut.ui.theme.PurpleGrey40
import com.example.compose_tut.ui.theme.robotoFontFamily

@Preview(showBackground = true, name = "row", device = "spec:width=1080px,height=2400px,dpi=440")
@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp,end=16.dp, top = 20.dp),
        content = { Body() })
}

@Composable
fun Body() {
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        AppBar()
        Text(text = "Welcome back,Nehal", fontSize = 14.sp)
        Text(text = "How are you feeling Today", fontSize = 20.sp)
        CategoriesList()
        CustomBox(
            title = "Today's Task",
            subTitle = "Peer Group Meetup",
            description = "Let's openup the thing that matters amoung the people",
            textColor = Pink02,
            backgroundColor = Pink01
        )
        CustomBox(
            title = "Meditation",
            subTitle = "Peer Group Meetup",
            description = "Let's openup the thing that matters amoung the people",
            textColor = Purple80,
            backgroundColor = PurpleGrey40
        )
    }
}

@Composable
fun AppBar() {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Image(
            painter = painterResource(id = R.drawable.list_icon),
            contentDescription = "List icon",
            modifier = Modifier.height(40.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.user),
            contentDescription = "User icon",
            modifier = Modifier.height(40.dp)
        )
    }
}

@Composable
fun CategoriesList() {
    val features = listOf(
        Feature("Happiness", R.drawable.happiness, Pink00),
        Feature("Meditation", R.drawable.meditation, LightBlue00),
        Feature(
            "Relax", R.drawable.relax,
            OrangeColor00
        ),
        Feature("Focus", R.drawable.focus, LightBlue01)
    )
    LazyRow(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
        items(features.size) { index ->
            ItemCard(features[index])
        }
    }
}

@Composable
fun ItemCard(feature: Feature) {
    Box(
        modifier = Modifier
            .width(100.dp)
            .height(100.dp)
            .background(feature.colorBox, shape = RoundedCornerShape(5.dp)),
        content = { BoxContent(feature) },
        contentAlignment = Alignment.Center
    )
}

@Composable
fun BoxContent(feature: Feature) {
    Column(
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(feature.iconId),
            contentDescription = feature.title,
            modifier = Modifier
                .width(50.dp)
                .height(50.dp)
        )
        Text(
            feature.title, fontSize = 15.sp, fontFamily = robotoFontFamily,

            )
    }
}



