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

case class SimpleSize2[@specialized T: Numeric](override var width: T, override var height: T) extends MutableSize2[T] {

  def this(size: Size2[_ <: T]) = this(size.width, size.height)

  def this() = this(default[T], default[T])

  override def getWidthAsInt(): Int = implicitly[Numeric[T]].toInt(width)

  override def getHeightAsInt(): Int = implicitly[Numeric[T]].toInt(height)

  override def getWidthAsLong(): Long = implicitly[Numeric[T]].toLong(width)

  override def getHeightAsLong(): Long = implicitly[Numeric[T]].toLong(height)

  override def getWidthAsDouble(): Double = implicitly[Numeric[T]].toDouble(width)

  override def getHeightAsDouble(): Double = implicitly[Numeric[T]].toDouble(height)
}
