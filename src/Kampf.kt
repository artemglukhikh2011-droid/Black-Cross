fun fight(attacker: Entity, defender: Entity) {
    val damageToDefender = (attacker.attack - defender.defense).coerceAtLeast(1)
    defender.health -= damageToDefender
    println("${attacker.name} greift ${defender.name} an und verursacht $damageToDefender Schaden. ${defender.name} hat noch ${defender.health} Leben.")

    if (defender.isAlive()) {
        val damageToAttacker = (defender.attack - attacker.defense).coerceAtLeast(1)
        attacker.health -= damageToAttacker
        println("${defender.name} kontert und verursacht $damageToAttacker Schaden. ${attacker.name} hat noch ${attacker.health} Leben.")
    }
}