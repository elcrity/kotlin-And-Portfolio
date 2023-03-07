package com.example.blackjack

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.blackjack.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import java.util.*


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()

        }
//        val manager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
//        blackJack()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}

fun blackJack() {
    val deck = Deck()
    deck.cards.shuffle()

    val playerCards = Player("p1")
    val dealerCards = Player("딜러")

    // 플레이어가 카드 2장을 뽑음
    repeat(2) {
        playerCards.drawCard(deck)
    }
    // 딜러가 카드 2장을 뽑음
    repeat(2) {
        dealerCards.drawCard(deck)
    }


    playerCards.showCards()
    playerCards.showScore()
    dealerCards.showCards(false)
    // 플레이어가 카드를 계속 뽑거나 그만둘 때까지 반복
    while (true) {
        Log.i("info", "카드를 더 받으시겠습니까? (Y/N)")
        val input = readLine()?.uppercase(Locale.getDefault())
        if (input == "Y") {
            println("드로우한 카드는 ${deck.cards[0]}")
            playerCards.drawCard(deck)
            playerCards.showCards()
            playerCards.showScore()
            if (playerCards.getScore() > 21) {
                println("21점을 초과했습니다. 딜러의 승리입니다.")
                return
            }
        } else {
            break
        }
    }

    // 딜러가 17점 이상이 될 때까지 카드를 계속 뽑음
    while (dealerCards.getScore() < 16) {
        println("드로우한 카드는 ${deck.cards[0]}")
        dealerCards.drawCard(deck)
        dealerCards.showScore()
        dealerCards.showCards()
        if (dealerCards.getScore() > 21) {
            println("딜러가 21점을 초과했습니다. 플레이어의 승리입니다.")
            return
        }
    }

    val playerValue = playerCards.getScore()
    val dealerValue = dealerCards.getScore()
    dealerCards.showCards()
    dealerCards.showScore()
    when {
        playerValue > dealerValue -> println("플레이어의 승리입니다.")
        dealerValue > playerValue -> println("딜러의 승리입니다.")
        else -> println("무승부입니다.")
    }
}