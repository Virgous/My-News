package com.project.newsapp.ui.article.viewadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.project.newsapp.data.api.response.Article
import com.project.newsapp.databinding.ArticleViewHolderBinding

class ArticleAdapter (private val cellClickListener: ArticleCellClickListener) : PagingDataAdapter<Article, ArticleAdapter.ViewHolder>(ArticleComparator) {

    inner class ViewHolder(val binding: ArticleViewHolderBinding): RecyclerView.ViewHolder(binding.root)

    object ArticleComparator : DiffUtil.ItemCallback<Article>(){
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.equals(newItem)
        }

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article = getItem(position)!!
        holder.binding.apply {
            tvArticleTitle.text = article.title
            tvArticleAuthor.text = article.author
            tvArticleDescription.text = article.description
            btnViewArticle.setOnClickListener {
                cellClickListener.onCellClickListener(article)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ArticleViewHolderBinding.inflate(
                LayoutInflater.from(parent.context), parent,false
            )
        )
    }
}