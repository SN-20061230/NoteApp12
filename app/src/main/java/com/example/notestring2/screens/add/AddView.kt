package com.example.notestring.screens.add

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Done
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.notestring2.database.ExpenseEntity
import com.example.notestring2.ui.theme.Primary
import com.example.notestring2.ui.theme.primaryColor
import com.example.notestring2.ui.theme.secondaryColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddView(vm: AddViewModel, navController: NavController) {
    val text = vm.text.observeAsState().value!!
    val amount = vm.amount.observeAsState().value!!

    Column(
        Modifier
            .fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween
    ) {
        CenterAlignedTopAppBar(title = { Text(text = "Yangi") }, navigationIcon = {
            IconButton(onClick = {
                navController.popBackStack()
            }) {
                Icon(Icons.Rounded.ArrowBack, contentDescription = "")
            }
        })
        Column(Modifier.padding(horizontal = 12.dp)) {
            OutlinedTextField(
                value = text,
                shape = RoundedCornerShape(12.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedIndicatorColor = primaryColor,
                    unfocusedIndicatorColor = Gray,
                    cursorColor = Primary
                ),
                onValueChange = { vm.updateText(it) },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                placeholder = { Text(text = "Mavzu kiriting", color = Gray) },
                leadingIcon = {
                    Icon(Icons.Rounded.Edit, contentDescription = null, tint = Gray)
                }
            )
            Spacer(modifier = Modifier.height(12.dp))
            OutlinedTextField(
                value = if (amount == "") "" else amount,
                shape = RoundedCornerShape(12.dp),
                colors = TextFieldDefaults.colors(
                    unfocusedIndicatorColor = Gray,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedIndicatorColor = primaryColor,
                    cursorColor = Primary
                ),
                onValueChange = { vm.updateAmount(it) },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                singleLine = true,
                placeholder = { Text(text = "Ma'lumot kiriting", color = Gray) },
                leadingIcon = {
                    Icon(Icons.Rounded.Done, contentDescription = null, tint = Gray)
                }
            )
        }
        TextButton(
            enabled = if (vm.id == -1) amount.isNotBlank()  && text.isNotBlank() else vm.expense.amount != amount || vm.expense.text != text,
            onClick = { vm.onAdd(ExpenseEntity(text = text, amount = amount)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            colors = ButtonDefaults.textButtonColors(
                containerColor = primaryColor,
                disabledContainerColor = secondaryColor
            ),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(text = "Qo'shish", color = Color.White, fontSize = 20.sp)
        }
    }
}