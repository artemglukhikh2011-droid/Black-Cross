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
    // Statusausgabe wie gehabt ...
}
fun printPlayerStatus(player: Player) {
    println("=== Spieler-Status ===")
    println("Leben: ${player.health}")
    println("Angriff: ${player.attack}")
    println("Schutz: ${player.defense}")
    println("Geschwindigkeit: ${player.speed}")
}
fun printMonsterStatus(monsters: List<Monster>) {
    println("--- Lebende Monster ---")
    var found = false
    for (monster in monsters) {
        if (monster.isAlive()) {
            println("${monster.name}: Leben ${monster.health}")
            found = true
        }
    }
    if (!found) {
        println("Keine Monster mehr am Leben.")
    }
    println("-----------------------")
}