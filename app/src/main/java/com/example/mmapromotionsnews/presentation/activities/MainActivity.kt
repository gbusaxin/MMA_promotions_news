package com.example.mmapromotionsnews.presentation.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.mmapromotionsnews.databinding.ActivityMainBinding
import com.example.mmapromotionsnews.domain.pojo.PromotionItem
import com.example.mmapromotionsnews.presentation.AppViewModel
import com.example.mmapromotionsnews.presentation.adapters.PromotionAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: AppViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: PromotionAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val rvPromotion = binding.rvPromotion
        val svPromotion = binding.svPromotion

        viewModel = ViewModelProvider(this)[AppViewModel::class.java]

        viewModel.promotionList.observe(this, { it ->
            adapter = PromotionAdapter(it as ArrayList<PromotionItem>)
            rvPromotion.adapter = adapter
            adapter.onPromotionClickListener = {
                val intent = Intent(this@MainActivity, PromoNavigationActivity::class.java)
                val selectedPromotion = it.promotion
                intent.putExtra("selectedPromotion", selectedPromotion)
                startActivity(intent)
            }
        })

        svPromotion.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                adapter.filter.filter(p0)
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                return false
            }

        })
    }
}