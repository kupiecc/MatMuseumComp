package net.jackapp.matmuseumcomp.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import net.jackapp.matmuseumcomp.data.viewdata.MuseumViewData
import net.jackapp.matmuseumcomp.domain.usecase.MuseumUseCases

class MuseumViewModel(
    private val museumUseCases: MuseumUseCases
) : ViewModel() {

    private val _museumItemFlow = MutableSharedFlow<MuseumViewData>()
    val museumItemFlow = _museumItemFlow.asSharedFlow()

    private val _museumSummaryFlow = MutableSharedFlow<MuseumViewData>()
    val museumSummaryFlow = _museumItemFlow.asSharedFlow()

    fun getMuseumItem() {
        viewModelScope.launch {
            _museumItemFlow.emit(museumUseCases.getFirstItemUseCase())
        }
    }

    fun getMuseumSummary() {
        viewModelScope.launch {
            _museumSummaryFlow.emit(museumUseCases.getSummaryUseCase())
        }
    }

}