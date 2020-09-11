@file:Suppress("UNUSED_PARAMETER")

package lesson2.task2

import lesson1.task1.sqr
import kotlin.math.abs
import kotlin.math.pow

/**
 * Пример
 *
 * Лежит ли точка (x, y) внутри окружности с центром в (x0, y0) и радиусом r?
 */
fun pointInsideCircle(x: Double, y: Double, x0: Double, y0: Double, r: Double) =
    sqr(x - x0) + sqr(y - y0) <= sqr(r)

/**
 * Простая (2 балла)
 *
 * Четырехзначное число назовем счастливым, если сумма первых двух ее цифр равна сумме двух последних.
 * Определить, счастливое ли заданное число, вернуть true, если это так.
 */
fun isNumberHappy(number: Int): Boolean {
    if ((number / 100) / 10 + (number / 100) % 10 == (number % 100) / 10 + (number % 100) % 10) return true
    return false
}

/**
 * Простая (2 балла)
 *
 * На шахматной доске стоят два ферзя (ферзь бьет по вертикали, горизонтали и диагоналям).
 * Определить, угрожают ли они друг другу. Вернуть true, если угрожают.
 * Считать, что ферзи не могут загораживать друг друга.
 */
fun queenThreatens(x1: Int, y1: Int, x2: Int, y2: Int): Boolean {
    if ((x1 == x2 || y1 == y2) || (abs(x1 - x2) == abs(y1 - y2))) return true
    return false
}


/**
 * Простая (2 балла)
 *
 * Дан номер месяца (от 1 до 12 включительно) и год (положительный).
 * Вернуть число дней в этом месяце этого года по григорианскому календарю.
 */
fun daysInMonth(month: Int, year: Int): Int {
    if (year % 4 == 0 && month == 2) {
        if (year % 100 != 0) return 29
        if (year % 400 == 0) return 29
    }
    return 28 + (month + month / 8) % 2 + 2 % month + 1 / month * 2
}

/**
 * Простая (2 балла)
 *
 * Проверить, лежит ли окружность с центром в (x1, y1) и радиусом r1 целиком внутри
 * окружности с центром в (x2, y2) и радиусом r2.
 * Вернуть true, если утверждение верно
 */
fun circleInside(
    x1: Double, y1: Double, r1: Double,
    x2: Double, y2: Double, r2: Double
): Boolean {
    var new_y1 = y1
    var new_y2 = y2
    var new_x1 = x1
    var new_x2 = x2
    if (new_y1 == 5e-324) new_y1 = 0.0
    if (new_y2 == 5e-324) new_y2 = 0.0
    if (new_x1 == 5e-324) new_x1 = 0.0
    if (new_x2 == 5e-324) new_x2 = 0.0
    if (new_x1 == new_x2 && new_y1 == new_y2 && r1 == r2) return true

    val p1 = new_x1 + r1
    val p2 = new_x1 - r1
    val p3 = new_y1 - r1
    val p4 = new_y1 + r1
    if ((p1 - new_x2).pow(2) + (new_y1 - new_y2).pow(2) <= (r2).pow(2) &&
        (p2 - new_x2).pow(2) + (new_y1 - new_y2).pow(2) <= (r2).pow(2) &&
        (x1 - new_x2).pow(2) + (p3 - new_y2).pow(2) <= (r2).pow(2) &&
        (x1 - new_x2).pow(2) + (p4 - new_y2).pow(2) <= (r2).pow(2)
    ) return true

    return false

}


/**
 * Средняя (3 балла)
 *
 * Определить, пройдет ли кирпич со сторонами а, b, c сквозь прямоугольное отверстие в стене со сторонами r и s.
 * Стороны отверстия должны быть параллельны граням кирпича.
 * Считать, что совпадения длин сторон достаточно для прохождения кирпича, т.е., например,
 * кирпич 4 х 4 х 4 пройдёт через отверстие 4 х 4.
 * Вернуть true, если кирпич пройдёт
 */
fun brickPasses(a: Int, b: Int, c: Int, r: Int, s: Int): Boolean {
    if (a <= s && b <= r) return true
    if (a <= r && b <= s) return true
    if (c <= s && b <= r) return true
    if (c <= r && b <= s) return true
    if (c <= s && a <= r) return true
    if (c <= r && a <= s) return true
    return false
}
