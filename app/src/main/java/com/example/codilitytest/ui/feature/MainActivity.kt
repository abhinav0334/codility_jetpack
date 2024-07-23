package com.example.codilitytest.ui.feature

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.provider.CalendarContract.Colors
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.codilitytest.model.DataModel
import com.example.codilitytest.ui.theme.CodilityTestTheme
import com.example.kotlindemo.viewmodel.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    lateinit var context: Context
    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CodilityTestTheme {
                MainScreen(viewModel = viewModel)
            }
        }
    }
}

@Composable
fun MainScreen(viewModel: MainActivityViewModel) {
    val detailData by viewModel.detailData.observeAsState(initial = emptyList())
    val isLoading by viewModel.isLoading.observeAsState(initial = false)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Button(onClick = {
            viewModel.fetchDetailData()
        }) {
            Text("Fetch Data")
        }

        if (isLoading) {
            CircularProgressIndicator(modifier = Modifier.padding(top = 16.dp))
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 16.dp)
            ) {
                items(detailData) { item ->
                    DetailItem(item)
                }
            }
        }
    }
}

@Composable
fun DetailItem(item: DataModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)


    ) {
        Column {
            Text(
                text = "Scheme Code " + item.schemeCode.toString(), // Customize this to display the data properly
                modifier = Modifier.padding(16.dp)
            )
            Text(
                text = "Scheme Name " + item.schemeName.toString(), // Customize this to display the data properly
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}