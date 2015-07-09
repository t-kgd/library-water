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
 * 不変であり、かつ、フィールドに直接アクセス可能な{@link LongPoint3}の実装。
 *
 * フィールドに直接アクセス可能なため、原則としてインターフェース部分に使ってはいけません。
 * また、内部状態をプリミティブ型で保持するので必然的にアクセッサは防御的コピーを行います。
 *
 * @author misakura
 */
public class ImmutableLongPoint3 extends DataObjectBase implements LongPoint3Trait {

    /**
     * 全ての値が{@code 0}である点。
     */
    public static final ImmutableLongPoint3 ZERO = new ImmutableLongPoint3(0, 0, 0);

    /**
     * 全ての値が{@code 1}である点。
     */
    public static final ImmutableLongPoint3 ONE = new ImmutableLongPoint3(1, 1, 1);

    /**
     * 全ての値が{@code -1}である点。
     */
    public static final ImmutableLongPoint3 MINUS = new ImmutableLongPoint3(-1, -1, -1);

    /**
     * x座標
     */
    public final long x;

    /**
     * y座標
     */
    public final long y;

    /**
     * z座標
     */
    public final long z;

    /**
     * コンストラクタ。
     *
     * @param x x座標。
     * @param y y座標。
     * @param z z座標。
     */
    public ImmutableLongPoint3(long x, long y, long z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * コンストラクタ。
     *
     * @param point 設定値を取得する点。
     */
    public ImmutableLongPoint3(LongPoint3 point) {
        this(point.getXAsLong(), point.getYAsLong(), point.getZAsLong());
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
}
