package bobo.learn.algorithm.kotlin

class Learn

fun main() {
    var alive: Boolean = true
    val name = "波波"
    val age = 12
    val result = 666;
    println(alive)
    println("hello%s,我今年%d,希望否极泰来$result".format(name, age))
    println(CompareToJava::class.java)
    println(Learn::class)

    repeat(10) {
        println(it)
    }
}

object Test {
    @JvmStatic
    fun sayMsg(msg: String) {
        println("from Test say: $msg")
    }
}