fun placeRandomChests(map: GameMap, count: Int) {
    repeat(count) {
        var x: Int
        var y: Int
        // Wiederholen, bis ein freies Feld gefunden wurde
        do {
            x = (1 until map.width - 1).random()
            y = (1 until map.height - 1).random()
        } while (map.tiles[y][x] != TileType.EMPTY)
        map.tiles[y][x] = TileType.CHEST
    }
}