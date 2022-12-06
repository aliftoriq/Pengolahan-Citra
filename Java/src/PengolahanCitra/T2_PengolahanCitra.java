package PengolahanCitra;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class T2_PengolahanCitra {

    static BufferedImage LoadImage (String img){
        BufferedImage image = null;
        try{
            image= ImageIO.read(new File(img));
        } catch (IOException io) {
            JOptionPane.showMessageDialog(null,"Failed");
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"Eror");
        }

        return image;
    }

    static void CitraNegatif(String img){
        BufferedImage image = LoadImage(img);
        int width = image.getWidth();
        int height = image.getHeight();
        try{
            for(int x=0;x<height;x++){
                for(int y=0;y<width;y++){
                    Color c = new Color(image.getRGB(y,x));
                    int col = (int) ((c.getRed()+c.getBlue()+c.getGreen())/3);
                    int negatif = 255 - col;
                    image.setRGB(y,x,new Color(negatif,negatif,negatif).getRGB());
                }
            }
            File output = new File("src/PengolahanCitra/1_CitraNegatif.png");
            ImageIO.write(image, "PNG", output);

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    static void Grayscale(String img){
        BufferedImage image = LoadImage(img);
        int width = image.getWidth();
        int height = image.getHeight();

        if (width == 0 || height == 0) {
            System.out.println("Error");
            return;
        }
        try{
            for(int x=0;x<height-1;x++){
                for(int y=0;y<width-1;y++){
                    Color c = new Color (image.getRGB(y,x));
                    // int grayScale = (int) ((c.getRed()+c.getBlue()+c.getGreen())/3);
                    // Y = 0.299R + 0.587G + 0.144B
                    int grayScale = (int) (((0.299*c.getRed())+(0.144*c.getBlue())+(0.587*c.getGreen())));
                    System.out.println(grayScale);

                    image.setRGB(y,x,new Color(grayScale,grayScale,grayScale).getRGB());
                }
            }
            File output = new File("src/PengolahanCitra/2_Grayscale.png");
            ImageIO.write(image, "PNG", output);

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }

    }

    static void ImageBrightening(String img){
        BufferedImage image = LoadImage(img);
        int width = image.getWidth();
        int height = image.getHeight();
        int brightnes = 100;

        if (width == 0 || height == 0) {
            System.out.println("Error");
            return;
        }
        try{
            for(int x=0;x<height;x++){
                for(int y=0;y<width;y++){
                    Color c = new Color (image.getRGB(y,x));
                    int col = (int) ((c.getRed()+c.getBlue()+c.getGreen())/3);
                    int hasil = col+brightnes;

                    if (hasil > 255){
                        hasil = 255;
                    }

                    image.setRGB(y,x,new Color(hasil,hasil,hasil).getRGB());
                }
            }
            File output = new File("src/PengolahanCitra/3_Brightening.png");
            ImageIO.write(image, "PNG", output);

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    static void Penjumlahan2Citra (String img1,String img2){
        BufferedImage image1 = LoadImage(img1);
        BufferedImage image2 = LoadImage(img2);
        BufferedImage image3 = new BufferedImage(image1.getWidth(),image1.getHeight(), BufferedImage.TYPE_INT_RGB);

        int width = image1.getWidth();
        int height = image1.getHeight();


        try{
            for(int x=0;x<height;x++){
                for(int y=0;y<width;y++){
                    Color c1 = new Color (image1.getRGB(y,x));
                    Color c2 = new Color(image2.getRGB(y,x));
                    int col1 = (int) ((c1.getRed()+c1.getBlue()+c1.getGreen())/3);
                    int col2 = (int) ((c2.getRed()+c2.getBlue()+c2.getGreen())/3);
                    int hasil = col1+col2;

                    if (hasil > 255){
                        hasil = 255;
                    }

                    image3.setRGB(y,x,new Color(hasil,hasil,hasil).getRGB());
                }
            }
            File output = new File("src/PengolahanCitra/4_OperasiPenambahan.png");
            ImageIO.write(image3, "PNG", output);

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    static void Pengurangan2Citra (String img1,String img2){
        BufferedImage image1 = LoadImage(img1);
        BufferedImage image2 = LoadImage(img2);


        int width = image1.getWidth();
        int height = image1.getHeight();


        try{
            for(int x=0;x<height;x++){
                for(int y=0;y<width;y++){
                    Color c1 = new Color (image1.getRGB(y,x));
                    Color c2 = new Color(image2.getRGB(y,x));
                    int col1 = (int) ((c1.getRed()+c1.getBlue()+c1.getGreen())/3);
                    int col2 = (int) ((c2.getRed()+c2.getBlue()+c2.getGreen())/3);
                    int hasil = col1-col2;

                    if (hasil !=0){
                        hasil = 255;
                    }


                    image1.setRGB(y,x,new Color(hasil,hasil,hasil).getRGB());
                }
            }
            File output = new File("src/PengolahanCitra/4_OperasiPenguranga.png");
            ImageIO.write(image1, "PNG", output);

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    static void Perkalian2Citra (String img1,String img2){
        BufferedImage image1 = LoadImage(img1);
        BufferedImage image2 = LoadImage(img2);
        BufferedImage image3 = null;

        int width = image1.getWidth();
        int height = image1.getHeight();


        try{
            for(int x=0;x<height;x++){
                for(int y=0;y<width;y++){
                    Color c1 = new Color (image1.getRGB(y,x));
                    Color c2 = new Color(image2.getRGB(y,x));
                    int col1 = (int) ((c1.getRed()+c1.getBlue()+c1.getGreen())/3);
                    int col2 = (int) ((c2.getRed()+c2.getBlue()+c2.getGreen())/3);
                    int hasil =0;
                    hasil = hasil + (col1*col2);

                    if (hasil < 0){
                        hasil = 0;
                    }
                    else if(hasil>255){
                        hasil = 255;
                    }
                    image3.setRGB(y,x,new Color(hasil,hasil,hasil).getRGB());
                }
            }
            File output = new File("src/PengolahanCitra/4_OperasiPerkalian.png");
            ImageIO.write(image3, "PNG", output);

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    static void Pembagian2Citra (String img1,String img2){
        BufferedImage image1 = LoadImage(img1);
        BufferedImage image2 = LoadImage(img2);


        int width = image1.getWidth();
        int height = image1.getHeight();


        try{
            for(int x=0;x<height;x++){
                for(int y=0;y<width;y++){
                    Color c1 = new Color (image1.getRGB(y,x));
                    Color c2 = new Color(image2.getRGB(y,x));
                    int col1 = (int) ((c1.getRed()+c1.getBlue()+c1.getGreen())/3);
                    int col2 = (int) ((c2.getRed()+c2.getBlue()+c2.getGreen())/3);
                    int hasil =0;
                    hasil = col1/col2;

                    if (hasil < 0){
                        hasil = 0;
                    }
                    else if(hasil>255){
                        hasil = 255;
                    }
                    image1.setRGB(y,x,new Color(hasil,hasil,hasil).getRGB());
                }
            }
            File output = new File("src/PengolahanCitra/4_OperasiPembagian.png");
            ImageIO.write(image1, "PNG", output);

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    static void AndOperator(String img1, String img2) {

        BufferedImage image1 = LoadImage(img1);
        BufferedImage image2 = LoadImage(img2);

        int width = image1.getWidth();
        int height = image1.getHeight();

        try {
            for (int x = 0; x < height; x++) {
                for (int y = 0; y < width; y++) {
                    Color c1 = new Color(image1.getRGB(y, x));
                    Color c2 = new Color(image2.getRGB(y, x));
                    int col1 = (int) ((c1.getRed() + c1.getBlue() + c1.getGreen()) / 3);
                    String col1Binary = Integer.toBinaryString(col1);
                    int col2 = (int) ((c2.getRed() + c2.getBlue() + c2.getGreen()) / 3);
                    String col2Binary = Integer.toBinaryString(col2);
                    int hasil = 0;

                    col1 = Integer.parseInt(col1Binary);
                    col2 = Integer.parseInt(col2Binary);

                    hasil = col1 & col2;

                    if (hasil < 0) {
                        hasil = 0;
                    } else if (hasil > 255) {
                        hasil = 255;
                    }
                    image1.setRGB(y, x, new Color(hasil, hasil, hasil).getRGB());
                }
            }
            File output = new File("src/PengolahanCitra/5_Operasi AND Catur.png");
            ImageIO.write(image1, "PNG", output);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    static void OrOperator(String img1, String img2) {

        BufferedImage image1 = LoadImage(img1);
        BufferedImage image2 = LoadImage(img2);

        int width = image1.getWidth();
        int height = image1.getHeight();

        try {
            for (int x = 0; x < height; x++) {
                for (int y = 0; y < width; y++) {
                    Color c1 = new Color(image1.getRGB(y, x));
                    Color c2 = new Color(image2.getRGB(y, x));
                    int col1 = (int) ((c1.getRed() + c1.getBlue() + c1.getGreen()) / 3);
                    String col1Binary = Integer.toBinaryString(col1);
                    int col2 = (int) ((c2.getRed() + c2.getBlue() + c2.getGreen()) / 3);
                    String col2Binary = Integer.toBinaryString(col2);
                    int hasil = 0;

                    col1 = Integer.parseInt(col1Binary);
                    col2 = Integer.parseInt(col2Binary);

                    hasil = col1 | col2;

                    if (hasil < 0) {
                        hasil = 0;
                    } else if (hasil > 255) {
                        hasil = 255;
                    }
                    image1.setRGB(y, x, new Color(hasil, hasil, hasil).getRGB());
                }
            }
            File output = new File("src/PengolahanCitra/5_Operasi OR Catur.png");
            ImageIO.write(image1, "PNG", output);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

   

    static void Rotasi (String img){
        BufferedImage imageTemp = LoadImage(img);
        int width = imageTemp.getWidth();
        int height = imageTemp.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        int count=0;
        try{
            do {
                for(int x=0,j=height-1;x<height;x++,j--){

                    for(int y=0,k=width-1; y<width ;y++,k--){

                        Color c = new Color (imageTemp.getRGB(j,k));
                        image.setRGB(y,x,new Color(c.getRed(),c.getGreen(),c.getBlue()).getRGB());
                    }
                }
                imageTemp = image;
                count++;

                if(count < 3) image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);;
            }while (count<3);

            File output = new File("src/PengolahanCitra/6_Rotasi.png");
            ImageIO.write(image, "PNG", output);

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    static void vertical_flip(String img) {
        // image untuk tempat gambar yg akan digeser (color)
        BufferedImage imageTemp = LoadImage(img);
        int width = imageTemp.getWidth();
        int height = imageTemp.getHeight();
        // image untuk menyimpan gambar asli
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        try {
            int k = height-1;

            for (int x = 0 ; x < width; x++) {
                for (int y = 0; y < height; y++) {


                    Color c = new Color(imageTemp.getRGB(y,x));
                    image.setRGB(y, k, new Color(c.getRed(), c.getGreen(), c.getBlue()).getRGB());
                }
                k--;
            }

            File output = new File("src/PengolahanCitra/6_Flip Vertical.png");
            ImageIO.write(image, "PNG", output);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    static void horizontal_flip(String img) {
        BufferedImage imageTemp = LoadImage(img);
        int width = imageTemp.getWidth();
        int height = imageTemp.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        try {
            int k = height-1;

            for (int x = 0 ; x < width; x++) {
                for (int y = 0; y < height; y++) {


                    Color c = new Color(imageTemp.getRGB(x,y));
                    image.setRGB(k,y, new Color(c.getRed(), c.getGreen(), c.getBlue()).getRGB());
                }
                k--;
            }

            File output = new File("src/PengolahanCitra/6_Flip Horizontal.png");
            ImageIO.write(image, "PNG", output);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static void zoom(String image){
        BufferedImage img = null;
        File file = null;
        try {
            file = new File(image);
            img = ImageIO.read(file);
            BufferedImage result = new BufferedImage(1000*2,1000*2,BufferedImage.TYPE_INT_RGB);
            int width = img.getWidth();
            int height = img.getHeight();
            System.out.println(width+" "+height);
            int i,j;
    
            i = 0;
            j =0;
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    int p,a,r,g,b;
                    p = img.getRGB(x, y);
                    a = (p >> 24) & 0xff;
                    r = (p >> 16) & 0xff;
                    g = (p >> 8) & 0xff;
                    b = p & 0xff;
                    p = (a << 24) | (r << 16) | (g << 8) | b;
    
                    result.setRGB(i, j, p);
                    result.setRGB(i,j+1, p);
                    result.setRGB(i+1, j, p);
                    result.setRGB(i+1, j+1, p);
                    j=j+2;
                }
                i=i+2;
                j=0;

                File output = new File("src/PengolahanCitra/6_Zoom.png");
            ImageIO.write(img, "PNG", output);
            }
        }catch (IOException e){
            System.out.println(e);
        }
    }


    public static void main(String[] args){
        // CitraNegatif("D:\\Workspace\\Java\\Intelij\\Java\\src\\PengolahanCitra\\Tes_Citra_1.jpg");
        Grayscale("D:\\Workspace\\Java\\Intelij\\Java\\src\\PengolahanCitra\\Tes_Citra_1.jpg");
        // ImageBrightening("D:\\Workspace\\Java\\Intelij\\Java\\src\\PengolahanCitra\\Tes_Citra_1.jpg");
        // Penjumlahan2Citra("D:\\Workspace\\Java\\Intelij\\Java\\src\\PengolahanCitra\\Tes_Citra_1.jpg" , "D:\\Workspace\\Java\\Intelij\\Java\\src\\PengolahanCitra\\Tes_Citra.jpg");
        // Pengurangan2Citra("D:\\Workspace\\Java\\Intelij\\Java\\src\\PengolahanCitra\\Tes_Citra_1.jpg" , "D:\\Workspace\\Java\\Intelij\\Java\\src\\PengolahanCitra\\Tes_Citra.jpg");
        // Perkalian2Citra("D:\\Workspace\\Java\\Intelij\\Java\\src\\PengolahanCitra\\Tes_Citra_1.jpg" , "D:\\Workspace\\Java\\Intelij\\Java\\src\\PengolahanCitra\\Tes_Citra.jpg");
        // AndOperator("D:\\Workspace\\Java\\Intelij\\Java\\src\\PengolahanCitra\\Tes_Citra_1.jpg" , "D:\\Workspace\\Java\\Intelij\\Java\\src\\PengolahanCitra\\Tes_Citra.jpg");
        // XOROperator("D:\\Workspace\\Java\\Intelij\\Java\\src\\PengolahanCitra\\Tes_Citra_1.jpg" , "D:\\Workspace\\Java\\Intelij\\Java\\src\\PengolahanCitra\\Tes_Citra.jpg");
        // Translasi("D:\\Workspace\\Java\\Intelij\\Java\\src\\PengolahanCitra\\Tes_Citra_1.jpg", 100, 50);
        // Rotasi("D:\\Workspace\\Java\\Intelij\\Java\\src\\PengolahanCitra\\Tes_Citra_2.jpg");
        // vertical_flip("D:\\Workspace\\Java\\Intelij\\Java\\src\\PengolahanCitra\\Tes_Citra_2.jpg");
        // horizontal_flip("D:\\Workspace\\Java\\Intelij\\Java\\src\\PengolahanCitra\\Tes_Citra_2.jpg");
        // zoom("D:\\Workspace\\Java\\Intelij\\Java\\src\\PengolahanCitra\\Tes_Citra_2.jpg");
    }



}
