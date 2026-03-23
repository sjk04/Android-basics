fun main() {
    val number = readln().toInt()
    val arr = mutableListOf<Int>()

    for (i in 2..number) {
        var isPrime = true

        for (j in 2 until i) {
            if (i % j == 0) {
                isPrime = false
                break
            }
        }

        if (isPrime) {
            arr.add(i)
        }
    }

    println(arr)
}
