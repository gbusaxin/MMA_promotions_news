package com.example.mmapromotionsnews.presentation.ui.fixtures

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mmapromotionsnews.databinding.FragmentFixturesBinding
import com.example.mmapromotionsnews.presentation.AppViewModel
import com.example.mmapromotionsnews.presentation.adapters.FixturesAdapter

class FixturesFragment : Fragment() {

    private lateinit var binding: FragmentFixturesBinding
    private lateinit var viewModel: AppViewModel
    private lateinit var adapter: FixturesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this)[AppViewModel::class.java]
        adapter = FixturesAdapter()
        binding = FragmentFixturesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvFixtures = binding.rvFixtures
        val promotion = activity?.intent?.getStringExtra("selectedPromotion") ?: ""
        viewModel.getPromotion(promotion).observe(viewLifecycleOwner, {
            adapter.list = it.fixtures
            rvFixtures.adapter = adapter
        })
    }
}