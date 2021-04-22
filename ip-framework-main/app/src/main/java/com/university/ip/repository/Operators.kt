package com.university.ip.repository

import android.graphics.Bitmap
import org.opencv.android.Utils
import org.opencv.core.*
import org.opencv.imgproc.Imgproc
import org.opencv.imgproc.Imgproc.pyrUp
import org.opencv.imgproc.Imgproc.resize

class Operators {
    fun increaseBrightness(bitmap: Bitmap, value: Int): Bitmap {
        val src = Mat(bitmap.getHeight(), bitmap.getWidth(), CvType.CV_8UC1)
        Utils.bitmapToMat(bitmap, src)
        src.convertTo(src, -1, 1.0, value.toDouble())
        val result = Bitmap.createBitmap(src.cols(), src.rows(), Bitmap.Config.ARGB_8888)
        Utils.matToBitmap(src, result)
        return result
    }

    fun increaseContrast(bitmap: Bitmap, value: Int): Bitmap {
        val src = Mat(bitmap.getHeight(), bitmap.getWidth(), CvType.CV_8UC1)
        Utils.bitmapToMat(bitmap, src)
        src.convertTo(src, -1, value.toDouble(), 1.0)
        val result = Bitmap.createBitmap(src.cols(), src.rows(), Bitmap.Config.ARGB_8888)
        Utils.matToBitmap(src, result)
        return result
    }

    fun convertToGreyscale(bitmap: Bitmap): Bitmap {
        val src=Mat(bitmap.getHeight(), bitmap.getWidth(), CvType.CV_8UC1)
        Utils.bitmapToMat(bitmap,src)
        Imgproc.cvtColor(src, src, Imgproc.COLOR_RGB2GRAY)
        val result=Bitmap.createBitmap(src.cols(), src.rows(), Bitmap.Config.ARGB_8888)
        Utils.matToBitmap(src, result)
        return result
    }

    fun convertToSepia(bitmap: Bitmap) :Bitmap {
        val src = Mat(bitmap.getHeight(), bitmap.getWidth(), CvType.CV_8UC1)
        Utils.bitmapToMat(bitmap, src)

        val mSepiaKernel = Mat(4, 4, CvType.CV_32F)
        mSepiaKernel.put(0, 0,  /* R */0.189, 0.769, 0.393, 0.0)
        mSepiaKernel.put(1, 0,  /* G */0.168, 0.686, 0.349, 0.0)
        mSepiaKernel.put(2, 0,  /* B */0.131, 0.534, 0.272, 0.0)
        mSepiaKernel.put(3, 0,  /* A */0.000, 0.000, 0.000, 1.0)

        Core.transform(src, src, mSepiaKernel)

        val result = Bitmap.createBitmap(src.cols(), src.rows(), Bitmap.Config.ARGB_8888)
        Utils.matToBitmap(src, result)
        return result
    }

    fun convertToFilter1(bitmap: Bitmap): Bitmap {
        val src=Mat(bitmap.getHeight(), bitmap.getWidth(), CvType.CV_8UC1)
        Utils.bitmapToMat(bitmap,src)
        Imgproc.cvtColor(src, src, Imgproc.COLOR_RGB2XYZ)
        val result=Bitmap.createBitmap(src.cols(), src.rows(), Bitmap.Config.ARGB_8888)
        Utils.matToBitmap(src, result)
        return result
    }

    fun convertToBinary(bitmap: Bitmap, value: Int): Bitmap {
        val src = Mat()
        Utils.bitmapToMat(bitmap, src)
        Imgproc.cvtColor(src, src, Imgproc.COLOR_BGR2GRAY)
        Imgproc.threshold(src, src, value.toDouble(), 255.0, Imgproc.THRESH_BINARY)
        val result=Bitmap.createBitmap(src.cols(), src.rows(), Bitmap.Config.ARGB_8888)
        Utils.matToBitmap(src, result)
        return result
    }

    fun transformFlip(bitmap: Bitmap): Bitmap {
        val src = Mat(bitmap.getHeight(), bitmap.getWidth(), CvType.CV_8UC1)
        Utils.bitmapToMat(bitmap, src)
        Core.flip(src, src, -1)
        val result = Bitmap.createBitmap(src.cols(), src.rows(), Bitmap.Config.ARGB_8888)
        Utils.matToBitmap(src, result)
        return result
    }

