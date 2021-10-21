package nks.api.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*
import nks.api.retrofit.repository.Repository

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository=Repository()
        val viewModelFactory=MainViewModelFactory(repository)
        viewModel=ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)


        button.setOnClickListener {
            val myNumber=number_editText.text.toString()
            viewModel.getPost2(Integer.parseInt(myNumber))

            viewModel.myResponse2.observe(this, Observer {response->
                if(response.isSuccessful) {
                    Log.d("Response", response.body()?.userId.toString())
                    Log.d("Response", response.body()?.id.toString())
                    Log.d("Response", response.body()?.title!!)
                    Log.d("Response", response.body()?.body!!)
                    text.text=response.body().toString()
                }
                else{
                    Log.d("Response", response.errorBody().toString())
                    Log.d("Response", response.code().toString())

                }
            })
        }


    }
}