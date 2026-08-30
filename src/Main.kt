fun main() {
    val map = GameMap(15, 10)
    map.generateSimpleMaze()

    // Truhen manuell setzen (Koordinaten anpassen)
    map.tiles[2][3] = TileType.CHEST
    map.tiles[5][7] = TileType.CHEST
    map.tiles[8][2] = TileType.CHEST



    val player = Player(health = 10, attack = 3, defense = 2, speed = 2, posX = 1, posY = 1)
    val monsters = mutableListOf(
        Monster("Goblin", health = 5, attack = 4, defense = 1, speed = 1, posX = 7, posY = 5),
        Monster("Ork", health = 8, attack = 6, defense = 2, speed = 1, posX = 10, posY = 3)
    )
    val items = mutableListOf<Item>() // Gegenstände, die der Spieler trägt

    var round = 0
    while (player.isAlive() && monsters.any { it.isAlive() }) {
        round++
        println("--- Runde $round ---")
        printMap(map, player, monsters)

        // Spielerzug
        playerTurn(map, player, monsters)

        // Monsterzüge
        monstersTurn(map, player, monsters)

        // Prüfen, ob alle Monster tot sind
        monsters.removeAll { !it.isAlive() }



    }

    if (player.isAlive()) println("Du hast alle Monster besiegt! Glückwunsch!")
    else println("Du bist gestorben. Spiel vorbei.")
}//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
