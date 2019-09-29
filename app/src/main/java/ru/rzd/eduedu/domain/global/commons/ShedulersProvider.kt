package ru.rzd.eduedu.domain.global.commons

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/** Created by Kamil Abdulatipov on 27.09.2019.
 *  telegram: @mr_geeek
 */

val io: Scheduler
    get() = Schedulers.io()

val ui: Scheduler
    get() = AndroidSchedulers.mainThread()