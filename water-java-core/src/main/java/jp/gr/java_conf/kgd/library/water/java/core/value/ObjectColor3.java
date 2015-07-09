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

/**
 * 3次元の色を表すインターフェース。
 *
 * インターフェース上にミューテータは存在しませんが、状態が不変であるかどうかは実装依存です。
 *
 * @author misakura
 * @param <T> 任意の型。
 */
public interface ObjectColor3<T> {

    /**
     * この色の赤成分にあたる値を返す。
     *
     * 得られる値が防御的にコピーされたものであるかどうかは実装依存です。
     *
     * @return 赤成分の値。
     */
    T getRed();

    /**
     * この色の緑成分にあたる値を返す。
     *
     * 得られる値が防御的にコピーされたものであるかどうかは実装依存です。
     *
     * @return 緑成分の値。
     */
    T getGreen();

    /**
     * この色の青成分にあたる値を返す。
     *
     * 得られる値が防御的にコピーされたものであるかどうかは実装依存です。
     *
     * @return 青成分の値。
     */
    T getBlue();
}
