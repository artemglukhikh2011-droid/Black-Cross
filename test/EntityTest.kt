import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class EntityTest {
    @Test
    fun doAttack() {
        val player = Player(health = 10, attack = 3, defense = 2, speed = 2, posX = 1, posY = 1)
        val goblin = Monster.createByName(name = "Goblin", posX = 1, posY = 1)
        val d1 = player.doAttack(goblin)
        assertTrue(goblin.isAlive())
        assertEquals(2, d1)
        val d2 = goblin.doAttack(player)
        assertTrue(player.isAlive())
        assertEquals(2, d2)
        assertEquals(8, player.health)
        assertEquals(3, goblin.health)
        player.doAttack(goblin)
        player.doAttack(goblin)
        assertFalse(goblin.isAlive())

        val kobold = Monster.createByName(name = "Kobold", posX = 1, posY = 1)
        val d3 = player.doAttack(kobold)
        assertTrue(kobold.isAlive())
        assertEquals(1, d3)
        val d4 = kobold.doAttack(player)
        assertTrue(player.isAlive())
        assertEquals(4, d4)
        assertEquals(4, player.health)
        assertEquals(7, kobold.health)
    }
}
