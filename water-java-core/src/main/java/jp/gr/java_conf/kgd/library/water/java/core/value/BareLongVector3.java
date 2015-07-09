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
 * フィールドに直接アクセス可能な{@link MutableLongVector3}の実装。
 *
 * フィールドに直接アクセス可能なため、原則としてインターフェース部分に使ってはいけません。
 * また、内部状態をプリミティブ型で保持するので必然的にアクセッサとミューテータは防御的コピーを行います。
 *
 * @author misakura
 */
public class BareLongVector3 extends DataObjectBase implements MutableLongVector3Trait {

    /**
     * x成分
     */
    public long x;

    /**
     * y成分
     */
    public long y;

    /**
     * z成分
     */
    public long z;

    /**
     * コンストラクタ。
     */
    public BareLongVector3() {
    }

    /**
     * コンストラクタ。
     *
     * @param x x成分。
     * @param y y成分。
     * @param z z成分。
     */
    public BareLongVector3(long x, long y, long z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * コンストラクタ。
     *
     * @param vector 設定値を取得するベクトル。
     */
    public BareLongVector3(LongVector3 vector) {
        this(vector.getXAsLong(), vector.getYAsLong(), vector.getZAsLong());
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
    public void setX(long x) {
        this.x = x;
    }

    @Override
    public void setY(long y) {
        this.y = y;
    }

    @Override
    public void setZ(long z) {
        this.z = z;
    }
}
