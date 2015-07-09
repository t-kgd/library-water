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

import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;

/**
 * 4次元のベクトルを表すインターフェース。
 *
 * ミューテータが存在しますが、実際に値を変更可能かどうかは実装依存です。
 *
 * @author misakura
 */
public interface MutableIntVector4 extends IntVector4 {

    /**
     * このベクトルのx成分にあたる値を設定する。
     *
     * @param x x成分の値。
     */
    void setX(int x);

    /**
     * このベクトルのy成分にあたる値を設定する。
     *
     * @param y y成分の値。
     */
    void setY(int y);

    /**
     * このベクトルのz成分にあたる値を設定する。
     *
     * @param z z成分の値。
     */
    void setZ(int z);

    /**
     * このベクトルのw成分にあたる値を設定する。
     *
     * @param w w成分の値。
     */
    void setW(int w);

    /**
     * このベクトルの現在のx成分を用いて新たな値を設定する。
     *
     * デフォルトの実装では、関数から得られた設定値を用いて{@link #setX}に委譲します。
     *
     * @param newValueOperator 現在の設定値を受け取り、新しい設定値を返す関数。
     */
    default void updateX(IntUnaryOperator newValueOperator) {
        setX(newValueOperator.applyAsInt(getXAsInt()));
    }

    /**
     * このベクトルの現在のy成分を用いて新たな値を設定する。
     *
     * デフォルトの実装では、関数から得られた設定値を用いて{@link #setY}に委譲します。
     *
     * @param newValueOperator 現在の設定値を受け取り、新しい設定値を返す関数。
     */
    default void updateY(IntUnaryOperator newValueOperator) {
        setY(newValueOperator.applyAsInt(getYAsInt()));
    }

    /**
     * このベクトルの現在のz成分を用いて新たな値を設定する。
     *
     * デフォルトの実装では、関数から得られた設定値を用いて{@link #setZ}に委譲します。
     *
     * @param newValueOperator 現在の設定値を受け取り、新しい設定値を返す関数。
     */
    default void updateZ(IntUnaryOperator newValueOperator) {
        setZ(newValueOperator.applyAsInt(getZAsInt()));
    }

    /**
     * このベクトルの現在のw成分を用いて新たな値を設定する。
     *
     * デフォルトの実装では、関数から得られた設定値を用いて{@link #setW}に委譲します。
     *
     * @param newValueOperator 現在の設定値を受け取り、新しい設定値を返す関数。
     */
    default void updateW(IntUnaryOperator newValueOperator) {
        setW(newValueOperator.applyAsInt(getWAsInt()));
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
    default void set(int x, int y, int z, int w) {
        setX(x);
        setY(y);
        setZ(z);
        setW(w);
    }

    /**
     * 他のベクトルインスタンスから全ての次元の値を取得し、このベクトルへ設定する。
     *
     * デフォルトの実装では、{@link #set(int, int, int, int)}に委譲します。
     *
     * @param vector 設定値を取得するベクトル。
     */
    default void set(IntVector4 vector) {
        set(vector.getXAsInt(), vector.getYAsInt(), vector.getZAsInt(), vector.getWAsInt());
    }

    /**
     * このベクトルに対して単項演算を行う。
     *
     * デフォルトの実装では、渡された演算をそれぞれの次元に適用し、得られた値を{@link #set(int, int, int, int)}に委譲します。
     *
     * @param operator 現在の設定値を受け取り、新しい設定値を返す関数。
     */
    default void calculate(IntUnaryOperator operator) {
        set(operator.applyAsInt(getXAsInt()), operator.applyAsInt(getYAsInt()), operator.applyAsInt(getZAsInt()), operator.applyAsInt(getWAsInt()));
    }

    /**
     * このベクトルに対して二項演算を行う。
     *
     * デフォルトの実装では、渡された演算をそれぞれの次元に適用し、得られた値を{@link #set(int, int, int, int)}に委譲します。
     *
     * @param operator 現在の設定値を受け取り、新しい設定値を返す関数。
     * @param x 右辺となるx成分の値。
     * @param y 右辺となるy成分の値。
     * @param z 右辺となるz成分の値。
     * @param w 右辺となるw成分の値。
     */
    default void calculate(IntBinaryOperator operator, int x, int y, int z, int w) {
        set(operator.applyAsInt(getXAsInt(), x), operator.applyAsInt(getYAsInt(), y), operator.applyAsInt(getZAsInt(), z), operator.applyAsInt(getWAsInt(), w));
    }

    /**
     * このベクトルに対して二項演算を行う。
     *
     * デフォルトの実装では、{@link #calculate(IntBinaryOperator, int, int, int, int)}に委譲します。
     *
     * @param operator 現在の設定値を受け取り、新しい設定値を返す関数。
     * @param vector 右辺となるベクトル。
     */
    default void calculate(IntBinaryOperator operator, IntVector4 vector) {
        calculate(operator, vector.getXAsInt(), vector.getYAsInt(), vector.getZAsInt(), vector.getWAsInt());
    }
}
