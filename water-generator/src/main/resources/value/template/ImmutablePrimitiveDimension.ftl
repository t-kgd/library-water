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
package jp.gr.java_conf.kgd.library.water.java.core.value;

import jp.gr.java_conf.kgd.library.water.java.core.template.DataObjectBase;

/**
 * 不変であり、かつ、フィールドに直接アクセス可能な{@link ${p.name}${dd.className.upper}${dimension}}の実装。
 *
 * フィールドに直接アクセス可能なため、原則としてインターフェース部分に使ってはいけません。
 * また、内部状態をプリミティブ型で保持するので必然的にアクセッサは防御的コピーを行います。
 *
 * @author misakura
 */
public class Immutable${p.name}${dd.className.upper}${dimension} extends DataObjectBase implements ${p.name}${dd.className.upper}${dimension}Trait {

    /**
     * 全ての値が{@code 0}である${dd.concept}。
     */
    public static final Immutable${p.name}${dd.className.upper}${dimension} ZERO = new Immutable${p.name}${dd.className.upper}${dimension}(<#list 0..(dimension - 1) as i>0<#if i_has_next>, </#if></#list>);

    /**
     * 全ての値が{@code 1}である${dd.concept}。
     */
    public static final Immutable${p.name}${dd.className.upper}${dimension} ONE = new Immutable${p.name}${dd.className.upper}${dimension}(<#list 0..(dimension - 1) as i>1<#if i_has_next>, </#if></#list>);

    /**
     * 全ての値が{@code -1}である${dd.concept}。
     */
    public static final Immutable${p.name}${dd.className.upper}${dimension} MINUS = new Immutable${p.name}${dd.className.upper}${dimension}(<#list 0..(dimension - 1) as i>-1<#if i_has_next>, </#if></#list>);
    <#list 0..(dimension - 1) as i>

    /**
     * ${dd.fields[i].display}
     */
    public final ${p.primitive} ${dd.fields[i].lower};
    </#list>

    /**
     * コンストラクタ。
     *
    <#list 0..(dimension - 1) as i>
     * @param ${dd.fields[i].lower} ${dd.fields[i].display}。
    </#list>
     */
    public Immutable${p.name}${dd.className.upper}${dimension}(<#list 0..(dimension - 1) as i>${p.primitive} ${dd.fields[i].lower}<#if i_has_next>, </#if></#list>) {
        <#list 0..(dimension - 1) as i>
        this.${dd.fields[i].lower} = ${dd.fields[i].lower};
        </#list>
    }

    /**
     * コンストラクタ。
     *
     * @param ${dd.className.lower} 設定値を取得する${dd.concept}。
     */
    public Immutable${p.name}${dd.className.upper}${dimension}(${p.name}${dd.className.upper}${dimension} ${dd.className.lower}) {
        this(<#list 0..(dimension - 1) as i>${dd.className.lower}.get${dd.fields[i].upper}As${p.name}()<#if i_has_next>, </#if></#list>);
    }

    <#list 0..(dimension - 1) as i>

    @Override
    public ${p.primitive} get${dd.fields[i].upper}As${p.name}() {
        return ${dd.fields[i].lower};
    }
    </#list>
}
