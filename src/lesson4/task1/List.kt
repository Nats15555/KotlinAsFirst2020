@file:Suppress("UNUSED_PARAMETER", "ConvertCallChainIntoSequence")

package lesson4.task1

import lesson1.task1.discriminant
import kotlin.math.sqrt

// Урок 4: списки
// Максимальное количество баллов = 12
// Рекомендуемое количество баллов = 8
// Вместе с предыдущими уроками = 24/33

/**
 * Пример
 *
 * Найти все корни уравнения x^2 = y
 */
fun sqRoots(y: Double) =
    when {
        y < 0 -> listOf()
        y == 0.0 -> listOf(0.0)
        else -> {
            val root = sqrt(y)
            // Результат!
            listOf(-root, root)
        }
    }

/**
 * Пример
 *
 * Найти все корни биквадратного уравнения ax^4 + bx^2 + c = 0.
 * Вернуть список корней (пустой, если корней нет)
 */
fun biRoots(a: Double, b: Double, c: Double): List<Double> {
    if (a == 0.0) {
        return if (b == 0.0) listOf()
        else sqRoots(-c / b)
    }
    val d = discriminant(a, b, c)
    if (d < 0.0) return listOf()
    else if (d == 0.0) return sqRoots(-b / (2 * a))
    val y1 = (-b + sqrt(d)) / (2 * a)
    val y2 = (-b - sqrt(d)) / (2 * a)
    return sqRoots(y1) + sqRoots(y2)
}

/**
 * Пример
 *
 * Выделить в список отрицательные элементы из заданного списка
 */
fun negativeList(list: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (element in list) {
        if (element < 0) {
            result.add(element)
        }
    }
    return result
}

/**
 * Пример
 *
 * Изменить знак для всех положительных элементов списка
 */
fun invertPositives(list: MutableList<Int>) {
    for (i in 0 until list.size) {
        val element = list[i]
        if (element > 0) {
            list[i] = -element
        }
    }
}

/**
 * Пример
 *
 * Из имеющегося списка целых чисел, сформировать список их квадратов
 */
fun squares(list: List<Int>) = list.map { it * it }

/**
 * Пример
 *
 * Из имеющихся целых чисел, заданного через vararg-параметр, сформировать массив их квадратов
 */
fun squares(vararg array: Int) = squares(array.toList()).toTypedArray()

/**
 * Пример
 *
 * По заданной строке str определить, является ли она палиндромом.
 * В палиндроме первый символ должен быть равен последнему, второй предпоследнему и т.д.
 * Одни и те же буквы в разном регистре следует считать равными с точки зрения данной задачи.
 * Пробелы не следует принимать во внимание при сравнении символов, например, строка
 * "А роза упала на лапу Азора" является палиндромом.
 */
fun isPalindrome(str: String): Boolean {
    val lowerCase = str.toLowerCase().filter { it != ' ' }
    for (i in 0..lowerCase.length / 2) {
        if (lowerCase[i] != lowerCase[lowerCase.length - i - 1]) return false
    }
    return true
}

/**
 * Пример
 *
 * По имеющемуся списку целых чисел, например [3, 6, 5, 4, 9], построить строку с примером их суммирования:
 * 3 + 6 + 5 + 4 + 9 = 27 в данном случае.
 */
fun buildSumExample(list: List<Int>) = list.joinToString(separator = " + ", postfix = " = ${list.sum()}")

/**
 * Простая (2 балла)
 *
 * Найти модуль заданного вектора, представленного в виде списка v,
 * по формуле abs = sqrt(a1^2 + a2^2 + ... + aN^2).
 * Модуль пустого вектора считать равным 0.0.
 */
fun abs(v: List<Double>): Double = TODO()

/**
 * Простая (2 балла)
 *
 * Рассчитать среднее арифметическое элементов списка list. Вернуть 0.0, если список пуст
 */
fun mean(list: List<Double>): Double = TODO()

/**
 * Средняя (3 балла)
 *
 * Центрировать заданный список list, уменьшив каждый элемент на среднее арифметическое всех элементов.
 * Если список пуст, не делать ничего. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun center(list: MutableList<Double>): MutableList<Double> = TODO()

/**
 * Средняя (3 балла)
 *
 * Найти скалярное произведение двух векторов равной размерности,
 * представленные в виде списков a и b. Скалярное произведение считать по формуле:
 * C = a1b1 + a2b2 + ... + aNbN. Произведение пустых векторов считать равным 0.
 */
fun times(a: List<Int>, b: List<Int>): Int = TODO()

/**
 * Средняя (3 балла)
 *
 * Рассчитать значение многочлена при заданном x:
 * p(x) = p0 + p1*x + p2*x^2 + p3*x^3 + ... + pN*x^N.
 * Коэффициенты многочлена заданы списком p: (p0, p1, p2, p3, ..., pN).
 * Значение пустого многочлена равно 0 при любом x.
 */
