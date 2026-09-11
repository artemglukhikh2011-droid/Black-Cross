fun attackWithCounterAttack(attacker: Entity, defender: Entity) {
    val damageToDefender = attacker.doAttack(defender)
    println("${attacker.name} greift ${defender.name} an und verursacht $damageToDefender Schaden. ${defender.name} hat noch ${defender.health} Leben.")

    if (defender.isAlive()) {
        val damageToAttacker = defender.doAttack(attacker)
        println("${defender.name} kontert und verursacht $damageToAttacker Schaden. ${attacker.name} hat noch ${attacker.health} Leben.")
    }
    // Wyvern-Effekt: Wenn die Wyvern den Spieler angreift, wird er vergiftet
    if (attacker is Monster && attacker.name == "Wywern" && defender is Player) {
        defender.wyvernPoisonTurns = 2
        println("You are poisoned. For next 2 turns you will lose 1 HP per turn.")
    }
}
