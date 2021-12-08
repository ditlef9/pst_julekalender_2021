package luke.day07

import luke.Luke
import java.util.*
import javax.crypto.Cipher
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.PBEKeySpec
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
        val message: String = "Y2MPyYU4kblEXrEfExry4AIRAjqdke+JyQQN50Uj5GuCu5rE66lEzQXB5bE VOlNGRoU06Ny4vh/gzSPFV0mHUrxaaAVt1BwN1WN1HFT7baIejtR5KyG6 JK8yC70CpuPZV610coCiWzdFICcgEtAdQaesScLrg495kxofzG3EGvA="
        val secretKey = "julenissenerteit"

        // Info Message
        var messageLength = message.length
        println("Message = $message")
        println("Message length = $messageLength\n")

        // Decrypt
        var decrypted: String = decryptAES(message, secretKey)!!
        println("Decrypted message = $decrypted")

    } // run

    fun encryptAES(strToEncrypt: String, secretKey: String) :  String?
    {
        /*
        try
        {
            val ivParameterSpec = IvParameterSpec(Base64.decode("iv", Base64.DEFAULT))

            val factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1")
            val spec =  PBEKeySpec(secretKey.toCharArray(), Base64.decode(salt, Base64.DEFAULT), 10000, 256)
            val tmp = factory.generateSecret(spec)
            val secretKey =  SecretKeySpec(tmp.encoded, "AES")

            val cipher = Cipher.getInstance("AES/CBC/PKCS7Padding")
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec)
            return Base64.encodeToString(cipher.doFinal(strToEncrypt.toByteArray(Charsets.UTF_8)), Base64.DEFAULT)
        }
        catch (e: Exception)
        {
            println("Error while encrypting: $e")
        }
        */
        return null
    }

    fun decryptAES(strToDecrypt : String, secretKey: String) : String? {

        try{

            val ivParameterSpec =  IvParameterSpec(Base64.getDecoder().decode("iv"))

            val factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1")
            val spec =  PBEKeySpec(secretKey.toCharArray(), Base64.getDecoder().decode("salt"), 10000, 256)
            val tmp = factory.generateSecret(spec);
            val secretKey =  SecretKeySpec(tmp.encoded, "AES")

            val cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return  String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)))
        }
        catch (e : Exception) {
            println("Error while decrypting: $e");
        }

        return null
    }
}
