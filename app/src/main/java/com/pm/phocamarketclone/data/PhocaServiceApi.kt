package com.pm.phocamarketclone.data

import com.pm.phocamarketclone.search.data.ResultGetSearch
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path


interface PhocaServiceApi {
    @GET("rest/photocard/list/{page_num}")
    fun get(@Path("page_num") page_num: String): Single<ResultGetSearch>
}