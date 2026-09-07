class GameMap(val width: Int, val height: Int) {
    // 2D-Array für statische Inhalte (Wände, Boden, Truhen)
    val tiles = Array(height) { Array(width) { TileType.EMPTY } }

    fun generateRandomMaze() {
        // Zuerst alles mit Wänden füllen
        for (y in 0 until height) {
            for (x in 0 until width) {
                tiles[y][x] = TileType.WALL
            }
        }

        // Startzelle (ungerade Koordinaten) auswählen und Rekursion starten
        carvePath(1, 1)
    }

    // Rekursive Funktion, die Gänge gräbt
    private fun carvePath(x: Int, y: Int) {
        tiles[y][x] = TileType.EMPTY   // aktuelle Zelle wird Boden

        // Zufällige Reihenfolge der vier Richtungen
        val directions = listOf(0 to -2, 0 to 2, -2 to 0, 2 to 0).shuffled()

        for ((dx, dy) in directions) {
            val nx = x + dx
            val ny = y + dy

            // Prüfen, ob Nachbarzelle innerhalb des Spielfelds liegt und noch Wand ist
            if (nx > 0 && ny > 0 && nx < width - 1 && ny < height - 1 && tiles[ny][nx] == TileType.WALL) {
                // Wand zwischen aktueller Zelle und Nachbarzelle entfernen
                tiles[y + dy / 2][x + dx / 2] = TileType.EMPTY
                // Rekursiv weitermachen
                carvePath(nx, ny)
            }
        }
    }

    fun isWalkable(x: Int, y: Int): Boolean {
        if (x < 0 || y < 0 || x >= width || y >= height) return false
        return tiles[y][x] != TileType.WALL
    }
}