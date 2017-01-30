package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        val yearCompare = this.year - other.year
        if (yearCompare != 0) return yearCompare

        val monthCompare = this.month - other.month
        if (monthCompare != 0) return monthCompare

        return this.dayOfMonth - other.dayOfMonth
    }
}

operator fun MyDate.rangeTo(other: MyDate): DateRange {
    return DateRange(this, other)
}

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(override val start: MyDate, override val endInclusive: MyDate): ClosedRange<MyDate>, Iterable<MyDate> {
    override fun iterator(): Iterator<MyDate> {
        return object : Iterator<MyDate> {
            private var currentDay = start

            override fun hasNext(): Boolean {
                return currentDay <= endInclusive
            }

            override fun next(): MyDate {
                val result = currentDay
                currentDay = currentDay.nextDay()
                return result
            }
        }
    }
}
