package com.yadneshdesale.tictactoe

import android.app.Application
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class WinnerPage : AppCompatActivity() {

    override fun onBackPressed() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_winner_page)

        val bundle: Bundle? = intent.extras
        val name = bundle?.get("name")

        val tView: TextView = findViewById(R.id.congrats_message)
        "Congratulations $name".also { tView.text = it }


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
