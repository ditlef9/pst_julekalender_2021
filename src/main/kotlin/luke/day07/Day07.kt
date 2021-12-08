package luke.day07

import luke.Luke
import java.nio.charset.StandardCharsets;
import java.util.*
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
/*
 Filename: Main.kt
 Author: Mr Ditlefsen, Mr Neim, Mr Wollan (That wrote it in Java!)
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


    // Input
    private val CIPHER_TEXT =
        "Y2MPyYU4kblEXrEfExry4AIRAjqdke+JyQQN50Uj5GuCu5rE66lEzQXB5bEVOlNGRoU06Ny4vh/gzSPFV0mHUrxaaAVt1BwN1WN1HFT7baIejtR5KyG6JK8yC70CpuPZV610coCiWzdFICcgEtAdQaesScLrg495kxofzG3EGvA="
    private val CIPHER_WITH_MODE_AND_PADDING = "AES/ECB/NoPadding"
    private val SECRET_KEY = "julenissenerteit"


    override fun run() {
        println(title())


        // Info Message
        var messageLength = CIPHER_TEXT.length
        println("Message = $CIPHER_TEXT")
        println("Message length = $messageLength\n")

        // Decrypt
        val byteBuffer = Base64.getDecoder().decode(CIPHER_TEXT)
        val cipher = Cipher.getInstance(CIPHER_WITH_MODE_AND_PADDING)
        val keyMaterial: ByteArray =
            SECRET_KEY.lowercase(Locale.getDefault()).toByteArray(StandardCharsets.US_ASCII)
        cipher.init(Cipher.DECRYPT_MODE, SecretKeySpec(keyMaterial, "AES"))
        val plainText = cipher.doFinal(byteBuffer)
        println(String(plainText))

    } // run
}
