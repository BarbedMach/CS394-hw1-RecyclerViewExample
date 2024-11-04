package com.example.rvhomework.datasource

import android.content.Context
import com.example.rvhomework.R
import com.example.rvhomework.data.Stock

class StockSource(private val context: Context) {
    fun getStockNames() : Array<String> = context.resources.getStringArray(R.array.stock_name)
    fun getStockValues() : Array<String> = context.resources.getStringArray(R.array.stock_value)
    fun getStockDeltas() : Array<String> = context.resources.getStringArray(R.array.stock_delta)
    fun getStockDescriptions() : Array<String> = context.resources.getStringArray(R.array.description)

    fun loadStocks() : List<Stock> {
        val stockNames = getStockNames()
        val stockValues = getStockValues()
        val stockDeltas = getStockDeltas()
        val stockDescriptions = getStockDescriptions()

        val stocks = mutableListOf<Stock>()
        for (i in stockNames.indices) {
            stocks.add(Stock((i + 1).toString(), stockNames[i], stockValues[i], stockDeltas[i], stockDescriptions[i]))
        }

        return stocks
    }
}