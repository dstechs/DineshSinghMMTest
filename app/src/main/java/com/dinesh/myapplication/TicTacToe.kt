package com.dinesh.myapplication

class TicTacToe(val size: Int) {

    companion object {
        val userOne = 'X'
        val userTwo = 'Y'
    }

    //Hold cells information (0,0) - X
    private val selectedCells = hashMapOf<Pair<Int, Int>, Char>()


    fun setSelection(selectedUser: Char, rowIndex: Int, columnIndex: Int): Result {

        selectedCells[Pair(rowIndex, columnIndex)] = selectedUser

        if(validateRow(selectedUser, rowIndex))
            return Result.WINNER

        if(validateColumn(selectedUser, columnIndex))
            return Result.WINNER

        if(validateDiagonals(selectedUser))
            return Result.WINNER

        if(selectedCells.size == size*size)
            return Result.DRAW


        return Result.WAITING

    }

    private fun validateRow(selectedUser: Char, rowIndex: Int) : Boolean {
        for(index in 0 until size) {
            if(selectedCells[Pair(rowIndex, index)] != selectedUser) {
                return false
            }
        }

        return true
    }

    private fun validateColumn(selectedUser: Char, columnIndex: Int) : Boolean {
        for(index in 0 until size) {
            if(selectedCells[Pair(index, columnIndex)] != selectedUser) {
                return false
            }
        }
        return true
    }

    private fun validateDiagonals(selectedUser: Char): Boolean {
        var rowIndex = 0
        var columnIndex = 0
        var isValid = true
        for(index in 0 until size) {
            if(selectedUser != selectedCells[Pair(rowIndex, columnIndex)]) {
                isValid = false
                break
            }
            rowIndex++
            columnIndex++
        }

        if(isValid)
            return true

        rowIndex = size - 1
        columnIndex = 0
        for(index in 0 until size) {
            if(selectedUser != selectedCells[Pair(rowIndex, columnIndex)]) {
                return false
            }
            rowIndex--
            columnIndex++
        }

        return true
    }

    fun reset() {
        selectedCells.clear()
    }


    enum class Result {
        WINNER, DRAW, WAITING
    }

}