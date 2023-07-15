package com.ssp.feature_one.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ssp.feature_one.adapter.PostAdapter
import com.ssp.feature_one.databinding.ActivityFeatureOneBinding
import com.ssp.feature_one.di.FeatureOneDaggerProvider
import com.ssp.feature_one.viewmodel.FeatureOneViewModel
import javax.inject.Inject

class FeatureOneActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFeatureOneBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: FeatureOneViewModel by viewModels { viewModelFactory }

    @Inject
    lateinit var adapter: PostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FeatureOneDaggerProvider.component.inject(this)
        binding = ActivityFeatureOneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setAdapter()
        observeViewModel()
        fetchData()
    }

    private fun observeViewModel() {
        viewModel.posts.observe(this) { posts ->
            adapter.setPosts(posts)
        }

        viewModel.progress.observe(this) {
            binding.progress.visibility = if (it) View.VISIBLE else View.GONE
        }
    }

    private fun setAdapter() {
        adapter.listener = {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("post", it)
            startActivity(intent)
        }
        binding.rvPhotos.layoutManager = LinearLayoutManager(this)
        binding.rvPhotos.adapter = adapter
    }

    private fun fetchData() {
        viewModel.fetchPhotos()
    }
}