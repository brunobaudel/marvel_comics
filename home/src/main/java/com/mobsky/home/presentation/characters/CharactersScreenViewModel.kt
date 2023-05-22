package com.mobsky.home.presentation.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobsky.home.domain.model.Characters
import com.mobsky.home.domain.usecase.GetCharactersUseCase
import com.mobsky.home.domain.usecase.invoke
import com.mobsky.home.presentation.util.TaskState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CharactersScreenViewModel(
    private val getCharactersUseCase: GetCharactersUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(CharactersScreenState())
    val uiState: StateFlow<CharactersScreenState> = _uiState.asStateFlow()

    fun getCharacters() {
        viewModelScope.launch {
            try {
                updateScreenStateProgress()
                val homeMenu = getCharactersUseCase.invoke()
                updateScreenStateSuccess(homeMenu)
            } catch (e: Exception) {
                updateScreenStateError(e)
            }
        }
    }

    private fun updateScreenStateSuccess(Characters: Characters) {
        _uiState.update { currentState ->
            currentState.copy(
                taskState = TaskState.Complete,
                Characters = Characters
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