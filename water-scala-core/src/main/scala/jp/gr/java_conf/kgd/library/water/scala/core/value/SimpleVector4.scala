/*
 * The MIT License
 *
 * Copyright 2015 misakura.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package jp.gr.java_conf.kgd.library.water.scala.core.value

import scala.math.Numeric

import jp.gr.java_conf.kgd.library.water.scala.core.util.DefaultValue._

case class SimpleVector4[@specialized T: Numeric](override var x: T, override var y: T, override var z: T, override var w: T) extends MutableVector4[T] {

  def this(vector: Vector4[_ <: T]) = this(vector.x, vector.y, vector.z, vector.w)

  def this() = this(default[T], default[T], default[T], default[T])

  override def getXAsInt(): Int = implicitly[Numeric[T]].toInt(x)

  override def getYAsInt(): Int = implicitly[Numeric[T]].toInt(y)

  override def getZAsInt(): Int = implicitly[Numeric[T]].toInt(z)

  override def getWAsInt(): Int = implicitly[Numeric[T]].toInt(w)

  override def getXAsLong(): Long = implicitly[Numeric[T]].toLong(x)

  override def getYAsLong(): Long = implicitly[Numeric[T]].toLong(y)

  override def getZAsLong(): Long = implicitly[Numeric[T]].toLong(z)

  override def getWAsLong(): Long = implicitly[Numeric[T]].toLong(w)

  override def getXAsDouble(): Double = implicitly[Numeric[T]].toDouble(x)

  override def getYAsDouble(): Double = implicitly[Numeric[T]].toDouble(y)

  override def getZAsDouble(): Double = implicitly[Numeric[T]].toDouble(z)

  override def getWAsDouble(): Double = implicitly[Numeric[T]].toDouble(w)
}
