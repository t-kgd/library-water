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
 * 不変であり、かつ、フィールドに直接アクセス可能な{@link IntPoint4}の実装。
 *
 * フィールドに直接アクセス可能なため、原則としてインターフェース部分に使ってはいけません。
 * また、内部状態をプリミティブ型で保持するので必然的にアクセッサは防御的コピーを行います。
 *
 * @author misakura
 */
public class ImmutableIntPoint4 extends DataObjectBase implements IntPoint4Trait {

    /**
     * 全ての値が{@code 0}である点。
     */
    public static final ImmutableIntPoint4 ZERO = new ImmutableIntPoint4(0, 0, 0, 0);

    /**
     * 全ての値が{@code 1}である点。
     */
    public static final ImmutableIntPoint4 ONE = new ImmutableIntPoint4(1, 1, 1, 1);

    /**
     * 全ての値が{@code -1}である点。
     */
    public static final ImmutableIntPoint4 MINUS = new ImmutableIntPoint4(-1, -1, -1, -1);

    /**
     * x座標
     */
    public final int x;

    /**
     * y座標
     */
    public final int y;

    /**
     * z座標
     */
    public final int z;

    /**
     * w座標
     */
    public final int w;

    /**
     * コンストラクタ。
     *
     * @param x x座標。
     * @param y y座標。
     * @param z z座標。
     * @param w w座標。
     */
    public ImmutableIntPoint4(int x, int y, int z, int w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    /**
     * コンストラクタ。
     *
     * @param point 設定値を取得する点。
     */
    public ImmutableIntPoint4(IntPoint4 point) {
        this(point.getXAsInt(), point.getYAsInt(), point.getZAsInt(), point.getWAsInt());
    }


    @Override
    public int getXAsInt() {
        return x;
    }

    @Override
    public int getYAsInt() {
        return y;
    }

    @Override
    public int getZAsInt() {
        return z;
    }

    @Override
    public int getWAsInt() {
        return w;
    }
}
