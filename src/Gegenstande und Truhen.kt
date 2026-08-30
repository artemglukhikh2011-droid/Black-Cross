// Beispiel: Truhen-Inhalt generieren
fun generateRandomItem(): Item {
    val items = listOf(
        Item("Schwert", bonusAttack = 2),
        Item("Schild", bonusDefense = 2),
        Item("Heiltrank", bonusHealth = 3),
        Item("Stiefel", bonusSpeed = 1)
    )
    return items.random()
}

fun applyItem(player: Player, item: Item) {
    player.attack += item.bonusAttack
    player.defense += item.bonusDefense
    player.health += item.bonusHealth
    player.speed += item.bonusSpeed
    println("Neue Werte: Angriff ${player.attack}, Verteidigung ${player.defense}, Leben ${player.health}, Geschwindigkeit ${player.speed}")
}