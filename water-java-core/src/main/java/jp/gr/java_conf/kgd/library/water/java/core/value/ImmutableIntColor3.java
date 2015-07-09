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
 * 不変であり、かつ、フィールドに直接アクセス可能な{@link IntColor3}の実装。
 *
 * フィールドに直接アクセス可能なため、原則としてインターフェース部分に使ってはいけません。
 * また、内部状態をプリミティブ型で保持するので必然的にアクセッサは防御的コピーを行います。
 *
 * @author misakura
 */
public class ImmutableIntColor3 extends DataObjectBase implements IntColor3Trait {

    /**
     * 全ての値が{@code 0}である色。
     */
    public static final ImmutableIntColor3 ZERO = new ImmutableIntColor3(0, 0, 0);

    /**
     * 全ての値が{@code 1}である色。
     */
    public static final ImmutableIntColor3 ONE = new ImmutableIntColor3(1, 1, 1);

    /**
     * 全ての値が{@code -1}である色。
     */
    public static final ImmutableIntColor3 MINUS = new ImmutableIntColor3(-1, -1, -1);

    /**
     * 赤成分
     */
    public final int red;

    /**
     * 緑成分
     */
    public final int green;

    /**
     * 青成分
     */
    public final int blue;

    /**
     * コンストラクタ。
     *
     * @param red 赤成分。
     * @param green 緑成分。
     * @param blue 青成分。
     */
    public ImmutableIntColor3(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    /**
     * コンストラクタ。
     *
     * @param color 設定値を取得する色。
     */
    public ImmutableIntColor3(IntColor3 color) {
        this(color.getRedAsInt(), color.getGreenAsInt(), color.getBlueAsInt());
    }


    @Override
    public int getRedAsInt() {
        return red;
    }

    @Override
    public int getGreenAsInt() {
        return green;
    }

    @Override
    public int getBlueAsInt() {
        return blue;
    }
}
