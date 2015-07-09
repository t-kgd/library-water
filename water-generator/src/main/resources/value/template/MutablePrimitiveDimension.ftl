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

import java.util.function.${p.name}BinaryOperator;
import java.util.function.${p.name}UnaryOperator;

/**
 * ${dimension}次元の${dd.concept}を表すインターフェース。
 *
 * ミューテータが存在しますが、実際に値を変更可能かどうかは実装依存です。
 *
 * @author misakura
 */
public interface Mutable${p.name}${dd.className.upper}${dimension} extends ${p.name}${dd.className.upper}${dimension} {
    <#list 0..(dimension - 1) as i>

    /**
     * この${dd.concept}の${dd.fields[i].display}にあたる値を設定する。
     *
     * @param ${dd.fields[i].lower} ${dd.fields[i].display}の値。
     */
    void set${dd.fields[i].upper}(${p.primitive} ${dd.fields[i].lower});
    </#list>
    <#list 0..(dimension - 1) as i>

    /**
     * この${dd.concept}の現在の${dd.fields[i].display}を用いて新たな値を設定する。
     *
     * デフォルトの実装では、関数から得られた設定値を用いて{@link #set${dd.fields[i].upper}}に委譲します。
     *
     * @param newValueOperator 現在の設定値を受け取り、新しい設定値を返す関数。
     */
    default void update${dd.fields[i].upper}(${p.name}UnaryOperator newValueOperator) {
        set${dd.fields[i].upper}(newValueOperator.applyAs${p.name}(get${dd.fields[i].upper}As${p.name}()));
    }
    </#list>

    /**
     * この${dd.concept}の全ての次元に値を設定する。
     *
     * デフォルトの実装では、それぞれの次元のミューテータに委譲します。
     *
    <#list 0..(dimension - 1) as i>
     * @param ${dd.fields[i].lower} ${dd.fields[i].display}の値。
    </#list>
     */
    default void set(<#list 0..(dimension - 1) as i>${p.primitive} ${dd.fields[i].lower}<#if i_has_next>, </#if></#list>) {
    <#list 0..(dimension - 1) as i>
        set${dd.fields[i].upper}(${dd.fields[i].lower});
    </#list>
    }

    /**
     * 他の${dd.concept}インスタンスから全ての次元の値を取得し、この${dd.concept}へ設定する。
     *
     * デフォルトの実装では、{@link #set(<#list 0..(dimension - 1) as i>${p.primitive}<#if i_has_next>, </#if></#list>)}に委譲します。
     *
     * @param ${dd.className.lower} 設定値を取得する${dd.concept}。
     */
    default void set(${p.name}${dd.className.upper}${dimension} ${dd.className.lower}) {
        set(<#list 0..(dimension - 1) as i>${dd.className.lower}.get${dd.fields[i].upper}As${p.name}()<#if i_has_next>, </#if></#list>);
    }

    /**
     * この${dd.concept}に対して単項演算を行う。
     *
     * デフォルトの実装では、渡された演算をそれぞれの次元に適用し、得られた値を{@link #set(<#list 0..(dimension - 1) as i>${p.primitive}<#if i_has_next>, </#if></#list>)}に委譲します。
     *
     * @param operator 現在の設定値を受け取り、新しい設定値を返す関数。
     */
    default void calculate(${p.name}UnaryOperator operator) {
        set(<#list 0..(dimension - 1) as i>operator.applyAs${p.name}(get${dd.fields[i].upper}As${p.name}())<#if i_has_next>, </#if></#list>);
    }

    /**
     * この${dd.concept}に対して二項演算を行う。
     *
     * デフォルトの実装では、渡された演算をそれぞれの次元に適用し、得られた値を{@link #set(<#list 0..(dimension - 1) as i>${p.primitive}<#if i_has_next>, </#if></#list>)}に委譲します。
     *
     * @param operator 現在の設定値を受け取り、新しい設定値を返す関数。
    <#list 0..(dimension - 1) as i>
     * @param ${dd.fields[i].lower} 右辺となる${dd.fields[i].display}の値。
    </#list>
     */
    default void calculate(${p.name}BinaryOperator operator, <#list 0..(dimension - 1) as i>${p.primitive} ${dd.fields[i].lower}<#if i_has_next>, </#if></#list>) {
        set(<#list 0..(dimension - 1) as i>operator.applyAs${p.name}(get${dd.fields[i].upper}As${p.name}(), ${dd.fields[i].lower})<#if i_has_next>, </#if></#list>);
    }

    /**
     * この${dd.concept}に対して二項演算を行う。
     *
     * デフォルトの実装では、{@link #calculate(${p.name}BinaryOperator, <#list 0..(dimension - 1) as i>${p.primitive}<#if i_has_next>, </#if></#list>)}に委譲します。
     *
     * @param operator 現在の設定値を受け取り、新しい設定値を返す関数。
     * @param ${dd.className.lower} 右辺となる${dd.concept}。
     */
    default void calculate(${p.name}BinaryOperator operator, ${p.name}${dd.className.upper}${dimension} ${dd.className.lower}) {
        calculate(operator, <#list 0..(dimension - 1) as i>${dd.className.lower}.get${dd.fields[i].upper}As${p.name}()<#if i_has_next>, </#if></#list>);
    }
}
