package com.blanktheevil.spirebirthdayparty.vfx

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.MathUtils
import com.badlogic.gdx.math.Vector2
import com.blanktheevil.spirebirthdayparty.extensions.scale
import com.megacrit.cardcrawl.helpers.Hitbox
import com.megacrit.cardcrawl.helpers.ImageMaster
import com.megacrit.cardcrawl.vfx.AbstractGameEffect

class Confetti(hb: Hitbox) : AbstractGameEffect() {
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
  val rot = Math.random().toFloat().times(359f)
  val rotvel = Math.random().times(25f)
  val vel = Vector2(MathUtils.random(-1f, 1f).scale(), MathUtils.random(-1f, 1f).scale())
  val drag = Vector2(0.999f, 0.999f)
  val grav = Vector2(0.0f, (-200f).scale())
  var life = 1f

  init {
    this.renderBehind = MathUtils.randomBoolean(0.2f)
    vel.nor()
    vel.scl(MathUtils.random(0f, 500f.scale()))
  }

  private fun applyDrag() {
    vel.x = vel.x.times(drag.x)
    if (vel.y > 0f) {
      vel.y = vel.y.times(drag.y)
    }
  }

  private fun applyGravity() {
    vel.add(grav.cpy().scl(Gdx.graphics.rawDeltaTime))
  }


  override fun update() {
    applyDrag()
    applyGravity()
    pos.add(vel.cpy().scl(Gdx.graphics.rawDeltaTime))
    rot.plus(rotvel.times(Gdx.graphics.rawDeltaTime))

    life -= Gdx.graphics.rawDeltaTime

    if (this.pos.y < 0) {
      this.isDone = true
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
      1f * Math.random().toFloat(),
      1f * Math.random().toFloat(),
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