package com.example.perfumes.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import com.example.perfumes.R
import com.example.perfumes.data.database.AppDatabase
import com.example.perfumes.data.database.user.UserRepository
import com.example.perfumes.databinding.ActivityLoginBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    private val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

//        val application = requireNotNull(this.application)
//
//        val dao = AppDatabase.getDatabase(application).userDao
//
//        val repository = UserRepository(dao)
//
//        val factory = UserViewModelFactory(repository, application)

        binding.loginBtn.setOnClickListener {

            val email = binding.etEmail.text.toString().trim { it <= ' ' }
            val password = binding.etPassword.text.toString().trim { it <= ' ' }

            when {

                TextUtils.isEmpty(binding.etEmail.text.toString().trim { it <= ' ' }) -> {

                    Toast.makeText(this, "Please Enter Email", Toast.LENGTH_SHORT).show()
                }

                TextUtils.isEmpty(binding.etPassword.text.toString().trim { it <= ' ' }) -> {

                    Toast.makeText(this, "Please Enter Paswword", Toast.LENGTH_SHORT).show()
                }

                else -> {

//                    if(userViewModel.login(email, password)) {
//
//                        val intent = Intent(this, MainActivity::class.java)
//
//                        startActivity(intent)
//                        finish()
//                    }

                    val intent = Intent(this, MainActivity::class.java)

                    startActivity(intent)
                    finish()


                }

            }

//            val intent = Intent(this, MainActivity::class.java)
//
//            startActivity(intent)
//            finish()
        }
    }
}