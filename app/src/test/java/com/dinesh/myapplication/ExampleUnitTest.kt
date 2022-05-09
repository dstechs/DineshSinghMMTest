package com.dinesh.myapplication

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun testingTicTacToe() {
        val ticTacToe = TicTacToe(3)

        ticTacToe.setSelection(TicTacToe.userOne, 0,0)
        ticTacToe.setSelection(TicTacToe.userTwo, 4,0)
        ticTacToe.setSelection(TicTacToe.userOne, 0,1)
        ticTacToe.setSelection(TicTacToe.userTwo, 4,1)
        val result = ticTacToe.setSelection(TicTacToe.userOne, 0,2)
        assertEquals("${result.name}",TicTacToe.Result.WINNER, result)
    }

    @Test
    fun drawTestCase() {
        val ticTacToe = TicTacToe(3)

        ticTacToe.setSelection(TicTacToe.userOne, 0,0)
        ticTacToe.setSelection(TicTacToe.userTwo, 0,1)
        ticTacToe.setSelection(TicTacToe.userOne, 1,0)
        ticTacToe.setSelection(TicTacToe.userTwo, 2,0)

        ticTacToe.setSelection(TicTacToe.userTwo, 1,1)
        ticTacToe.setSelection(TicTacToe.userOne, 2,1)
        ticTacToe.setSelection(TicTacToe.userTwo, 0,3)
        ticTacToe.setSelection(TicTacToe.userOne, 1,3)
        var result = ticTacToe.setSelection(TicTacToe.userTwo, 2,3)
        assertEquals("${result.name}",TicTacToe.Result.DRAW, result)
    }

    @Test
    fun diagonalTestCase() {
        val ticTacToe = TicTacToe(3)

        ticTacToe.setSelection(TicTacToe.userOne, 0,0)
        ticTacToe.setSelection(TicTacToe.userTwo, 0,1)
        ticTacToe.setSelection(TicTacToe.userOne, 1,1)
        ticTacToe.setSelection(TicTacToe.userTwo, 0,2)
        val result = ticTacToe.setSelection(TicTacToe.userOne, 2,2)
        assertEquals("${result.name}",TicTacToe.Result.WINNER, result)
    }

    @Test
    fun centerTestCase() {
        val ticTacToe = TicTacToe(3)

        ticTacToe.setSelection(TicTacToe.userOne, 0,0)
        ticTacToe.setSelection(TicTacToe.userTwo, 0,1)
        ticTacToe.setSelection(TicTacToe.userOne, 1 ,2)
        ticTacToe.setSelection(TicTacToe.userTwo, 1,1)
        ticTacToe.setSelection(TicTacToe.userOne, 0,3)
        val result = ticTacToe.setSelection(TicTacToe.userTwo, 2,1)
        assertEquals("${result.name}",TicTacToe.Result.WINNER, result)
    }

    @Test
    fun diagonalRightTestCase() {
        val ticTacToe = TicTacToe(3)

        ticTacToe.setSelection(TicTacToe.userOne, 2,0)
        ticTacToe.setSelection(TicTacToe.userTwo, 0,1)
        ticTacToe.setSelection(TicTacToe.userOne, 1,1)
        ticTacToe.setSelection(TicTacToe.userTwo, 2,2)
        val result = ticTacToe.setSelection(TicTacToe.userOne, 0,2)
        assertEquals("${result.name}",TicTacToe.Result.WINNER, result)
    }
}