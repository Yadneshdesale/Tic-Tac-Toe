package com.yadneshdesale.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val p1Name:EditText = findViewById(R.id.Name_player1)
        val p2Name:EditText = findViewById(R.id.Name_player2)

        p1Name.setSelection(p1Name.getText().length);
        p2Name.setSelection(p2Name.getText().length);

        val startButton: Button = findViewById(R.id.start)

        startButton.setOnClickListener{

            if(p1Name.text.isNotEmpty() && p2Name.text.isNotEmpty())
            {
                intent = Intent(this, GamePage::class.java)
                intent.putExtra("player1Name", p1Name.text)
                intent.putExtra("player2Name", p2Name.text)
                startActivity(intent)
            }
            if(p1Name.text.isEmpty() && p2Name.text.isEmpty())
            {
                Toast.makeText(this, "Provide names of players", Toast.LENGTH_SHORT).show()
            }
            else if(p1Name.text.isEmpty())
            {
                Toast.makeText(this, "Provide name of player1", Toast.LENGTH_SHORT).show()
            }
            else if(p2Name.text.isEmpty())
            {
                Toast.makeText(this, "Provide name of player2", Toast.LENGTH_SHORT).show()
            }

        }
    }

}