package com.mobsky.home.domain.model

import com.google.gson.GsonBuilder

data class QueryStringFilters(
    var format: String? = null,
    var formatType: String? = null,
    var noVariants: String? = null,
    var dateDescriptor: String? = null,
    var hasDigitalIssue: String? = null,
    var orderBy: String? = null,
    var limit: String? = null,
) {

    fun getQueryStringMap(): Map<String, String> =
        mapper.fromJson(mapper.toJson(this), Map::class.java) as Map<String, String>

    companion object {
        private val mapper = GsonBuilder().create()
    }
}
