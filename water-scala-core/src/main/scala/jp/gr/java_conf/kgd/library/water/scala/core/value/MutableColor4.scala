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

import jp.gr.java_conf.kgd.library.water.java.core.value.{ MutableObjectColor4 => JavaMutableObjectColor4 }

trait MutableColor4[@specialized T] extends JavaMutableObjectColor4[T] with Color4[T] {

  def red_=(red: T): Unit

  def green_=(green: T): Unit

  def blue_=(blue: T): Unit

  def alpha_=(alpha: T): Unit

  override def setRed(red: T): Unit = red_=(red)

  override def setGreen(green: T): Unit = green_=(green)

  override def setBlue(blue: T): Unit = blue_=(blue)

  override def setAlpha(alpha: T): Unit = alpha_=(alpha)
}