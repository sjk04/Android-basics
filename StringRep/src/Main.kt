fun main()
{
    val numbersString=listOf("one","two","three","four" )
    println(numbersString)
    println(numbersString.joinToString())//conert to string the list
    // for adding another line or string
    //we use StringBuffer
    val listString=StringBuffer("the list is :")
    println(numbersString.joinTo(listString))
    println(numbersString.joinToString(separator = " ,", prefix = "start: ", postfix = ":end"))
    val numbers=(1..100).toList()
    println(numbers)
    println(numbers.joinToString (limit = 15, truncated = "... 100"))
    println(numbersString.joinToString { "element: ${it.uppercase()}" })
}