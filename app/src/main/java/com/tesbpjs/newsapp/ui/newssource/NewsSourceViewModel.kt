package com.tesbpjs.newsapp.ui.newssource

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tesbpjs.newsapp.data.api.response.Source
import com.tesbpjs.newsapp.data.repository.NewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsSourceViewModel(private val newsRepository: NewsRepository):ViewModel() {
    private val _sources = MutableLiveData<List<Source>>()

    val sources: LiveData<List<Source>> get() = _sources

    fun getNewsSourceByCategory(category:String){
        viewModelScope.launch(Dispatchers.IO){
            _sources.postValue(
                newsRepository.getNewsSourceByCategory(category)
            )
        }
    }
}