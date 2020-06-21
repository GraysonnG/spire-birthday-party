package com.blanktheevil.spirebirthdayparty

import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer
import java.io.IOException
import java.util.*

@Suppress("unused")
@SpireInitializer
class SpireBirthdayParty {
  companion object Alfred {
    var name: String = "[name not loaded]"
    var version: String = "[version not loaded]"
    var modid: String = "[modid not loaded]"
    var author: String = "[author not loaded]"
    var description: String = "[description not loaded]"

    @JvmStatic
    fun initialize() {

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
  }
}