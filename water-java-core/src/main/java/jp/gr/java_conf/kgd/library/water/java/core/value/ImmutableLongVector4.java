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
 * 不変であり、かつ、フィールドに直接アクセス可能な{@link LongVector4}の実装。
 *
 * フィールドに直接アクセス可能なため、原則としてインターフェース部分に使ってはいけません。
 * また、内部状態をプリミティブ型で保持するので必然的にアクセッサは防御的コピーを行います。
 *
 * @author misakura
 */
public class ImmutableLongVector4 extends DataObjectBase implements LongVector4Trait {

    /**
     * 全ての値が{@code 0}であるベクトル。
     */
    public static final ImmutableLongVector4 ZERO = new ImmutableLongVector4(0, 0, 0, 0);

    /**
     * 全ての値が{@code 1}であるベクトル。
     */
    public static final ImmutableLongVector4 ONE = new ImmutableLongVector4(1, 1, 1, 1);

    /**
     * 全ての値が{@code -1}であるベクトル。
     */
    public static final ImmutableLongVector4 MINUS = new ImmutableLongVector4(-1, -1, -1, -1);

    /**
     * x成分
     */
    public final long x;

    /**
     * y成分
     */
    public final long y;

    /**
     * z成分
     */
    public final long z;

    /**
     * w成分
     */
    public final long w;

    /**
     * コンストラクタ。
     *
     * @param x x成分。
     * @param y y成分。
     * @param z z成分。
     * @param w w成分。
     */
    public ImmutableLongVector4(long x, long y, long z, long w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    /**
     * コンストラクタ。
     *
     * @param vector 設定値を取得するベクトル。
     */
    public ImmutableLongVector4(LongVector4 vector) {
        this(vector.getXAsLong(), vector.getYAsLong(), vector.getZAsLong(), vector.getWAsLong());
    }


    @Override
    public long getXAsLong() {
        return x;
    }

    @Override
    public long getYAsLong() {
        return y;
    }

    @Override
    public long getZAsLong() {
        return z;
    }

    @Override
    public long getWAsLong() {
        return w;
    }
}
