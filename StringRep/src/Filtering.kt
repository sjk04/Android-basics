fun main()
{
    val numbers=listOf(1,2,3,4,5,6,7,8,9,10)
    val longerThan3=numbers.filter{it >3}
    println(longerThan3)
    val numberMap=mapOf("key 1" to 1,"key2" to 2,"key3" to 3)
    val filterMap=numberMap.filter{ it.key.endsWith("1")&&it.value>1}
    println(filterMap)
    val mixed=listOf(1,2,3,'A','B','C',"hello world",8,9,false)
    mixed.filterIsInstance<Int>().forEach { println(it) }
    // partition

    val (match,rest)=numbers.partition{it>3}
    println(match)
    println(rest)
}
// any ,none ,all predicates
// return true or false according to the matching condition
// ex
// numbers.any{it.endsWith("e")}
