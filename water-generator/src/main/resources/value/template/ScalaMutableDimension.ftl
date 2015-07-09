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

import ${packageLevel.java}.{ MutableObject${dd.className.upper}${dimension} => JavaMutableObject${dd.className.upper}${dimension} }

trait Mutable${dd.className.upper}${dimension}[@specialized T] extends JavaMutableObject${dd.className.upper}${dimension}[T] with ${dd.className.upper}${dimension}[T] {
  <#list 0..(dimension - 1) as i>

  def ${dd.fields[i].lower}_=(${dd.fields[i].lower}: T): Unit
  </#list>
  <#list 0..(dimension - 1) as i>

  override def set${dd.fields[i].upper}(${dd.fields[i].lower}: T): Unit = ${dd.fields[i].lower}_=(${dd.fields[i].lower})
  </#list>
}
