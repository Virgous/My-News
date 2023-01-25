package com.project.newsapp.data.api.response

class NewsResponse (
    val status:String,
    val totalResult:Int,
    val articles:List<Article>
)