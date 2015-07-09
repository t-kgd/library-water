import jp.gr.java_conf.kgd.library.water.generator.core.value.*

def dd = {args -> return new DimensionDefine(args)}
def nt = {u, l -> return new NameTuple(u, l)}
def ft = {u, l, d -> return new FieldTuple(u, l, d)}

size = dd(
    concept: 'サイズ',
    className: nt('Size', 'size'),
    fields: [ft('Width', 'width', '幅'), ft('Height','height', '高さ'), ft('Depth','depth', '奥行')],
    dimensionMin: 2,
    dimensionMax: 3
)

point = dd(
    concept: '点',
    className: nt('Point', 'point'),
    fields: [ft('X', 'x', 'x座標'), ft('Y','y', 'y座標'), ft('Z','z', 'z座標'), ft('W','w', 'w座標')],
    dimensionMin: 2,
    dimensionMax: 4
)

color = dd(
    concept: '色',
    className: nt('Color', 'color'),
    fields: [ft('Red', 'red', '赤成分'), ft('Green','green', '緑成分'), ft('Blue','blue', '青成分'), ft('Alpha','alpha', '透明度')],
    dimensionMin: 3,
    dimensionMax: 4
)

vector = dd(
    concept: 'ベクトル',
    className: nt('Vector', 'vector'),
    fields: [ft('X', 'x', 'x成分'), ft('Y','y', 'y成分'), ft('Z','z', 'z成分'), ft('W','w', 'w成分')],
    dimensionMin: 2,
    dimensionMax: 4
)