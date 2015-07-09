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

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * ${dimension}次元の${dd.concept}を表すインターフェース。
 *
 * ミューテータが存在しますが、実際に値を変更可能かどうかは実装依存です。
 *
 * @author misakura
 * @param <T> 任意の型。
 */
public interface MutableObject${dd.className.upper}${dimension}<T> extends Object${dd.className.upper}${dimension}<T> {
    <#list 0..(dimension - 1) as i>

    /**
     * この${dd.concept}の${dd.fields[i].display}にあたる値を設定する。
     *
     * 設定値を防御的にコピーするかどうかは実装依存です。
     *
     * @param ${dd.fields[i].lower} ${dd.fields[i].display}の値。
     */
    void set${dd.fields[i].upper}(T ${dd.fields[i].lower});
    </#list>
    <#list 0..(dimension - 1) as i>

    /**
     * この${dd.concept}の現在の${dd.fields[i].display}を用いて新たな値を設定する。
     *
     * 関数から導出する設定値を防御的にコピーするかどうかは実装依存です。<br>
     * デフォルトの実装では、関数から得られた設定値を用いて{@link #set${dd.fields[i].upper}}に委譲します。その設定値は防御的コピーを行わずに渡します。
     *
     * @param newValueFunction 現在の設定値を受け取り、新しい設定値を返す関数。
     */
    default void update${dd.fields[i].upper}(Function<? super T, ? extends T> newValueFunction) {
        set${dd.fields[i].upper}(newValueFunction.apply(get${dd.fields[i].upper}()));
    }
    </#list>

    /**
     * この${dd.concept}の全ての次元に値を設定する。
     *
     * 設定値を防御的にコピーするかどうかは実装依存です。<br>
     * デフォルトの実装では、それぞれの次元のミューテータに委譲します。
     *
    <#list 0..(dimension - 1) as i>
     * @param ${dd.fields[i].lower} ${dd.fields[i].display}の値。
    </#list>
     */
    default void set(<#list 0..(dimension - 1) as i>T ${dd.fields[i].lower}<#if i_has_next>, </#if></#list>) {
    <#list 0..(dimension - 1) as i>
        set${dd.fields[i].upper}(${dd.fields[i].lower});
    </#list>
    }

    /**
     * {@code T}にアップキャスト可能な型が指定された他の${dd.concept}インスタンスから全ての次元の値を取得し、この${dd.concept}へ設定する。
     *
     * 他の${dd.concept}インスタンスから取得する設定値を防御的にコピーするかどうかは実装依存です。<br>
     * デフォルトの実装では、{@link #set(<#list 0..(dimension - 1) as i>Object<#if i_has_next>, </#if></#list>)}に委譲します。
     *
     * @param ${dd.className.lower} 設定値を取得する${dd.concept}。
     */
    default void set(Object${dd.className.upper}${dimension}<? extends T> ${dd.className.lower}) {
        set(<#list 0..(dimension - 1) as i>${dd.className.lower}.get${dd.fields[i].upper}()<#if i_has_next>, </#if></#list>);
    }

    /**
     * この${dd.concept}に対して単項演算を行う。
     *
     * デフォルトの実装では、渡された演算をそれぞれの次元に適用し、得られた値を{@link #set(<#list 0..(dimension - 1) as i>Object<#if i_has_next>, </#if></#list>)}に委譲します。
     *
     * @param operator 現在の設定値を受け取り、新しい設定値を返す関数。
     */
    default void calculate(UnaryOperator<T> operator) {
        set(<#list 0..(dimension - 1) as i>operator.apply(get${dd.fields[i].upper}())<#if i_has_next>, </#if></#list>);
    }

    /**
     * この${dd.concept}に対して二項演算を行う。
     *
     * デフォルトの実装では、渡された演算をそれぞれの次元に適用し、得られた値を{@link #set(<#list 0..(dimension - 1) as i>Object<#if i_has_next>, </#if></#list>)}に委譲します。
     *
     * @param operator 現在の設定値を受け取り、新しい設定値を返す関数。
    <#list 0..(dimension - 1) as i>
     * @param ${dd.fields[i].lower} 右辺となる${dd.fields[i].display}の値。
    </#list>
     */
    default void calculate(BinaryOperator<T> operator, <#list 0..(dimension - 1) as i>T ${dd.fields[i].lower}<#if i_has_next>, </#if></#list>) {
        set(<#list 0..(dimension - 1) as i>operator.apply(get${dd.fields[i].upper}(), ${dd.fields[i].lower})<#if i_has_next>, </#if></#list>);
    }

    /**
     * この${dd.concept}に対して二項演算を行う。
     *
     * デフォルトの実装では、{@link #calculate(BinaryOperator, <#list 0..(dimension - 1) as i>Object<#if i_has_next>, </#if></#list>)}に委譲します。
     *
     * @param operator 現在の設定値を受け取り、新しい設定値を返す関数。
     * @param ${dd.className.lower} 右辺となる${dd.concept}。
     */
    default void calculate(BinaryOperator<T> operator, Object${dd.className.upper}${dimension}<? extends T> ${dd.className.lower}) {
        calculate(operator, <#list 0..(dimension - 1) as i>${dd.className.lower}.get${dd.fields[i].upper}()<#if i_has_next>, </#if></#list>);
    }
}
