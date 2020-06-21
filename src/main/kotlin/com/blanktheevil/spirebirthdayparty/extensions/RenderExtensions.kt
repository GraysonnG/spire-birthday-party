package com.blanktheevil.spirebirthdayparty.extensions

import com.megacrit.cardcrawl.core.Settings

fun Float.scale(): Float = this.times(Settings.scale)
fun Int.scale(): Float = this.times(Settings.scale)