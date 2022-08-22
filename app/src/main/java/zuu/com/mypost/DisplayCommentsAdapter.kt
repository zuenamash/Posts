package zuu.com.mypost

import android.view.LayoutInflater
import  android.os.Bundle
import  androidx.appcompat.app.AppCompatActivity
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import zuu.com.mypost.databinding.DisplaycomentBinding


class DisplayCommentsAdapter(var commentList:List<Comment>): RecyclerView.Adapter<CommentViewHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
            var binding=DisplaycomentBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            return CommentViewHolder(binding)
}


    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        var currentComment = commentList.get(position)

        with(holder.binding) {
            tvName.text = currentComment.username.toString()
            tvIdNo.text = currentComment.id.toString()
            tvTxtTittle.text = currentComment.email
            tvTextBody.text = currentComment.body

        }
    }
    override fun getItemCount():Int{
        return  commentList.size

        }}
class CommentViewHolder(var binding: DisplaycomentBinding):RecyclerView.ViewHolder(binding.root)

