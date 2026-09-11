// Beispiel: Truhen-Inhalt generieren
fun generateRandomItem(): Item {
    val items = listOf(
        Item("Sword", bonusAttack = 2),
        Item("Shild", bonusDefense = 2),
        Item("Potion", bonusHealth = 3),
        Item("SpellofSpeed", bonusSpeed = 1),
        Item("Oguresmalldragon")   //  neuer Gegenstand, nur der Name zählt
    )
    return items.random()
}

fun applyItem(player: Player, item: Item) {
    // Besondere Prüfung für den Oguresmalldragon
    if (item.name == "Oguresmalldragon") {
        player.hasOguresmalldragon = true
        println("You found Ogure, small dragon, please keep him.🐉")
    }

    // Normale Boni anwenden (der Oguresmalldragon hat keine, daher passiert hier nichts)
    player.attack += item.bonusAttack
    player.defense += item.bonusDefense
    player.health += item.bonusHealth
    player.speed += item.bonusSpeed

    // Nur Werte ausgeben, wenn es Boni gab (optional)
    if (item.bonusAttack != 0 || item.bonusDefense != 0 || item.bonusHealth != 0 || item.bonusSpeed != 0) {
        println("New Stats: Attack ${player.attack}, Defense ${player.defense}, HP ${player.health}, Speed ${player.speed}")
    }
}