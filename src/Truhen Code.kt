fun placeRandomChests(map: GameMap, count: Int) {
    repeat(count) {
        val (x, y) = findRandomEmptyCell(map)
        map.tiles[y][x] = TileType.CHEST
    }
}