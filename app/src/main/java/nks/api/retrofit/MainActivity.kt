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
            viewModel.getCustomPost(Integer.parseInt(myNumber))

            viewModel.myCustomPost.observe(this, Observer {response->
                if(response.isSuccessful) {
                    text.text=response.body().toString()
                    response.body()?.forEach{
                        Log.d("Response", it.userId.toString())
                        Log.d("Response", it.id.toString())
                        Log.d("Response", it.title)
                        Log.d("Response", it.body)
                        Log.d("Response", "----------------------")
                    }
                }
                else{
                    Log.d("Response", response.errorBody().toString())
                    Log.d("Response", response.code().toString())

                }
            })
        }


    }
}