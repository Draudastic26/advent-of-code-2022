import utils.Input

fun main() {
    val limit = 100000

    println("Day 7")

    val input = Input.readAsLines("input/7")

    val w = Walker()
    input.forEach {
        if (it.startsWith("$")) w.processCommand(it)
        else w.processFile(it)
    }

    val dirPathByLevel =
        w.dirMap.keys.map { it.drop(1).split("/").map { split -> split.ifEmpty { "/" } } }.sortedByDescending { it.size }

    dirPathByLevel.forEach {
        val dir = w.dirMap[it.joinToString("/")]!!
        dir.size = dir.content.sumOf { sub -> sub.size }
    }

    val sumBelowLimit = w.dirMap.values.filter { it.size <= limit }.sumOf { it.size }
    println("Result part one $sumBelowLimit")

    // Part 2
    println("Day 7 - Part Two")
    val total = 70000000
    val required = 30000000
    val unused = total - w.dirMap["/"]!!.size
    val threshold = required - unused
    val minDirSize = w.dirMap.values.filter { it.size >= threshold }.minByOrNull { it.size }!!.size
    println("Result part two $minDirSize")
}

data class File(
    val name: String,
    val isDir: Boolean = false,
    var size: Int = 0,
    val content: MutableList<File> = mutableListOf()
)

class Walker {
    private val cd = "$ cd "
    private val up = "$ cd .."
    private val dir = "dir "

    private val path = ArrayDeque(listOf<String>())
    val dirMap = mutableMapOf<String, File>()

    fun processCommand(command: String) {
        if (command == up) {
            path.removeLast()
        } else if (command.startsWith(cd)) {
            val dirName = command.replace(cd, "")
            //create dir
            val currentDir = File(dirName, true)
            //put into current dir
            if (path.joinToString("/") != "") dirMap[path.joinToString("/")]!!.content.add(currentDir)
            //change current path
            path.addLast(dirName)
            //add to path map
            dirMap[path.joinToString("/")] = currentDir
        }
    }

    fun processFile(fileText: String) {
        if (!fileText.startsWith(dir)) {
            val fileInfo = fileText.split(" ")
            val size = fileInfo[0].toInt()
            val name = fileInfo[1]
            val file = File(name, false, size)
            dirMap[path.joinToString("/")]!!.content.add(file)
        }
    }

}

