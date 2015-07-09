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
 * フィールドに直接アクセス可能な{@link MutableDoublePoint4}の実装。
 *
 * フィールドに直接アクセス可能なため、原則としてインターフェース部分に使ってはいけません。
 * また、内部状態をプリミティブ型で保持するので必然的にアクセッサとミューテータは防御的コピーを行います。
 *
 * @author misakura
 */
public class BareDoublePoint4 extends DataObjectBase implements MutableDoublePoint4Trait {

    /**
     * x座標
     */
    public double x;

    /**
     * y座標
     */
    public double y;

    /**
     * z座標
     */
    public double z;

    /**
     * w座標
     */
    public double w;

    /**
     * コンストラクタ。
     */
    public BareDoublePoint4() {
    }

    /**
     * コンストラクタ。
     *
     * @param x x座標。
     * @param y y座標。
     * @param z z座標。
     * @param w w座標。
     */
    public BareDoublePoint4(double x, double y, double z, double w) {
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
    public BareDoublePoint4(DoublePoint4 point) {
        this(point.getXAsDouble(), point.getYAsDouble(), point.getZAsDouble(), point.getWAsDouble());
    }

    @Override
    public double getXAsDouble() {
        return x;
    }

    @Override
    public double getYAsDouble() {
        return y;
    }

    @Override
    public double getZAsDouble() {
        return z;
    }

    @Override
    public double getWAsDouble() {
        return w;
    }

    @Override
    public void setX(double x) {
        this.x = x;
    }

    @Override
    public void setY(double y) {
        this.y = y;
    }

    @Override
    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public void setW(double w) {
        this.w = w;
    }
}
