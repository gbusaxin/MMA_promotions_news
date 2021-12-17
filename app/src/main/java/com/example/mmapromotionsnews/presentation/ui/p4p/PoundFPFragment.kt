package com.example.mmapromotionsnews.presentation.ui.p4p

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mmapromotionsnews.R
import com.example.mmapromotionsnews.databinding.FragmentPoundFPBinding
import com.example.mmapromotionsnews.presentation.AppViewModel
import com.example.mmapromotionsnews.presentation.adapters.Pound4PAdapter


class PoundFPFragment : Fragment() {

    private lateinit var viewModel:AppViewModel
    private lateinit var adapter: Pound4PAdapter
    private lateinit var binding:FragmentPoundFPBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this)[AppViewModel::class.java]
        adapter = Pound4PAdapter()
        binding = FragmentPoundFPBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val promotion = activity?.intent?.getStringExtra("selectedPromotion")?:""
        viewModel.getPromotion(promotion).observe(viewLifecycleOwner,{
            adapter.list = it.p4p
            binding.rvP4p.adapter = adapter
        })
    }

}