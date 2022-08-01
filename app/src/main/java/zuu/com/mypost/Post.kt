package zuu.com.mypost

import android.icu.text.CaseMap

data class Post(
    var Username:Int,
    var id:Int,
    var title: String,
    var body:String
)

data class Comment(
    var username:Int,
    var id:Int,
    var name:String,
    var email:String,
    var body:String
)

