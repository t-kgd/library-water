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

import java.util.function.LongBinaryOperator;
import java.util.function.LongUnaryOperator;

/**
 * 2次元のサイズを表すインターフェース。
 *
 * ミューテータが存在しますが、実際に値を変更可能かどうかは実装依存です。
 *
 * @author misakura
 */
public interface MutableLongSize2 extends LongSize2 {

    /**
     * このサイズの幅にあたる値を設定する。
     *
     * @param width 幅の値。
     */
    void setWidth(long width);

    /**
     * このサイズの高さにあたる値を設定する。
     *
     * @param height 高さの値。
     */
    void setHeight(long height);

    /**
     * このサイズの現在の幅を用いて新たな値を設定する。
     *
     * デフォルトの実装では、関数から得られた設定値を用いて{@link #setWidth}に委譲します。
     *
     * @param newValueOperator 現在の設定値を受け取り、新しい設定値を返す関数。
     */
    default void updateWidth(LongUnaryOperator newValueOperator) {
        setWidth(newValueOperator.applyAsLong(getWidthAsLong()));
    }

    /**
     * このサイズの現在の高さを用いて新たな値を設定する。
     *
     * デフォルトの実装では、関数から得られた設定値を用いて{@link #setHeight}に委譲します。
     *
     * @param newValueOperator 現在の設定値を受け取り、新しい設定値を返す関数。
     */
    default void updateHeight(LongUnaryOperator newValueOperator) {
        setHeight(newValueOperator.applyAsLong(getHeightAsLong()));
    }

    /**
     * このサイズの全ての次元に値を設定する。
     *
     * デフォルトの実装では、それぞれの次元のミューテータに委譲します。
     *
     * @param width 幅の値。
     * @param height 高さの値。
     */
    default void set(long width, long height) {
        setWidth(width);
        setHeight(height);
    }

    /**
     * 他のサイズインスタンスから全ての次元の値を取得し、このサイズへ設定する。
     *
     * デフォルトの実装では、{@link #set(long, long)}に委譲します。
     *
     * @param size 設定値を取得するサイズ。
     */
    default void set(LongSize2 size) {
        set(size.getWidthAsLong(), size.getHeightAsLong());
    }

    /**
     * このサイズに対して単項演算を行う。
     *
     * デフォルトの実装では、渡された演算をそれぞれの次元に適用し、得られた値を{@link #set(long, long)}に委譲します。
     *
     * @param operator 現在の設定値を受け取り、新しい設定値を返す関数。
     */
    default void calculate(LongUnaryOperator operator) {
        set(operator.applyAsLong(getWidthAsLong()), operator.applyAsLong(getHeightAsLong()));
    }

    /**
     * このサイズに対して二項演算を行う。
     *
     * デフォルトの実装では、渡された演算をそれぞれの次元に適用し、得られた値を{@link #set(long, long)}に委譲します。
     *
     * @param operator 現在の設定値を受け取り、新しい設定値を返す関数。
     * @param width 右辺となる幅の値。
     * @param height 右辺となる高さの値。
     */
    default void calculate(LongBinaryOperator operator, long width, long height) {
        set(operator.applyAsLong(getWidthAsLong(), width), operator.applyAsLong(getHeightAsLong(), height));
    }

    /**
     * このサイズに対して二項演算を行う。
     *
     * デフォルトの実装では、{@link #calculate(LongBinaryOperator, long, long)}に委譲します。
     *
     * @param operator 現在の設定値を受け取り、新しい設定値を返す関数。
     * @param size 右辺となるサイズ。
     */
    default void calculate(LongBinaryOperator operator, LongSize2 size) {
        calculate(operator, size.getWidthAsLong(), size.getHeightAsLong());
    }
}
