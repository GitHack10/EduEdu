package ru.rzd.eduedu.presentation.global.utils

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup

fun ViewGroup.inflate(layoutId: Int) = LayoutInflater.from(context).inflate(
    layoutId,
    this,
    false
)!!

inline fun <T : Fragment> T.withArgs(
    argsBuilder: Bundle.() -> Unit
): T =
    this.apply {
        arguments = Bundle().apply(argsBuilder)
    }