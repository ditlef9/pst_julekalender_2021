package luke.day07

import luke.Luke


/*
 Filename: Main.kt
 Author: Mr Ditlefsen and Mr Neim
 Date: 07.12.2021
 Version: 1
 License: http://opensource.org/licenses/gpl-license.php GNU Public License
 */


fun main() {
    Day07().run()
}
class Day07 : Luke() {
    override fun day() = 7
    override fun title() = "Encrypted message with receiver"

    override fun run() {
        println(title())


        // Input data
        var message: String = "Y2MPyYU4kblEXrEfExry4AIRAjqdke+JyQQN50Uj5GuCu5rE66lEzQXB5bE VOlNGRoU06Ny4vh/gzSPFV0mHUrxaaAVt1BwN1WN1HFT7baIejtR5KyG6 JK8yC70CpuPZV610coCiWzdFICcgEtAdQaesScLrg495kxofzG3EGvA="
        var receiver: String = "Chili Willy"

        // Info Message
        var messageLength = message.length
        println("Message = $message")
        println("Message length = $messageLength\n")

        // Info parts
        var items = message.split(" ")
        for (part in items) {
            var partLength = part.length
            println("Part = $part")
            println("Part length = $partLength\n")
        }

        // Print all combinations
        val result = items
            .flatMap { i1 ->
                items.flatMap { i2 ->
                    items.mapNotNull { i3 ->
                        val combination = listOf(i1, i2, i3).distinct()
                        if (combination.count() == 3) combination else null
                    }
                }
            }
            .mapIndexed { index, it -> "" + (index + 1) + ". " + it[0] + "\n" + it[1] + "\n" + it[2] }

        for (item in result) {
            println(item + "\n")
        }



    } // run




}