fun polynom(p: List<Int>, x: Int): Int = TODO()

/**
 * Средняя (3 балла)
 *
 * В заданном списке list каждый элемент, кроме первого, заменить
 * суммой данного элемента и всех предыдущих.
 * Например: 1, 2, 3, 4 -> 1, 3, 6, 10.
 * Пустой список не следует изменять. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun accumulate(list: MutableList<Int>): MutableList<Int> = TODO()

/**
 * Средняя (3 балла)
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде списка множителей, например 75 -> (3, 5, 5).
 * Множители в списке должны располагаться по возрастанию.
 */
fun factorize(n: Int): List<Int> = TODO()

/**
 * Сложная (4 балла)
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде строки, например 75 -> 3*5*5
 * Множители в результирующей строке должны располагаться по возрастанию.
 */
fun factorizeToString(n: Int): String = TODO()

/**
 * Средняя (3 балла)
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием base > 1.
 * Результат перевода вернуть в виде списка цифр в base-ичной системе от старшей к младшей,
 * например: n = 100, base = 4 -> (1, 2, 1, 0) или n = 250, base = 14 -> (1, 3, 12)
 */
fun convert(n: Int, base: Int): List<Int> = TODO()

/**
 * Сложная (4 балла)
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием 1 < base < 37.
 * Результат перевода вернуть в виде строки, цифры более 9 представлять латинскими
 * строчными буквами: 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: n = 100, base = 4 -> 1210, n = 250, base = 14 -> 13c
 *
 * Использовать функции стандартной библиотеки, напрямую и полностью решающие данную задачу
 * (например, n.toString(base) и подобные), запрещается.
 */
fun convertToString(n: Int, base: Int): String = TODO()

/**
 * Средняя (3 балла)
 *
 * Перевести число, представленное списком цифр digits от старшей к младшей,
 * из системы счисления с основанием base в десятичную.
 * Например: digits = (1, 3, 12), base = 14 -> 250
 */
fun decimal(digits: List<Int>, base: Int): Int = TODO()

/**
 * Сложная (4 балла)
 *
 * Перевести число, представленное цифровой строкой str,
 * из системы счисления с основанием base в десятичную.
 * Цифры более 9 представляются латинскими строчными буквами:
 * 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: str = "13c", base = 14 -> 250
 *
 * Использовать функции стандартной библиотеки, напрямую и полностью решающие данную задачу
 * (например, str.toInt(base)), запрещается.
 */
fun decimalFromString(str: String, base: Int): Int = TODO()

/**
 * Сложная (5 баллов)
 *
 * Перевести натуральное число n > 0 в римскую систему.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: 23 = XXIII, 44 = XLIV, 100 = C.
 */
fun roman(n: Int): String {
    val strArray1 = arrayOf("", "I", "IV", "V", "IX")
    val strArray2  = arrayOf("", "X", "XL", "L", "XC")
    val strArray3 = arrayOf("", "C", "CD", "D", "CM")
    val strArray4 =
        arrayOf("", "M", "MM", "MMM", "MMMM", "MMMMM", "MMMMMM", "MMMMMMM", "MMMMMMMM", "MMMMMMMMM")
    var i = n
    var flag = 1 // 4=1000 3=100 2=10 1=1
    var roman = ""
    var s = 0
    while (i > 0) {
        s = i % 10
        if (flag == 1) {
            when {
                s == 9 -> roman = strArray1[4]
                s == 8 -> roman = strArray1[3] + strArray1[1] + strArray1[1] + strArray1[1]
                s == 7 -> roman = strArray1[3] + strArray1[1] + strArray1[1]
                s == 6 -> roman = strArray1[3] + strArray1[1]
                s == 5 -> roman = strArray1[3]
                s == 4 -> roman = strArray1[2]
                s == 3 -> roman = strArray1[1] + strArray1[1] + strArray1[1]
                s == 2 -> roman = strArray1[1] + strArray1[1]
                s == 1 -> roman = strArray1[1]
            }
        }
        if (flag == 2) {
            when {
                s == 9 -> roman = strArray2[4] + roman
                s == 8 -> roman = strArray2[3] + strArray2[1] + strArray2[1] + strArray2[1] + roman
                s == 7 -> roman = strArray2[3] + strArray2[1] + strArray2[1] + roman
                s == 6 -> roman = strArray2[3] + strArray2[1] + roman
                s == 5 -> roman = strArray2[3] + roman
                s == 4 -> roman = strArray2[2] + roman
                s == 3 -> roman = strArray2[1] + strArray2[1] + strArray2[1] + roman
                s == 2 -> roman = strArray2[1] + strArray2[1] + roman
                s == 1 -> roman = strArray2[1] + roman
            }
        }
        if (flag == 3) {
            when {
                s == 9 -> roman = strArray3[4] + roman
                s == 8 -> roman = strArray3[3] + strArray3[1] + strArray3[1] + strArray3[1] + roman
                s == 7 -> roman = strArray3[3] + strArray3[1] + strArray3[1] + roman
                s == 6 -> roman = strArray3[3] + strArray3[1] + roman
                s == 5 -> roman = strArray3[3] + roman
                s == 4 -> roman = strArray3[2] + roman
                s == 3 -> roman = strArray3[1] + strArray3[1] + strArray3[1] + roman
                s == 2 -> roman = strArray3[1] + strArray3[1] + roman
                s == 1 -> roman = strArray3[1] + roman
            }
        }
        if (flag == 4) {
            when {
                s == 9 -> roman = strArray4[9] + roman
                s == 8 -> roman = strArray4[8] + roman
                s == 7 -> roman = strArray4[7] + roman
                s == 6 -> roman = strArray4[6] + roman
                s == 5 -> roman = strArray4[5] + roman
                s == 4 -> roman = strArray4[4] + roman
                s == 3 -> roman = strArray4[3] + roman
                s == 2 -> roman = strArray4[2] + roman
                s == 1 -> roman = strArray4[1] + roman
            }
        }

        flag++
        i /= 10
    }
    return roman
}

