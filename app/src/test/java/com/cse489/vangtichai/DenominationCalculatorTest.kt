package com.cse489.vangtichai

import org.junit.Assert.assertEquals
import org.junit.Test

class DenominationCalculatorTest {

    @Test
    fun testZeroAmount() {
        val result = DenominationCalculator.calculateNotesMap(0)
        assertEquals(0L, result[1000])
        assertEquals(0L, result[500])
        assertEquals(0L, result[200])
        assertEquals(0L, result[100])
        assertEquals(0L, result[50])
        assertEquals(0L, result[20])
        assertEquals(0L, result[10])
        assertEquals(0L, result[5])
        assertEquals(0L, result[2])
        assertEquals(0L, result[1])
    }

    @Test
    fun testAssignmentExample786() {
        val result = DenominationCalculator.calculateNotesMap(786)
        assertEquals(0L, result[1000])
        assertEquals(1L, result[500])
        assertEquals(1L, result[200])
        assertEquals(0L, result[100])
        assertEquals(1L, result[50])
        assertEquals(1L, result[20])
        assertEquals(1L, result[10])
        assertEquals(1L, result[5])
        assertEquals(0L, result[2])
        assertEquals(1L, result[1])

        val totalSum = result.entries.sumOf { (denom, count) -> denom.toLong() * count }
        assertEquals(786L, totalSum)
    }

    @Test
    fun testSingleDenominationAmounts() {
        assertEquals(1L, DenominationCalculator.calculateNotesMap(1000)[1000])
        assertEquals(1L, DenominationCalculator.calculateNotesMap(500)[500])
        assertEquals(1L, DenominationCalculator.calculateNotesMap(200)[200])
        assertEquals(1L, DenominationCalculator.calculateNotesMap(100)[100])
        assertEquals(1L, DenominationCalculator.calculateNotesMap(50)[50])
        assertEquals(1L, DenominationCalculator.calculateNotesMap(20)[20])
        assertEquals(1L, DenominationCalculator.calculateNotesMap(10)[10])
        assertEquals(1L, DenominationCalculator.calculateNotesMap(5)[5])
        assertEquals(1L, DenominationCalculator.calculateNotesMap(2)[2])
        assertEquals(1L, DenominationCalculator.calculateNotesMap(1)[1])
    }

    @Test
    fun testSumEqualityForVariousAmounts() {
        val testAmounts = listOf(1L, 2L, 5L, 10L, 20L, 50L, 100L, 500L, 786L, 12345L, 999999999L)

        for (amount in testAmounts) {
            val result = DenominationCalculator.calculateNotesMap(amount)
            val sum = result.entries.sumOf { (denom, count) -> denom.toLong() * count }
            assertEquals("Sum must equal original amount for $amount", amount, sum)
        }
    }

    @Test
    fun testNegativeAmountHandledSafely() {
        val result = DenominationCalculator.calculateNotesMap(-50)
        assertEquals(0L, result[500])
        assertEquals(0L, result[1])
    }
}
