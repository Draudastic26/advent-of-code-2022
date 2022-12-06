package utils

import java.io.File

object Input {
    fun readAsLines(fileName: String): List<String> = File(fileName).readLines()
    fun readAsString(fileName: String): String = File(fileName).readText()
}