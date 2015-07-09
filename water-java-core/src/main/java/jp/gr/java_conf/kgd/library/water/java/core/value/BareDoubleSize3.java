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
 * フィールドに直接アクセス可能な{@link MutableDoubleSize3}の実装。
 *
 * フィールドに直接アクセス可能なため、原則としてインターフェース部分に使ってはいけません。
 * また、内部状態をプリミティブ型で保持するので必然的にアクセッサとミューテータは防御的コピーを行います。
 *
 * @author misakura
 */
public class BareDoubleSize3 extends DataObjectBase implements MutableDoubleSize3Trait {

    /**
     * 幅
     */
    public double width;

    /**
     * 高さ
     */
    public double height;

    /**
     * 奥行
     */
    public double depth;

    /**
     * コンストラクタ。
     */
    public BareDoubleSize3() {
    }

    /**
     * コンストラクタ。
     *
     * @param width 幅。
     * @param height 高さ。
     * @param depth 奥行。
     */
    public BareDoubleSize3(double width, double height, double depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    /**
     * コンストラクタ。
     *
     * @param size 設定値を取得するサイズ。
     */
    public BareDoubleSize3(DoubleSize3 size) {
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

    @Override
    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public void setDepth(double depth) {
        this.depth = depth;
    }
}
