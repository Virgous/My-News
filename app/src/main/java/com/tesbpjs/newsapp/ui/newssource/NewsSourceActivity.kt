package com.tesbpjs.newsapp.ui.newssource

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.tesbpjs.newsapp.R
import com.tesbpjs.newsapp.data.api.response.Source
import com.tesbpjs.newsapp.data.repository.NewsRepository
import com.tesbpjs.newsapp.data.repository.NewsRepositoryImpl
import com.tesbpjs.newsapp.databinding.ActivityNewsSourceBinding
import com.tesbpjs.newsapp.ui.article.ArticleActivity
import com.tesbpjs.newsapp.ui.newssource.viewadapter.NewsSourceCellClickListener
import com.tesbpjs.newsapp.ui.newssource.viewadapter.NewsSourceViewAdapter

class NewsSourceActivity : AppCompatActivity(),NewsSourceCellClickListener {
    private lateinit var newsRepository: NewsRepository
    private lateinit var viewModel: NewsSourceViewModel
    private val adapter = NewsSourceViewAdapter(this)
    private lateinit var binding: ActivityNewsSourceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_news_source)
        binding = ActivityNewsSourceBinding.inflate(layoutInflater)
        binding.apply {
            rvSources.layoutManager = LinearLayoutManager(this@NewsSourceActivity)
            rvSources.adapter = adapter
        }

        setContentView(binding.root)
        newsRepository = NewsRepositoryImpl()
        viewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T:ViewModel> create(modelClass: Class<T>): T{
                return NewsSourceViewModel(newsRepository) as T
            }
        })[NewsSourceViewModel::class.java]
        subscribe()
    }

    private fun subscribe() {
        intent.getStringExtra("category")?.let{
            source->
            viewModel.sources.observe(this@NewsSourceActivity){
                it?.let {
                    adapter.submitData(it)
                    adapter.notifyDataSetChanged()
                }
            }
            viewModel.getNewsSourceByCategory(source)
        }
    }

    override fun onCellClickListener(data: Source) {
        val i = Intent(this@NewsSourceActivity, ArticleActivity::class.java)
        i.putExtra("sourceId",data.id)
        startActivity(i)
    }
}