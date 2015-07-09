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

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * 2次元のサイズを表すインターフェース。
 *
 * ミューテータが存在しますが、実際に値を変更可能かどうかは実装依存です。
 *
 * @author misakura
 * @param <T> 任意の型。
 */
public interface MutableObjectSize2<T> extends ObjectSize2<T> {

    /**
     * このサイズの幅にあたる値を設定する。
     *
     * 設定値を防御的にコピーするかどうかは実装依存です。
     *
     * @param width 幅の値。
     */
    void setWidth(T width);

    /**
     * このサイズの高さにあたる値を設定する。
     *
     * 設定値を防御的にコピーするかどうかは実装依存です。
     *
     * @param height 高さの値。
     */
    void setHeight(T height);

    /**
     * このサイズの現在の幅を用いて新たな値を設定する。
     *
     * 関数から導出する設定値を防御的にコピーするかどうかは実装依存です。<br>
     * デフォルトの実装では、関数から得られた設定値を用いて{@link #setWidth}に委譲します。その設定値は防御的コピーを行わずに渡します。
     *
     * @param newValueFunction 現在の設定値を受け取り、新しい設定値を返す関数。
     */
    default void updateWidth(Function<? super T, ? extends T> newValueFunction) {
        setWidth(newValueFunction.apply(getWidth()));
    }

    /**
     * このサイズの現在の高さを用いて新たな値を設定する。
     *
     * 関数から導出する設定値を防御的にコピーするかどうかは実装依存です。<br>
     * デフォルトの実装では、関数から得られた設定値を用いて{@link #setHeight}に委譲します。その設定値は防御的コピーを行わずに渡します。
     *
     * @param newValueFunction 現在の設定値を受け取り、新しい設定値を返す関数。
     */
    default void updateHeight(Function<? super T, ? extends T> newValueFunction) {
        setHeight(newValueFunction.apply(getHeight()));
    }

    /**
     * このサイズの全ての次元に値を設定する。
     *
     * 設定値を防御的にコピーするかどうかは実装依存です。<br>
     * デフォルトの実装では、それぞれの次元のミューテータに委譲します。
     *
     * @param width 幅の値。
     * @param height 高さの値。
     */
    default void set(T width, T height) {
        setWidth(width);
        setHeight(height);
    }

    /**
     * {@code T}にアップキャスト可能な型が指定された他のサイズインスタンスから全ての次元の値を取得し、このサイズへ設定する。
     *
     * 他のサイズインスタンスから取得する設定値を防御的にコピーするかどうかは実装依存です。<br>
     * デフォルトの実装では、{@link #set(Object, Object)}に委譲します。
     *
     * @param size 設定値を取得するサイズ。
     */
    default void set(ObjectSize2<? extends T> size) {
        set(size.getWidth(), size.getHeight());
    }

    /**
     * このサイズに対して単項演算を行う。
     *
     * デフォルトの実装では、渡された演算をそれぞれの次元に適用し、得られた値を{@link #set(Object, Object)}に委譲します。
     *
     * @param operator 現在の設定値を受け取り、新しい設定値を返す関数。
     */
    default void calculate(UnaryOperator<T> operator) {
        set(operator.apply(getWidth()), operator.apply(getHeight()));
    }

    /**
     * このサイズに対して二項演算を行う。
     *
     * デフォルトの実装では、渡された演算をそれぞれの次元に適用し、得られた値を{@link #set(Object, Object)}に委譲します。
     *
     * @param operator 現在の設定値を受け取り、新しい設定値を返す関数。
     * @param width 右辺となる幅の値。
     * @param height 右辺となる高さの値。
     */
    default void calculate(BinaryOperator<T> operator, T width, T height) {
        set(operator.apply(getWidth(), width), operator.apply(getHeight(), height));
    }

    /**
     * このサイズに対して二項演算を行う。
     *
     * デフォルトの実装では、{@link #calculate(BinaryOperator, Object, Object)}に委譲します。
     *
     * @param operator 現在の設定値を受け取り、新しい設定値を返す関数。
     * @param size 右辺となるサイズ。
     */
    default void calculate(BinaryOperator<T> operator, ObjectSize2<? extends T> size) {
        calculate(operator, size.getWidth(), size.getHeight());
    }
}
