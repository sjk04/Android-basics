fun main()

{
    val numbers=listOf("one","two","three","four")
    println(numbers.slice(1..3))
    println(numbers.slice(0..3 step 2))
    println(numbers.slice(setOf(0,1,3)))
    //numbers.take,numbers.takeLast,numbers.drop,numbers.dropLast


}