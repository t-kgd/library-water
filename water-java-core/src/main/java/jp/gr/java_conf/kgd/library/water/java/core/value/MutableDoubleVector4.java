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

import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleUnaryOperator;

/**
 * 4次元のベクトルを表すインターフェース。
 *
 * ミューテータが存在しますが、実際に値を変更可能かどうかは実装依存です。
 *
 * @author misakura
 */
public interface MutableDoubleVector4 extends DoubleVector4 {

    /**
     * このベクトルのx成分にあたる値を設定する。
     *
     * @param x x成分の値。
     */
    void setX(double x);

    /**
     * このベクトルのy成分にあたる値を設定する。
     *
     * @param y y成分の値。
     */
    void setY(double y);

    /**
     * このベクトルのz成分にあたる値を設定する。
     *
     * @param z z成分の値。
     */
    void setZ(double z);

    /**
     * このベクトルのw成分にあたる値を設定する。
     *
     * @param w w成分の値。
     */
    void setW(double w);

    /**
     * このベクトルの現在のx成分を用いて新たな値を設定する。
     *
     * デフォルトの実装では、関数から得られた設定値を用いて{@link #setX}に委譲します。
     *
     * @param newValueOperator 現在の設定値を受け取り、新しい設定値を返す関数。
     */
    default void updateX(DoubleUnaryOperator newValueOperator) {
        setX(newValueOperator.applyAsDouble(getXAsDouble()));
    }

    /**
     * このベクトルの現在のy成分を用いて新たな値を設定する。
     *
     * デフォルトの実装では、関数から得られた設定値を用いて{@link #setY}に委譲します。
     *
     * @param newValueOperator 現在の設定値を受け取り、新しい設定値を返す関数。
     */
    default void updateY(DoubleUnaryOperator newValueOperator) {
        setY(newValueOperator.applyAsDouble(getYAsDouble()));
    }

    /**
     * このベクトルの現在のz成分を用いて新たな値を設定する。
     *
     * デフォルトの実装では、関数から得られた設定値を用いて{@link #setZ}に委譲します。
     *
     * @param newValueOperator 現在の設定値を受け取り、新しい設定値を返す関数。
     */
    default void updateZ(DoubleUnaryOperator newValueOperator) {
        setZ(newValueOperator.applyAsDouble(getZAsDouble()));
    }

    /**
     * このベクトルの現在のw成分を用いて新たな値を設定する。
     *
     * デフォルトの実装では、関数から得られた設定値を用いて{@link #setW}に委譲します。
     *
     * @param newValueOperator 現在の設定値を受け取り、新しい設定値を返す関数。
     */
    default void updateW(DoubleUnaryOperator newValueOperator) {
        setW(newValueOperator.applyAsDouble(getWAsDouble()));
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
    default void set(double x, double y, double z, double w) {
        setX(x);
        setY(y);
        setZ(z);
        setW(w);
    }

    /**
     * 他のベクトルインスタンスから全ての次元の値を取得し、このベクトルへ設定する。
     *
     * デフォルトの実装では、{@link #set(double, double, double, double)}に委譲します。
     *
     * @param vector 設定値を取得するベクトル。
     */
    default void set(DoubleVector4 vector) {
        set(vector.getXAsDouble(), vector.getYAsDouble(), vector.getZAsDouble(), vector.getWAsDouble());
    }

    /**
     * このベクトルに対して単項演算を行う。
     *
     * デフォルトの実装では、渡された演算をそれぞれの次元に適用し、得られた値を{@link #set(double, double, double, double)}に委譲します。
     *
     * @param operator 現在の設定値を受け取り、新しい設定値を返す関数。
     */
    default void calculate(DoubleUnaryOperator operator) {
        set(operator.applyAsDouble(getXAsDouble()), operator.applyAsDouble(getYAsDouble()), operator.applyAsDouble(getZAsDouble()), operator.applyAsDouble(getWAsDouble()));
    }

    /**
     * このベクトルに対して二項演算を行う。
     *
     * デフォルトの実装では、渡された演算をそれぞれの次元に適用し、得られた値を{@link #set(double, double, double, double)}に委譲します。
     *
     * @param operator 現在の設定値を受け取り、新しい設定値を返す関数。
     * @param x 右辺となるx成分の値。
     * @param y 右辺となるy成分の値。
     * @param z 右辺となるz成分の値。
     * @param w 右辺となるw成分の値。
     */
    default void calculate(DoubleBinaryOperator operator, double x, double y, double z, double w) {
        set(operator.applyAsDouble(getXAsDouble(), x), operator.applyAsDouble(getYAsDouble(), y), operator.applyAsDouble(getZAsDouble(), z), operator.applyAsDouble(getWAsDouble(), w));
    }

    /**
     * このベクトルに対して二項演算を行う。
     *
     * デフォルトの実装では、{@link #calculate(DoubleBinaryOperator, double, double, double, double)}に委譲します。
     *
     * @param operator 現在の設定値を受け取り、新しい設定値を返す関数。
     * @param vector 右辺となるベクトル。
     */
    default void calculate(DoubleBinaryOperator operator, DoubleVector4 vector) {
        calculate(operator, vector.getXAsDouble(), vector.getYAsDouble(), vector.getZAsDouble(), vector.getWAsDouble());
    }
}
