package subtask3

import java.util.*

class StringParser {

    fun getResult(inputString: String): Array<String> {
        val stringToParse: String = inputString
        var parsingIndex: Int = 0
        val parsedStrings = mutableListOf<String>()
        val openBracketsIndexes = mutableMapOf<String, Int>()
        val squareBracketOpen = Stack<Int>()
        val lessThanBracket = Stack<Int>()
        val parenthesisOpen = Stack<Int>()

        while (parsingIndex < stringToParse.length) {
            when {
                stringToParse[parsingIndex] == '[' -> {squareBracketOpen.push(parsingIndex); parsingIndex += 1}

                stringToParse[parsingIndex] == '<' -> {lessThanBracket.push(parsingIndex); parsingIndex += 1}

                stringToParse[parsingIndex] == '(' -> {parenthesisOpen.push(parsingIndex); parsingIndex += 1 }

                stringToParse[parsingIndex] == ']' -> {
                    if (squareBracketOpen.isEmpty()) {
                        parsingIndex += 1
                    } else {
                        parsedStrings.add(stringToParse.substring(squareBracketOpen.peek() + 1, parsingIndex))
                        openBracketsIndexes.put(parsedStrings.last(), squareBracketOpen.pop())
                        parsingIndex += 1
                    }
                }

                stringToParse[parsingIndex] == '>' -> {if (lessThanBracket.isEmpty()) {
                        parsingIndex += 1
                    } else {
                        parsedStrings.add(stringToParse.substring(lessThanBracket.peek() + 1, parsingIndex))
                        openBracketsIndexes.put(parsedStrings.last(), lessThanBracket.pop())
                        parsingIndex += 1
                    }
                }

                stringToParse[parsingIndex] == ')' -> {if (parenthesisOpen.isEmpty()) {
                        parsingIndex += 1
                    } else {
                        parsedStrings.add(stringToParse.substring(parenthesisOpen.peek() + 1,
                            parsingIndex))
                        openBracketsIndexes.put(parsedStrings.last(),
                            parenthesisOpen.pop())
                        parsingIndex += 1
                    }
                }
                else -> parsingIndex += 1
            }

        }
        for (i in 0..parsedStrings.size - 2) {
            if (openBracketsIndexes.getValue(parsedStrings.get(i)) > openBracketsIndexes.getValue(parsedStrings.get(i + 1))) {
                parsedStrings[i] = parsedStrings[i + 1].also {parsedStrings[i + 1] = parsedStrings[i]}
            }
        }
        val result = parsedStrings.toList()
        return result.toTypedArray()
    }
}

