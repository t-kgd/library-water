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

package jp.gr.java_conf.kgd.library.water.generator.core.value

import freemarker.template.Configuration

/**
 *
 * @author misakura
 */
class ValueGenerator {

    def generate() {
        def config = new ConfigSlurper().parse(getText("value/config.groovy"))
        def javaOutputPath = config.outputPath.java
        def scalaOutputPath = config.outputPath.scala

        def primitives = new PrimitiveTuple().getAll()

        def data = new ConfigSlurper().parse(getText("value/data.groovy"))
        def root = [:]
        root.packageLevel = config.packageLevel
        root.primitives = primitives
        data.each {
            root.dd = it.value

            //            (1..root.dd.fields.size).each {
            (root.dd.dimensionMin..root.dd.dimensionMax).each {
                root.dimension = it

                process("ObjectDimension.ftl", root, javaOutputPath, {"Object${it}.java"})
                process("MutableObjectDimension.ftl", root, javaOutputPath, {"MutableObject${it}.java"})
                process("SimpleObjectDimension.ftl", root, javaOutputPath, {"SimpleObject${it}.java"})

                process("NumberDimension.ftl", root, javaOutputPath, {"Number${it}.java"})

                primitives.each { p ->
                    root.p = p
                    process("PrimitiveDimension.ftl", root, javaOutputPath, {"${p.name}${it}.java"})
                    process("MutablePrimitiveDimension.ftl", root, javaOutputPath, {"Mutable${p.name}${it}.java"})
                    process("PrimitiveDimensionTrait.ftl", root, javaOutputPath, {"${p.name}${it}Trait.java"})
                    process("MutablePrimitiveDimensionTrait.ftl", root, javaOutputPath, {"Mutable${p.name}${it}Trait.java"})
                    process("BarePrimitiveDimension.ftl", root, javaOutputPath, {"Bare${p.name}${it}.java"})
                    process("ImmutablePrimitiveDimension.ftl", root, javaOutputPath, {"Immutable${p.name}${it}.java"})
                }

                process("ScalaDimension.ftl", root, scalaOutputPath, {"${it}.scala"})
                process("ScalaMutableDimension.ftl", root, scalaOutputPath, {"Mutable${it}.scala"})
                process("ScalaSimpleDimension.ftl", root, scalaOutputPath, {"Simple${it}.scala"})
            }
        }
    }

    private def getText(filename) {
        return new File("src/main/resources/" + filename).getText("utf-8")
    }

    private def process(template, data, outputPath, filenameCreator) {
        def cfg = new Configuration();
        cfg.setDefaultEncoding("utf-8")

        def classLoader = this.getClass().getClassLoader()
        cfg.setDirectoryForTemplateLoading(new File(classLoader.getResource("value/template").toURI()));

        def filename = filenameCreator(data.dd.className.upper + data.dimension)
        def out = new OutputStreamWriter(new FileOutputStream(new File(outputPath + filename)), "utf-8")
        //def out = new OutputStreamWriter(System.out)

        def temp = cfg.getTemplate(template);
        temp.process(data, out);
        out.flush();
    }
}

