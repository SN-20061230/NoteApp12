package com.example.notestring.item

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.notestring2.database.ExpenseEntity
import com.example.notestring2.ui.theme.Primary

@Composable
fun ExpenseItem(
    expense: ExpenseEntity,
    onDelete: (expense: ExpenseEntity) -> Unit,
    onUpdate: (id:Int) -> Unit
) {
    Spacer(modifier = Modifier.height(5.dp))

    Row(modifier = Modifier.fillMaxSize().padding(top = 5.dp, bottom = 5.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically){


        Column(

            modifier = Modifier.fillMaxSize().weight(0.8f)
                .border(
                    BorderStroke(1.dp, Gray),
                    shape = RoundedCornerShape(12.dp),)
            , verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = expense.text!!,
                fontWeight = FontWeight.W500,
                fontSize = 20.sp,
                modifier = Modifier.padding(start = 10.dp,10.dp),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = expense.amount!!.toString(),
                color = Primary,
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            )

        }

        Column( modifier = Modifier.fillMaxSize().weight(0.2f)
            , verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally){
            IconButton(onClick = { onUpdate(expense.id) }, modifier = Modifier.padding(5.dp).border(
                BorderStroke(1.dp, Gray),
                shape = RoundedCornerShape(12.dp),)) {
                Icon(Icons.Rounded.Edit, contentDescription = null, tint = Gray)
            }
            IconButton(onClick = { onDelete(expense) }, modifier = Modifier.padding(5.dp).border(
                BorderStroke(1.dp, Gray),
                shape = RoundedCornerShape(12.dp),)) {
                Icon(Icons.Rounded.Delete, contentDescription = null, tint = Gray)
            }
        }

    }
}