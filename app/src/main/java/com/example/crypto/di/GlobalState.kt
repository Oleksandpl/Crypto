package com.example.crypto.di

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GlobalState @Inject constructor() {
    private val _detailsIdState: MutableState<String> = mutableStateOf("")
    val detailsIdState: State<String> = _detailsIdState

    fun setDetailsIdState(id: String) {
        _detailsIdState.value = id
    }
}