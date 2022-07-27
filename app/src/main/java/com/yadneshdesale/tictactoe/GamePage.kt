package com.yadneshdesale.tictactoe

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.GridLayout
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class GamePage : AppCompatActivity() {
    var t = 1
    var k = 0

    private fun isWon():Boolean
    {
        val b1:Button = findViewById(R.id.b00)
        val b2:Button = findViewById(R.id.b01)
        val b3:Button = findViewById(R.id.b02)
        val b4:Button = findViewById(R.id.b10)
        val b5:Button = findViewById(R.id.b11)
        val b6:Button = findViewById(R.id.b12)
        val b7:Button = findViewById(R.id.b20)
        val b8:Button = findViewById(R.id.b21)
        val b9:Button = findViewById(R.id.b22)


        if(b1.text == b2.text && b2.text == b3.text&& b1.text != "")
        {
            b1.isEnabled = false; b2.isEnabled = false; b3.isEnabled = false; b4.isEnabled = false
            b5.isEnabled = false; b6.isEnabled = false; b7.isEnabled = false; b8.isEnabled = false
            b9.isEnabled = false; return true
        }
        else if(b4.text == b5.text && b5.text == b6.text && b4.text != "")
        {
            b1.isEnabled = false; b2.isEnabled = false; b3.isEnabled = false; b4.isEnabled = false
            b5.isEnabled = false; b6.isEnabled = false; b7.isEnabled = false; b8.isEnabled = false
            b9.isEnabled = false; return true;  }
        else if(b7.text == b8.text && b8.text == b9.text && b7.text != "") {
            b1.isEnabled = false; b2.isEnabled = false; b3.isEnabled = false; b4.isEnabled = false
            b5.isEnabled = false; b6.isEnabled = false; b7.isEnabled = false; b8.isEnabled = false
            b9.isEnabled = false; return true;  }

        else if(b1.text == b4.text && b4.text == b7.text && b1.text != "")
        {
            b1.isEnabled = false; b2.isEnabled = false; b3.isEnabled = false; b4.isEnabled = false
            b5.isEnabled = false; b6.isEnabled = false; b7.isEnabled = false; b8.isEnabled = false
            b9.isEnabled = false; return true;  }
        else if(b2.text == b5.text && b5.text == b8.text && b2.text!= "") {
            b1.isEnabled = false; b2.isEnabled = false; b3.isEnabled = false; b4.isEnabled = false
            b5.isEnabled = false; b6.isEnabled = false; b7.isEnabled = false; b8.isEnabled = false
            b9.isEnabled = false; return true;  }
        else if(b3.text == b6.text && b6.text == b9.text && b3.text!= "") {
            b1.isEnabled = false; b2.isEnabled = false; b3.isEnabled = false; b4.isEnabled = false
            b5.isEnabled = false; b6.isEnabled = false; b7.isEnabled = false; b8.isEnabled = false
            b9.isEnabled = false; return true;  }
        else if(b1.text == b5.text && b5.text == b9.text&& b1.text!="") {
            b1.isEnabled = false; b2.isEnabled = false; b3.isEnabled = false; b4.isEnabled = false
            b5.isEnabled = false; b6.isEnabled = false; b7.isEnabled = false; b8.isEnabled = false
            b9.isEnabled = false; return true;  }
        else if(b3.text == b5.text && b5.text == b7.text && b3.text!="") {
            b1.isEnabled = false; b2.isEnabled = false; b3.isEnabled = false; b4.isEnabled = false
            b5.isEnabled = false; b6.isEnabled = false; b7.isEnabled = false; b8.isEnabled = false
            b9.isEnabled = false; return true;  }
        return false
    }

    fun afterButtonClicked(v: View) {
        val b: Button = v as Button
        b.isEnabled = false
        b.text = "O"
        var flag:Boolean = false

        val plyr1: TextView = findViewById(R.id.p1)
        val plyr2: TextView = findViewById(R.id.p2)
        val oSym: TextView = findViewById(R.id.o_symbol)
        val xSym: TextView = findViewById(R.id.x_symbol)

        if (t == 1) {
            b.text = "O"
            t = 2
            plyr1.textSize = 30F
            plyr1.setTextColor(Color.parseColor("#AFC8FA"))
            oSym.textSize = 50F
            oSym.setTextColor(Color.parseColor("#AFC8FA"))

            plyr2.textSize = 36F
            plyr2.setTextColor(Color.parseColor("#6CDD0A"))
            xSym.textSize = 56F
            xSym.setTextColor(Color.parseColor("#6CDD0A"))
            k++

            if(isWon())
            {
                flag = true
                intent = Intent(this, WinnerPage::class.java )
                intent.putExtra("name", plyr1.text)
                startActivity(intent)
            }

        } else {
            b.text = "X"
            t = 1

            plyr2.textSize = 30F
            plyr2.setTextColor(Color.parseColor("#AFC8FA"))
            xSym.textSize = 50F
            xSym.setTextColor(Color.parseColor("#AFC8FA"))

            plyr1.textSize = 36F
            plyr1.setTextColor(Color.parseColor("#6CDD0A"))
            oSym.textSize = 56F
            oSym.setTextColor(Color.parseColor("#6CDD0A"))
            k++

            if(isWon())
            {
                flag = true
                intent = Intent(this, WinnerPage::class.java)
                intent.putExtra("name", plyr2.text)
                startActivity(intent)
            }
        }

        if(!flag) {
            if (k == 9) {
                val intent = Intent(this, drawPage::class.java)
                startActivity(intent)
            }
        }
    }


    private fun startGame(plyr1:TextView, plyr2:TextView, xSym:TextView, oSym:TextView, grid:GridLayout)
    {
        if(t == 1) {
            plyr1.textSize = 36F
            plyr1.setTextColor(Color.parseColor("#6CDD0A"))
            oSym.textSize = 56F
            oSym.setTextColor(Color.parseColor("#6CDD0A"))
        }
        else
        {
            plyr2.textSize = 36F
            plyr2.setTextColor(Color.parseColor("#6CDD0A"))
            xSym.textSize = 56F
            xSym.setTextColor(Color.parseColor("#6CDD0A"))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_page)

        val bundle: Bundle? = intent.extras
        val p1Name = bundle?.get("player1Name")
        val p2Name = bundle?.get("player2Name")

        val player1:TextView = findViewById(R.id.p1)
        val player2:TextView = findViewById(R.id.p2)

        val xSymbol: TextView = findViewById(R.id.x_symbol)
        val oSymbol: TextView = findViewById(R.id.o_symbol)


        player1.text = p1Name.toString()
        player2.text = p2Name.toString()

        val grid:GridLayout = findViewById(R.id.game_grid)

        startGame(player1, player2, xSymbol, oSymbol, grid)


        val bundle1:Bundle?=intent.extras
        val exit = bundle?.get("Exit")

        if(exit == 1) finish()
    }
}