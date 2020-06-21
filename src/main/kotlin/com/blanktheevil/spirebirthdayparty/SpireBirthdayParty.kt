package com.blanktheevil.spirebirthdayparty

import basemod.BaseMod
import basemod.interfaces.PostInitializeSubscriber
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer
import com.megacrit.cardcrawl.audio.Sfx
import java.io.IOException
import java.util.*

@Suppress("unused")
@SpireInitializer
class SpireBirthdayParty : PostInitializeSubscriber {
  companion object Alfred {
    var name: String = "[name not loaded]"
    var version: String = "[version not loaded]"
    var modid: String = "[modid not loaded]"
    var author: String = "[author not loaded]"
    var description: String = "[description not loaded]"

    private lateinit var sfx: Sfx

    @JvmStatic
    fun initialize() {
      loadProjectProperties()
      BaseMod.subscribe(SpireBirthdayParty())
    }

    private fun loadProjectProperties() {
      try {
        with(Properties()) {
          load(SpireBirthdayParty::class.java.getResourceAsStream("/META-INF/spirebirthdayparty.prop"))
          name = getProperty("name")
          version = getProperty("version")
          modid = getProperty("id")
          author = getProperty("author")
          description = getProperty("description")
        }
      } catch (e: IOException) {
        e.printStackTrace()
      }
    }

    private fun loadSFX() {
      sfx = Sfx("com/blanktheevil/spirebirthdayparty/sounds/yay.mp3")
      sfx.play(0.0f)
    }

    fun YAAAAY() {
      sfx.play(0.04f)
    }
  }

  override fun receivePostInitialize() {
    loadSFX()
  }
}