fun main() {
    val map = GameMap(15, 10)
    map.generateRandomMaze()
    placeRandomChests(map, 3)   // 3 Chests place random


    val player = Player(health = 10, attack = 3, defense = 2, speed = 2, posX = 1, posY = 1)
    val occupied = mutableListOf(1 to 1)  // Player Position
    val monsters = mutableListOf<Monster>()

    val goblinPos = findRandomEmptyCell(map, occupied)
    occupied.add(goblinPos)
    monsters.add(Monster.createByName(name = "Goblin", posX = goblinPos.first, posY = goblinPos.second))

    val koboldPos = findRandomEmptyCell(map, occupied)
    occupied.add(koboldPos)
    monsters.add(Monster.createByName(name = "Kobold", posX = koboldPos.first, posY = koboldPos.second))
    val wywernPos = findRandomEmptyCell(map, occupied)
    occupied.add(wywernPos)
    monsters.add(Monster.createByName(name = "Wywern", posX = wywernPos.first, posY = wywernPos.second))
    val items = mutableListOf<Item>() // Items that has a Player

    var round = 0
    while (player.isAlive() && monsters.any { it.isAlive() }) {
        round++
        println("--- Round $round ---")
        printMap(map, player, monsters)

        printPlayerStatus(player)
        printMonsterStatus(monsters)
        printRandomOgureMessage(player)
        applyWyvernPoison(player)   // Potion is working

        // playerturn
        playerTurn(map, player, monsters)

        // monsterturn
        monstersTurn(map, player, monsters)


        monsters.removeAll { !it.isAlive() }



    }

    if (player.isAlive()) println("You won!😊")
    else println("Game over!")
}//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
