package com.mobsky.home.presentation.comics


import com.mobsky.home.domain.model.Comics
import com.mobsky.home.presentation.util.ScreenState
import com.mobsky.home.presentation.util.TaskState

data class ComicsScreenState(
    val taskState: TaskState = TaskState.NotStarted,
    val comics: Comics = listOf()
): ScreenState(taskState)