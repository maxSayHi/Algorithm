package bobo.learn.algorithm.kotlin

class Learn

fun main() {
//    var alive: Boolean = true
//    val name = "波波"
//    val age = 12
//    val result = 666;
//    println(alive)
//    println("hello%s,我今年%d,希望否极泰来$result".format(name, age))
//    println(CompareToJava::class.java)
//    println(Learn::class)
//
//    var ll:Learn = Learn()
//    println(ll.toString())
//
//
//    repeat(10) {
//        println(it)
//    }

//    var user = User()
//    user.eat()

    var list = mutableListOf("1", "2", "3")
    list.forEach {
        if(it=="2")
        return@forEach
    }
    for (i in list) {
        println(i)
    }
}

object Test {
    @JvmStatic
    fun sayMsg(msg: String) {
        println("from Test say: $msg")
    }
}