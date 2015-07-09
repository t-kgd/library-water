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
 * 4次元の色を表すインターフェース。
 *
 * ミューテータが存在しますが、実際に値を変更可能かどうかは実装依存です。
 *
 * @author misakura
 */
public interface MutableIntColor4 extends IntColor4 {

    /**
     * この色の赤成分にあたる値を設定する。
     *
     * @param red 赤成分の値。
     */
    void setRed(int red);

    /**
     * この色の緑成分にあたる値を設定する。
     *
     * @param green 緑成分の値。
     */
    void setGreen(int green);

    /**
     * この色の青成分にあたる値を設定する。
     *
     * @param blue 青成分の値。
     */
    void setBlue(int blue);

    /**
     * この色の透明度にあたる値を設定する。
     *
     * @param alpha 透明度の値。
     */
    void setAlpha(int alpha);

    /**
     * この色の現在の赤成分を用いて新たな値を設定する。
     *
     * デフォルトの実装では、関数から得られた設定値を用いて{@link #setRed}に委譲します。
     *
     * @param newValueOperator 現在の設定値を受け取り、新しい設定値を返す関数。
     */
    default void updateRed(IntUnaryOperator newValueOperator) {
        setRed(newValueOperator.applyAsInt(getRedAsInt()));
    }

    /**
     * この色の現在の緑成分を用いて新たな値を設定する。
     *
     * デフォルトの実装では、関数から得られた設定値を用いて{@link #setGreen}に委譲します。
     *
     * @param newValueOperator 現在の設定値を受け取り、新しい設定値を返す関数。
     */
    default void updateGreen(IntUnaryOperator newValueOperator) {
        setGreen(newValueOperator.applyAsInt(getGreenAsInt()));
    }

    /**
     * この色の現在の青成分を用いて新たな値を設定する。
     *
     * デフォルトの実装では、関数から得られた設定値を用いて{@link #setBlue}に委譲します。
     *
     * @param newValueOperator 現在の設定値を受け取り、新しい設定値を返す関数。
     */
    default void updateBlue(IntUnaryOperator newValueOperator) {
        setBlue(newValueOperator.applyAsInt(getBlueAsInt()));
    }

    /**
     * この色の現在の透明度を用いて新たな値を設定する。
     *
     * デフォルトの実装では、関数から得られた設定値を用いて{@link #setAlpha}に委譲します。
     *
     * @param newValueOperator 現在の設定値を受け取り、新しい設定値を返す関数。
     */
    default void updateAlpha(IntUnaryOperator newValueOperator) {
        setAlpha(newValueOperator.applyAsInt(getAlphaAsInt()));
    }

    /**
     * この色の全ての次元に値を設定する。
     *
     * デフォルトの実装では、それぞれの次元のミューテータに委譲します。
     *
     * @param red 赤成分の値。
     * @param green 緑成分の値。
     * @param blue 青成分の値。
     * @param alpha 透明度の値。
     */
    default void set(int red, int green, int blue, int alpha) {
        setRed(red);
        setGreen(green);
        setBlue(blue);
        setAlpha(alpha);
    }

    /**
     * 他の色インスタンスから全ての次元の値を取得し、この色へ設定する。
     *
     * デフォルトの実装では、{@link #set(int, int, int, int)}に委譲します。
     *
     * @param color 設定値を取得する色。
     */
    default void set(IntColor4 color) {
        set(color.getRedAsInt(), color.getGreenAsInt(), color.getBlueAsInt(), color.getAlphaAsInt());
    }

    /**
     * この色に対して単項演算を行う。
     *
     * デフォルトの実装では、渡された演算をそれぞれの次元に適用し、得られた値を{@link #set(int, int, int, int)}に委譲します。
     *
     * @param operator 現在の設定値を受け取り、新しい設定値を返す関数。
     */
    default void calculate(IntUnaryOperator operator) {
        set(operator.applyAsInt(getRedAsInt()), operator.applyAsInt(getGreenAsInt()), operator.applyAsInt(getBlueAsInt()), operator.applyAsInt(getAlphaAsInt()));
    }

    /**
     * この色に対して二項演算を行う。
     *
     * デフォルトの実装では、渡された演算をそれぞれの次元に適用し、得られた値を{@link #set(int, int, int, int)}に委譲します。
     *
     * @param operator 現在の設定値を受け取り、新しい設定値を返す関数。
     * @param red 右辺となる赤成分の値。
     * @param green 右辺となる緑成分の値。
     * @param blue 右辺となる青成分の値。
     * @param alpha 右辺となる透明度の値。
     */
    default void calculate(IntBinaryOperator operator, int red, int green, int blue, int alpha) {
        set(operator.applyAsInt(getRedAsInt(), red), operator.applyAsInt(getGreenAsInt(), green), operator.applyAsInt(getBlueAsInt(), blue), operator.applyAsInt(getAlphaAsInt(), alpha));
    }

    /**
     * この色に対して二項演算を行う。
     *
     * デフォルトの実装では、{@link #calculate(IntBinaryOperator, int, int, int, int)}に委譲します。
     *
     * @param operator 現在の設定値を受け取り、新しい設定値を返す関数。
     * @param color 右辺となる色。
     */
    default void calculate(IntBinaryOperator operator, IntColor4 color) {
        calculate(operator, color.getRedAsInt(), color.getGreenAsInt(), color.getBlueAsInt(), color.getAlphaAsInt());
    }
}
