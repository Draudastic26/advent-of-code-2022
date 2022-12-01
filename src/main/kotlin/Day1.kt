import utils.Input

fun main() {
    println("Day 1")
    val lines = Input.readAsLines("input/1")

    val caloriesPerElf = mutableListOf<Collection<Int>>()
    val currentElf = mutableListOf<Int>()

    lines.forEach {
        if (it.isEmpty()) {
            caloriesPerElf.add(currentElf.toList())
            currentElf.clear()
        } else {
            currentElf.add(it.toInt())
        }
    }

    val maxCalories = caloriesPerElf.maxOfOrNull { it.sum() }
    val top3Calories = caloriesPerElf.map { it.sum() }.sortedByDescending { it }.take(3).sum()
    println("Max calories: $maxCalories")
    println("Sum of top 3: $top3Calories")
}

