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
 * 不変であり、かつ、フィールドに直接アクセス可能な{@link DoubleVector2}の実装。
 *
 * フィールドに直接アクセス可能なため、原則としてインターフェース部分に使ってはいけません。
 * また、内部状態をプリミティブ型で保持するので必然的にアクセッサは防御的コピーを行います。
 *
 * @author misakura
 */
public class ImmutableDoubleVector2 extends DataObjectBase implements DoubleVector2Trait {

    /**
     * 全ての値が{@code 0}であるベクトル。
     */
    public static final ImmutableDoubleVector2 ZERO = new ImmutableDoubleVector2(0, 0);

    /**
     * 全ての値が{@code 1}であるベクトル。
     */
    public static final ImmutableDoubleVector2 ONE = new ImmutableDoubleVector2(1, 1);

    /**
     * 全ての値が{@code -1}であるベクトル。
     */
    public static final ImmutableDoubleVector2 MINUS = new ImmutableDoubleVector2(-1, -1);

    /**
     * x成分
     */
    public final double x;

    /**
     * y成分
     */
    public final double y;

    /**
     * コンストラクタ。
     *
     * @param x x成分。
     * @param y y成分。
     */
    public ImmutableDoubleVector2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * コンストラクタ。
     *
     * @param vector 設定値を取得するベクトル。
     */
    public ImmutableDoubleVector2(DoubleVector2 vector) {
        this(vector.getXAsDouble(), vector.getYAsDouble());
    }


    @Override
    public double getXAsDouble() {
        return x;
    }

    @Override
    public double getYAsDouble() {
        return y;
    }
}
