open class Employee( val name: String)
{
    open fun calculate() :Int
    {
        return 0
    }
}
class FullTimeEmployee(name: String,val salary:Int) : Employee(name)
{
    override fun calculate():Int {
        return salary
    }
}
class PartTimeEmployee(name: String,val hours: Int,val pay:Int) : Employee(name)
{
    override fun calculate():Int {
        return hours*pay
    }
}
fun main()
{
    print("enter name of part time employee ")
    var name1=readln()
    print("enter name of full time employee ")
    var name2=readln()
    print("for full time the monthly salary is 10000")
    print("for part time enter the hours you worked and and hourly rate is 30")
    var hours=readln().toInt()
    val f= FullTimeEmployee(name2,10000)
    val p= PartTimeEmployee(name1,hours,30)

    println("${f.name} has the salary ${f.calculate()}.")
    println("${p.name} has the salary ${p.calculate()}.")
}
