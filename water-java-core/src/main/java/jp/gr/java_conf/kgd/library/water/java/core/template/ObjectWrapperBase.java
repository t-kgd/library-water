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
package jp.gr.java_conf.kgd.library.water.java.core.template;

/**
 * ラップクラスの基礎。
 *
 * 差分プログラミングを意識しています。
 *
 * @author misakura
 * @param <T> ラップ対象の任意の型。
 */
public class ObjectWrapperBase<T> {

    /**
     * ラップ対象。
     */
    private final T wrapped;

    /**
     * コンストラクタ。
     *
     * @param wrapped ラップ対象。
     */
    protected ObjectWrapperBase(T wrapped) {
        this.wrapped = wrapped;
    }

    /**
     * 生成時にコンストラクタに渡されたラップ対象を返す。
     *
     * @return ラップ対象。
     */
    protected final T getWrapped() {
        return wrapped;
    }

    @Override
    public boolean equals(Object obj) {
        return getWrapped().equals(obj);
    }

    @Override
    public int hashCode() {
        return getWrapped().hashCode();
    }

    @Override
    public String toString() {
        return getWrapped().toString();
    }
}
