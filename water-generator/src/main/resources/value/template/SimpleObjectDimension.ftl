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

import jp.gr.java_conf.kgd.library.water.java.core.template.DataObjectBase;

/**
 * 値の変更が可能な{@link MutableObjectSize2}の実装。
 *
 * この実装のアクセッサとミューテータは防御的コピーを行いません。アクセッサはフィールドの参照をそのまま返し、ミューテータは引数の参照をそのままフィールドに設定します。
 * {@code T}が不変でない場合は注意してください。
 *
 * @author misakura
 * @param <T> 任意の型。
 */
public class SimpleObject${dd.className.upper}${dimension}<T> extends DataObjectBase implements MutableObject${dd.className.upper}${dimension}<T> {
    <#list 0..(dimension - 1) as i>

    /**
     * ${dd.fields[i].display}。
     */
    private T ${dd.fields[i].lower};
    </#list>

    /**
     * コンストラクタ。
     */
    public SimpleObject${dd.className.upper}${dimension}() {
    }

    /**
     * コンストラクタ。
     *
     * 引数の参照をそのままフィールドに設定します。（防御的コピーを行いません。）
     *
    <#list 0..(dimension - 1) as i>
     * @param ${dd.fields[i].lower} ${dd.fields[i].display}。
    </#list>
     */
    public SimpleObject${dd.className.upper}${dimension}(<#list 0..(dimension - 1) as i>T ${dd.fields[i].lower}<#if i_has_next>, </#if></#list>) {
       <#list 0..(dimension - 1) as i>
       this.${dd.fields[i].lower} = ${dd.fields[i].lower};
       </#list>
    }

    /**
     * コンストラクタ。
     *
     * 引数の${dd.concept}から得られる参照をそのままフィールドに設定します。（防御的コピーを行いません。）
     *
     * @param ${dd.className.lower} 設定値を取得する${dd.concept}。
     */
    public SimpleObject${dd.className.upper}${dimension}(Object${dd.className.upper}${dimension}<? extends T> ${dd.className.lower}) {
        this(<#list 0..(dimension - 1) as i>${dd.className.lower}.get${dd.fields[i].upper}()<#if i_has_next>, </#if></#list>);
    }
    <#list 0..(dimension - 1) as i>

    /**
     * このサイズの幅にあたる値を返す。
     *
     * フィールドの参照をそのまま返します。（防御的コピーを行いません。）
     *
     * @return {@inheritDoc}
     */
    @Override
    public T get${dd.fields[i].upper}() {
        return ${dd.fields[i].lower};
    }
    </#list>
    <#list 0..(dimension - 1) as i>

    /**
     * このサイズの幅にあたる値を返す。
     *
     * 引数の参照をそのままフィールドに設定します。（防御的コピーを行いません。）
     *
     * @param ${dd.fields[i].lower} {@inheritDoc}
     */
    @Override
    public void set${dd.fields[i].upper}(T ${dd.fields[i].lower}) {
        this.${dd.fields[i].lower} = ${dd.fields[i].lower};
    }
    </#list>
}
