fun printMap(map: GameMap, player: Player, monsters: List<Monster>) {
    for (y in 0..< map.height) {
        for (x in 0..< map.width) {
            val hasPlayer = (player.posX == x && player.posY == y)
            val monsterAt = monsters.firstOrNull { it.posX == x && it.posY == y && it.isAlive() }
            val tile = map.tiles[y][x]
            when {
                hasPlayer -> print("P")
                monsterAt != null -> print(monsterAt.symbol)   // <-- hier das Symbol
                tile == TileType.WALL -> print("#")
                tile == TileType.CHEST -> print("C")
                else -> print(".")
            }
        }
        println()
    }

}
fun printPlayerStatus(player: Player) {
    println("=== Player-Status ===")
    println("HP: ${player.health}")
    println("Attack: ${player.attack}")
    println("Defense: ${player.defense}")
    println("Speed: ${player.speed}")
}
fun printMonsterStatus(monsters: List<Monster>) {
    println("--- Monsters-Status ---")
    var found = false
    for (monster in monsters) {
        if (monster.isAlive()) {
            println("${monster.name}: HP ${monster.health}")
            found = true
        }
    }
    if (!found) {
        println("No monsters found.")
    }
    println("-----------------------")
}