package zuu.com.mypost

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import zuu.com.mypost.databinding.RecyclerPostBinding

class Recyler_Adapter1 (var PostList:List<Post>): RecyclerView.Adapter<Recyler_Adapter1.PostViewHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
            var binding=RecyclerPostBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            return PostViewHolder(binding)
        }

        override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
            var currentPost=PostList.get(position)
            with(holder.binding){
                tvUsername.text=currentPost.Username.toString()
                tvId.text=currentPost.id.toString()
                tvTittle.text=currentPost.title
                tvBody.text=currentPost.body

            }

        }

        override fun getItemCount(): Int {
            return PostList.size
        }

    class PostViewHolder(var binding:Recyler_Adapter1.PostViewHolder):
        RecyclerView.ViewHolder(binding.root)

//    class PostViewHolder (var binding:)
//    RecyclerView.ViewHolder(binding.root)}


