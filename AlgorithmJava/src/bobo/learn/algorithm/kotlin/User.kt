package bobo.learn.algorithm.kotlin

import java.math.BigDecimal

class User() {
    var name: String = "max"
    var no: Char = '1'
    val age: Int = 18
    val salary: Double = 12.1
    val sexy: Boolean = true
    var assets: BigDecimal = BigDecimal(12)
    var punish = null

    fun eat() {
        println("eat！")
        println(name[0])
        println(punish.toString())
    }
}

