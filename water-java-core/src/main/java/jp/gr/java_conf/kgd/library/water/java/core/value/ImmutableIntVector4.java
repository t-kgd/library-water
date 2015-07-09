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
 * 不変であり、かつ、フィールドに直接アクセス可能な{@link IntVector4}の実装。
 *
 * フィールドに直接アクセス可能なため、原則としてインターフェース部分に使ってはいけません。
 * また、内部状態をプリミティブ型で保持するので必然的にアクセッサは防御的コピーを行います。
 *
 * @author misakura
 */
public class ImmutableIntVector4 extends DataObjectBase implements IntVector4Trait {

    /**
     * 全ての値が{@code 0}であるベクトル。
     */
    public static final ImmutableIntVector4 ZERO = new ImmutableIntVector4(0, 0, 0, 0);

    /**
     * 全ての値が{@code 1}であるベクトル。
     */
    public static final ImmutableIntVector4 ONE = new ImmutableIntVector4(1, 1, 1, 1);

    /**
     * 全ての値が{@code -1}であるベクトル。
     */
    public static final ImmutableIntVector4 MINUS = new ImmutableIntVector4(-1, -1, -1, -1);

    /**
     * x成分
     */
    public final int x;

    /**
     * y成分
     */
    public final int y;

    /**
     * z成分
     */
    public final int z;

    /**
     * w成分
     */
    public final int w;

    /**
     * コンストラクタ。
     *
     * @param x x成分。
     * @param y y成分。
     * @param z z成分。
     * @param w w成分。
     */
    public ImmutableIntVector4(int x, int y, int z, int w) {
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
    public ImmutableIntVector4(IntVector4 vector) {
        this(vector.getXAsInt(), vector.getYAsInt(), vector.getZAsInt(), vector.getWAsInt());
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
