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
 * フィールドに直接アクセス可能な{@link MutableIntColor3}の実装。
 *
 * フィールドに直接アクセス可能なため、原則としてインターフェース部分に使ってはいけません。
 * また、内部状態をプリミティブ型で保持するので必然的にアクセッサとミューテータは防御的コピーを行います。
 *
 * @author misakura
 */
public class BareIntColor3 extends DataObjectBase implements MutableIntColor3Trait {

    /**
     * 赤成分
     */
    public int red;

    /**
     * 緑成分
     */
    public int green;

    /**
     * 青成分
     */
    public int blue;

    /**
     * コンストラクタ。
     */
    public BareIntColor3() {
    }

    /**
     * コンストラクタ。
     *
     * @param red 赤成分。
     * @param green 緑成分。
     * @param blue 青成分。
     */
    public BareIntColor3(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    /**
     * コンストラクタ。
     *
     * @param color 設定値を取得する色。
     */
    public BareIntColor3(IntColor3 color) {
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

    @Override
    public void setRed(int red) {
        this.red = red;
    }

    @Override
    public void setGreen(int green) {
        this.green = green;
    }

    @Override
    public void setBlue(int blue) {
        this.blue = blue;
    }
}
