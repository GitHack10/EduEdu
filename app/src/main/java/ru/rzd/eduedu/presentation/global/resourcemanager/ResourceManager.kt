package ru.rzd.eduedu.presentation.global.resourcemanager

interface ResourceManager {
    fun getString(idRes: Int): String
    fun getArrayOfStrings(resourceId: Int): Array<String>
}