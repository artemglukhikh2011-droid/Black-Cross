fun attackWithCounterAttack(attacker: Entity, defender: Entity) {
    val damageToDefender = attacker.doAttack(defender)
    println("${attacker.name} greift ${defender.name} an und verursacht $damageToDefender Schaden. ${defender.name} hat noch ${defender.health} Leben.")

    if (defender.isAlive()) {
        val damageToAttacker = defender.doAttack(attacker)
        println("${defender.name} kontert und verursacht $damageToAttacker Schaden. ${attacker.name} hat noch ${attacker.health} Leben.")
    }
}