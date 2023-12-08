package com.example.final_project_team_01_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.final_project_team_01_2.databinding.ApiBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.Path

const val BASE_URL = "https://triviago-ea074-default-rtdb.firebaseio.com/"

interface ApiInterface {
    @GET("/quiz_results/{userId}.json")
    fun getUserResults(@Path("userId") userId: String): Call<UserQuizResults>

    @PATCH("/quiz_results/{userId}.json")
    fun updateUserResults(@Path("userId") userId: String, @Body results: UserQuizResults): Call<Void>
}
interface UpdateCallback {
    fun onUpdateComplete()
}

data class UserQuizResults(
    var correct: Int = 0,
    var incorrect: Int = 0
)

class APIActivity : AppCompatActivity() {

    private lateinit var binding: ApiBinding
    private val apiInterface = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()
        .create(ApiInterface::class.java)
    private var correctCount = 0
    private var incorrectCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ApiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Fetch results if 'shouldFetchResults' is passed as true
        if (intent.getBooleanExtra("shouldFetchResults", false)) {
            getMyData("1") // User ID is set to "1" for all users for now
        }

        binding.btnCorrect.setOnClickListener {
            correctCount++
            updateQuizResults()
        }

        binding.btnIncorrect.setOnClickListener {
            incorrectCount++
            updateQuizResults()
        }
    }

    private fun getMyData(userId: String) {
        apiInterface.getUserResults(userId).enqueue(object : Callback<UserQuizResults> {
            override fun onResponse(call: Call<UserQuizResults>, response: Response<UserQuizResults>) {
                val responseBody = response.body()
                responseBody?.let {
                    correctCount = it.correct
                    incorrectCount = it.incorrect
                    binding.txtId.text = "Correct: ${it.correct}\nIncorrect: ${it.incorrect}"
                } ?: run {
                    binding.txtId.text = "No results found."
                }
            }

            override fun onFailure(call: Call<UserQuizResults>, t: Throwable) {
                Log.d("APIActivity", "Error fetching data: ${t.message}")
            }
        })
    }

    fun updateMyData(userId: String, correct: Int, incorrect: Int, callback: UpdateCallback) {
        val results = UserQuizResults(correct, incorrect)
        apiInterface.updateUserResults(userId, results).enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    callback.onUpdateComplete()
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                Log.d("APIActivity", "Error updating data: ${t.message}")
            }
        })
    }

    private fun updateQuizResults() {
        updateMyData("1", correctCount, incorrectCount, object : UpdateCallback {
            override fun onUpdateComplete() {
                Log.d("APIActivity", "Results updated")
                getMyData("1")
            }
        })
    }
}

