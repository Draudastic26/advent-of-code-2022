import utils.Input

fun main() {
    println("Day 3")
    val lines = Input.readAsLines("input/3")
    val abc = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"

    val prioritiesOne = lines.map {
        val splitIndex = it.length / 2
        val a = it.substring(0, splitIndex).toSet()
        val b = it.substring(splitIndex, it.length).toSet()
        a.intersect(b).first()
    }.sumOf { abc.indexOf(it) + 1 }
    println("Part One - sum of priorities: $prioritiesOne")

    val groups = lines.chunked(3)
    val prioritiesTwo = groups.map {
        val a = it[0].toSet()
        val b = it[1].toSet()
        val c = it[2].toSet()
        a.intersect(b).intersect(c).first()
    }.sumOf { abc.indexOf(it) + 1 }
    println("Part One - sum of priorities: $prioritiesTwo")
}

