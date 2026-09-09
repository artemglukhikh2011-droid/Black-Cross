fun monstersTurn(map: GameMap, player: Player, monsters: MutableList<Monster>) {
    for (monster in monsters) {
        if (!monster.isAlive()) continue

        // Distanz zum Spieler bestimmen
        val dx = player.posX - monster.posX
        val dy = player.posY - monster.posY

        if (kotlin.math.abs(dx) + kotlin.math.abs(dy) == 1) {
            // Benachbart -> Angriff
            attackWithCounterAttack(monster, player)
        } else {
            // Bewegung: einen Schritt in Richtung Spieler (einfach)
            val stepX = if (dx > 0) 1 else if (dx < 0) -1 else 0
            val stepY = if (dy > 0) 1 else if (dy < 0) -1 else 0
            // Zuerst versuchen, horizontal oder vertikal zu gehen
            // Prüfen, ob das Monster auf das Zielfeld ziehen darf
            fun canMoveTo(x: Int, y: Int): Boolean {
                // Immer innerhalb der Karte?
                if (x < 0 || y < 0 || x >= map.width || y >= map.height) return false
                // Wenn das Monster durch Wände gehen kann, ist jedes Feld erlaubt
                if (monster.canPassWalls) return true
                // Sonst normales begehbares Feld (keine Wand)
                return map.isWalkable(x, y)
            }

// Bewegung versuchen
            if (stepX != 0 && canMoveTo(monster.posX + stepX, monster.posY)) {
                monster.posX += stepX
            } else if (stepY != 0 && canMoveTo(monster.posX, monster.posY + stepY)) {
                monster.posY += stepY
            }
            // Ansonsten bleibt das Monster stehen
        }
    }
}