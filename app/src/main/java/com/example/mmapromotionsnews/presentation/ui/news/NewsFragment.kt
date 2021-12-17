package com.example.mmapromotionsnews.presentation.ui.news

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mmapromotionsnews.databinding.FragmentNewsBinding
import com.example.mmapromotionsnews.presentation.NewsViewModel
import com.example.mmapromotionsnews.presentation.adapters.NewsAdapter


class NewsFragment : Fragment() {

    private lateinit var binding : FragmentNewsBinding
    private lateinit var viewModel: NewsViewModel
    private lateinit var adapter:NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this)[NewsViewModel::class.java]
        adapter = NewsAdapter()
        binding = FragmentNewsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.news.observe(viewLifecycleOwner,{
            adapter.list = it
            val rvNews = binding.rvNews
            rvNews.adapter = adapter
        })
    }
}