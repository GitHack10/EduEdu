package ru.rzd.eduedu.presentation.global.resourcemanager

import android.content.Context
import javax.inject.Inject

/** Created by Kamil Abdulatipov on 27.09.2019.
 *  telegram: @mr_geeek
 */

class AndroidResourceManager @Inject constructor(
    private val context: Context
) : ResourceManager {

    override fun getString(idRes: Int): String =
        context.getString(idRes)

    override fun getArrayOfStrings(resourceId: Int): Array<String> =
        context.resources.getStringArray(resourceId)
}