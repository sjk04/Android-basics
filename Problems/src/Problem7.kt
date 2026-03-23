fun main()
{
    val num1=readln().toInt()
    val num2=readln().toInt()
    val symbol=readln()
    fun calculate(num1: Int, num2: Int,symbol: String)
    {
        var result=when (symbol)
        {
            "+" -> num1+num2
            "-" -> num1-num2
            "*" -> num1*num2
            "/" -> num1/num2
            else -> "invalid"

        }
        println(result)
    }

    calculate(num1,num2,symbol)
    
}