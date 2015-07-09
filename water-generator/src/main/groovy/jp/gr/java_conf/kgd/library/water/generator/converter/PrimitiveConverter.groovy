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

/**
 * 特定キーワードを各種プリミティブ及びプリミティブラッパ型に置き換えて生成するコードジェネレータ。
 * FreeMarkerを用いずに特定キーワードを置換するだけになっています。
 *
 * @author misakura
 */
class PrimitiveConverter {

    private static final def FILENAME_KEY = "filename"
    private static final def OUTPUT_DIRECTORY_KEY = "outputDirectory"
    private static final def TARGETS_KEY = "targets"

    private static final def PRIMITIVE_NAME_KEY = "primitiveName"
    private static final def WRAPPER_NAME_KEY = "wrapperName"
    private static final def NAMING_LOWER_KEY = "namingLower"
    private static final def NAMING_UPPER_KEY = "namingUpper"

    private static final def DEFAULT_PRIMITIVE_NAME = "PrimitiveName"
    private static final def DEFAULT_WRAPPER_NAME = "WrapperName"
    private static final def DEFAULT_NAMING_LOWER = "NamingLower"
    private static final def DEFAULT_NAMING_UPPER = "NamingUpper"

    def generate(File configFile, File templateFile) {
        def config = new ConfigSlurper().parse(configFile.getText("utf-8"))
        def template = templateFile.getText("utf-8")

        def filename = config.get(FILENAME_KEY)
        def outputDirectory = config.get(OUTPUT_DIRECTORY_KEY)

        def regexpPrimitiveName = getOrDefault(config, PRIMITIVE_NAME_KEY, DEFAULT_PRIMITIVE_NAME)
        def regexpWrapperName = getOrDefault(config, WRAPPER_NAME_KEY, DEFAULT_WRAPPER_NAME)
        def regexpNamingLower = getOrDefault(config, NAMING_LOWER_KEY, DEFAULT_NAMING_LOWER)
        def regexpNamingUpper = getOrDefault(config, NAMING_UPPER_KEY, DEFAULT_NAMING_UPPER)

        def targets = getOrDefault(config, TARGETS_KEY, PrimitiveData.getAll())

        targets.each {
            def currentTemplate = template
            currentTemplate = currentTemplate.replaceAll(regexpPrimitiveName, it.primitiveName)
            currentTemplate = currentTemplate.replaceAll(regexpWrapperName, it.wrapperName)
            currentTemplate = currentTemplate.replaceAll(regexpNamingLower, it.namingLower)
            currentTemplate = currentTemplate.replaceAll(regexpNamingUpper, it.namingUpper)

            def currentFilename = filename
            currentFilename = currentFilename.replaceAll(regexpNamingUpper, it.namingUpper)

            def outputFile = new File(outputDirectory, currentFilename)
            def outputWriter = new OutputStreamWriter(new FileOutputStream(outputFile), "utf-8")

            outputWriter.write(currentTemplate)
            outputWriter.flush()
        }
    }

    private static def getOrDefault(map, key, defaultValue) {
        def value = map.get(key)
        return value == null ? defaultValue : value
    }
}

