fun main()
{
    val numbers=mutableListOf("one","two","three","four","five","six")
    val plusList=numbers+"ten"
    val minusList=numbers-mutableListOf("one","two")
    println(minusList)
    println(plusList)
}