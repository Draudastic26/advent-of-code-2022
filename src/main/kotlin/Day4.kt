import utils.Input

fun main() {
    println("Day 4")
    val lines = Input.readAsLines("input/4")

    val containOther = lines.map { it.split(",").flatMap { elf -> elf.split('-') }.map { value -> value.toInt() } }
        .count { fullyContain(it[0], it[1], it[2], it[3]) }

    println("Part One - Fully contain the other: $containOther")

    val containOtherTwo = lines.map { it.split(",").flatMap { elf -> elf.split('-') }.map { value -> value.toInt() } }
        .count { fullyContainTwo(it[0], it[1], it[2], it[3]) }

    println("Part Two - Fully contain the other: $containOtherTwo")
}

fun fullyContain(a1: Int, a2: Int, b1: Int, b2: Int): Boolean {
    return (a1 <= b1 && a2 >= b2) || (b1 <= a1 && b2 >= a2)
}

fun fullyContainTwo(a1: Int, a2: Int, b1: Int, b2: Int): Boolean {
    return fullyContain(
        a1,
        a2,
        b1,
        b2
    ) || (a1 <= b1 && a2 <= b2 && a2 >= b1) || (a1 >= b1 && a2 >= b2 && a1 <= b2)
}
