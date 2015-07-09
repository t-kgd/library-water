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
 * フィールドに直接アクセス可能な{@link MutableDoubleColor4}の実装。
 *
 * フィールドに直接アクセス可能なため、原則としてインターフェース部分に使ってはいけません。
 * また、内部状態をプリミティブ型で保持するので必然的にアクセッサとミューテータは防御的コピーを行います。
 *
 * @author misakura
 */
public class BareDoubleColor4 extends DataObjectBase implements MutableDoubleColor4Trait {

    /**
     * 赤成分
     */
    public double red;

    /**
     * 緑成分
     */
    public double green;

    /**
     * 青成分
     */
    public double blue;

    /**
     * 透明度
     */
    public double alpha;

    /**
     * コンストラクタ。
     */
    public BareDoubleColor4() {
    }

    /**
     * コンストラクタ。
     *
     * @param red 赤成分。
     * @param green 緑成分。
     * @param blue 青成分。
     * @param alpha 透明度。
     */
    public BareDoubleColor4(double red, double green, double blue, double alpha) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = alpha;
    }

    /**
     * コンストラクタ。
     *
     * @param color 設定値を取得する色。
     */
    public BareDoubleColor4(DoubleColor4 color) {
        this(color.getRedAsDouble(), color.getGreenAsDouble(), color.getBlueAsDouble(), color.getAlphaAsDouble());
    }

    @Override
    public double getRedAsDouble() {
        return red;
    }

    @Override
    public double getGreenAsDouble() {
        return green;
    }

    @Override
    public double getBlueAsDouble() {
        return blue;
    }

    @Override
    public double getAlphaAsDouble() {
        return alpha;
    }

    @Override
    public void setRed(double red) {
        this.red = red;
    }

    @Override
    public void setGreen(double green) {
        this.green = green;
    }

    @Override
    public void setBlue(double blue) {
        this.blue = blue;
    }

    @Override
    public void setAlpha(double alpha) {
        this.alpha = alpha;
    }
}
