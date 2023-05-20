package com.mobsky.home.presentation.home


import com.mobsky.home.domain.model.HomeMenus
import com.mobsky.home.presentation.util.ScreenState
import com.mobsky.home.presentation.util.TaskState

data class HomeScreenState(
    val taskState: TaskState = TaskState.NotStarted,
    val homeMenus: HomeMenus = listOf()
): ScreenState(taskState)