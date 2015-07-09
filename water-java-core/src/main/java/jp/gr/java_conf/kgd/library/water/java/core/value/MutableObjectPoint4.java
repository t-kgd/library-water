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
 * 4次元の点を表すインターフェース。
 *
 * ミューテータが存在しますが、実際に値を変更可能かどうかは実装依存です。
 *
 * @author misakura
 * @param <T> 任意の型。
 */
public interface MutableObjectPoint4<T> extends ObjectPoint4<T> {

    /**
     * この点のx座標にあたる値を設定する。
     *
     * 設定値を防御的にコピーするかどうかは実装依存です。
     *
     * @param x x座標の値。
     */
    void setX(T x);

    /**
     * この点のy座標にあたる値を設定する。
     *
     * 設定値を防御的にコピーするかどうかは実装依存です。
     *
     * @param y y座標の値。
     */
    void setY(T y);

    /**
     * この点のz座標にあたる値を設定する。
     *
     * 設定値を防御的にコピーするかどうかは実装依存です。
     *
     * @param z z座標の値。
     */
    void setZ(T z);

    /**
     * この点のw座標にあたる値を設定する。
     *
     * 設定値を防御的にコピーするかどうかは実装依存です。
     *
     * @param w w座標の値。
     */
    void setW(T w);

    /**
     * この点の現在のx座標を用いて新たな値を設定する。
     *
     * 関数から導出する設定値を防御的にコピーするかどうかは実装依存です。<br>
     * デフォルトの実装では、関数から得られた設定値を用いて{@link #setX}に委譲します。その設定値は防御的コピーを行わずに渡します。
     *
     * @param newValueFunction 現在の設定値を受け取り、新しい設定値を返す関数。
     */
    default void updateX(Function<? super T, ? extends T> newValueFunction) {
        setX(newValueFunction.apply(getX()));
    }

    /**
     * この点の現在のy座標を用いて新たな値を設定する。
     *
     * 関数から導出する設定値を防御的にコピーするかどうかは実装依存です。<br>
     * デフォルトの実装では、関数から得られた設定値を用いて{@link #setY}に委譲します。その設定値は防御的コピーを行わずに渡します。
     *
     * @param newValueFunction 現在の設定値を受け取り、新しい設定値を返す関数。
     */
    default void updateY(Function<? super T, ? extends T> newValueFunction) {
        setY(newValueFunction.apply(getY()));
    }

    /**
     * この点の現在のz座標を用いて新たな値を設定する。
     *
     * 関数から導出する設定値を防御的にコピーするかどうかは実装依存です。<br>
     * デフォルトの実装では、関数から得られた設定値を用いて{@link #setZ}に委譲します。その設定値は防御的コピーを行わずに渡します。
     *
     * @param newValueFunction 現在の設定値を受け取り、新しい設定値を返す関数。
     */
    default void updateZ(Function<? super T, ? extends T> newValueFunction) {
        setZ(newValueFunction.apply(getZ()));
    }

    /**
     * この点の現在のw座標を用いて新たな値を設定する。
     *
     * 関数から導出する設定値を防御的にコピーするかどうかは実装依存です。<br>
     * デフォルトの実装では、関数から得られた設定値を用いて{@link #setW}に委譲します。その設定値は防御的コピーを行わずに渡します。
     *
     * @param newValueFunction 現在の設定値を受け取り、新しい設定値を返す関数。
     */
    default void updateW(Function<? super T, ? extends T> newValueFunction) {
        setW(newValueFunction.apply(getW()));
    }

    /**
     * この点の全ての次元に値を設定する。
     *
     * 設定値を防御的にコピーするかどうかは実装依存です。<br>
     * デフォルトの実装では、それぞれの次元のミューテータに委譲します。
     *
     * @param x x座標の値。
     * @param y y座標の値。
     * @param z z座標の値。
     * @param w w座標の値。
     */
    default void set(T x, T y, T z, T w) {
        setX(x);
        setY(y);
        setZ(z);
        setW(w);
    }

    /**
     * {@code T}にアップキャスト可能な型が指定された他の点インスタンスから全ての次元の値を取得し、この点へ設定する。
     *
     * 他の点インスタンスから取得する設定値を防御的にコピーするかどうかは実装依存です。<br>
     * デフォルトの実装では、{@link #set(Object, Object, Object, Object)}に委譲します。
     *
     * @param point 設定値を取得する点。
     */
    default void set(ObjectPoint4<? extends T> point) {
        set(point.getX(), point.getY(), point.getZ(), point.getW());
    }

    /**
     * この点に対して単項演算を行う。
     *
     * デフォルトの実装では、渡された演算をそれぞれの次元に適用し、得られた値を{@link #set(Object, Object, Object, Object)}に委譲します。
     *
     * @param operator 現在の設定値を受け取り、新しい設定値を返す関数。
     */
    default void calculate(UnaryOperator<T> operator) {
        set(operator.apply(getX()), operator.apply(getY()), operator.apply(getZ()), operator.apply(getW()));
    }

    /**
     * この点に対して二項演算を行う。
     *
     * デフォルトの実装では、渡された演算をそれぞれの次元に適用し、得られた値を{@link #set(Object, Object, Object, Object)}に委譲します。
     *
     * @param operator 現在の設定値を受け取り、新しい設定値を返す関数。
     * @param x 右辺となるx座標の値。
     * @param y 右辺となるy座標の値。
     * @param z 右辺となるz座標の値。
     * @param w 右辺となるw座標の値。
     */
    default void calculate(BinaryOperator<T> operator, T x, T y, T z, T w) {
        set(operator.apply(getX(), x), operator.apply(getY(), y), operator.apply(getZ(), z), operator.apply(getW(), w));
    }

    /**
     * この点に対して二項演算を行う。
     *
     * デフォルトの実装では、{@link #calculate(BinaryOperator, Object, Object, Object, Object)}に委譲します。
     *
     * @param operator 現在の設定値を受け取り、新しい設定値を返す関数。
     * @param point 右辺となる点。
     */
    default void calculate(BinaryOperator<T> operator, ObjectPoint4<? extends T> point) {
        calculate(operator, point.getX(), point.getY(), point.getZ(), point.getW());
    }
}
