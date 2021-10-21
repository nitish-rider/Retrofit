package nks.api.retrofit

import okhttp3.Interceptor
import okhttp3.Response

class MyInterceptor:Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        val request=chain.request()
            .newBuilder()
            .addHeader("content-type","application/json")
            .addHeader("content-num","1110")
            .addHeader("content-type","application/json")
            .build()
        return chain.proceed(request)
    }
}