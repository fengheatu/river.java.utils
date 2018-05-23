package com.river.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.OutputStream;
import java.nio.file.Path;
import java.util.HashMap;

/**
 * @author he.feng
 * @2018/5/23
 * @desc
 */
public class QRCodeUtil {

    private static final String DEFAULT_ENCODE = "UTF-8";


    /**
     * 二维码 保存到本地
     * @param width
     * @param height
     * @param imgType
     * @param content
     * @param path
     */
    public static void createQRCodeToPath(Integer width, Integer height, String imgType, String content, String path) {

        if (StringUtils.isBlank(path)) {
            throw new RuntimeException("路径不能为空");
        }

        if (null == width) {
            width = 300;
        }
        if (null == height) {
            height = 300;
        }
        if (StringUtils.isBlank(imgType)) {
            imgType = "png";
        }

        //定义二维码参数
        HashMap<Object, Object> hints = new HashMap<Object, Object>();
        //编码
        hints.put(EncodeHintType.CHARACTER_SET, DEFAULT_ENCODE);
        //纠错等级
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        //边距
        hints.put(EncodeHintType.MARGIN, 2);

        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height);
            path = path + "\\" + System.currentTimeMillis() + "." + imgType;
            Path file = new File(path).toPath();
            MatrixToImageWriter.writeToPath(bitMatrix, imgType, file);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     *将二维码写到 输出流中
     * @param width
     * @param height
     * @param imgType
     * @param content
     * @param outputStream
     */
    public static void createQRCodeToOutputStream(Integer width, Integer height, String imgType, String content, OutputStream outputStream){

        if (null == width) {
            width = 300;
        }
        if (null == height) {
            height = 300;
        }
        if (StringUtils.isBlank(imgType)) {
            imgType = "png";
        }

        //定义二维码参数
        HashMap<Object, Object> hints = new HashMap<Object, Object>();
        //编码
        hints.put(EncodeHintType.CHARACTER_SET, DEFAULT_ENCODE);
        //纠错等级
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        //边距
        hints.put(EncodeHintType.MARGIN, 2);

        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height);
            MatrixToImageWriter.writeToStream(bitMatrix, imgType, outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
