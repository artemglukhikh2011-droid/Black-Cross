fun playerTurn(map: GameMap, player: Player, monsters: List<Monster>) {
    var movesLeft = player.speed
    while (movesLeft > 0) {
        println("Bewegungen übrig: $movesLeft")
        val input = readLine()?.lowercase() ?: ""
        val dx = when (input) {
            "w", "up" -> 0 to -1
            "s", "down" -> 0 to 1
            "a", "left" -> -1 to 0
            "d", "right" -> 1 to 0
            "q" -> break // Runde beenden
            else -> null
        }
        if (dx != null) {
            val newX = player.posX + dx.first
            val newY = player.posY + dx.second
            if (map.isWalkable(newX, newY)) {
                // Prüfen, ob dort ein Monster ist
                val monster = monsters.find { it.posX == newX && it.posY == newY && it.isAlive() }
                if (monster != null) {
                    // Kampf starten
                    attackWithCounterAttack(player, monster)
                    movesLeft = 0 // Kampf beendet die Bewegung für diese Runde
                } else {
                    // ===== HIER DEN TRUHEN-CODE EINFÜGEN =====
                    if (map.tiles[newY][newX] == TileType.CHEST) {
                        val item = generateRandomItem()
                        println("Du hast eine Truhe geöffnet und ${item.name} gefunden!")
                        applyItem(player, item)
                        map.tiles[newY][newX] = TileType.EMPTY  // Truhe entfernen
                        movesLeft-- // Öffnen kostet einen Bewegungspunkt
                        player.posX = newX
                        player.posY = newY
                    } else {
                        // Normale Bewegung, wenn keine Truhe da ist
                        player.posX = newX
                        player.posY = newY
                        movesLeft--
                    }
                    // ===== ENDE DES TRUHEN-CODES =====
                }
            } else {
                println("Dort ist eine Wand!")
            }
        }
    }
}