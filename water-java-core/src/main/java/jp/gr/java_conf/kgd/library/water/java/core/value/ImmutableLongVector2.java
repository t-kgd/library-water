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
 * 不変であり、かつ、フィールドに直接アクセス可能な{@link LongVector2}の実装。
 *
 * フィールドに直接アクセス可能なため、原則としてインターフェース部分に使ってはいけません。
 * また、内部状態をプリミティブ型で保持するので必然的にアクセッサは防御的コピーを行います。
 *
 * @author misakura
 */
public class ImmutableLongVector2 extends DataObjectBase implements LongVector2Trait {

    /**
     * 全ての値が{@code 0}であるベクトル。
     */
    public static final ImmutableLongVector2 ZERO = new ImmutableLongVector2(0, 0);

    /**
     * 全ての値が{@code 1}であるベクトル。
     */
    public static final ImmutableLongVector2 ONE = new ImmutableLongVector2(1, 1);

    /**
     * 全ての値が{@code -1}であるベクトル。
     */
    public static final ImmutableLongVector2 MINUS = new ImmutableLongVector2(-1, -1);

    /**
     * x成分
     */
    public final long x;

    /**
     * y成分
     */
    public final long y;

    /**
     * コンストラクタ。
     *
     * @param x x成分。
     * @param y y成分。
     */
    public ImmutableLongVector2(long x, long y) {
        this.x = x;
        this.y = y;
    }

    /**
     * コンストラクタ。
     *
     * @param vector 設定値を取得するベクトル。
     */
    public ImmutableLongVector2(LongVector2 vector) {
        this(vector.getXAsLong(), vector.getYAsLong());
    }


    @Override
    public long getXAsLong() {
        return x;
    }

    @Override
    public long getYAsLong() {
        return y;
    }
}
