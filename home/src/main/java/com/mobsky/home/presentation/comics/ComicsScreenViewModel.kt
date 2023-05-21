package com.mobsky.home.presentation.comics

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobsky.home.domain.model.Comics
import com.mobsky.home.domain.usecase.GetComicsUseCase
import com.mobsky.home.domain.usecase.invoke
import com.mobsky.home.presentation.util.TaskState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ComicsScreenViewModel(
    private val getComicsUseCase: GetComicsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(ComicsScreenState())
    val uiState: StateFlow<ComicsScreenState> = _uiState.asStateFlow()

    fun getComics() {
        viewModelScope.launch {
            try {
                updateScreenStateProgress()
                val homeMenu = getComicsUseCase.invoke()
                updateScreenStateSuccess(homeMenu)
            } catch (e: Exception) {
                updateScreenStateError(e)
            }
        }
    }

    private fun updateScreenStateSuccess(comics: Comics) {
        _uiState.update { currentState ->
            currentState.copy(
                taskState = TaskState.Complete,
                comics = comics
            )
        }
    }

    private fun updateScreenStateError(exception: Exception) {
        _uiState.update { currentState ->
            currentState.copy(
                taskState = TaskState.Error(exception)
            )
        }
    }

    private fun updateScreenStateProgress() {
        _uiState.update { currentState ->
            currentState.copy(
                taskState = TaskState.InProgress
            )
        }
    }

}