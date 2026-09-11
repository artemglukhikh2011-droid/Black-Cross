// Enum für die Art des Feldes – später können wir komplexere Kacheln machen
enum class TileType {
    EMPTY, WALL, PLAYER, MONSTER, CHEST
}

// Items
data class Item(
    val name: String,
    val bonusAttack: Int = 0,
    val bonusDefense: Int = 0,
    val bonusHealth: Int = 0,
    val bonusSpeed: Int = 0,
)

// Class for all alive objects
open class Entity(
    var name: String,
    var health: Int,
    var attack: Int,
    var defense: Int,
    var speed: Int,          // Anzahl Felder, die pro Runde gelaufen werden kann
    var posX: Int,
    var posY: Int
) {
    fun isAlive() = health > 0

    /**
     * Imitieren einen Angriff gegen [defender].
     *
     * [Entity.health] für [defender] verringert auf den Unterschied zwischen [Entity.defense] für [defender]
     * und einiger [attack], mindestens 1.
     *
     * @return der Anzahl von Schaden verursacht
     */
    fun doAttack(defender: Entity): Int {
        val damageToDefender = (this.attack - defender.defense).coerceAtLeast(1)
        defender.health -= damageToDefender
        return damageToDefender
    }
}

//  Player Class
class Player(
    health: Int,
    attack: Int,
    defense: Int,
    speed: Int,
    posX: Int,
    posY: Int
) : Entity("Player", health, attack, defense, speed, posX, posY){
    // Neu: Has a Player Oguresmalldragon
    var hasOguresmalldragon: Boolean = false
    var wyvernPoisonTurns: Int = 0             // Potion Turns
}

// Monster-Klasse
class Monster private constructor(
    name: String,
    health: Int,
    attack: Int,
    defense: Int,
    speed: Int,
    posX: Int,
    posY: Int,
    val canPassWalls: Boolean = false   // New: true for Kobold
) : Entity(name, health, attack, defense, speed, posX, posY) {

    val symbol: Char
        get() = name.first().uppercaseChar()

    companion object {
        fun createByName(name: String, posX: Int, posY: Int): Monster {
            val template = listOfMonsters[name]!!
            return Monster(
                template.name, template.health, template.attack, template.defense, template.speed, posX, posY, template.canPassWalls
            )
        }

        private val listOfMonsters: Map<String, Monster> = listOf(
            Monster(name = "Goblin", health = 5, attack = 4, defense = 1, speed = 1, posX = 0, posY = 0),
            Monster(name = "Kobold", health = 5, attack = 5, defense = 0, speed = 2, posX = 0, posY = 0, canPassWalls = true),
            Monster(name = "Wywern", health = 5, attack = 4, defense = 1, speed = 1, posX = 0, posY = 0)
        ).associateBy { it.name }
    }
}