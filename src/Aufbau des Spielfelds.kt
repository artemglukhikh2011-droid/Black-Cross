class GameMap(val width: Int, val height: Int) {
    // 2D-Array für statische Inhalte (Wände, Boden, Truhen)
    val tiles = Array(height) { Array(width) { TileType.EMPTY } }

    // Einfaches Labyrinth generieren (nur Rand als Wand, Rest leer)
    fun generateSimpleMaze() {
        for (y in 0 until height) {
            for (x in 0 until width) {
                tiles[y][x] = if (x == 0 || y == 0 || x == width-1 || y == height-1) TileType.WALL else TileType.EMPTY
            }
        }
        // Ein paar Truhen platzieren (später mehr)
    }

    fun isWalkable(x: Int, y: Int): Boolean {
        if (x < 0 || y < 0 || x >= width || y >= height) return false
        return tiles[y][x] != TileType.WALL
    }
}