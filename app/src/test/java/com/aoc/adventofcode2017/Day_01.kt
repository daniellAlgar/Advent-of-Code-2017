package com.aoc.adventofcode2017

import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class Day_01 {

    // ------------------------------------------ Part 1 ------------------------------------------
    @Test
    fun part1_testCircularString() {
        val input = "1122"
        val expected = "11221"
        val actual = input.toCircularString()
        assertEquals(expected, actual)
    }

    @Test
    fun part1_exampleValues() {
        val input = listOf("1122", "1111", "1234", "91212129")
        val expected = listOf(3, 4, 0, 9)

        input.forEachIndexed { index, value ->
            assertEquals(expected[index], parserPart1(value))
        }
    }

    @Test
    fun part1_answer() {
        val realValues = Mocks.day1_1

        val answer = parserPart1(input = realValues)
        println("Answer part 1: $answer")
    }

    // ------------------------------------------ Part 2 ------------------------------------------
    @Test
    fun part2_testLongCircularString() {
        val input = "1212"
        val expected = "121212"
        val actual = input.toLongCircularString()
        assertEquals(expected, actual)
    }

    @Test
    fun part2_exampleValues() {
        val input = listOf("1212", "1221", "123425", "123123", "12131415")
        val expected = listOf(6, 0, 4, 12, 4)

        input.forEachIndexed { index, value ->
            assertEquals(expected[index], parserPart2(input = value))
        }
    }

    @Test
    fun part2_answer() {
        val realValues = Mocks.day1_2

        val answer = parserPart2(input = realValues)
        println("Answer part 2: $answer")
    }
}

fun String.toCircularString(): String = this + this.first()
fun String.toLongCircularString(): String = this + this.substring(0, this.length/2)

fun parserPart1(input: String): Int {
    val data = input.toCircularString()
    return parser(input = data, stepSize = 1)
}

fun parserPart2(input: String): Int {
    val stepSize = input.length / 2
    val data = input.toLongCircularString()
    return parser(input = data, stepSize = stepSize)
}

fun parser(input: String, stepSize: Int): Int {
    return (0 until input.length - stepSize)
            .filter { input[it] == input[it + stepSize] }
            .sumBy { input[it] - '0' }
}