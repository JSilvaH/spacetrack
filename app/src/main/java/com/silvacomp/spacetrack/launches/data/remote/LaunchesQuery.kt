package com.silvacomp.spacetrack.launches.data.remote

import androidx.annotation.Keep
import com.squareup.moshi.Json
@Keep
data class LaunchesQuery(
    @field:Json(name = "docs")val docs: List<Launch>,
    @field:Json(name = "totalDocs")val totalDocs: Int,
    @field:Json(name = "offset")val offset: Int,
    @field:Json(name = "limit")val limit: Int,
    @field:Json(name = "totalPages")val totalPages: Int,
    @field:Json(name = "page")val page: Int,
    @field:Json(name = "pagingCounter")val pagingCounter: Int,
    @field:Json(name = "hasPrevPage")val hasPrevPage:Boolean,
    @field:Json(name = "hasNextPage")val hasNextPage: Boolean,
    @field:Json(name = "prevPage")val prevPage: Int? = null,
    @field:Json(name = "nextPage")val nextPage: Int? = null
)
