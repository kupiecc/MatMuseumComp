package net.jackapp.matmuseumcomp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import net.jackapp.matmuseumcomp.ui.theme.MatMuseumCompTheme
import net.jackapp.matmuseumcomp.ui.views.Museum
import net.jackapp.matmuseumcomp.viewmodels.MuseumViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val museumViewModel: MuseumViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        museumViewModel.getMuseumItem()

        setContent {
            MatMuseumCompTheme {
                Museum(viewModel = museumViewModel)
            }
        }
    }
}