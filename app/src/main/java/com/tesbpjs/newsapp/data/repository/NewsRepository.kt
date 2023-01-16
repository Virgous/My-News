package com.tesbpjs.newsapp.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.tesbpjs.newsapp.data.api.response.Article
import com.tesbpjs.newsapp.data.api.response.Source

interface NewsRepository {
    fun getNewsBySourcePaging(source: String): LiveData<PagingData<Article>>

    suspend fun getNewsSourceByCategory(category:String):List<Source>
}