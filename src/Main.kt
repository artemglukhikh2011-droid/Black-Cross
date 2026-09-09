fun main() {
    val map = GameMap(15, 10)
    map.generateRandomMaze()
    placeRandomChests(map, 3)   // 3 Truhen zufällig platzieren


    val player = Player(health = 10, attack = 3, defense = 2, speed = 2, posX = 1, posY = 1)
    val occupied = mutableListOf(1 to 1)  // Spielerposition (bereits besetzt)
    val monsters = mutableListOf<Monster>()

    val goblinPos = findRandomEmptyCell(map, occupied)
    occupied.add(goblinPos)
    monsters.add(Monster.createByName(name = "Goblin", posX = goblinPos.first, posY = goblinPos.second))

    val koboldPos = findRandomEmptyCell(map, occupied)
    occupied.add(koboldPos)
    monsters.add(Monster.createByName(name = "Kobold", posX = koboldPos.first, posY = koboldPos.second))
    val items = mutableListOf<Item>() // Gegenstände, die der Spieler trägt

    var round = 0
    while (player.isAlive() && monsters.any { it.isAlive() }) {
        round++
        println("--- Runde $round ---")
        printMap(map, player, monsters)

        printPlayerStatus(player)
        printMonsterStatus(monsters)
        printRandomOgureMessage(player)

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
