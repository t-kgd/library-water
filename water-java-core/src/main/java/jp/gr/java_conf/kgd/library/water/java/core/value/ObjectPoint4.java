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
 * 4次元の点を表すインターフェース。
 *
 * インターフェース上にミューテータは存在しませんが、状態が不変であるかどうかは実装依存です。
 *
 * @author misakura
 * @param <T> 任意の型。
 */
public interface ObjectPoint4<T> {

    /**
     * この点のx座標にあたる値を返す。
     *
     * 得られる値が防御的にコピーされたものであるかどうかは実装依存です。
     *
     * @return x座標の値。
     */
    T getX();

    /**
     * この点のy座標にあたる値を返す。
     *
     * 得られる値が防御的にコピーされたものであるかどうかは実装依存です。
     *
     * @return y座標の値。
     */
    T getY();

    /**
     * この点のz座標にあたる値を返す。
     *
     * 得られる値が防御的にコピーされたものであるかどうかは実装依存です。
     *
     * @return z座標の値。
     */
    T getZ();

    /**
     * この点のw座標にあたる値を返す。
     *
     * 得られる値が防御的にコピーされたものであるかどうかは実装依存です。
     *
     * @return w座標の値。
     */
    T getW();
}
