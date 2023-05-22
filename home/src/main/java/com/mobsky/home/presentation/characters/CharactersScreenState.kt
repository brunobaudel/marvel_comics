package com.mobsky.home.presentation.characters


import com.mobsky.home.domain.model.Characters
import com.mobsky.home.presentation.util.ScreenState
import com.mobsky.home.presentation.util.TaskState

data class CharactersScreenState(
    val taskState: TaskState = TaskState.NotStarted,
    val Characters: Characters = listOf()
): ScreenState(taskState)