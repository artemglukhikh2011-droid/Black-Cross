fun printMap(map: GameMap, player: Player, monsters: List<Monster>) {
    for (y in 0 until map.height) {
        for (x in 0 until map.width) {
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