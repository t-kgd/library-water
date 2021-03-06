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
public class SimpleObjectPoint4<T> extends DataObjectBase implements MutableObjectPoint4<T> {

    /**
     * x座標。
     */
    private T x;

    /**
     * y座標。
     */
    private T y;

    /**
     * z座標。
     */
    private T z;

    /**
     * w座標。
     */
    private T w;

    /**
     * コンストラクタ。
     */
    public SimpleObjectPoint4() {
    }

    /**
     * コンストラクタ。
     *
     * 引数の参照をそのままフィールドに設定します。（防御的コピーを行いません。）
     *
     * @param x x座標。
     * @param y y座標。
     * @param z z座標。
     * @param w w座標。
     */
    public SimpleObjectPoint4(T x, T y, T z, T w) {
       this.x = x;
       this.y = y;
       this.z = z;
       this.w = w;
    }

    /**
     * コンストラクタ。
     *
     * 引数の点から得られる参照をそのままフィールドに設定します。（防御的コピーを行いません。）
     *
     * @param point 設定値を取得する点。
     */
    public SimpleObjectPoint4(ObjectPoint4<? extends T> point) {
        this(point.getX(), point.getY(), point.getZ(), point.getW());
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
     * フィールドの参照をそのまま返します。（防御的コピーを行いません。）
     *
     * @return {@inheritDoc}
     */
    @Override
    public T getZ() {
        return z;
    }

    /**
     * このサイズの幅にあたる値を返す。
     *
     * フィールドの参照をそのまま返します。（防御的コピーを行いません。）
     *
     * @return {@inheritDoc}
     */
    @Override
    public T getW() {
        return w;
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

    /**
     * このサイズの幅にあたる値を返す。
     *
     * 引数の参照をそのままフィールドに設定します。（防御的コピーを行いません。）
     *
     * @param z {@inheritDoc}
     */
    @Override
    public void setZ(T z) {
        this.z = z;
    }

    /**
     * このサイズの幅にあたる値を返す。
     *
     * 引数の参照をそのままフィールドに設定します。（防御的コピーを行いません。）
     *
     * @param w {@inheritDoc}
     */
    @Override
    public void setW(T w) {
        this.w = w;
    }
}
