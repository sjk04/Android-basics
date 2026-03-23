fun main()
{
    val name=readLine()
    val s1=readln().toInt()
    val s2=readln().toInt()
    val s3=readln().toInt()
    var average = (s1+s2+s3)/3.0
    val grade=when {

        average >=80 -> "A"
        average >=60 -> "B"
        average >=40 -> "C"
            else->"Fail"


    }
    println("name :$name")
    println("grade :$grade")
    println("average :$average")

}