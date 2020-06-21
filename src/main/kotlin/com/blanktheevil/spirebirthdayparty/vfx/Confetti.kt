package com.blanktheevil.spirebirthdayparty.vfx

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.MathUtils
import com.badlogic.gdx.math.Vector2
import com.blanktheevil.spirebirthdayparty.extensions.scale
import com.megacrit.cardcrawl.helpers.Hitbox
import com.megacrit.cardcrawl.helpers.ImageMaster
import com.megacrit.cardcrawl.vfx.AbstractGameEffect

class Confetti(val hb: Hitbox) : AbstractGameEffect() {
  companion object Luis {
    val SIZE = 10.scale()
  }

  val col = Color(
    Math.random().toFloat(),
    Math.random().toFloat(),
    Math.random().toFloat(),
    1f
  )

  val pos = Vector2(hb.cX, hb.cY)
  val rot = Math.random().toFloat()
  val vel = Vector2(MathUtils.random(-1f, 1f).scale(), MathUtils.random(-1f, 1f).scale())
  val drag = Vector2(0.99f, 0.99f)
  val grav = Vector2(0.0f, -0.1f)

  init {
    this.renderBehind = MathUtils.randomBoolean(0.2f)
    vel.nor()
    vel.scl(MathUtils.random(0f, 3f))
  }

  private fun applyDrag() {
    vel.x = vel.x.times(drag.x)
    vel.y = vel.y.times(drag.y)
  }

  private fun applyGravity() {
    vel.add(grav)
  }


  override fun update() {
    applyDrag()
    applyGravity()
    pos.add(vel)

    if (this.pos.y < 0) {
      this.isDone
    }
  }

  override fun render(sb: SpriteBatch) {
    sb.color = this.col
    sb.draw(
      ImageMaster.WHITE_SQUARE_IMG,
      pos.x,
      pos.y,
      SIZE.div(2f),
      SIZE.div(2f),
      SIZE,
      SIZE,
      1f,
      1f,
      rot,
      0,
      0,
      ImageMaster.WHITE_SQUARE_IMG.width,
      ImageMaster.WHITE_SQUARE_IMG.height,
      false,
      false
    )
  }

  override fun dispose() {

  }
}