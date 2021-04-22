package com.university.ip.ui.editor

import android.graphics.Bitmap
import com.university.ip.ui.base.BaseContract

interface EditorContract {

    interface View : BaseContract.View {
        //view functions for each change of activity
        fun setBitmap(bitmap: Bitmap)
    }

    interface Presenter {
        //functions that are going to use our library
        fun brightness(bitmap: Bitmap, value: Int)

        fun contrast(bitmap: Bitmap, value: Int)

        fun greyConversion(bitmap:Bitmap)

        fun sepiaConversion(bitmap:Bitmap)

        fun filter1Conversion(bitmap:Bitmap)

        fun toBinary(bitmap:Bitmap, value:Int)

        fun flip(bitmap:Bitmap)

        fun rotateRight(bitmap:Bitmap)

        fun rotateLeft(bitmap:Bitmap)

        fun zoomin(bitmap:Bitmap)

        fun zoomout(bitmap:Bitmap)

        fun blur(bitmap: Bitmap, value: Int)

        fun filter2Conversion(bitmap: Bitmap,value: Int)

        fun filter3Conversion(bitmap: Bitmap)
    }
}