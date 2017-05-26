package my.demo

/**
 * Created by jinhui on 2017/5/26.
 * 邮箱: 1004260403@qq.com
 *
 * 1、发现Kotlin写语句没有逗号，没有new对象;
 * 2、在Kotlin 中类可以有属性，
 * 我们可以使用 var 关键字声明可变属性，或者用val关键字声明只读属性
 *
 *  * 本demo学习以下知识点：
 *  1、定义函数
 *  2、定义局部变量
 *  3、注释（与 java 和 javaScript 一样，Kotlin 支持单行注释和块注释。）
 *  4、使用字符串模板
 *  5、使用条件表达式
 *  6、使用可空变量以及空值检查(当空值可能出现时应该明确指出该引用可空。)
 *  7、使用值检查并自动转换(
 *  使用 is 操作符检查一个表达式是否是某个类型的实例。
 *  如果对不可变的局部变量或属性进行过了类型检查，就没有必要明确转换)
 *  8、使用循环
 *  9、使用ranges
 *  10、使用集合
 */
fun main(args: Array<String>) {
    print("sum of 3 and 5 is ")
    println(sum(3, 5))
    println("sum of 19 and 23 is ${sum1(19, 23)}")
    printsum(-1, 8)
    printsum1(-1, 8)
    // 2、定义局部变量
    val a: Int = 1   // 直接初始化
    val b = 2     // 推导出Int型
    val c: Int  // 当没有初始化值时必须声明类型
    c = 3
    println("a = $a, b = $b, c = $c")
    // 变量
    var x = 5 // 推导出是int类型
    x += 1
    println("x = $x")
    var a1 = 1;
    // 使用变量名作为模板
    val s1 = "a1 is $a1"
    a1 = 2
    // 使用表达式作为模板
    val s2 = "${s1.replace("is", "was")}, but now is $a1" // replace:后面字符串替换前面
    println(s2)
    println("max of 12 and 23 is ${maxof(12, 23)}")
    printProduct("6", "7")
    printProduct("a", "7")
    printProduct("a", "b")

    printProduct1("6", "7")
    printProduct1("a", "7")
    printProduct1("6", "b")

    fun printLength(obj: Any) {
        println("'$obj' string length is " +
                "${getStringLength(obj) ?: "... err, not a string"} ")
    }
    printLength("Incomprehensibilities")
    printLength(1000)
    printLength(listOf(Any()))

    // 使用循环 && 对一个集合进行迭代：
    val items = listOf("apple", "banana", "kiwi")
    for (item in items){
        println(item)
    }
    // 获得循环下标
    val items2 = listOf("1", "2", "3")
    for (index in items2.indices){
        println("item at $index is ${items2[index]}")
    }
    // 使用 while 循环
    val items3 = listOf("apple", "banana", "kiwi")
    var index = 0
    while (index < items3.size) {
        println("item at $index is ${items3[index]}")
        index++
    }
    // 使用 when 表达式
    println(describe(1))
    println(describe("Hello"))
    println(describe(1000L))
    println(describe(2))
    println(describe("other"))
    // 使用ranges
    // 使用 in 操作符检查数值是否在某个范围内：
    val x1 = 11
    val y1 = 9
    if(x1 in 1..y1 + 1){
        println("fits in range")
    }else{
        println("fits not in range")
    }
    // 检查数值是否在范围外：
    val list = listOf("a", "b", "c")
    if (-1 !in 0..list.lastIndex) {
        println("-1 is out of range")
    }
    if (list.size !in list.indices) {
        println("list.indices =" + list.indices)
        println("list size is out of valid list indices range too")
    }
    // 在范围内迭代：
    for (x in 1..5){
        print(x)
    }
    println()
    // 或者使用步进：
    for (x in 1..10 step 2){
        print(x)
    }
    println()
    for (x in 9 downTo 0 step 3) {
        print(x)
    }
    println()
    // 使用集合
    // 使用 in 操作符检查集合中是否包含某个对象
    val items4 = setOf("apple", "banana", "kiwi")
    when {
        "orange" in items4 -> print("juicy")
        "apple" in items4 -> println("apple is fine too")
    }
    // 使用lambda表达式过滤和映射集合：
    val fruits = listOf("banana", "avocado", "apple", "kiwi")
    fruits.filter { it.startsWith("a") }
            .sortedBy { it }
            .map { it.toUpperCase() }
            .forEach { println(it) }
}


// 定义函数
fun sum(a: Int, b: Int): Int {
    return a + b;
}
// 该函数只有一个表达式函数体以及一个自推导型的返回值：
fun sum1(a: Int, b: Int) = a + b
// 返回一个没有意义的值：
fun printsum(a: Int, b: Int): Unit {
    println("sum of $a and $b is ${a + b}")
}
// Unit 的返回类型可以省略：
fun printsum1(a: Int, b: Int){
    println("sum of $a and $b is ${a + b}")
}
// 使用条件表达式
fun maxof(a: Int, b: Int): Int {
    if(a > b){
        return a
    }else{
        return b
    }
}
// 使用一个返回可空值的函数：两种写法
fun parseInt(str: String): Int? {
    return str.toIntOrNull()
}
fun printProduct(arg1: String, arg2: String){
    val x = parseInt(arg1)
    val y = parseInt(arg2)
    // 直接使用x*y会产生错误因为它们中有可能会有空值
    if(x != null && y != null){
        // x 和 y 将会在空值检测后自动转换为非空值
        println("x * y = " + x * y)
    }else{
        println("either '$arg1' or '$arg2' is not a number")
    }
}
// 或者这样
fun parseInt1(str: String): Int? {
    return str.toIntOrNull()
}

fun printProduct1(arg1: String, arg2: String) {
    val x = parseInt1(arg1)
    val y = parseInt1(arg2)

    if (x == null) {
        println("Wrong number format in arg1: '${arg1}'")
        return
    }
    if (y == null) {
        println("Wrong number format in arg2: '${arg2}'")
        return
    }
    // x 和 y 将会在空值检测后自动转换为非空值
    println(x * y)
}

fun getStringLength(obj: Any): Int? {
    if (obj is String) {
        // obj 将会在这个分支中自动转换为 String 类型
        return obj.length
    }
    // obj 在种类检查外仍然是 Any 类型
    return null
}
// 使用 when 表达式
fun describe(obj: Any): String =
        when (obj) {
             1          -> "One"
            "Hello"    -> "Greeting"
            is Long    -> "Long"
            !is String -> "Not a string"
            else       -> "Unknown"
        }





