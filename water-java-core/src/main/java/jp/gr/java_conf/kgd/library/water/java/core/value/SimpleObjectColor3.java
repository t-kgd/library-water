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

import jp.gr.java_conf.kgd.library.water.java.core.template.DataObjectBase;

/**
 * 値の変更が可能な{@link MutableObjectSize2}の実装。
 *
 * この実装のアクセッサとミューテータは防御的コピーを行いません。アクセッサはフィールドの参照をそのまま返し、ミューテータは引数の参照をそのままフィールドに設定します。
 * {@code T}が不変でない場合は注意してください。
 *
 * @author misakura
 * @param <T> 任意の型。
 */
public class SimpleObjectColor3<T> extends DataObjectBase implements MutableObjectColor3<T> {

    /**
     * 赤成分。
     */
    private T red;

    /**
     * 緑成分。
     */
    private T green;

    /**
     * 青成分。
     */
    private T blue;

    /**
     * コンストラクタ。
     */
    public SimpleObjectColor3() {
    }

    /**
     * コンストラクタ。
     *
     * 引数の参照をそのままフィールドに設定します。（防御的コピーを行いません。）
     *
     * @param red 赤成分。
     * @param green 緑成分。
     * @param blue 青成分。
     */
    public SimpleObjectColor3(T red, T green, T blue) {
       this.red = red;
       this.green = green;
       this.blue = blue;
    }

    /**
     * コンストラクタ。
     *
     * 引数の色から得られる参照をそのままフィールドに設定します。（防御的コピーを行いません。）
     *
     * @param color 設定値を取得する色。
     */
    public SimpleObjectColor3(ObjectColor3<? extends T> color) {
        this(color.getRed(), color.getGreen(), color.getBlue());
    }

    /**
     * このサイズの幅にあたる値を返す。
     *
     * フィールドの参照をそのまま返します。（防御的コピーを行いません。）
     *
     * @return {@inheritDoc}
     */
    @Override
    public T getRed() {
        return red;
    }

    /**
     * このサイズの幅にあたる値を返す。
     *
     * フィールドの参照をそのまま返します。（防御的コピーを行いません。）
     *
     * @return {@inheritDoc}
     */
    @Override
    public T getGreen() {
        return green;
    }

    /**
     * このサイズの幅にあたる値を返す。
     *
     * フィールドの参照をそのまま返します。（防御的コピーを行いません。）
     *
     * @return {@inheritDoc}
     */
    @Override
    public T getBlue() {
        return blue;
    }

    /**
     * このサイズの幅にあたる値を返す。
     *
     * 引数の参照をそのままフィールドに設定します。（防御的コピーを行いません。）
     *
     * @param red {@inheritDoc}
     */
    @Override
    public void setRed(T red) {
        this.red = red;
    }

    /**
     * このサイズの幅にあたる値を返す。
     *
     * 引数の参照をそのままフィールドに設定します。（防御的コピーを行いません。）
     *
     * @param green {@inheritDoc}
     */
    @Override
    public void setGreen(T green) {
        this.green = green;
    }

    /**
     * このサイズの幅にあたる値を返す。
     *
     * 引数の参照をそのままフィールドに設定します。（防御的コピーを行いません。）
     *
     * @param blue {@inheritDoc}
     */
    @Override
    public void setBlue(T blue) {
        this.blue = blue;
    }
}
