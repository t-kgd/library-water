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
 * 値の変更が可能な{@link MutableSize2}の実装。
 *
 * この実装のアクセッサとミューテータは防御的コピーを行いません。アクセッサはフィールドの参照をそのまま返し、ミューテータは引数の参照をそのままフィールドに設定します。
 * {@code T}が不変でない場合は注意してください。
 *
 * @author misakura
 * @param <T> 任意の型。
 */
public class SimpleObjectVector2<T> extends DataObjectBase implements MutableObjectVector2<T> {

    /**
     * x成分。
     */
    private T x;

    /**
     * y成分。
     */
    private T y;

    /**
     * コンストラクタ。
     */
    public SimpleObjectVector2() {
    }

    /**
     * コンストラクタ。
     *
     * 引数の参照をそのままフィールドに設定します。（防御的コピーを行いません。）
     *
     * @param x x成分。
     * @param y y成分。
     */
    public SimpleObjectVector2(T x, T y) {
       this.x = x;
       this.y = y;
    }

    /**
     * コンストラクタ。
     *
     * 引数のベクトルから得られる参照をそのままフィールドに設定します。（防御的コピーを行いません。）
     *
     * @param vector 設定値を取得するベクトル。
     */
    public SimpleObjectVector2(ObjectVector2<? extends T> vector) {
        this(vector.getX(), vector.getY());
    }

    /**
     * このサイズの幅にあたる値を返す。
     *
     * フィールドの参照をそのまま返します。（防御的コピーを行いません。）
     *
     * @return {@inheritDoc}
     */
    @Override
    public T getX() {
        return x;
    }

    /**
     * このサイズの幅にあたる値を返す。
     *
     * フィールドの参照をそのまま返します。（防御的コピーを行いません。）
     *
     * @return {@inheritDoc}
     */
    @Override
    public T getY() {
        return y;
    }

    /**
     * このサイズの幅にあたる値を返す。
     *
     * 引数の参照をそのままフィールドに設定します。（防御的コピーを行いません。）
     *
     * @param x {@inheritDoc}
     */
    @Override
    public void setX(T x) {
        this.x = x;
    }

    /**
     * このサイズの幅にあたる値を返す。
     *
     * 引数の参照をそのままフィールドに設定します。（防御的コピーを行いません。）
     *
     * @param y {@inheritDoc}
     */
    @Override
    public void setY(T y) {
        this.y = y;
    }
}
