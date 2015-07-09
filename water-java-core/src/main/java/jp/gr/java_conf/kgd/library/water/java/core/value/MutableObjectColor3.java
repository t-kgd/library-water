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
 * 3次元の色を表すインターフェース。
 *
 * ミューテータが存在しますが、実際に値を変更可能かどうかは実装依存です。
 *
 * @author misakura
 * @param <T> 任意の型。
 */
public interface MutableObjectColor3<T> extends ObjectColor3<T> {

    /**
     * この色の赤成分にあたる値を設定する。
     *
     * 設定値を防御的にコピーするかどうかは実装依存です。
     *
     * @param red 赤成分の値。
     */
    void setRed(T red);

    /**
     * この色の緑成分にあたる値を設定する。
     *
     * 設定値を防御的にコピーするかどうかは実装依存です。
     *
     * @param green 緑成分の値。
     */
    void setGreen(T green);

    /**
     * この色の青成分にあたる値を設定する。
     *
     * 設定値を防御的にコピーするかどうかは実装依存です。
     *
     * @param blue 青成分の値。
     */
    void setBlue(T blue);

    /**
     * この色の現在の赤成分を用いて新たな値を設定する。
     *
     * 関数から導出する設定値を防御的にコピーするかどうかは実装依存です。<br>
     * デフォルトの実装では、関数から得られた設定値を用いて{@link #setRed}に委譲します。その設定値は防御的コピーを行わずに渡します。
     *
     * @param newValueFunction 現在の設定値を受け取り、新しい設定値を返す関数。
     */
    default void updateRed(Function<? super T, ? extends T> newValueFunction) {
        setRed(newValueFunction.apply(getRed()));
    }

    /**
     * この色の現在の緑成分を用いて新たな値を設定する。
     *
     * 関数から導出する設定値を防御的にコピーするかどうかは実装依存です。<br>
     * デフォルトの実装では、関数から得られた設定値を用いて{@link #setGreen}に委譲します。その設定値は防御的コピーを行わずに渡します。
     *
     * @param newValueFunction 現在の設定値を受け取り、新しい設定値を返す関数。
     */
    default void updateGreen(Function<? super T, ? extends T> newValueFunction) {
        setGreen(newValueFunction.apply(getGreen()));
    }

    /**
     * この色の現在の青成分を用いて新たな値を設定する。
     *
     * 関数から導出する設定値を防御的にコピーするかどうかは実装依存です。<br>
     * デフォルトの実装では、関数から得られた設定値を用いて{@link #setBlue}に委譲します。その設定値は防御的コピーを行わずに渡します。
     *
     * @param newValueFunction 現在の設定値を受け取り、新しい設定値を返す関数。
     */
    default void updateBlue(Function<? super T, ? extends T> newValueFunction) {
        setBlue(newValueFunction.apply(getBlue()));
    }

    /**
     * この色の全ての次元に値を設定する。
     *
     * 設定値を防御的にコピーするかどうかは実装依存です。<br>
     * デフォルトの実装では、それぞれの次元のミューテータに委譲します。
     *
     * @param red 赤成分の値。
     * @param green 緑成分の値。
     * @param blue 青成分の値。
     */
    default void set(T red, T green, T blue) {
        setRed(red);
        setGreen(green);
        setBlue(blue);
    }

    /**
     * {@code T}にアップキャスト可能な型が指定された他の色インスタンスから全ての次元の値を取得し、この色へ設定する。
     *
     * 他の色インスタンスから取得する設定値を防御的にコピーするかどうかは実装依存です。<br>
     * デフォルトの実装では、{@link #set(Object, Object, Object)}に委譲します。
     *
     * @param color 設定値を取得する色。
     */
    default void set(ObjectColor3<? extends T> color) {
        set(color.getRed(), color.getGreen(), color.getBlue());
    }

    /**
     * この色に対して単項演算を行う。
     *
     * デフォルトの実装では、渡された演算をそれぞれの次元に適用し、得られた値を{@link #set(Object, Object, Object)}に委譲します。
     *
     * @param operator 現在の設定値を受け取り、新しい設定値を返す関数。
     */
    default void calculate(UnaryOperator<T> operator) {
        set(operator.apply(getRed()), operator.apply(getGreen()), operator.apply(getBlue()));
    }

    /**
     * この色に対して二項演算を行う。
     *
     * デフォルトの実装では、渡された演算をそれぞれの次元に適用し、得られた値を{@link #set(Object, Object, Object)}に委譲します。
     *
     * @param operator 現在の設定値を受け取り、新しい設定値を返す関数。
     * @param red 右辺となる赤成分の値。
     * @param green 右辺となる緑成分の値。
     * @param blue 右辺となる青成分の値。
     */
    default void calculate(BinaryOperator<T> operator, T red, T green, T blue) {
        set(operator.apply(getRed(), red), operator.apply(getGreen(), green), operator.apply(getBlue(), blue));
    }

    /**
     * この色に対して二項演算を行う。
     *
     * デフォルトの実装では、{@link #calculate(BinaryOperator, Object, Object, Object)}に委譲します。
     *
     * @param operator 現在の設定値を受け取り、新しい設定値を返す関数。
     * @param color 右辺となる色。
     */
    default void calculate(BinaryOperator<T> operator, ObjectColor3<? extends T> color) {
        calculate(operator, color.getRed(), color.getGreen(), color.getBlue());
    }
}
