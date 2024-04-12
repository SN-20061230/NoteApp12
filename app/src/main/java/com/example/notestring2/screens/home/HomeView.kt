package com.example.notestring.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.notestring.item.ExpenseItem
import com.example.notestring2.ui.theme.primaryColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(vm : HomeViewModel, navController: NavController) {
    vm.loadList()
    val list = vm.list.observeAsState().value

    Column(Modifier.fillMaxSize()) {
        CenterAlignedTopAppBar(title = { Text(text = "Bosh Sahifa", fontWeight = FontWeight.SemiBold) })
        if(list!!.isEmpty()){
            EmptyIcon()
        }
        else{
            LazyColumn (
                Modifier.padding(start = 10.dp, end = 4.dp)){
                items(list.size) {index->
                    ExpenseItem(
                        expense = list[index],
                        onDelete = {vm.delete(list[index])
                        },
                        onUpdate = {vm.onUpdate(list[index])}
                    )
                }
            }
        }

    }


    Box(modifier = Modifier.fillMaxSize()){
        Box (
            Modifier
                .padding(20.dp)
                .align(Alignment.BottomEnd)){
            FloatingActionButton(onClick = {vm.onAdd() }, containerColor = primaryColor) {
                Row(Modifier.padding(horizontal = 16.dp), verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Rounded.Add, contentDescription = "", tint = Color.White)
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = "Qo'shish", color = Color.White)
                }
            }
        }
    }
}

@Composable
fun EmptyIcon() {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        val composition by rememberLottieComposition(spec = LottieCompositionSpec.Url("https://lottie.host/cb9658f7-56e1-418c-b9f9-c94d3af5d5b0/CXDVREveWd.lottie"))
        LottieAnimation(composition = composition, iterations = LottieConstants.IterateForever, modifier = Modifier.width(200.dp).height(200.dp))
    }
}