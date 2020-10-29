package com.ems.utils;

import org.apache.commons.io.output.ByteArrayOutputStream;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.Random;

/**
 * 图片验证码工具类
 */
public class ValidCodeUtil {
    private static final ValidCodeUtil validCodeUtil = new ValidCodeUtil();

    private final int WIDTH = 15;// 图片的宽度

    private final int HEIGHT = 22;// 图片的高度

    private final int CODE_LENGTH = 4;// 字符串长度

    private final String RAND_RANGE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";// 随机字符串范围

    private final char[] CHARS = RAND_RANGE.toCharArray();//随机字符串范围

    private Random random = new Random();

    private ValidCodeUtil() {
        // 
    }

    public static ValidCodeUtil getInstance() {
        return validCodeUtil;
    }

    /**
     * 生成指定字符串的图像数据
     *
     * @param verifyCode  即将被打印的随机字符串
     * @return 生成的图像数据
     */
    public BufferedImage getImage(String verifyCode) {
        BufferedImage image = new BufferedImage(WIDTH * CODE_LENGTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        // 获取图形上下文
        Graphics graphics = image.getGraphics();
        // 设置背景色
        graphics.setColor(getRandColor(1, 30));
        // 填充背景色
        graphics.fillRect(0, 0, WIDTH * 4, HEIGHT);
        // 设置边框颜色
        graphics.setColor(new Color(0, 255, 0));
        // 画边框
        for (int i = 0; i < 2; i++){
            graphics.drawRect(i, i, WIDTH * CODE_LENGTH - i * 2 - 1, HEIGHT - i * 2 - 1);
        }

        // 设置随机干扰线条颜色
        graphics.setColor(getRandColor(50, 100));
        // 产生50条干扰线条
        for (int i = 0; i < 255; i++) {
            int x1 = random.nextInt(WIDTH * CODE_LENGTH - 4) + 2;
            int y1 = random.nextInt(HEIGHT - 4) + 2;
            int x2 = random.nextInt(WIDTH * CODE_LENGTH - 2 - x1) + x1;
            int y2 = y1;
            graphics.drawLine(x1, y1, x2, y2);
        }
        // 设置字体
        graphics.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        // 画字符串
        for (int i = 0; i < this.CODE_LENGTH; i++) {
            String temp = verifyCode.substring(i, i + 1);
            graphics.setColor(getRandColor(100, 255));
            graphics.drawString(temp, 13 * i + 6, 16);
        }
        // 图像生效
        graphics.dispose();
        return image;
    }

    public ByteArrayInputStream getVerfyImage(String verifyCode) throws CommonException {
        ByteArrayInputStream input = null;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try {
            ImageOutputStream imageOut = ImageIO.createImageOutputStream(output);
            ImageIO.write(getImage(verifyCode), "JPEG", imageOut);
            imageOut.close();
            input = new ByteArrayInputStream(output.toByteArray());
        } catch (Exception e) {
            throw new CommonException("创建验证码图片出现错误", e);
        }
        return input;
    }

    public ByteArrayInputStream getDefualtVerfyImage(String imagePath) throws Exception {
        ByteArrayInputStream input = null;
        BufferedImage bu = ImageIO.read(new File(imagePath));
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try {
            ImageIO.write(bu, "JPEG", output);
            input = new ByteArrayInputStream(output.toByteArray());
            output.close();
        } catch (Exception e) {
            throw new CommonException("获取验证码图片出现错误", e);
        }
        return input;
    }

    /**
     * 生成随机字符串
     *
     * @return 随机字符串
     */
    public String getVerifyCode() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < CODE_LENGTH; i++){
            sb.append(CHARS[random.nextInt(CHARS.length)]);
        }

        return sb.toString();
    }

    /*
     * 给定范围获得随机颜色
     */
    private Color getRandColor(int fc, int bc) {
        Random random = new Random();
        if (fc > 255)
        { fc = 255;}
        if (bc > 255)
        { bc = 255;}
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }
}
