package yandexpracticum.lesson8

/**
 * Динамическое программирование (ДП) — это не конкретный алгоритм,
 * а техника, которая позволяет эффективно решать довольно широкий класс задач.
 *
 * Задача. Дан массив из N целых чисел arr. Найдите длину максимальной
 * возрастающей подпоследовательности в этом массиве. Например, при
 * arr=[2, 3, 6, 4, 1, 3, 5, 4, 6] искомая подпоследовательность —
 * [2, 3, 4, 5, 6] и поэтому ответ равен 5.
 *
 * Очень неформально можно сказать, что метод ДП заключается в том,
 * чтобы найти некоторую вспомогательную величину, которая:
 *  1) помогает получить ответ на задачу,
 *  2) считается понятным образом.
 *
 * Попробуем понять, что может являться такой величиной для данной задачи.
 *
 */