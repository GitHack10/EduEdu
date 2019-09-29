package ru.diitcenter.mytester.presentation.mvp.global

/**
 * Используется для передачи выбранного элемента между экранами.
 * Например, возврат выбранного элемента с экрана "Список элементов" на предыдущий экран.
 */
class ItemSelection {
    var selectedItem = Any()
        set(value) {
            field = value
            changeListener?.invoke(value)
        }

    private var changeListener: ((Any) -> Unit)? = null

    fun setOnChangeListener(listener: ((Any) -> Unit)?) {
        this.changeListener = listener
    }
}