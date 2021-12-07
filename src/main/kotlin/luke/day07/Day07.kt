package luke.day07

import luke.Luke
import luke.day06.Day06

/*
 Filename: Main.kt
 Author: Mr Ditlefsen and Mr Neim
 Date: 07.12.2021
 Version: 1
 License: http://opensource.org/licenses/gpl-license.php GNU Public License
 */


fun main() {
    Day06().run()
}
class Day07 : Luke() {
    override fun day() = 6
    override fun title() = "Monday December 6th 2021 is a day off"

    override fun run() {
        println(title())


        var message: String = "Y2MPyYU4kblEXrEfExry4AIRAjqdke+JyQQN50Uj5GuCu5rE66lEzQXB5bE VOlNGRoU06Ny4vh/gzSPFV0mHUrxaaAVt1BwN1WN1HFT7baIejtR5KyG6 JK8yC70CpuPZV610coCiWzdFICcgEtAdQaesScLrg495kxofzG3EGvA="
        var receiver: String = "Chili Willy"

        // Info Message
        var messageLength = message.length
        println("Message = $message")
        println("Message length = $messageLength")

        // Info parts
        var messageSplitOnSpace = message.split(" ")
        for (part in messageSplitOnSpace) {
            var partLength = part.length
            println("\n")
            println("Part = $part")
            println("Part length = $partLength")
        }


    } // run

}
