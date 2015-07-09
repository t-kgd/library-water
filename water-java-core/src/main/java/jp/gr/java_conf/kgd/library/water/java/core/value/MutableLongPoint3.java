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
 * 3次元の点を表すインターフェース。
 *
 * ミューテータが存在しますが、実際に値を変更可能かどうかは実装依存です。
 *
 * @author misakura
 */
public interface MutableLongPoint3 extends LongPoint3 {

    /**
     * この点のx座標にあたる値を設定する。
     *
     * @param x x座標の値。
     */
    void setX(long x);

    /**
     * この点のy座標にあたる値を設定する。
     *
     * @param y y座標の値。
     */
    void setY(long y);

    /**
     * この点のz座標にあたる値を設定する。
     *
     * @param z z座標の値。
     */
    void setZ(long z);

    /**
     * この点の現在のx座標を用いて新たな値を設定する。
     *
     * デフォルトの実装では、関数から得られた設定値を用いて{@link #setX}に委譲します。
     *
     * @param newValueOperator 現在の設定値を受け取り、新しい設定値を返す関数。
     */
    default void updateX(LongUnaryOperator newValueOperator) {
        setX(newValueOperator.applyAsLong(getXAsLong()));
    }

    /**
     * この点の現在のy座標を用いて新たな値を設定する。
     *
     * デフォルトの実装では、関数から得られた設定値を用いて{@link #setY}に委譲します。
     *
     * @param newValueOperator 現在の設定値を受け取り、新しい設定値を返す関数。
     */
    default void updateY(LongUnaryOperator newValueOperator) {
        setY(newValueOperator.applyAsLong(getYAsLong()));
    }

    /**
     * この点の現在のz座標を用いて新たな値を設定する。
     *
     * デフォルトの実装では、関数から得られた設定値を用いて{@link #setZ}に委譲します。
     *
     * @param newValueOperator 現在の設定値を受け取り、新しい設定値を返す関数。
     */
    default void updateZ(LongUnaryOperator newValueOperator) {
        setZ(newValueOperator.applyAsLong(getZAsLong()));
    }

    /**
     * この点の全ての次元に値を設定する。
     *
     * デフォルトの実装では、それぞれの次元のミューテータに委譲します。
     *
     * @param x x座標の値。
     * @param y y座標の値。
     * @param z z座標の値。
     */
    default void set(long x, long y, long z) {
        setX(x);
        setY(y);
        setZ(z);
    }

    /**
     * 他の点インスタンスから全ての次元の値を取得し、この点へ設定する。
     *
     * デフォルトの実装では、{@link #set(long, long, long)}に委譲します。
     *
     * @param point 設定値を取得する点。
     */
    default void set(LongPoint3 point) {
        set(point.getXAsLong(), point.getYAsLong(), point.getZAsLong());
    }

    /**
     * この点に対して単項演算を行う。
     *
     * デフォルトの実装では、渡された演算をそれぞれの次元に適用し、得られた値を{@link #set(long, long, long)}に委譲します。
     *
     * @param operator 現在の設定値を受け取り、新しい設定値を返す関数。
     */
    default void calculate(LongUnaryOperator operator) {
        set(operator.applyAsLong(getXAsLong()), operator.applyAsLong(getYAsLong()), operator.applyAsLong(getZAsLong()));
    }

    /**
     * この点に対して二項演算を行う。
     *
     * デフォルトの実装では、渡された演算をそれぞれの次元に適用し、得られた値を{@link #set(long, long, long)}に委譲します。
     *
     * @param operator 現在の設定値を受け取り、新しい設定値を返す関数。
     * @param x 右辺となるx座標の値。
     * @param y 右辺となるy座標の値。
     * @param z 右辺となるz座標の値。
     */
    default void calculate(LongBinaryOperator operator, long x, long y, long z) {
        set(operator.applyAsLong(getXAsLong(), x), operator.applyAsLong(getYAsLong(), y), operator.applyAsLong(getZAsLong(), z));
    }

    /**
     * この点に対して二項演算を行う。
     *
     * デフォルトの実装では、{@link #calculate(LongBinaryOperator, long, long, long)}に委譲します。
     *
     * @param operator 現在の設定値を受け取り、新しい設定値を返す関数。
     * @param point 右辺となる点。
     */
    default void calculate(LongBinaryOperator operator, LongPoint3 point) {
        calculate(operator, point.getXAsLong(), point.getYAsLong(), point.getZAsLong());
    }
}
