package com.ammar.autofitapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ammar.autofitapp.models.SnackbarMessage
import com.ammar.autofitapp.util.Event
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

open class BaseViewModel: ViewModel() {

    val dispatcher = Dispatchers.Default

    var _showHideProgressDialog = MutableLiveData<Event<Boolean>>()
    val showHideProgressDialog: LiveData<Event<Boolean>> get() = _showHideProgressDialog

    val snackbarData = MutableLiveData<Event<SnackbarMessage>>()
    protected fun showSnackbarMessage(message: SnackbarMessage) {
        snackbarData.value = Event(message)
    }

    protected fun showSnackbarMessage(message: String, positiveMsg: Boolean = false) {
        snackbarData.value =
            Event(SnackbarMessage(content = message, positiveMessage = positiveMsg))
    }


    suspend fun customDelay(millis: Long) = withContext(dispatcher) {
        delay(millis)
    }

}