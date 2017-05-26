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
 *  7、使用值检查并自动转换
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


