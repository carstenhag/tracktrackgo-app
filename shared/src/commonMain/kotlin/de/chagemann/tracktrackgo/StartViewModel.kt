package de.chagemann.tracktrackgo

import de.chagemann.tracktrackgo.openfooddbapi.OpenFoodDatabaseApi
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class StartViewModel : ViewModel() {

    private val httpClient = getHttpClient()
    private val api = OpenFoodDatabaseApi(httpClient)

    private val _viewState = MutableStateFlow(ViewState(counter = 0))
    val viewState = _viewState.asStateFlow()

    fun fetchData(barcode: String) {
        viewModelScope.launch {
            api.getProductForBarcode(barcode)
        }
    }

    data class ViewState(
        val counter: Int
    )
}