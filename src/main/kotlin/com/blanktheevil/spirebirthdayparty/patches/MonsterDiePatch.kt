package com.blanktheevil.spirebirthdayparty.patches

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch
import com.megacrit.cardcrawl.monsters.AbstractMonster

@SpirePatch(clz = AbstractMonster::class, method = "die", paramtypez = [Boolean::class])
object MonsterDiePatch {
  fun yay(monster: AbstractMonster, triggerRelics: Boolean) {
    if (!monster.isDying) {
      for (i in 0 until 20) {
        println("yay!")
      }
    }
  }
}