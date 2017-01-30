package iii_conventions

import util.TODO


class Invokable {
    var getNumberOfInvocations = 0

    operator fun invoke(): Invokable {
        getNumberOfInvocations++
        return this
    }
}

fun todoTask31(): Nothing = TODO(
    """
        Task 31.
        Change class Invokable to count the number of invocations (round brackets).
        Uncomment the commented code - it should return 4.
    """,
    references = { invokable: Invokable -> })

fun task31(invokable: Invokable): Int {
    return call(invokable, 4).getNumberOfInvocations
}

fun call(invokable: Invokable, count:Int) : Invokable {
    for (i in 1..count) invokable.invoke()
    return invokable
}