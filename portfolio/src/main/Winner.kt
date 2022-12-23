package main

fun whoWinner(player: Deck, dealer: Deck) :Deck{
    val winPlayer = when {
        player.Scr > dealer.Scr -> player
        player.Scr < dealer.Scr -> dealer
        (player.Card.size - 1) > (dealer.Card.size - 1) -> dealer
        (player.Card.size - 1) < (dealer.Card.size - 1) -> player
        else -> makePlayer("무승부", 0)
    }
    return winPlayer
}