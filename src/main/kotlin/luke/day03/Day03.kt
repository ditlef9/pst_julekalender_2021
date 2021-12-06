package luke.day03

import luke.Luke

fun main() {
    Day03().run()
}

/*
 Filename: Main.kt
 Author: Ditlef
 Date: 03.12.2021 22:31
 Version: 1
 License: http://opensource.org/licenses/gpl-license.php GNU Public License
 */

class Day03: Luke() {
    override fun day() = 3

    override fun title() = "Pigpen cipher decoder"


    override fun run() {
        /*
        0 (A)  1 (B)  2 (C)       9 (J)  10 (K)  11 (L)
        3 (D)  4 (E)  5 (F)      12 (M)  13 (N)  14 (O)
        6 (G)  7 (H)  8 (I)      15 (P)  16 (Q)  17 (R)

               18 (S)              22 (W)
          19 (T)  20 (U)      23 (X)  24 (Y)
               21 (V)              25 (Z)
         */


        // Your message
        var message: Array<Int> = arrayOf(9, 20, 11, 4, 13, 8, 18, 18, 4, 13, 4, 17, 19, 4, 8, 19)

        // Pigpen
        var pigpen: Array<String> = arrayOf("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z")


        // Print message
        println("1) Message:")
        for (letter in message) {
            var solved: String = pigpen[letter];
            print("$letter")
        }

        // Print Solve
        println("\n\n2) Solve:")
        for (letter in message) {
            var solved: String = pigpen[letter];
            println("$letter -> $solved")
        }

        // Print Solution
        println("\n3) Solution:")
        for (letter in message) {
            var solved: String = pigpen[letter];
            print("$solved")
        }
    }
}