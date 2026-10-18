package com.cse489.vangtichai

/**
 * Data class representing the calculation result for a single denomination.
 */
data class DenominationResult(
    val denomination: Int,
    val count: Long
)

/**
 * Calculator object implementing the greedy denomination algorithm
 * for Bangladeshi Taka (BDT).
 */
object DenominationCalculator {

    // Supported BDT denominations in exact required order: 500, 100, 50, 20, 10, 5, 2, 1
    val SUPPORTED_DENOMINATIONS = listOf(500, 100, 50, 20, 10, 5, 2, 1)

    /**
     * Calculates note counts for each denomination using the greedy approach.
     *
     * @param amount The total amount in BDT (non-negative).
     * @return List of DenominationResult ordered from highest to lowest denomination.
     */
    fun calculateNotes(amount: Long): List<DenominationResult> {
        val safeAmount = if (amount < 0) 0L else amount
        var remaining = safeAmount
        val results = mutableListOf<DenominationResult>()

        for (denom in SUPPORTED_DENOMINATIONS) {
            val count = remaining / denom
            remaining %= denom
            results.add(DenominationResult(denom, count))
        }

        return results
    }

    /**
     * Helper returning a Map of denomination Int to note count Long.
     */
    fun calculateNotesMap(amount: Long): Map<Int, Long> {
        return calculateNotes(amount).associate { it.denomination to it.count }
    }
}
