package com.ssp.feature_one.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ssp.core.ImageLoader
import com.ssp.feature_one.data.Post
import com.ssp.feature_one.databinding.ItemPostBinding
import javax.inject.Inject

class PostAdapter @Inject constructor(
    private val imageLoader: ImageLoader
) : RecyclerView.Adapter<PostAdapter.ViewHolder>() {
    var listener: ((Post) -> Unit)? = null

    private val posts: MutableList<Post> = mutableListOf()

    fun setPosts(posts: List<Post>) {
        this.posts.clear()
        this.posts.addAll(posts)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPostBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = posts[position]
        holder.bind(post)
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    inner class ViewHolder(private val binding: ItemPostBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listener?.invoke(posts[position])
                }
            }
        }

        fun bind(post: Post) {
            binding.post = post
            binding.executePendingBindings()

            imageLoader.loadImage(post.thumbnailUrl, binding.ivImage)
        }
    }
}
