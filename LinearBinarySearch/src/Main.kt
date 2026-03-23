//LINEAR SEARCH
/*
fun main()
{
    println(searchElement(27,mutableListOf(1,2,3,4,32,27)))
}

private fun searchElement(searchedElement:Int,numbers:MutableList<Int>): Int{
    var count=0
    for (number in numbers)
    {
        count++
        println(count)
        if (searchedElement == number)
        {
            return number
        }
    }
    return -1
}

 */


//BINARY SEARCH

fun main()
{
    println(searchElement(27,mutableListOf(1,2,3,4,32,27)))
}

private fun searchElement(searchedElement:Int,numbers:MutableList<Int>): Int{
    val sortedlist=numbers.sorted()
    var low=0
    var count=0
    var high=sortedlist.size-1
    while (low<=high)
    {
        count++
        println("count:$count")
        val mid=(low+high)/2
        val cmp=sortedlist[mid].compareTo(searchedElement)
        if (cmp<0)
        {
            low=mid+1
        }
        else if(cmp>0)
        {
            high=mid-1

        }
        else
        {
            return sortedlist[mid]
        }
    }
    return -1
}