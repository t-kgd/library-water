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
public class SimpleObjectSize2<T> extends DataObjectBase implements MutableObjectSize2<T> {

    /**
     * 幅。
     */
    private T width;

    /**
     * 高さ。
     */
    private T height;

    /**
     * コンストラクタ。
     */
    public SimpleObjectSize2() {
    }

    /**
     * コンストラクタ。
     *
     * 引数の参照をそのままフィールドに設定します。（防御的コピーを行いません。）
     *
     * @param width 幅。
     * @param height 高さ。
     */
    public SimpleObjectSize2(T width, T height) {
       this.width = width;
       this.height = height;
    }

    /**
     * コンストラクタ。
     *
     * 引数のサイズから得られる参照をそのままフィールドに設定します。（防御的コピーを行いません。）
     *
     * @param size 設定値を取得するサイズ。
     */
    public SimpleObjectSize2(ObjectSize2<? extends T> size) {
        this(size.getWidth(), size.getHeight());
    }

    /**
     * このサイズの幅にあたる値を返す。
     *
     * フィールドの参照をそのまま返します。（防御的コピーを行いません。）
     *
     * @return {@inheritDoc}
     */
    @Override
    public T getWidth() {
        return width;
    }

    /**
     * このサイズの幅にあたる値を返す。
     *
     * フィールドの参照をそのまま返します。（防御的コピーを行いません。）
     *
     * @return {@inheritDoc}
     */
    @Override
    public T getHeight() {
        return height;
    }

    /**
     * このサイズの幅にあたる値を返す。
     *
     * 引数の参照をそのままフィールドに設定します。（防御的コピーを行いません。）
     *
     * @param width {@inheritDoc}
     */
    @Override
    public void setWidth(T width) {
        this.width = width;
    }

    /**
     * このサイズの幅にあたる値を返す。
     *
     * 引数の参照をそのままフィールドに設定します。（防御的コピーを行いません。）
     *
     * @param height {@inheritDoc}
     */
    @Override
    public void setHeight(T height) {
        this.height = height;
    }
}
