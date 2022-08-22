package zuu.com.mypost

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import retrofit2.Callback
import retrofit2.Call
import retrofit2.Response
import zuu.com.mypost.databinding.ActivityComentBinding

class ComentActivity : AppCompatActivity() {
    var postId = 0
    var commentId=0
    lateinit var binding: ActivityComentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        obtainPostId()
        fetchPostById()
        fetchComments()
        setupToolbar()
        viewComments()
        commentPostId()
    }
    fun obtainPostId (){
        postId = intent.extras?.getInt("POST_ID")?:0
    }
    fun commentPostId (){
        commentId=intent.extras?.getInt("POST_ID")?:0
    }
    fun viewComments(){
        val extras =intent
        postId=extras.getIntExtra("POST_ID",0)
    }
    fun fetchPostById() {
    val apiClient = ApiClient.buildApiClient(ApiInterface::class.java)
    val request = apiClient.getPostById(postId)
    request.enqueue(object : Callback<Post> {
        override fun onResponse(call: Call<Post>, response: Response<Post>) {
            if (response.isSuccessful) {
                val post = response.body()
                binding.tvPostHeader.text = post?.title
                binding.tvPostBody.text = post?.body
            }
        }
        override fun onFailure(call: Call<Post>, t: Throwable) {
            Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
        }
    })
}
    fun setupToolbar(){
            setSupportActionBar(binding.tlNewPost)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setDisplayHomeAsUpEnabled(false)
        }

    fun fetchComments() {
        val apiClient = ApiClient.buildApiClient(ApiInterface::class.java)
        val request = apiClient.getComments(postId)

        request.enqueue(object : Callback<List<Comment>> {
            override fun onResponse(call: Call<List<Comment>>, response: Response<List<Comment>>) {
                if (response.isSuccessful) {
                    val comment = response.body()?: emptyList()
                   displayComment(comment)
                }
            }
            override fun onFailure(call: Call<List<Comment>>, t: Throwable) {
                Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
            }
        })
    }
    fun displayComment(commentList: List<Comment>) {
    val adapter = DisplayCommentsAdapter(commentList)
    binding.rvCommentsDisplay.layoutManager = LinearLayoutManager(this)
    binding.rvCommentsDisplay.adapter = adapter
}
}