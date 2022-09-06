package yandexpracticum.lesson7

/** Some notes from lesson paper:
 *
 * Обратите внимание, что связь, как правило, односторонняя:
 * из вершины нет указателя на родительскую вершину.
 * Построить такие указатели за один обход можно.
 * Но нужно уточнить у интервьюера, можно ли так делать
 * или от вас ждут решение без этого.
 *
 * У всех возможных задач на деревья общая идея решения:
 * нужно применить поиск в глубину, то есть
 * рекурсивный обход дерева, начиная с корня.
 *
 *
 * Вспомним, какие бывают способы обхода деревьев:
 *
 *  1) Preorder: сначала посещаем текущую вершину,
 *               затем рассматриваем её поддеревья.
 *  2) Inorder: рассматриваем левое поддерево, посещаем
 *              текущую вершину и затем рассматриваем правое поддерево.
 *              (Применим только к бинарным деревьям.)
 *  3) Postorder: рассматриваем все поддеревья
 *                текущей вершины, затем посещаем её.
 *
 *  Для следующих задач, применяются следующие виды обходов:
 *  1) Вывести все ключи двоичного дерева поиска в порядке неубывания. - Inorder
 *  2) Заданы зависимости вида «задача A должна быть выполнена ранее задачи B».
 *     Нужно сформировать корректную последовательность выполнения зада ч. - Preorder
 *  3) Для двух вершин в дереве найти наименьшего общего предка. - Postorder
 *
 *  4)  Дано бинарное дерево, нужно вывести список списков значений
 *  вершин «по слоям». В каждом слое значения должны идти слева направо.
 *  Для дерева:      5
 *                  / \
 *                 /   \
 *                3     1
 *                 \   /
 *                  4 2
 *
 * нужно вернуть: [[5], [3, 1], [4, 2]]
 * (Подсказка, вариант обхода можно выбрать любой, задача решиться любым)
 * (Подсказка, реализация на Python
 * class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None

    def get_layered_representation(root):
        result = []
        DFS(root, 0, result)
        return result

    def DFS(node, depth, result):
        if not node:
            return
        # Т.к. мы выбрали preorder, то результат нужно увеличивать
        # не больше, чем на 1
        if depth >= len(result):
            result.append([])
        result[depth].append(node.val)
        DFS(node.left, depth + 1, result)
        DFS(node.right, depth + 1, result)
 */