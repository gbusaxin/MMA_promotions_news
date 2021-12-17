package com.example.mmapromotionsnews.presentation.ui.mian_info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mmapromotionsnews.databinding.FragmentInfoBinding
import com.example.mmapromotionsnews.presentation.AppViewModel
import com.squareup.picasso.Picasso

class InfoFragment : Fragment() {

    private lateinit var binding: FragmentInfoBinding
    private lateinit var viewModel: AppViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this)[AppViewModel::class.java]
        binding = FragmentInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val promotionImage = binding.imageInfoPromotion
        val promotionName = binding.textInfoPromotion
        val promotionBoss = binding.textInfoBoss
        val promotionAbout = binding.textInfoPoromotionAbout
        val promotionRules = binding.textInfoPoromotionRules

        val promotion = activity?.intent?.getStringExtra("selectedPromotion")?:""
        viewModel.getPromotion(promotion).observe(viewLifecycleOwner,{
            Picasso.get().load(it.image).into(promotionImage)
            promotionName.text = it.promotion
            promotionBoss.text = it.boss
            promotionAbout.text = it.about
            promotionRules.text = it.rules
        })
    }

}