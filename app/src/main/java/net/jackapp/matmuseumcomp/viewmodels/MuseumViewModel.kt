package net.jackapp.matmuseumcomp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import net.jackapp.matmuseumcomp.data.json.MuseumItem
import net.jackapp.matmuseumcomp.data.viewdata.MuseumViewData
import net.jackapp.matmuseumcomp.usecase.MuseumUseCase

class MuseumViewModel(
    private val museumUseCase: MuseumUseCase
) : ViewModel() {

    private val _museumViewData = MutableSharedFlow<MuseumViewData>()
    val museumViewData = _museumViewData.asSharedFlow()

    fun getMuseumItem() {
        viewModelScope.launch {
            isLoading()
            result(museumUseCase.getFirstAvailableItem())
        }
    }

    private suspend fun result(it: MuseumItem?) {
        _museumViewData.emit(
                if (it == null)
                    MuseumViewData.Error("Huston! We have a problem!")
                else
                    MuseumViewData.Success(listOf(it))
            )
    }

    private suspend fun isLoading() {
        _museumViewData.emit(MuseumViewData.Loading)
    }

}