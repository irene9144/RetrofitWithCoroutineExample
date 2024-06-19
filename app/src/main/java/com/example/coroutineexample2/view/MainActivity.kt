package com.example.coroutineexample2.view

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coroutineexample2.adapter.CompanyAdapter
import com.example.coroutineexample2.api.RetrofitInstance
import com.example.coroutineexample2.databinding.ActivityMainBinding
import com.example.coroutineexample2.viewmodel.MainRepository
import com.example.coroutineexample2.viewmodel.MainViewModel
import com.example.coroutineexample2.viewmodel.MyViewModelFactory
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels {
        MyViewModelFactory(MainRepository(RetrofitInstance.getInstance()))
    }
    private lateinit var adapter: CompanyAdapter
    var gson = Gson()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)


        viewModel.companyList.observe(this, Observer { companyList ->
            Log.e("smkwon","companyList -- > $companyList")
//            val type = object: TypeToken<List<Company>>(){}.type
//            val after_json_saved = gson.fromJson<List<Company>>(companyList as String, type)
//           // binding.recyclerView.adapter = CompanyAdapter(companyList as List<Company>)
//            Log.e("smkwon","after_json_saved -- > $after_json_saved")

            binding.recyclerView.adapter = CompanyAdapter(companyList)
        })

    }

}