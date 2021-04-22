package com.university.ip.ui.editor

import android.graphics.Bitmap
import com.university.ip.repository.Operators
import com.university.ip.ui.base.BasePresenter

class EditorPresenter : BasePresenter<EditorContract.View>(), EditorContract.Presenter {

    private val operators = Operators()

    override fun brightness(bitmap: Bitmap, value: Int) {
        val result = operators.increaseBrightness(bitmap, value)
        getView()?.setBitmap(result)
    }

    override fun contrast(bitmap: Bitmap, value: Int) {
        val result = operators.increaseContrast(bitmap, value)
        getView()?.setBitmap(result)
    }

    override fun greyConversion(bitmap: Bitmap) {
        val result=operators.convertToGreyscale(bitmap)
        getView()?.setBitmap(result)
    }

    override fun sepiaConversion(bitmap: Bitmap) {
        val result=operators.convertToSepia(bitmap)
        getView()?.setBitmap(result)
    }

    override fun filter1Conversion(bitmap: Bitmap) {
        val result=operators.convertToFilter1(bitmap)
        getView()?.setBitmap(result)
    }

    override fun toBinary(bitmap: Bitmap, value: Int) {
        val result=operators.convertToBinary(bitmap,value)
        getView()?.setBitmap(result)
    }

    override fun flip(bitmap: Bitmap) {
        val result=operators.transformFlip(bitmap)
        getView()?.setBitmap(result)
    }

    override fun rotateRight(bitmap: Bitmap) {
        val result=operators.transformRight(bitmap)
        getView()?.setBitmap(result)
    }

    override fun rotateLeft(bitmap: Bitmap) {
        val result=operators.transformLeft(bitmap)
        getView()?.setBitmap(result)
    }

    override fun zoomin(bitmap: Bitmap) {
        val result=operators.transformZoomIn(bitmap)
        getView()?.setBitmap(result)
    }

    override fun zoomout(bitmap: Bitmap) {
        val result=operators.transformZoomOut(bitmap)
        getView()?.setBitmap(result)
    }

    override fun blur(bitmap: Bitmap, value: Int) {
        val result=operators.transformBlur(bitmap,value)
        getView()?.setBitmap(result)
    }

    override fun filter2Conversion(bitmap: Bitmap,value: Int) {
        val result=operators.convertToFilter2(bitmap,value)
        getView()?.setBitmap(result)
    }

    override fun filter3Conversion(bitmap: Bitmap) {
        val result=operators.convertToFilter3(bitmap)
        getView()?.setBitmap(result)
    }

}