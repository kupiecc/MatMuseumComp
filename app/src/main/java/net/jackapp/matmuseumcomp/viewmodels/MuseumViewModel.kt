package net.jackapp.matmuseumcomp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import net.jackapp.matmuseumcomp.data.json.MuseumItem
import net.jackapp.matmuseumcomp.data.resultdata.MuseumViewData
import net.jackapp.matmuseumcomp.usecase.GetItemUseCase

class MuseumViewModel(
    private val getItemUseCase: GetItemUseCase
) : ViewModel() {

    private val _museumViewData = MutableSharedFlow<MuseumViewData>()
    val museumViewData = _museumViewData.asSharedFlow()

    fun getMuseumItem() {
        viewModelScope.launch {
            _museumViewData.emit(MuseumViewData.Loading)
            _museumViewData.emit(getItemUseCase.getFirstAvailableItem())
        }
    }

}