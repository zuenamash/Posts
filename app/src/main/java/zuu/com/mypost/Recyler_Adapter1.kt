package zuu.com.mypost

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import zuu.com.mypost.databinding.RecyclerPostBinding
import kotlin.coroutines.Continuation

class Recyler_Adapter1 (var postList:List<Post>): RecyclerView.Adapter<PostViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
//            Here we are instanciating .
        var binding =
            RecyclerPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding)
//            return the instatiation
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
//            Here we are displying our post
        var currentPost = postList.get(position)
        with(holder.binding) {
            tvHeadName.text = currentPost.username.toString()
            tvIdNoo.text = currentPost.id.toString()
            tvTittle.text = currentPost.title
            tvBody.text = currentPost.body

//                Continuation of how to display a post in an new activity

            var context = holder.itemView.context
            cvPost.setOnClickListener {
                val intent = Intent(context, ComentActivity::class.java)
                intent.putExtra("POST_ID", currentPost.id)
                context.startActivity(intent)
            }
        }
    }
        override fun getItemCount(): Int {
            return postList.size
        }
    }

    class PostViewHolder(var binding:RecyclerPostBinding):
        RecyclerView.ViewHolder(binding.root)


//doing null check
//        if (post!=null){
//            display (posts)
//        }




