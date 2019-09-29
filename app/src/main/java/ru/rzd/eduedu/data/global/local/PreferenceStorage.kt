package ru.rzd.eduedu.data.global.local

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/** Created by Kamil Abdulatipov on 27.09.2019.
 *  telegram: @mr_geeek
 */

interface PreferenceStorage {
    var isLogin: Boolean
    var token: String
}

class SharedPreferenceStorage @Inject constructor(context: Context) :
    PreferenceStorage {

    private val prefs: SharedPreferences =
        context.getSharedPreferences(PREF_PROFILE, Context.MODE_PRIVATE)

    override var token by StringPreference(prefs, PREF_TOKEN, "")

    override var isLogin by BooleanPreference(prefs, PREF_IS_LOGIN, false)

    companion object {
        const val PREF_PROFILE = "PROFILE_STORE"
        const val PREF_TOKEN = "PREF_TOKEN"
        const val PREF_IS_LOGIN = "PREF_IS_LOGIN"
    }
}

class StringPreference(
    private val pref: SharedPreferences,
    private val key: String,
    private val defaultValue: String
) : ReadWriteProperty<Any, String> {

    override fun getValue(thisRef: Any, property: KProperty<*>): String {
        return pref.getString(key, defaultValue)!!
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: String) {
        pref.edit()
            .putString(key, value)
            .apply()
    }
}

class BooleanPreference(
    private val pref: SharedPreferences,
    private val key: String,
    private val defaultValue: Boolean
) : ReadWriteProperty<Any, Boolean> {

    override fun setValue(thisRef: Any, property: KProperty<*>, value: Boolean) =
        pref.edit().putBoolean(key, value).apply()

    override fun getValue(thisRef: Any, property: KProperty<*>) =
        pref.getBoolean(key, defaultValue)
}