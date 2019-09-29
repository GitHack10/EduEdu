package ru.rzd.eduedu.presentation.global.base

interface BottomBarListener {
    fun showBar(show: Boolean)
    fun onItemChecked(item: ITEM)

    enum class ITEM(val index: Int) {
        HOME(0),
        PROFILE(1),
    }
}