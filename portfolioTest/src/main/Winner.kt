package main

fun whoWinner(player: Player, dealer: Player) :Player{
    val winPlayer = when {
        player.deck[0].Scr > dealer.deck[0].Scr -> player
        player.deck[0].Scr < dealer.deck[0].Scr -> dealer
        (player.deck[0].Card.size - 1) > (dealer.deck[0].Card.size - 1) -> dealer
        (player.deck[0].Card.size - 1) < (dealer.deck[0].Card.size - 1) -> player
        else -> makePlayer("무승부", 0)
    }
    return winPlayer
}