package nks.api.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*
import nks.api.retrofit.model.Post
import nks.api.retrofit.repository.Repository

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository=Repository()
        val viewModelFactory=MainViewModelFactory(repository)
        viewModel=ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)


        viewModel.pushPost2(1110,2000,"Nitish Kumar Sonthalia","Android Developer")

        viewModel.myPushResponse2.observe(this, Observer {response->
            if(response.isSuccessful) {
                text.text=response.body().toString()
                Log.d("Response", response.body().toString())
                Log.d("Response", response.code().toString())
                Log.d("Response", response.message())
            }
            else{
                Log.d("Response", response.errorBody().toString())
                Log.d("Response", response.code().toString())

            }
        })



    }
}