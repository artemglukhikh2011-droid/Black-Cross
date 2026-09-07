fun main() {
    val map = GameMap(15, 10)
    map.generateRandomMaze()
    placeRandomChests(map, 3)   // 3 Truhen zufällig platzieren


    val player = Player(health = 10, attack = 3, defense = 2, speed = 2, posX = 1, posY = 1)
    val monsters = mutableListOf<Monster>()
    val goblinPos = findRandomEmptyCell(map)
    monsters.add(Monster("Goblin", 5, 4, 1, 1, goblinPos.first, goblinPos.second ))
    val goblin2Pos = findRandomEmptyCell(map)
    monsters.add(Monster("Goblin", 5, 4, 1, 1, goblin2Pos.first, goblin2Pos.second))
    // Kobold – kann durch Wände gehen
    val koboldPos = findRandomEmptyCell(map)
    monsters.add(Monster(name = "Kobold", health = 6, attack = 4, defense = 1, speed = 2, posX = koboldPos.first, posY = koboldPos.second, canPassWalls =true ))



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