/**
 * Очень сложная (7 баллов)
 *
 * Записать заданное натуральное число 1..999999 прописью по-русски.
 * Например, 375 = "триста семьдесят пять",
 * 23964 = "двадцать три тысячи девятьсот шестьдесят четыре"
 */
fun russian(n: Int): String {
    var i = n
    var strBuf = ""

    var strArray1: Array<String> = arrayOf(
        "", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять",
        "десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать", "семнадцать",
        "восемнадцать", "девятнадцать"
    )
    var strArray2: Array<String> = arrayOf(
        "", "",
        "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", "восемьдесят", "девяносто"
    )
    var strArray3: Array<String> = arrayOf(
        "",
        "сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот",
        "девятьсот"
    )
    var strArray4: Array<String> = arrayOf(
        "тысяч",
        "одна тысяча",
        "две тысячи",
        "три тысячи",
        "четыре тысячи",
        "пять тысяч",
        "шесть тысяч",
        "семь тысяч",
        "восемь тысяч",
        "девять тысяч",
        "десять тысяч",
        "одиннадцать тысяч",
        "двенадцать тысяч",
        "тринадцать тысяч",
        "четырнадцать тысяч",
        "пятнадцать тысяч",
        "шестнадцать тысяч",
        "семнадцать тысяч",
        "восемнадцать тысяч",
        "девятнадцать тысяч"
    )
    var strArray5: Array<String> = arrayOf(
        "миллионов",
        "один миллион",
        "два миллиона",
        "три миллиона",
        "четыре миллиона",
        "пять миллионов",
        "шесть миллионов",
        "семь миллионов",
        "восемь миллионов",
        "девять миллионов",
        "десять миллионов",
        "одинадцать миллионов",
        "двеннадцать миллионов",
        "триннадцать миллионов",
        "четырннадцать миллионов",
        "пятнадцать миллионов",
        "шестнадцать миллионов",
        "семьнадцать миллионов",
        "восемьнадцать миллионов",
        "девятнадцать миллионов"
    )

    var nBuf = 0
    var flag = 0 // 0 = xxx, 1 = xxx.xxx, 2 = xxx.xxx.xxx
    while (i >= 1) {
        nBuf = i % 1000
        if (flag == 0) {
            if (nBuf % 100 < 20) {
                strBuf = strArray3[nBuf / 100] + " " + strArray1[nBuf % 100]
            } else {
                strBuf = strArray3[nBuf / 100] + " " + strArray2[(nBuf / 10) % 10] + " " + strArray1[nBuf % 10]
            }
            flag = 1
        } else if (flag == 1) {
            if (nBuf % 100 < 20) {
                strBuf = strArray3[nBuf / 100] + " " + strArray4[nBuf % 100] + " " + strBuf
            } else {
                strBuf =
                    strArray3[nBuf / 100] + " " + strArray2[(nBuf / 10) % 10] + " " + strArray4[nBuf % 10] +
                            " " + strBuf
            }
            flag = 2
        } else if (flag == 2) {
            if (nBuf % 100 < 20) {
                strBuf = strArray3[nBuf / 100] + " " + strArray5[nBuf % 100] + " " + strBuf
            } else {
                strBuf =
                    strArray3[nBuf / 100] + " " + strArray2[(nBuf / 10) % 10] + " " + strArray5[nBuf % 10] +
                            " " + strBuf
            }

        }

        i /= 1000
    }
    return strBuf.trim().replace("  ", " ")
}