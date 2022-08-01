package zuu.com.mypost

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

private lateinit var linearLayoutManager: LinearLayoutManager
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        linearLayoutManager = LinearLayoutManager(this)
//        RecyclerView.layoutManager = linearLayoutManager

        fetchPost()
    }
    fun fetchPost(){
        val ApiClient = ApiClient.buildApiClient(ApiInterface::class.java)
        val request = ApiClient.getPosts()

        request.enqueue(object: Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful) {
                    var posts = response.body()
                    Toast.makeText(baseContext, "fetched ${posts!!.size} posts", Toast.LENGTH_LONG)
                        .show()

                    binding.rvAdapter.layoutManager= LinearLayoutManager(baseContext)
                    binding.rvAdapter.adapter= Recyler_Adapter1(post)
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
            }

        })}}




