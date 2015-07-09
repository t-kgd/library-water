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
package ${packageLevel.java};

/**
 * 値の型を{@link ${p.type}}に特化し、デフォルトの挙動を定めた{@link ${p.name}${dd.className.upper}${dimension}}。
 *
 * デフォルトの挙動を定めたものであり、原則としてインターフェース部分に使ってはいけません。
 *
 * @author misakura
 */
public interface ${p.name}${dd.className.upper}${dimension}Trait extends Object${dd.className.upper}${dimension}<${p.type}>, Number${dd.className.upper}${dimension} {
    <#list primitives as pit>
    <#if pit != p>
    <#list 0..(dimension - 1) as i>

    /**
     * この${dd.concept}の${dd.fields[i].display}にあたる値を返す。
     *
     * デフォルトの実装では、{@link #get${dd.fields[i].upper}As${p.name}()}に委譲し、得られた値を静的キャストして返します。
     *
     * @return {@inheritDoc}
     */
    @Override
    default ${pit.primitive} get${dd.fields[i].upper}As${pit.name}() {
        return (${pit.primitive}) get${dd.fields[i].upper}As${p.name}();
    }
    </#list>
    </#if>
    </#list>
    <#list 0..(dimension - 1) as i>

    /**
     * この${dd.concept}の${dd.fields[i].display}にあたる値を返す。
     *
     * 得られる値が防御的にコピーされたものであるかどうかは実装依存です。<br>
     * デフォルトの実装では、{@link #get${dd.fields[i].upper}As${p.name}()}に委譲し、得られた値をボックス化して返します。（つまり、防御的コピーを行います。）
     *
     * @return {@inheritDoc}
     * @deprecated このインターフェースを直接操作する場合は{@link #get${dd.fields[i].upper}As${p.name}()}を使うべきです。
     */
    @Deprecated
    @Override
    default ${p.type} get${dd.fields[i].upper}() {
        return get${dd.fields[i].upper}As${p.name}();
    }
    </#list>
}
