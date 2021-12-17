package com.example.mmapromotionsnews.presentation.ui.results

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mmapromotionsnews.databinding.FragmentResultBinding
import com.example.mmapromotionsnews.presentation.AppViewModel
import com.example.mmapromotionsnews.presentation.adapters.ResultAdapter

class ResultFragment : Fragment() {

    private lateinit var adapter: ResultAdapter
    private lateinit var viewModel: AppViewModel
    private lateinit var binding: FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        adapter = ResultAdapter()
        viewModel = ViewModelProvider(this)[AppViewModel::class.java]
        binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val promotion = activity?.intent?.getStringExtra("selectedPromotion") ?: ""
        val rvResult = binding.rvResult
        viewModel.getPromotion(promotion).observe(viewLifecycleOwner, {
            adapter.list = it.results
            rvResult.adapter = adapter
        })
    }

}