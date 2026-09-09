import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PlaceRandomChestsTest {
    @Test
    fun placeRandomThreeChests() {
        val map = GameMap(15, 10)
        map.generateRandomMaze()
        placeRandomChests(map, 3)   // 3 Truhen zufällig platzieren
        assertEquals(3, map.tiles.flatten().count { it == TileType.CHEST })
    }

    @Test
    fun placeRandomSevenChests() {
        val map = GameMap(15, 10)
        map.generateRandomMaze()
        placeRandomChests(map, 7)   // 7 Truhen zufällig platzieren
        assertEquals(7, map.tiles.flatten().count { it == TileType.CHEST })
    }
}