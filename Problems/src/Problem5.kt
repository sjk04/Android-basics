fun main()
{
    try {
        val amounttowithdraw=readln().toInt()
        val balance=1000
        var newbalance=withdraw(amounttowithdraw,balance)
        println(newbalance)
    }
    catch(e:Exception)
    {
        println(e.message)
    }
}
fun withdraw(amount:Int,balance:Int):Int
{
    if (amount<=0)
    {
        throw IllegalArgumentException("amount must be greater than 0")
    }
    if (amount>balance)
    {
        throw IllegalArgumentException("insufficient balance")

    }
    return balance-amount
}
