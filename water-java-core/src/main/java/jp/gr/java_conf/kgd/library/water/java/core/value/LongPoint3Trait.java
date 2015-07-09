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
 * 値の型を{@link Long}に特化し、デフォルトの挙動を定めた{@link LongPoint3}。
 *
 * デフォルトの挙動を定めたものであり、原則としてインターフェース部分に使ってはいけません。
 *
 * @author misakura
 */
public interface LongPoint3Trait extends ObjectPoint3<Long>, NumberPoint3 {

    /**
     * この点のx座標にあたる値を返す。
     *
     * デフォルトの実装では、{@link #getXAsLong()}に委譲し、得られた値を静的キャストして返します。
     *
     * @return {@inheritDoc}
     */
    @Override
    default int getXAsInt() {
        return (int) getXAsLong();
    }

    /**
     * この点のy座標にあたる値を返す。
     *
     * デフォルトの実装では、{@link #getYAsLong()}に委譲し、得られた値を静的キャストして返します。
     *
     * @return {@inheritDoc}
     */
    @Override
    default int getYAsInt() {
        return (int) getYAsLong();
    }

    /**
     * この点のz座標にあたる値を返す。
     *
     * デフォルトの実装では、{@link #getZAsLong()}に委譲し、得られた値を静的キャストして返します。
     *
     * @return {@inheritDoc}
     */
    @Override
    default int getZAsInt() {
        return (int) getZAsLong();
    }

    /**
     * この点のx座標にあたる値を返す。
     *
     * デフォルトの実装では、{@link #getXAsLong()}に委譲し、得られた値を静的キャストして返します。
     *
     * @return {@inheritDoc}
     */
    @Override
    default double getXAsDouble() {
        return (double) getXAsLong();
    }

    /**
     * この点のy座標にあたる値を返す。
     *
     * デフォルトの実装では、{@link #getYAsLong()}に委譲し、得られた値を静的キャストして返します。
     *
     * @return {@inheritDoc}
     */
    @Override
    default double getYAsDouble() {
        return (double) getYAsLong();
    }

    /**
     * この点のz座標にあたる値を返す。
     *
     * デフォルトの実装では、{@link #getZAsLong()}に委譲し、得られた値を静的キャストして返します。
     *
     * @return {@inheritDoc}
     */
    @Override
    default double getZAsDouble() {
        return (double) getZAsLong();
    }

    /**
     * この点のx座標にあたる値を返す。
     *
     * 得られる値が防御的にコピーされたものであるかどうかは実装依存です。<br>
     * デフォルトの実装では、{@link #getXAsLong()}に委譲し、得られた値をボックス化して返します。（つまり、防御的コピーを行います。）
     *
     * @return {@inheritDoc}
     * @deprecated このインターフェースを直接操作する場合は{@link #getXAsLong()}を使うべきです。
     */
    @Deprecated
    @Override
    default Long getX() {
        return getXAsLong();
    }

    /**
     * この点のy座標にあたる値を返す。
     *
     * 得られる値が防御的にコピーされたものであるかどうかは実装依存です。<br>
     * デフォルトの実装では、{@link #getYAsLong()}に委譲し、得られた値をボックス化して返します。（つまり、防御的コピーを行います。）
     *
     * @return {@inheritDoc}
     * @deprecated このインターフェースを直接操作する場合は{@link #getYAsLong()}を使うべきです。
     */
    @Deprecated
    @Override
    default Long getY() {
        return getYAsLong();
    }

    /**
     * この点のz座標にあたる値を返す。
     *
     * 得られる値が防御的にコピーされたものであるかどうかは実装依存です。<br>
     * デフォルトの実装では、{@link #getZAsLong()}に委譲し、得られた値をボックス化して返します。（つまり、防御的コピーを行います。）
     *
     * @return {@inheritDoc}
     * @deprecated このインターフェースを直接操作する場合は{@link #getZAsLong()}を使うべきです。
     */
    @Deprecated
    @Override
    default Long getZ() {
        return getZAsLong();
    }
}
