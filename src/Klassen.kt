// Enum für die Art des Feldes – später können wir komplexere Kacheln machen
enum class TileType {
    EMPTY, WALL, PLAYER, MONSTER, CHEST
}

// Gegenstand, der in Truhen gefunden werden kann
data class Item(
    val name: String,
    val bonusAttack: Int = 0,
    val bonusDefense: Int = 0,
    val bonusHealth: Int = 0,
    val bonusSpeed: Int = 0
)

// Basisklasse für alle "lebenden" Objekte (Spieler und Monster)
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
}

// Spieler-Klasse (erbt von Entity)
class Player(
    health: Int,
    attack: Int,
    defense: Int,
    speed: Int,
    posX: Int,
    posY: Int
) : Entity("Spieler", health, attack, defense, speed, posX, posY)

// Monster-Klasse
class Monster(
    name: String,
    health: Int,
    attack: Int,
    defense: Int,
    speed: Int,
    posX: Int,
    posY: Int,
    val canPassWalls: Boolean = false   // Neu: true für Kobold
) : Entity(name, health, attack, defense, speed, posX, posY) {

    val symbol: Char
        get() = name.first().uppercaseChar()
}