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
 * 4次元のベクトルを表すインターフェース。
 *
 * ミューテータが存在しますが、実際に値を変更可能かどうかは実装依存です。
 *
 * @author misakura
 */
public interface MutableLongVector4 extends LongVector4 {

    /**
     * このベクトルのx成分にあたる値を設定する。
     *
     * @param x x成分の値。
     */
    void setX(long x);

    /**
     * このベクトルのy成分にあたる値を設定する。
     *
     * @param y y成分の値。
     */
    void setY(long y);

    /**
     * このベクトルのz成分にあたる値を設定する。
     *
     * @param z z成分の値。
     */
    void setZ(long z);

    /**
     * このベクトルのw成分にあたる値を設定する。
     *
     * @param w w成分の値。
     */
    void setW(long w);

    /**
     * このベクトルの現在のx成分を用いて新たな値を設定する。
     *
     * デフォルトの実装では、関数から得られた設定値を用いて{@link #setX}に委譲します。
     *
     * @param newValueOperator 現在の設定値を受け取り、新しい設定値を返す関数。
     */
    default void updateX(LongUnaryOperator newValueOperator) {
        setX(newValueOperator.applyAsLong(getXAsLong()));
    }

    /**
     * このベクトルの現在のy成分を用いて新たな値を設定する。
     *
     * デフォルトの実装では、関数から得られた設定値を用いて{@link #setY}に委譲します。
     *
     * @param newValueOperator 現在の設定値を受け取り、新しい設定値を返す関数。
     */
    default void updateY(LongUnaryOperator newValueOperator) {
        setY(newValueOperator.applyAsLong(getYAsLong()));
    }

    /**
     * このベクトルの現在のz成分を用いて新たな値を設定する。
     *
     * デフォルトの実装では、関数から得られた設定値を用いて{@link #setZ}に委譲します。
     *
     * @param newValueOperator 現在の設定値を受け取り、新しい設定値を返す関数。
     */
    default void updateZ(LongUnaryOperator newValueOperator) {
        setZ(newValueOperator.applyAsLong(getZAsLong()));
    }

    /**
     * このベクトルの現在のw成分を用いて新たな値を設定する。
     *
     * デフォルトの実装では、関数から得られた設定値を用いて{@link #setW}に委譲します。
     *
     * @param newValueOperator 現在の設定値を受け取り、新しい設定値を返す関数。
     */
    default void updateW(LongUnaryOperator newValueOperator) {
        setW(newValueOperator.applyAsLong(getWAsLong()));
    }

    /**
     * このベクトルの全ての次元に値を設定する。
     *
     * デフォルトの実装では、それぞれの次元のミューテータに委譲します。
     *
     * @param x x成分の値。
     * @param y y成分の値。
     * @param z z成分の値。
     * @param w w成分の値。
     */
    default void set(long x, long y, long z, long w) {
        setX(x);
        setY(y);
        setZ(z);
        setW(w);
    }

    /**
     * 他のベクトルインスタンスから全ての次元の値を取得し、このベクトルへ設定する。
     *
     * デフォルトの実装では、{@link #set(long, long, long, long)}に委譲します。
     *
     * @param vector 設定値を取得するベクトル。
     */
    default void set(LongVector4 vector) {
        set(vector.getXAsLong(), vector.getYAsLong(), vector.getZAsLong(), vector.getWAsLong());
    }

    /**
     * このベクトルに対して単項演算を行う。
     *
     * デフォルトの実装では、渡された演算をそれぞれの次元に適用し、得られた値を{@link #set(long, long, long, long)}に委譲します。
     *
     * @param operator 現在の設定値を受け取り、新しい設定値を返す関数。
     */
    default void calculate(LongUnaryOperator operator) {
        set(operator.applyAsLong(getXAsLong()), operator.applyAsLong(getYAsLong()), operator.applyAsLong(getZAsLong()), operator.applyAsLong(getWAsLong()));
    }

    /**
     * このベクトルに対して二項演算を行う。
     *
     * デフォルトの実装では、渡された演算をそれぞれの次元に適用し、得られた値を{@link #set(long, long, long, long)}に委譲します。
     *
     * @param operator 現在の設定値を受け取り、新しい設定値を返す関数。
     * @param x 右辺となるx成分の値。
     * @param y 右辺となるy成分の値。
     * @param z 右辺となるz成分の値。
     * @param w 右辺となるw成分の値。
     */
    default void calculate(LongBinaryOperator operator, long x, long y, long z, long w) {
        set(operator.applyAsLong(getXAsLong(), x), operator.applyAsLong(getYAsLong(), y), operator.applyAsLong(getZAsLong(), z), operator.applyAsLong(getWAsLong(), w));
    }

    /**
     * このベクトルに対して二項演算を行う。
     *
     * デフォルトの実装では、{@link #calculate(LongBinaryOperator, long, long, long, long)}に委譲します。
     *
     * @param operator 現在の設定値を受け取り、新しい設定値を返す関数。
     * @param vector 右辺となるベクトル。
     */
    default void calculate(LongBinaryOperator operator, LongVector4 vector) {
        calculate(operator, vector.getXAsLong(), vector.getYAsLong(), vector.getZAsLong(), vector.getWAsLong());
    }
}
