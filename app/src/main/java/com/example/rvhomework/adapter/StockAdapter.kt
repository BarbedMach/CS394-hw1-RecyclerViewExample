package com.example.rvhomework.adapter

import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rvhomework.data.Stock
import com.example.rvhomework.R
import com.example.rvhomework.StockDetailActivity


class StockAdapter(private val stocks: List<Stock>) : RecyclerView.Adapter<StockAdapter.StockViewHolder>() {
    class StockViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private lateinit var stock: Stock

        val stockIndex: TextView = view.findViewById(R.id.stock_index)
        val stockName: TextView = view.findViewById(R.id.stock_name)
        val stockValue: TextView = view.findViewById(R.id.stock_value)
        val stockDelta: TextView = view.findViewById(R.id.stock_delta)

        init {
            view.setOnClickListener {
                val context = itemView.context
                val showStockDetailIntent = Intent(context, StockDetailActivity::class.java)
                showStockDetailIntent.putExtra(StockDetailActivity.STOCK_NAME, stock.name)
                showStockDetailIntent.putExtra(StockDetailActivity.STOCK_VALUE, stock.value)
                showStockDetailIntent.putExtra(StockDetailActivity.STOCK_DELTA, stock.delta)
                showStockDetailIntent.putExtra(StockDetailActivity.STOCK_DESC, stock.description)

                context.startActivity(showStockDetailIntent)
            }
        }

        fun bind(stock: Stock) {
            this.stock = stock

            stockIndex.text = stock.index
            stockName.text = stock.name
            stockValue.text = stock.value
            stockDelta.text = stock.delta

            when {
                stock.delta.startsWith("-") -> {
                    stockDelta.setTextColor(itemView.resources.getColor(R.color.red))
                }
                stock.delta.startsWith("+") -> {
                    stockDelta.setTextColor(itemView.resources.getColor(R.color.green))
                }
                else -> {
                    stockDelta.setTextColor(itemView.resources.getColor(R.color.black))
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StockViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        return StockViewHolder(view)
    }

    override fun onBindViewHolder(holder: StockViewHolder, position: Int) {
        val stock = stocks[position]
        holder.bind(stock)
    }

    override fun getItemCount(): Int = stocks.size
}