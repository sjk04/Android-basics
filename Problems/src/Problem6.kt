fun main()
{
    val name=readln()
    var marks=readln().toInt()
    var s=Student(name, marks)
    s.addMaks(marks)
    println(s)
}
data class Student(val name: String, var marks: Int)
{
    fun addMaks(newmarks: Int)
    {
        marks+=newmarks
    }
}