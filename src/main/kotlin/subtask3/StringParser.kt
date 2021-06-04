package subtask3

import java.util.*

class StringParser {

    fun getResult(inputString: String): Array<String> {
        var stringToParse: String = inputString
        var parsingIndex: Int = 0
        var arrayOfParsedStrings = mutableListOf<String>()
        var mapOfOccurringIndexes = mutableMapOf<String, Int>()
        var squareBracketOpen = Stack<Int>()
        var lessThanBracket = Stack<Int>()
        var parenthesisOpen = Stack<Int>()
        while (parsingIndex < stringToParse.length) {
            if (stringToParse[parsingIndex] == '[') {
                squareBracketOpen.push(parsingIndex)
                parsingIndex += 1
            } else if (stringToParse[parsingIndex] == '<') {
                lessThanBracket.push(parsingIndex)
                parsingIndex += 1
            } else if (stringToParse[parsingIndex] == '(') {
                parenthesisOpen.push(parsingIndex)
                parsingIndex += 1
            } else if (stringToParse[parsingIndex] == ']') {
                if (squareBracketOpen.isEmpty()) {
                    parsingIndex += 1
                } else {
                    arrayOfParsedStrings.add(stringToParse.substring(squareBracketOpen.peek() + 1,
                        parsingIndex))
                    mapOfOccurringIndexes.put(arrayOfParsedStrings.last(), squareBracketOpen.pop())
                    parsingIndex += 1
                }
            } else if (stringToParse[parsingIndex] == '>') {
                if (lessThanBracket.isEmpty()) {
                    parsingIndex += 1
                } else {
                    arrayOfParsedStrings.add(stringToParse.substring(lessThanBracket.peek() + 1,
                        parsingIndex))
                    mapOfOccurringIndexes.put(arrayOfParsedStrings.last(), lessThanBracket.pop())
                    parsingIndex += 1
                }
            } else if (stringToParse[parsingIndex] == ')') {
                if (parenthesisOpen.isEmpty()) {
                    parsingIndex += 1
                } else {
                    arrayOfParsedStrings.add(stringToParse.substring(parenthesisOpen.peek() + 1,
                        parsingIndex))
                    mapOfOccurringIndexes.put(arrayOfParsedStrings.last(), parenthesisOpen.pop())
                    parsingIndex += 1
                }
            } else {
                parsingIndex += 1
            }
        }
        for (i in 0..arrayOfParsedStrings.size - 2) {
            if (mapOfOccurringIndexes.getValue(arrayOfParsedStrings.get(i)) > mapOfOccurringIndexes.getValue(arrayOfParsedStrings.get(i + 1))) {
                arrayOfParsedStrings[i] = arrayOfParsedStrings[i + 1].also {arrayOfParsedStrings[i + 1] = arrayOfParsedStrings[i]}
            }
        }
        val result = arrayOfParsedStrings.toList()
        return result.toTypedArray()
    }
}

//        val openBracketsArray: CharArray = charArrayOf('<', '(', '[')
//        var openBracketIndex: Int = 0
//        var closeBracketIndex: Int = 0
//        while (parsingIndex < stringToParse.length - 1)
//            openBracketIndex = stringToParse.indexOfAny(chars = openBracketsArray, startIndex = parsingIndex)
//            when {
//                stringToParse[openBracketIndex] == '<' -> {
//                    if (stringToParse.indexOf())
//                }
//            }



//            when {
//                stringToParse.indexOfAny(chars = charArrayOf('<', '(', '['))
//            }
//            for (i in stringToParse.indices) {
//                when {
//                    stringToParse[i] == '<' || stringToParse[i] == '(' ||
//                }
//            }


