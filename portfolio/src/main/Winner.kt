package BlackJack

fun winPrize(deck: Deck, cost:Int){
    deck.Budjet += cost*2
}


fun betMoney(player:Deck,cost:Int) {
    player.Budjet -= cost
}

fun whoWinner(player: Deck, dealer: Deck) :Deck{
   val win = when {
        player.Scr > dealer.Scr -> player
        player.Scr < dealer.Scr -> dealer
        else -> if (player.Card.size - 1 > dealer.Card.size - 1)
            dealer
        else
            player
    }
    return win
}