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
 * 値の型を{@link Integer}に特化し、デフォルトの挙動を定めた{@link IntColor4}。
 *
 * デフォルトの挙動を定めたものであり、原則としてインターフェース部分に使ってはいけません。
 *
 * @author misakura
 */
public interface IntColor4Trait extends ObjectColor4<Integer>, NumberColor4 {

    /**
     * この色の赤成分にあたる値を返す。
     *
     * デフォルトの実装では、{@link #getRedAsInt()}に委譲し、得られた値を静的キャストして返します。
     *
     * @return {@inheritDoc}
     */
    @Override
    default long getRedAsLong() {
        return (long) getRedAsInt();
    }

    /**
     * この色の緑成分にあたる値を返す。
     *
     * デフォルトの実装では、{@link #getGreenAsInt()}に委譲し、得られた値を静的キャストして返します。
     *
     * @return {@inheritDoc}
     */
    @Override
    default long getGreenAsLong() {
        return (long) getGreenAsInt();
    }

    /**
     * この色の青成分にあたる値を返す。
     *
     * デフォルトの実装では、{@link #getBlueAsInt()}に委譲し、得られた値を静的キャストして返します。
     *
     * @return {@inheritDoc}
     */
    @Override
    default long getBlueAsLong() {
        return (long) getBlueAsInt();
    }

    /**
     * この色の透明度にあたる値を返す。
     *
     * デフォルトの実装では、{@link #getAlphaAsInt()}に委譲し、得られた値を静的キャストして返します。
     *
     * @return {@inheritDoc}
     */
    @Override
    default long getAlphaAsLong() {
        return (long) getAlphaAsInt();
    }

    /**
     * この色の赤成分にあたる値を返す。
     *
     * デフォルトの実装では、{@link #getRedAsInt()}に委譲し、得られた値を静的キャストして返します。
     *
     * @return {@inheritDoc}
     */
    @Override
    default double getRedAsDouble() {
        return (double) getRedAsInt();
    }

    /**
     * この色の緑成分にあたる値を返す。
     *
     * デフォルトの実装では、{@link #getGreenAsInt()}に委譲し、得られた値を静的キャストして返します。
     *
     * @return {@inheritDoc}
     */
    @Override
    default double getGreenAsDouble() {
        return (double) getGreenAsInt();
    }

    /**
     * この色の青成分にあたる値を返す。
     *
     * デフォルトの実装では、{@link #getBlueAsInt()}に委譲し、得られた値を静的キャストして返します。
     *
     * @return {@inheritDoc}
     */
    @Override
    default double getBlueAsDouble() {
        return (double) getBlueAsInt();
    }

    /**
     * この色の透明度にあたる値を返す。
     *
     * デフォルトの実装では、{@link #getAlphaAsInt()}に委譲し、得られた値を静的キャストして返します。
     *
     * @return {@inheritDoc}
     */
    @Override
    default double getAlphaAsDouble() {
        return (double) getAlphaAsInt();
    }

    /**
     * この色の赤成分にあたる値を返す。
     *
     * 得られる値が防御的にコピーされたものであるかどうかは実装依存です。<br>
     * デフォルトの実装では、{@link #getRedAsInt()}に委譲し、得られた値をボックス化して返します。（つまり、防御的コピーを行います。）
     *
     * @return {@inheritDoc}
     * @deprecated このインターフェースを直接操作する場合は{@link #getRedAsInt()}を使うべきです。
     */
    @Deprecated
    @Override
    default Integer getRed() {
        return getRedAsInt();
    }

    /**
     * この色の緑成分にあたる値を返す。
     *
     * 得られる値が防御的にコピーされたものであるかどうかは実装依存です。<br>
     * デフォルトの実装では、{@link #getGreenAsInt()}に委譲し、得られた値をボックス化して返します。（つまり、防御的コピーを行います。）
     *
     * @return {@inheritDoc}
     * @deprecated このインターフェースを直接操作する場合は{@link #getGreenAsInt()}を使うべきです。
     */
    @Deprecated
    @Override
    default Integer getGreen() {
        return getGreenAsInt();
    }

    /**
     * この色の青成分にあたる値を返す。
     *
     * 得られる値が防御的にコピーされたものであるかどうかは実装依存です。<br>
     * デフォルトの実装では、{@link #getBlueAsInt()}に委譲し、得られた値をボックス化して返します。（つまり、防御的コピーを行います。）
     *
     * @return {@inheritDoc}
     * @deprecated このインターフェースを直接操作する場合は{@link #getBlueAsInt()}を使うべきです。
     */
    @Deprecated
    @Override
    default Integer getBlue() {
        return getBlueAsInt();
    }

    /**
     * この色の透明度にあたる値を返す。
     *
     * 得られる値が防御的にコピーされたものであるかどうかは実装依存です。<br>
     * デフォルトの実装では、{@link #getAlphaAsInt()}に委譲し、得られた値をボックス化して返します。（つまり、防御的コピーを行います。）
     *
     * @return {@inheritDoc}
     * @deprecated このインターフェースを直接操作する場合は{@link #getAlphaAsInt()}を使うべきです。
     */
    @Deprecated
    @Override
    default Integer getAlpha() {
        return getAlphaAsInt();
    }
}
