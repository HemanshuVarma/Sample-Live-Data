package com.varma.hemanshu.demolivedata.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DemoViewModel : ViewModel() {
    private val _editTextString = MutableLiveData<String>()
    val editTextString: LiveData<String> get() = _editTextString

    private val _isButtonEnabled = MutableLiveData<Boolean>()
    val isButtonEnabled: LiveData<Boolean> get() = _isButtonEnabled

    fun updateText(text: String) {
        _editTextString.value = text
    }

    fun enableButton() {
        _isButtonEnabled.value = !_editTextString.value.isNullOrEmpty()
    }
}