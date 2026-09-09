// Prüft, ob die Koordinaten (x, y) im 4x4-Schutzbereich um den Startpunkt liegen
fun isInSpawnProtectionZone(x: Int, y: Int): Boolean {
    // Startpunkt des Spielers (normalerweise 1,1)
    val startX = 1
    val startY = 1
    // Größe des Schutzquadrats: 4x4 Felder
    val zoneSize = 4

    val endX = startX + zoneSize - 1   // 1+4-1 = 4
    val endY = startY + zoneSize - 1   // 1+4-1 = 4

    return x in startX..endX && y in startY..endY
}