import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class EntityTest {
    @Test
    fun doAttack() {
        val player = Player(health = 10, attack = 3, defense = 2, speed = 2, posX = 1, posY = 1)
        val goblin = Monster(name = "Goblin", health = 5, attack = 4, defense = 1, speed = 1, posX = 1, posY = 1)
        val d1 = player.doAttack(goblin)
        assertTrue(goblin.isAlive())
        assertEquals(2, d1)
        val d2 = goblin.doAttack(player)
        assertTrue(player.isAlive())
        assertEquals(2, d2)
        assertEquals(player.health, 8)
        assertEquals(goblin.health, 3)
    }
}
