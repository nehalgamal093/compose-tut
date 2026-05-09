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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true, name = "row", device = "spec:width=600px,height=2340px,dpi=440")
@Composable
fun HomeScreen(){
    Box(
        modifier = Modifier.fillMaxSize().padding(10.dp),
        content = { Body() })
}
@Composable
fun Body(){
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        AppBar()
        Text(text = "Welcome back,Nehal", fontSize = 14.sp)
        Text(text = "How are you feeling Today", fontSize = 20.sp)
        CategoriesList()
        TodayTask()
        Meditation()
    }
}

@Composable
fun AppBar(){
    Row( modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween) {
        Image(
            painter = painterResource(id = R.drawable.list_icon),
            contentDescription = "List icon",
            modifier = Modifier.height(20.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.user),
            contentDescription = "User icon",
            modifier = Modifier.height(20.dp)
        )
    }
}

@Composable
fun CategoriesList(){
    val features = listOf(Feature("Happiness",R.drawable.happiness,Color.Red),Feature("Meditation",R.drawable.meditation,Color.Yellow),Feature("Relax",R.drawable.relax,Color.Cyan),Feature("Focus",R.drawable.focus,Color.DarkGray))
    LazyRow(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
        items(features.size){
            index-> ItemCard(features[index])
        }
    }
}

@Composable
fun ItemCard(feature: Feature){
    Box(modifier = Modifier.width(100.dp).height(100.dp).background(feature.colorBox, shape = RoundedCornerShape(5.dp)), content = { BoxContent(feature) }, contentAlignment = Alignment.Center)
}

@Composable
fun BoxContent(feature: Feature){
    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(feature.iconId),
            contentDescription = feature.title,
            modifier = Modifier.width(20.dp).height(20.dp)
        )
        Text(feature.title, fontSize = 8.sp)
    }
}

@Composable
fun TodayTask(){
    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Text(text = "Today's Task")
        Box(
            modifier = Modifier.fillMaxWidth().height(110.dp).background(Color.LightGray,RoundedCornerShape(10.dp)).padding(10.dp),
            content = {
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    Text(text = "Peer Group Meetup")
                    Text(text = "Let's openup the thing that matters amoung the people")
                    Row() {
                        Text(text = "Join Now")
                    }
                }
            }
        )
    }
}

@Composable
fun Meditation(){
    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Text(text = "Meditation")
        Box(
            modifier = Modifier.fillMaxWidth().height(110.dp).background(Color.Blue,RoundedCornerShape(10.dp)).padding(10.dp),
            content = {
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    Text(text = "Peer Group Meetup")
                    Text(text = "Let's openup the thing that matters amoung the people")
                    Row() {
                        Text(text = "Join Now")
                    }
                }
            }
        )
    }
}