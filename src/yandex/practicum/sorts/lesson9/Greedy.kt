package yandex.practicum.sorts.lesson9

/**
 * Задача: есть N соревнований по спортивному программированию,
 * i-е из них проходит в промежуток времени [ai,bi). Какое
 * максимальное количество соревнований можно выбрать, чтобы в любой
 * момент времени проходило не более одного соревнования из этого набора?
 *
 * Чтобы решить эту задачу, нужно упорядочить соревнования
 * и выбирать по следующему правилу: если предыдущее соревнование
 * закончилось к началу рассматриваемого, то мы добавляем текущее
 * соревнование к итоговому набору. Если нет — переходим к следующему.
 *
 * Как именно нужно упорядочивать соревнования,
 * чтобы жадный алгоритм давал правильный ответ?
 *
 * Подсказка: По времени окончания
 *
 *
 * Доказательство корректности
 *
 * Пусть S — это множество доступных (т. е. не пересекающихся с уже выбранными) событий.
 * Обозначим за R(X) максимальное подмножество непересекающихся событий множества X.
 * Рассмотрим такое событие e=[es,ef)∈S, что его ef минимален среди событий S.
 * Обозначим за P подмножество событий из S непересекающихся с e.
 * Тогда множество {e}∪R(P) — это возможный ответ на задачу.
 * Докажем, что он оптимальный, т. е. ∣{e}∪R(P)∣=∣R(S)∣.
 *
 * Рассмотрим в R(S) событие с минимальной правой границей e’=[es’,ef’)∈R(S).
 * По условию минимальности ef выполняется ef⩽ef’. Обозначим за Q подмножество
 * событий из S непересекающихся с e′ Ясно, что R(S)={e’}∪R(Q).
 * Теперь нужно показать, что ∣{e}∪R(P)∣=∣{e’}∪R(Q). Поскольку R(S)
 * оптимально для S, то по определению ∣e∪R(P)∣⩽*     ∣{e’}∪R(Q)∣.
 * Так что нужно доказать, что ∣R(P)∣⩾∣R(Q)∣.
 *
 * Возможны случаи:
 *
 *  1) Если es’⩾ef, то возникает противоречие максимальности R(S):
 *     в него можно добавить событие eee и ответ увеличится.
 *
 *  2) Иначе рассмотрим q=[qs,qf)∈Q. Это событие обладает свойством qs⩾ef’,
 *     а поскольку ef’⩾ef, то qs⩾ef, а значит, q∈P.
 *     Это означает, что Q⊂P, поэтому ∣R(Q)∣⩽∣R(P)∣.
 *
 *  Других случаев нет, поэтому доказано, что e∈R(S).e\in R(S).e∈R(S).
 *
 *
 * Жадные алгоритмы — очень хитрая тема. Часто задача выглядит
 * как решаемая с их помощью, а на самом деле это не так.
 * Проблема в том, что надёжно доказать применимость жадного алгоритма сложно.
 * Поэтому мы предлагаем несколько соображений:
 *
 * 1) На собеседованиях жадные алгоритмы чаще всего встречаются в задачах
 *    вроде первой задачи из этого урока — прорешайте их. Ещё полезно изучить темы,
 *    связанные с кодом Хаффмана и минимальным остовным деревом.
 *
 * 2) Если задача на какую-то другую тему, то старайтесь думать,
 *    что она НЕ решается жадным алгоритмом, и ищите другие способы.
 *
 * 3) Если вы всё-таки уверены, что задача решается жадным алгоритмом,
 *    постарайтесь придумать контрпримеры.
 *
 * 4) Если контрпримеры найти не получится, озвучьте решение интервьюеру.
 *    Он либо подтвердит вашу догадку, либо задаст правильное направление.
 *
 * 5) Если всё-таки получилось найти контрпример, не пытайтесь адаптировать
 *    жадный алгоритм под этот контрпример. Скорее всего, задача таким образом
 *    не решается и вы впустую потратите время. Возможно, стоит смотреть
 *    в сторону динамического программирования.
 */