package nks.api.retrofit.repository

import nks.api.retrofit.api.RetrofitInstance
import nks.api.retrofit.model.Post
import retrofit2.Response

class Repository {
    suspend fun getPost(auth:String):Response<Post>{
        return RetrofitInstance.api.getPost(auth)
    }

    suspend fun getPost2(number:Int):Response<Post>{
        return RetrofitInstance.api.getPost2(number)
    }

    suspend fun getCustomPost(userId:Int,sort:String,order:String):Response<List<Post>>{
        return RetrofitInstance.api.getCustomPost(userId,sort,order)
    }

    suspend fun getCustomPost2(userId:Int,options:Map<String,String>):Response<List<Post>>{
        return RetrofitInstance.api.getCustomPost2(userId,options)
    }
    suspend fun pushPost(post: Post): Response<Post>{
        return RetrofitInstance.api.pushPost(post)
    }
}