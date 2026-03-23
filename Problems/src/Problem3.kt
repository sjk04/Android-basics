fun main() {
    var sentence = readln()
    var words = sentence.split(" ")
    println(sentence)
    println(words)
    var dic = mutableMapOf<String, Int>()
    for (word in words) {
        if (word in dic) {
            dic[word] = dic[word] !!+ 1
        } else {
            dic[word] = 1
        }

    }
    println(dic)
}
/*
If dic[word] is not null → use that value

If it is null → use 0
 */