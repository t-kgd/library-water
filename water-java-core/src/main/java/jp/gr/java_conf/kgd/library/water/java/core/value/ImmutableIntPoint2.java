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
 * 不変であり、かつ、フィールドに直接アクセス可能な{@link IntPoint2}の実装。
 *
 * フィールドに直接アクセス可能なため、原則としてインターフェース部分に使ってはいけません。
 * また、内部状態をプリミティブ型で保持するので必然的にアクセッサは防御的コピーを行います。
 *
 * @author misakura
 */
public class ImmutableIntPoint2 extends DataObjectBase implements IntPoint2Trait {

    /**
     * 全ての値が{@code 0}である点。
     */
    public static final ImmutableIntPoint2 ZERO = new ImmutableIntPoint2(0, 0);

    /**
     * 全ての値が{@code 1}である点。
     */
    public static final ImmutableIntPoint2 ONE = new ImmutableIntPoint2(1, 1);

    /**
     * 全ての値が{@code -1}である点。
     */
    public static final ImmutableIntPoint2 MINUS = new ImmutableIntPoint2(-1, -1);

    /**
     * x座標
     */
    public final int x;

    /**
     * y座標
     */
    public final int y;

    /**
     * コンストラクタ。
     *
     * @param x x座標。
     * @param y y座標。
     */
    public ImmutableIntPoint2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * コンストラクタ。
     *
     * @param point 設定値を取得する点。
     */
    public ImmutableIntPoint2(IntPoint2 point) {
        this(point.getXAsInt(), point.getYAsInt());
    }


    @Override
    public int getXAsInt() {
        return x;
    }

    @Override
    public int getYAsInt() {
        return y;
    }
}
