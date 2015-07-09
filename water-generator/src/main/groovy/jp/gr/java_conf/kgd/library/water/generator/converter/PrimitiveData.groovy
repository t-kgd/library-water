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

package jp.gr.java_conf.kgd.library.water.generator.converter

import groovy.transform.TupleConstructor

/**
 *
 * @author misakura
 */
@TupleConstructor
class PrimitiveData {

    final def primitiveName
    final def wrapperName
    final def namingLower
    final def namingUpper

    private static final def BOOLEAN_DATA = new PrimitiveData("boolean", "Boolean", "boolean", "Boolean")
    private static final def CHAR_DATA = new PrimitiveData("char", "Character", "char", "Char")
    private static final def BYTE_DATA = new PrimitiveData("byte", "Byte", "byte", "Byte")
    private static final def SHORT_DATA = new PrimitiveData("short", "Short", "short", "Short")
    private static final def INT_DATA = new PrimitiveData("int", "Integer", "int", "Int")
    private static final def LONG_DATA = new PrimitiveData("long", "Long", "long", "Long")
    private static final def FLOAT_DATA = new PrimitiveData("float", "Float", "float", "Float")
    private static final def DOUBLE_DATA = new PrimitiveData("double", "Double", "double", "Double")

    private static final def ALL_MAP = Collections.unmodifiableMap([BOOLEAN: BOOLEAN_DATA, CHAR: CHAR_DATA, BYTE: BYTE_DATA, SHORT: SHORT_DATA,
                                                                    INT: INT_DATA, LONG: LONG_DATA, FLOAT: FLOAT_DATA, DOUBLE: DOUBLE_DATA])

    private static final def NUMBERS = Collections.unmodifiableList([BYTE_DATA, SHORT_DATA, INT_DATA, LONG_DATA, FLOAT_DATA, DOUBLE_DATA])

    static def getData(PrimitiveType type) {
        return ALL_MAP.get(type)
    }

    static def getAll() {
        return ALL_MAP.values()
    }

    static def getNumbers() {
        return NUMBERS
    }
}

