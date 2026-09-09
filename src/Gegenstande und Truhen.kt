// Beispiel: Truhen-Inhalt generieren
fun generateRandomItem(): Item {
    val items = listOf(
        Item("Schwert", bonusAttack = 2),
        Item("Schild", bonusDefense = 2),
        Item("Heiltrank", bonusHealth = 3),
        Item("Stiefel", bonusSpeed = 1),
        Item("Oguresmalldragon")   //  neuer Gegenstand, nur der Name zählt
    )
    return items.random()
}

fun applyItem(player: Player, item: Item) {
    // Besondere Prüfung für den Oguresmalldragon
    if (item.name == "Oguresmalldragon") {
        player.hasOguresmalldragon = true
        println("Du hast den Ogure, einen kleinen Drachen, gefunden! Er wird dich von nun an begleiten.")
    }

    // Normale Boni anwenden (der Oguresmalldragon hat keine, daher passiert hier nichts)
    player.attack += item.bonusAttack
    player.defense += item.bonusDefense
    player.health += item.bonusHealth
    player.speed += item.bonusSpeed

    // Nur Werte ausgeben, wenn es Boni gab (optional)
    if (item.bonusAttack != 0 || item.bonusDefense != 0 || item.bonusHealth != 0 || item.bonusSpeed != 0) {
        println("Neue Werte: Angriff ${player.attack}, Verteidigung ${player.defense}, Leben ${player.health}, Geschwindigkeit ${player.speed}")
    }
}