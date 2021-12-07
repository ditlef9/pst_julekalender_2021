package luke.day07

import luke.Luke
import java.util.*
import javax.crypto.*
import javax.crypto.spec.SecretKeySpec


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
        var key: String = "julenissenerteit"

        // Info Message
        var messageLength = message.length
        println("Message = $message")
        println("Message length = $messageLength\n")

        // Decrypt
        decryptAES(message, key)

    } // run

    private fun decryptAES(message: String, key: String) {
        // Todo
    }

}
