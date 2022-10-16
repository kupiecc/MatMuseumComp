package net.jackapp.matmuseumcomp.ui.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.jackapp.matmuseumcomp.data.json.MuseumItem
import net.jackapp.matmuseumcomp.data.resultdata.MuseumViewData
import net.jackapp.matmuseumcomp.viewmodels.MuseumViewModel

@Composable
fun Museum(viewModel: MuseumViewModel) {
    val museumViewDataStateFlow = viewModel.museumViewData.collectAsState(MuseumViewData.Loading)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { TopBarTitle() },
            )
        }
    ) {
         MuseumResult(museumViewDataStateFlow.value)
    }
}

@Composable
private fun MuseumResult(museumViewData: MuseumViewData) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        when (museumViewData) {
            is MuseumViewData.Success ->
                MuseumListView(museumViewData.items)
            is MuseumViewData.Error ->
                Error(museumViewData.message)
            is MuseumViewData.Loading ->
                ProgressIndicator()
            is MuseumViewData.Empty ->
                Welcome()
        }
    }
}

@Composable
fun MuseumListView(items: List<MuseumItem>) {
    LazyColumn {
        itemsIndexed(items) { _: Int, item: MuseumItem ->
            Text(text = item.title)
        }
    }
}

@Composable
private fun Error(message: String) {
    Text(
        text = message,
        fontSize = 22.sp,
        color = Color.Red
    )
}

@Composable
private fun ProgressIndicator() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
private fun Welcome() {
    Text(
        modifier = Modifier.padding(16.dp),
        text = "Hello World!"
    )
}

@Composable
private fun TopBarTitle() {
    Text(
        text = "MatMuseum",
        color = MaterialTheme.colors.onPrimary,
        fontWeight = FontWeight.Bold,
    )
}


@Preview(widthDp = 400, heightDp = 800, showBackground = true)
@Composable
fun DefaultPreview() {
    MuseumResult(museumViewData = MuseumViewData.Error("error message"))
}