package com.example.flowrowhw

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalLayoutApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FlowColumn(
                Modifier
                    .fillMaxSize()
                    .horizontalScroll(rememberScrollState()),
                maxItemsInEachColumn = 3
            ) {

                EmployersDataBase.employees.forEach { person ->
                    Box(
                        Modifier
                            .wrapContentSize()
                            .padding(3.dp)
                            .background(Color.LightGray)
                    ) {
                        Column {
                            Image(
                                modifier = Modifier.size(76.dp),
                                painter = painterResource(id = person.image),
                                contentDescription = "",
                                contentScale = ContentScale.Crop
                            )
                            Text(text = "Имя: " + person.name, fontSize = 35.sp)
                            Text(text = "Фамилия: " + person.lastName, fontSize = 35.sp)
                            Text(text = "Должность: " + person.employee.toString(), fontSize = 35.sp)
                            Text(text = "Зарплата: " + person.salary.toString(), fontSize = 35.sp)
                        }


                    }
                }

            }
        }
    }
}

