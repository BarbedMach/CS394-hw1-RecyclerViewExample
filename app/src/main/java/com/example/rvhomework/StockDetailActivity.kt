package com.example.rvhomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.rvhomework.databinding.ActivityStockDetailBinding

class StockDetailActivity : AppCompatActivity() {
    companion object {
        const val STOCK_NAME = "stock_name"
        const val STOCK_VALUE = "stock_value"
        const val STOCK_DELTA = "stock_delta"
        const val STOCK_DESC = "stock_desc"
        const val STOCK_DELTA_COLOR: Int = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityStockDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_stock_detail)

        val stockName = intent.getStringExtra(STOCK_NAME)
        val stockValue = intent.getStringExtra(STOCK_VALUE)
        val stockDelta = intent.getStringExtra(STOCK_DELTA)
        val stockDesc = intent.getStringExtra(STOCK_DESC)

        binding.stockNameView.text = stockName
        binding.stockValueView.text = stockValue
        binding.stockDeltaView.text = stockDelta
        binding.stockDescView.text = stockDesc

        ViewCompat.setOnApplyWindowInsetsListener(binding.stockDetailMain) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}