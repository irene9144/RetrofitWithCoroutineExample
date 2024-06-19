package com.example.coroutineexample2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coroutineexample2.databinding.MyItemBinding
import com.example.coroutineexample2.model.Company

class CompanyAdapter(private var companies: List<Company>) :
    RecyclerView.Adapter<CompanyAdapter.CompanyViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CompanyAdapter.CompanyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = MyItemBinding.inflate(layoutInflater)
        return CompanyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return companies.size
    }

    fun setList(newList: List<Company>) {
        companies = newList
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: CompanyViewHolder, position: Int) {
        holder.bind(companies[position])
    }

    inner class CompanyViewHolder(private val binding: MyItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Company) {
            binding.tvId.text = item.companyId.toString()
            binding.tvName.text = item.name
            //binding.tvDescription.text = item.description
        }
    }
}