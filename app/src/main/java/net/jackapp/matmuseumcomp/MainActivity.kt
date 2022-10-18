package net.jackapp.matmuseumcomp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import net.jackapp.matmuseumcomp.presentation.theme.MatMuseumCompTheme
import net.jackapp.matmuseumcomp.presentation.views.MuseumView
import net.jackapp.matmuseumcomp.presentation.viewmodels.MuseumViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val museumViewModel: MuseumViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        museumViewModel.getMuseumItem()

        setContent {
            MatMuseumCompTheme {
                MuseumView(viewModel = museumViewModel)
            }
        }
    }
}