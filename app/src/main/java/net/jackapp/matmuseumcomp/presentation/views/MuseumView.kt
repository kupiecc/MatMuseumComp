package net.jackapp.matmuseumcomp.presentation.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.jackapp.matmuseumcomp.data.json.MuseumItem
import net.jackapp.matmuseumcomp.data.json.MuseumSummary
import net.jackapp.matmuseumcomp.data.viewdata.MuseumViewData
import net.jackapp.matmuseumcomp.leetcode.LongestPalindromic
import net.jackapp.matmuseumcomp.presentation.viewmodels.MuseumViewModel

@Composable
fun MuseumView(viewModel: MuseumViewModel) {
    val museumViewDataStateFlow = viewModel.museumItemFlow.collectAsState(MuseumViewData.Loading)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { TopBarTitle() },
            )
        }
    ) {
//        ShimmerView()
        LongestPalindromicView()
//         MuseumResult(museumViewDataStateFlow.value)
    }
}

@Composable
fun LongestPalindromicView() {
    val longestPalindromic = remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Button(onClick = {
            longestPalindromic.value = LongestPalindromic()
                .longestPalindrome("aacabdkacaa")
        }) {
            Text(text = "Longest palindromic")
        }
        Text(text = longestPalindromic.value)
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
            is MuseumViewData.SuccessItem ->
                MuseumListView(listOf(museumViewData.item))
            is MuseumViewData.SuccessSummary ->
                MuseumSummaryView(museumViewData.summary)
            is MuseumViewData.Error ->
                ErrorView(museumViewData.message)
            is MuseumViewData.Loading ->
                ProgressIndicator()
        }
    }
}

@Composable
fun MuseumSummaryView(summary: MuseumSummary) {
    Column {
        Text(text = summary.total.toString())
        Text(text = summary.objectIDs.toString())
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
private fun ErrorView(message: String) {
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
    val ids = listOf(1, 2, 3, 4, 5, 6)
    val museumSummary = MuseumSummary(objectIDs = ids, total = ids.size)
    MuseumResult(museumViewData = MuseumViewData.SuccessSummary(museumSummary))
}