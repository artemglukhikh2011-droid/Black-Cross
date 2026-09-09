fun printRandomOgureMessage(player: Player) {
    if (!player.hasOguresmalldragon) return

    val messages = listOf(
        "Gib mir eine Bon-Bon!!!",
        "Ogure hat Angst!!!!!",
        "Ku-Ku"
    )
    println("Oguresmalldragon: ${messages.random()}")
}