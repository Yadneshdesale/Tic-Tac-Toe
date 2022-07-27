package com.yadneshdesale.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class drawPage : AppCompatActivity() {

    override fun onBackPressed() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_draw_page)

        val restart: Button = findViewById(R.id.button)
        restart.setOnClickListener{
            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val exit: Button = findViewById(R.id.button2)

        exit.setOnClickListener{
            intent = Intent(this, GamePage::class.java)
            intent.putExtra("Exit", 1)
            startActivity(intent)

            finishAffinity()
        }
    }
}