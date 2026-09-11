fun applyWyvernPoison(player: Player) {
    if (player.wyvernPoisonTurns > 0) {
        player.health -= 1
        player.wyvernPoisonTurns--
        println("The wyvern's poison takes effect! You lose 1 life. Remaining poison turns:: ${player.wyvernPoisonTurns}")
    }
}