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

package ${packageLevel.scala}

import scala.math.Numeric

import jp.gr.java_conf.kgd.library.water.scala.core.util.DefaultValue._

case class Simple${dd.className.upper}${dimension}[@specialized T: Numeric](<#list 0..(dimension - 1) as i>override var ${dd.fields[i].lower}: T<#if i_has_next>, </#if></#list>) extends Mutable${dd.className.upper}${dimension}[T] {

  def this(${dd.className.lower}: ${dd.className.upper}${dimension}[_ <: T]) = this(<#list 0..(dimension - 1) as i>${dd.className.lower}.${dd.fields[i].lower}<#if i_has_next>, </#if></#list>)

  def this() = this(<#list 0..(dimension - 1) as i>default[T]<#if i_has_next>, </#if></#list>)
  <#list primitives as pit>
  <#list 0..(dimension - 1) as i>

  override def get${dd.fields[i].upper}As${pit.name}(): ${pit.name} = implicitly[Numeric[T]].to${pit.name}(${dd.fields[i].lower})
  </#list>
  </#list>
}
