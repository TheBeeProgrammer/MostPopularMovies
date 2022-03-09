package com.example.data.api

import com.example.data.model.entities.MokyResponse
import io.reactivex.Flowable
import retrofit2.http.GET

interface MokyApi {
    @GET("v3/72f66f33-9186-4b20-a9a6-2c65661bc9cf")
    fun getMovies(): Flowable<List<MokyResponse>>
}