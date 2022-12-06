import java.awt.image.BufferedImage
import java.awt.image.BufferedImageOp
import java.io.File
import java.io.IOException
import java.nio.BufferOverflowException
import javax.imageio.ImageIO

fun convertIntArrayToBufferedImage(intArray: IntArray, width : Int,bufferedImageType : Int): BufferedImage{
    val height = intArray.size/width
    val bufferedImage = BufferedImage(width, height, bufferedImageType)
    bufferedImage.setRGB(0, 0, width, height, intArray, 0, width)
    return bufferedImage
}

fun saveToFile(bi: BufferedImage, fileName : String){
    try {
        val outputFile = File(fileName)
        ImageIO.write(bi, "png", outputFile)

    }catch (e: IOException){
        println(e.message)
    }
}

fun loadFromFile(fileName: String): BufferedImage?{
    return try {
        ImageIO.read(File(fileName))
    }catch (e: Exception){
        null
    }
}

fun IntArray.getBufferedImage(width: Int, type: Int): BufferedImage{
    val height = this.size/width
    val bi = BufferedImage(width, height, type)
    bi.setRGB(0,0,width,height, this, 0, width)
    return bi
}

val BufferedImage.intArray: IntArray get() = IntArray(width*height)
    .let {getRGB(0, 0, width, height, it, 0, width) }

val BufferedImage.grayBuffereddImage : BufferedImage get(){
    return BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY).apply {
        graphics.drawImage(this, 0, 0, null)
    }
}

fun getGrayScale(bi: BufferedImage): BufferedImage {
    val width = bi.width
    val height = bi.height
    val newBI = BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY)
    val g = newBI.graphics
    g.drawImage(bi, 0, 0, null)
    return newBI
}

fun getNegativeImage (bi: BufferedImage) : BufferedImage{
    val width = bi.width
    val scanLine = bi.intArray
    for (i in scanLine.indices){
        val originalIntensity = scanLine[i]
        val r = (originalIntensity shr 16) and 0xff
        val g = (originalIntensity shr 8) and 0xff
        val b = originalIntensity and 0xff
        val rResult = 0xFF - r
        val gResult = 0xFF - g
        val bResult = 0xFF - b
        val result = rResult shl 16 + gResult shl 8 + bResult
        scanLine[i] = result
    }
    return scanLine.getBufferedImage(width, bi.type)
}

fun main(){
//    val intArray = IntArray(128*128){0xFF00}
//    val bi = convertIntArrayToBufferedImage(intArray ,128, BufferedImage.TYPE_INT_RGB)
//    saveToFile(bi, "tes.png")

//    IntArray(256*32){
//        (it * 0x10000)
//    }.getBufferedImage(256, BufferedImage.TYPE_INT_RGB).let {
//        saveToFile(it, "gradasi-red.png")
//    }

//    IntArray(256*32){
//        (it % 256).let { it or (it shl 8) or 0xFF0000 }
//    }.getBufferedImage(256, BufferedImage.TYPE_INT_RGB).let {
//        saveToFile(it, "gradasi-red-white.png")
//    }

//    loadFromFile("lena.jpeg")?.let{bufferedImage ->
//        bufferedImage.intArray
//            .map {it and 0xFF00}
//            .toIntArray()
//            .getBufferedImage(bufferedImage.width, BufferedImage.TYPE_INT_RGB)
//            .let{
//                saveToFile(it, "greenChanel.png")
//            }
//    }


//    loadFromFile("lena.jpeg")?.let{bufferedImage ->
//        val grayScale = getGrayScale(bufferedImage)
//        saveToFile(grayScale, "grayScale.png")
//
//    }

//    loadFromFile("lena.jpeg")?.let{bufferedImage ->
//        val width = bufferedImage.width
//        val redChanel = bufferedImage.intArray.map{
//            val red = (it shr 16) and 0xFF
//            red * 0x10000 + red * 0x100 + red
//        }.toIntArray().getBufferedImage(width, BufferedImage.TYPE_INT_RGB)
//        saveToFile(redChanel, "redChanel.png")
//
//    }

    loadFromFile("lena.jpeg")?.let{bufferedImage ->
        val grayScale = getNegativeImage(bufferedImage)
        saveToFile(grayScale, "Negative.png")

    }

}



