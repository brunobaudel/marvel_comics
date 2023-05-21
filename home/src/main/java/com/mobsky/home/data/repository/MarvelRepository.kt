package com.mobsky.home.data.repository

import com.mobsky.home.domain.model.Comics
import com.mobsky.home.domain.model.QueryStringFilters


interface MarvelRepository {

    suspend fun getComics(queryStringParameter: QueryStringFilters = QueryStringFilters()): Comics
}