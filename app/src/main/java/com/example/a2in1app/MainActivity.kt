package com.example.a2in1app

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var numbersGameButton: Button
    private lateinit var guessThePhraseButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numbersGameButton = findViewById(R.id.btNumbersGame)
        numbersGameButton.setOnClickListener { startGame(activity_numbers_game()) }
        guessThePhraseButton = findViewById(R.id.btGuessThePhrase)
        guessThePhraseButton.setOnClickListener { startGame(activity_guess_the_phrase()) }

        title = "Main Activity"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.mi_numbers_game -> {
                startGame(activity_numbers_game())
                return true
            }
            R.id.mi_guess_the_phrase -> {
                startGame(activity_guess_the_phrase())
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun startGame(activity: Activity){
        val intent = Intent(this, activity::class.java)
        startActivity(intent)
    }
}