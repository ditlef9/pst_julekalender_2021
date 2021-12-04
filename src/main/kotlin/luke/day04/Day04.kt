package luke.day04

import luke.Luke
import org.intellij.lang.annotations.Language
import java.io.File
import java.util.regex.Pattern
import java.util.stream.Collectors
import java.util.stream.Collectors.toList
data class  Ting(val index: Int, val hylleplass: String, val utstyr: String, val id:Int)
    // Indeks;Hylleplass;Utstyr;Id

fun main(args: Array<String>) {
    Day04().run()
}

class Day04: Luke() {
    override fun day() = 4
    override fun title() = "ASCII Hex disorder"

    private val sortedByIndex = File("src\\main\\kotlin\\luke\\day04\\verksted_npst.txt")
        .readLines()
        .stream()
        .map{it.replace(" ", "")}
        .filter { !it.contains("Hylleplass") }
        .map {
            val s = it.split(";")
             Ting(s[0].toInt(), s[1], s[2], s[3].toInt())
        }
        .collect(toList())


    override fun run() {

        println("ordered by Utstyr:")
        val sortedByUtstyr = sortedByIndex.stream()
            .sorted { o1, o2 -> o1.utstyr.compareTo(o2.utstyr) }
            //.peek { println("" + it.id + " __ "+ it.index) } // debug
            .toList()

        val hexUtstyr = sortedByUtstyr.stream()
            .map { it.hylleplass }
            .map{hexToString(it)}
            .collect(Collectors.joining(""))
        println(hexUtstyr)
        val strippedAllNonAlphabetical = hexUtstyr.replace("[\\W]".toRegex(), "")
        println(strippedAllNonAlphabetical)
        println()

        // Life is too short.. clean up manually:
        val p = strippedAllNonAlphabetical.split((108).toChar());
        println("${p[0]}{${p[1]}l${p[2]}}")
    }
}

fun hexToString(hex: String): String {
    val sb = StringBuilder()
    val temp = StringBuilder()

    //49204c6f7665204a617661 split into two characters 49, 20, 4c...
    var i = 0
    while (i < hex.length - 1) {


        //grab the hex in pairs
        val output = hex.substring(i, i + 2)
        //convert hex to decimal
        val decimal = output.toInt(16)
        //convert the decimal to character
        sb.append(decimal.toChar())
        temp.append(decimal)
        i += 2
    }
//    println("Decimal : $temp")
    return sb.toString()
}