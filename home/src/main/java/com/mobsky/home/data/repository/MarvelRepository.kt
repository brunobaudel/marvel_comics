package com.mobsky.home.data.repository

import com.mobsky.home.domain.model.Comics


interface MarvelRepository {

    suspend fun getComics(): Comics
}