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
 * 不変であり、かつ、フィールドに直接アクセス可能な{@link DoubleSize3}の実装。
 *
 * フィールドに直接アクセス可能なため、原則としてインターフェース部分に使ってはいけません。
 * また、内部状態をプリミティブ型で保持するので必然的にアクセッサは防御的コピーを行います。
 *
 * @author misakura
 */
public class ImmutableDoubleSize3 extends DataObjectBase implements DoubleSize3Trait {

    /**
     * 全ての値が{@code 0}であるサイズ。
     */
    public static final ImmutableDoubleSize3 ZERO = new ImmutableDoubleSize3(0, 0, 0);

    /**
     * 全ての値が{@code 1}であるサイズ。
     */
    public static final ImmutableDoubleSize3 ONE = new ImmutableDoubleSize3(1, 1, 1);

    /**
     * 全ての値が{@code -1}であるサイズ。
     */
    public static final ImmutableDoubleSize3 MINUS = new ImmutableDoubleSize3(-1, -1, -1);

    /**
     * 幅
     */
    public final double width;

    /**
     * 高さ
     */
    public final double height;

    /**
     * 奥行
     */
    public final double depth;

    /**
     * コンストラクタ。
     *
     * @param width 幅。
     * @param height 高さ。
     * @param depth 奥行。
     */
    public ImmutableDoubleSize3(double width, double height, double depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    /**
     * コンストラクタ。
     *
     * @param size 設定値を取得するサイズ。
     */
    public ImmutableDoubleSize3(DoubleSize3 size) {
        this(size.getWidthAsDouble(), size.getHeightAsDouble(), size.getDepthAsDouble());
    }


    @Override
    public double getWidthAsDouble() {
        return width;
    }

    @Override
    public double getHeightAsDouble() {
        return height;
    }

    @Override
    public double getDepthAsDouble() {
        return depth;
    }
}
