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
package jp.gr.java_conf.kgd.library.water.java.core.value.helper;

import java.util.function.DoubleBinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.LongBinaryOperator;

/**
 * 基本的な二項演算子。
 *
 * @author misakura
 */
public enum PrimitiveBinaryOperators implements IntBinaryOperator, LongBinaryOperator, DoubleBinaryOperator {

    /**
     * 加算
     */
    PLUS((l, r) -> l + r, (l, r) -> l + r, (l, r) -> l + r),
    /**
     * 減算
     */
    MINUS((l, r) -> l - r, (l, r) -> l - r, (l, r) -> l - r),
    /**
     * 乗算
     */
    MULTIPLY((l, r) -> l * r, (l, r) -> l * r, (l, r) -> l * r),
    /**
     * 除算
     */
    DIVIDE((l, r) -> l / r, (l, r) -> l / r, (l, r) -> l / r),
    /**
     * 剰余
     */
    MODULO((l, r) -> l % r, (l, r) -> l % r, (l, r) -> l % r),;

    private final IntBinaryOperator intBinaryOperator;

    private final LongBinaryOperator longBinaryOperator;

    private final DoubleBinaryOperator doubleBinaryOperator;

    private PrimitiveBinaryOperators(IntBinaryOperator intBinaryOperator, LongBinaryOperator longBinaryOperator, DoubleBinaryOperator doubleBinaryOperator) {
        this.intBinaryOperator = intBinaryOperator;
        this.longBinaryOperator = longBinaryOperator;
        this.doubleBinaryOperator = doubleBinaryOperator;
    }

    @Override
    public int applyAsInt(int left, int right) {
        return intBinaryOperator.applyAsInt(left, right);
    }

    @Override
    public long applyAsLong(long left, long right) {
        return longBinaryOperator.applyAsLong(left, right);
    }

    @Override
    public double applyAsDouble(double left, double right) {
        return doubleBinaryOperator.applyAsDouble(left, right);
    }
}