    fun transformRight(bitmap: Bitmap): Bitmap {
        val src = Mat(bitmap.getHeight(), bitmap.getWidth(), CvType.CV_8UC1)
        Utils.bitmapToMat(bitmap, src)
        Core.transpose(src,src)
        Core.flip(src, src, 0)
        val result = Bitmap.createBitmap(src.cols(), src.rows(), Bitmap.Config.ARGB_8888)
        Utils.matToBitmap(src, result)
        return result
    }

    fun transformLeft(bitmap: Bitmap): Bitmap {
        val src = Mat(bitmap.getHeight(), bitmap.getWidth(), CvType.CV_8UC1)
        Utils.bitmapToMat(bitmap, src)
        Core.transpose(src,src)
        Core.flip(src, src, +1)
        val result = Bitmap.createBitmap(src.cols(), src.rows(), Bitmap.Config.ARGB_8888)
        Utils.matToBitmap(src, result)
        return result
    }

    fun transformZoomIn(bitmap: Bitmap):Bitmap {
        val src = Mat(bitmap.getHeight(), bitmap.getWidth(), CvType.CV_8UC1)
        Utils.bitmapToMat(bitmap, src)

        val roi = Rect(src.width() / 4, src.height() / 4, src.width() / 2, src.height() / 2)
        val src2 = Mat(src, roi)

        val result = Bitmap.createBitmap(src2.cols(), src2.rows(), Bitmap.Config.ARGB_8888)
        Utils.matToBitmap(src2, result)
        return result
    }

    fun transformZoomOut(bitmap: Bitmap):Bitmap {

        val src = Mat(bitmap.getHeight(), bitmap.getWidth(), CvType.CV_8UC1)
        Utils.bitmapToMat(bitmap, src)

        val interpolation = Imgproc.INTER_CUBIC
        resize(src, src, src.size(), -5.5, -5.5, interpolation)

        val result = Bitmap.createBitmap(src.cols(), src.rows(), Bitmap.Config.ARGB_8888)
        Utils.matToBitmap(src, result)
        return result
    }

    fun transformBlur(bitmap: Bitmap, value: Int): Bitmap {
        val src = Mat(bitmap.height, bitmap.width, CvType.CV_8UC1)
        Utils.bitmapToMat(bitmap, src)
        val dst = Mat(src.cols(), src.rows(), src.type())
        val size = Size(value.toDouble(), value.toDouble())
        val point = Point(value.toDouble() / 2, value.toDouble() / 2)
        Imgproc.blur(src, dst, size, point, Core.BORDER_DEFAULT)
        val result = Bitmap.createBitmap(src.cols(), src.rows(), Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(dst, result)
        return result
    }

    fun convertToFilter2(bitmap: Bitmap, value: Int):Bitmap{
        val src=Mat(bitmap.getHeight(), bitmap.getWidth(), CvType.CV_8UC1)
        Utils.bitmapToMat(bitmap,src)
        Imgproc.threshold(src, src, value.toDouble(), 200.0, Imgproc.THRESH_BINARY)
        val result=Bitmap.createBitmap(src.cols(), src.rows(), Bitmap.Config.ARGB_8888)
        Utils.matToBitmap(src, result)
        return result
    }

    fun convertToFilter3(bitmap: Bitmap):Bitmap{
        val src=Mat(bitmap.getHeight(), bitmap.getWidth(), CvType.CV_8UC1)
        Utils.bitmapToMat(bitmap,src)
        Imgproc.cvtColor(src, src, Imgproc.COLOR_BGR2GRAY)
        Imgproc.adaptiveThreshold(src, src, 200.0, Imgproc.ADAPTIVE_THRESH_GAUSSIAN_C, Imgproc.THRESH_BINARY,3,2.0)
        val result=Bitmap.createBitmap(src.cols(), src.rows(), Bitmap.Config.ARGB_8888)
        Utils.matToBitmap(src, result)
        return result
    }
}