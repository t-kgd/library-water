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

case class SimpleColor3[@specialized T: Numeric](override var red: T, override var green: T, override var blue: T) extends MutableColor3[T] {

  def this(color: Color3[_ <: T]) = this(color.red, color.green, color.blue)

  def this() = this(default[T], default[T], default[T])

  override def getRedAsInt(): Int = implicitly[Numeric[T]].toInt(red)

  override def getGreenAsInt(): Int = implicitly[Numeric[T]].toInt(green)

  override def getBlueAsInt(): Int = implicitly[Numeric[T]].toInt(blue)

  override def getRedAsLong(): Long = implicitly[Numeric[T]].toLong(red)

  override def getGreenAsLong(): Long = implicitly[Numeric[T]].toLong(green)

  override def getBlueAsLong(): Long = implicitly[Numeric[T]].toLong(blue)

  override def getRedAsDouble(): Double = implicitly[Numeric[T]].toDouble(red)

  override def getGreenAsDouble(): Double = implicitly[Numeric[T]].toDouble(green)

  override def getBlueAsDouble(): Double = implicitly[Numeric[T]].toDouble(blue)
}
