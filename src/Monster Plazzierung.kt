fun findRandomEmptyCell(map: GameMap): Pair<Int, Int> {
    var x: Int
    var y: Int
    do {
        x = (1 until map.width - 1).random()
        y = (1 until map.height - 1).random()
    } while (map.tiles[y][x] != TileType.EMPTY)
    return x to y
}