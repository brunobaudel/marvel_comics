package com.mobsky.home.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobsky.home.domain.model.HomeMenus
import com.mobsky.home.domain.usecase.GetHomeMenuUseCase
import com.mobsky.home.domain.usecase.invoke
import com.mobsky.home.presentation.util.TaskState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeScreenViewModel(
    private val getHomeMenuUseCase: GetHomeMenuUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeScreenState())
    val uiState: StateFlow<HomeScreenState> = _uiState.asStateFlow()

    fun getMenu() {
        viewModelScope.launch {
            try {
                updateScreenStateProgress()
                val homeMenu = getHomeMenuUseCase.invoke()
                updateScreenStateSuccess(homeMenu)
            } catch (e: Exception) {
                updateScreenStateError(e)
            }
        }
    }

    private fun updateScreenStateSuccess(homeMenus: HomeMenus) {
        _uiState.update { currentState ->
            currentState.copy(
                taskState = TaskState.Complete,
                homeMenus = homeMenus
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