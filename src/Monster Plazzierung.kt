fun findRandomEmptyCell(map: GameMap, occupied: List<Pair<Int,Int>> = emptyList()): Pair<Int, Int> {
    var pos: Pair<Int, Int>
    do {
        val x = (1 until map.width - 1).random()
        val y = (1 until map.height - 1).random()
        pos = x to y
    } while (
        map.tiles[y][x] != TileType.EMPTY ||
        pos in occupied ||
        isInSpawnProtectionZone(x, y)   // <-- NEU: Schutzbereich ausschließen
    )
    return pos
}