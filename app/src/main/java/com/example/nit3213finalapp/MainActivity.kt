package com.example.nit3213finalapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.nit3213finalapp.databinding.ActivityMainBinding
import com.example.nit3213finalapp.network.ApiService
import com.example.nit3213finalapp.network.LoginRequest
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var apiService: ApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.etUsername.setText("Dipen")
        binding.etPassword.setText("s8095318")

        binding.btnLogin.setOnClickListener {
            loginUser()
        }
    }

    private fun loginUser() {
        val username = binding.etUsername.text.toString().trim()
        val password = binding.etPassword.text.toString().trim()

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please enter username and password", Toast.LENGTH_SHORT).show()
            return
        }

        binding.progressBar.visibility = View.VISIBLE

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = apiService.login(LoginRequest(username, password))

                withContext(Dispatchers.Main) {
                    binding.progressBar.visibility = View.GONE

                    if (response.isSuccessful && response.body() != null) {
                        val keypass = response.body()!!.keypass
                        Toast.makeText(this@MainActivity, "Login successful", Toast.LENGTH_SHORT).show()

                        val intent = Intent(this@MainActivity, DashboardActivity::class.java)
                        intent.putExtra("keypass", keypass)
                        startActivity(intent)
                    } else {
                        val errorText = response.errorBody()?.string()
                        Toast.makeText(
                            this@MainActivity,
                            "Login failed: ${response.code()} ${errorText ?: ""}",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(
                        this@MainActivity,
                        "Error: ${e.message}",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }
}