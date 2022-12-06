package PengolahanCitra.Konvolusi;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class konvolusi {
    public static void main(String[] args){
        int a[][] = {{4,4,3,5,4},
                    {6,6,5,5,2},
                    {5,6,6,6,2},
                    {6,7,5,5,3},
                    {3,5,2,4,4} };

        int kernel[][] = {{0,-1,0},
                         {-1,4,-1},
                         {0,-1,0}};

        float kernelLowPass[][] = {{1/9f,1/9f,1/9f},
                                {1/9f,1/9f,1/9f},
                                {1/9f,1/9f,1/9f}};

        int kernelBlur[][] = {{1,1,1},
                             {1,1,1},
                             {1,1,1}};

        int LolosTinggi1[][] = {{0,-1,0},
                              {-1,4,-1},
                              {0,-1,0}};

        int LolosTinggi2[][] = {{-1,-1,-1},
                            {-1,8,-1},
                            {-1,-1,-1}};

        int kernelGalucianBlur[][] = {{1,2,1},
                                     {2,4,2},
                                     {1,2,1}};

        int kernelSharp[][] = {{-1,-1,-1},
                              {-1,9,-1},
                              {-1,-1,-1}};

        int robert [][]= {{0, 1},
                         {-1, 0}};

        int sobel [][]= {{1, 0, -1},
                        {2, 0, -2},
                        {1, 0, -1}};

        int sobelver [][]= {{1, 2, 1},
                {0, 0, 0,},
                {-1, -2, -1}};


        int prewittor[][]= {{-1, 0, 1},
                        {-1, 0, 1},
                        {-1, 0, 1}};


        int kernelOperatorPrewil [][]=
                        {{-1, 0, 1},
                        {-1, 0, 1},
                        {-1, 0, 1}};

        int kernelLaplace [][]=
                        {{1, 4, 1},
                        {4, -20, 4},
                        {1, 4, 1}};

//      LowPass - blur
        konvolusiColorFloat("D:\\Workspace\\Java\\Intelij\\Java\\src\\PengolahanCitra\\lena.jpeg", kernelLowPass ,"low-pass");

//      Median - penghalusan
        konvolusiMedian("D:\\Workspace\\Java\\Intelij\\Java\\src\\PengolahanCitra\\lena.jpeg");

//      Lolos Tinggi (Lolos Atas) - Tepi
        konvolusiColor("D:\\Workspace\\Java\\Intelij\\Java\\src\\PengolahanCitra\\lena.jpeg", LolosTinggi1, "Lolos-Tinggi-1");
        konvolusiColor("D:\\Workspace\\Java\\Intelij\\Java\\src\\PengolahanCitra\\lena.jpeg", LolosTinggi2, "Lolos-Tinggi-2");

//      Robert Sobel dan prewit
//        konvolusiColorRobert("D:\\Workspace\\Java\\Intelij\\Java\\src\\PengolahanCitra\\lena.jpeg", robert, "robert");

        konvolusiColor("D:\\Workspace\\Java\\Intelij\\Java\\src\\PengolahanCitra\\lena.jpeg", sobel, "sobel");
        konvolusiColor("D:\\Workspace\\Java\\Intelij\\Java\\src\\PengolahanCitra\\lena.jpeg", sobelver, "sobelver");
        Penjumlahan2Citra("D:\\Workspace\\Java\\Intelij\\Java\\src\\PengolahanCitra\\Konvolusi\\kovolusi-sobel.png", "D:\\Workspace\\Java\\Intelij\\Java\\src\\PengolahanCitra\\Konvolusi\\kovolusi-sobelver.png", "sobel");

//        konvolusiColor("D:\\Workspace\\Java\\Intelij\\Java\\src\\PengolahanCitra\\lena.jpeg", prewittor, "prewit");

//      Glausian blur
        konvolusiColorGlausian("D:\\Workspace\\Java\\Intelij\\Java\\src\\PengolahanCitra\\lena.jpeg", kernelGalucianBlur, "galucian-blur");

        Grayscale("D:\\Workspace\\Java\\Intelij\\Java\\src\\PengolahanCitra\\lena.jpeg");


//        konvolusi("D:\\Workspace\\Java\\Intelij\\Java\\src\\PengolahanCitra\\Tes_Citra.jpg", kernel, "grayscale");
//        konvolusiColor("D:\\Workspace\\Java\\Intelij\\Java\\src\\PengolahanCitra\\Tes_Citra.jpg", kernelGalucianBlur, "galucian-blur");
//        konvolusiColor("D:\\Workspace\\Java\\Intelij\\Java\\src\\PengolahanCitra\\Tes_Citra.jpg", kernel, "tes");
//        konvolusiColorFloat("D:\\Workspace\\Java\\Intelij\\Java\\src\\PengolahanCitra\\Tes_Citra.jpg", kernelLowPass ,"low-pass");
//        konvolusiColor("D:\\Workspace\\Java\\Intelij\\Java\\src\\PengolahanCitra\\Tes_Citra.jpg", kernelBlur ,"blur");
//        konvolusiColor("D:\\Workspace\\Java\\Intelij\\Java\\src\\PengolahanCitra\\Tes_Citra.jpg", kernelSharp, "sharp");
//        konvolusiColor("D:\\Workspace\\Java\\Intelij\\Java\\src\\PengolahanCitra\\Tes_Citra.jpg", kernelOperatorSobel, "sobel");
//        konvolusiColor("D:\\Workspace\\Java\\Intelij\\Java\\src\\PengolahanCitra\\Tes_Citra.jpg", kernelLaplace, "laplace");

    }

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



    static void konvolusiColor(String img, int[][] kernel, String name){
        BufferedImage image = LoadImage(img);
        int width = image.getWidth();
        int height = image.getHeight();
        int sumKernel = 0;
        for (int i = 0; i <kernel.length ; i++) {
            for (int j = 0; j < kernel[0].length; j++) {
                sumKernel = sumKernel + kernel[i][j];
            }
        }
        try{
            //konvolusi
            for (int i = 1; i <height-1 ; i++) {
                for (int j = 1; j <width-1 ; j++) {
                    int x = 0;
                    int y =0;
                    int r = 0,g =0 ,b = 0;

                    // perhitunngan perframe kernel
                    for (int k = i-1; k <= i+1 ; k++) {
                        for (int l = j-1 ; l <= j+1; l++) {
                            Color c = new Color(image.getRGB(l,k));
                            r += c.getRed() * kernel[x][y];
                            g += c.getGreen() * kernel[x][y];
                            b += c.getBlue() * kernel[x][y];

                            x++;
                            if(x>2){
                                x = 0;
                                y++;
                            }
                        }
                        if(y>2) {
                            y = 0;
                        }
                    }

                    if(r > 255) r = 255;
                    else if(r < 0) r = 0;
                    if(g > 255) g = 255;
                    else if(g < 0) g = 0;
                    if(b > 255) b = 255;
                    else if(b < 0) b = 0;

                    image.setRGB(j-1,i-1,new Color(r,g,b).getRGB());
                }
            }

            File output = new File("src/PengolahanCitra/Konvolusi/kovolusi-" + name + ".png");
            ImageIO.write(image, "PNG", output);

            System.out.println(name + " Berhasil");

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    static void konvolusiColorGlausian(String img, int[][] kernel, String name){
        BufferedImage image = LoadImage(img);
        int width = image.getWidth();
        int height = image.getHeight();
        int sumKernel = 0;
        for (int i = 0; i <kernel.length ; i++) {
            for (int j = 0; j < kernel[0].length; j++) {
                sumKernel = sumKernel + kernel[i][j];
            }
        }
        try{
            //konvolusi
            for (int i = 1; i <height-1 ; i++) {
                for (int j = 1; j <width-1 ; j++) {
                    int x = 0;
                    int y =0;
                    int r = 0,g =0 ,b = 0;

                    // perhitunngan perframe kernel
                    for (int k = i-1; k <= i+1 ; k++) {
                        for (int l = j-1 ; l <= j+1; l++) {
                            Color c = new Color(image.getRGB(l,k));
                            r += c.getRed() * kernel[x][y];
                            g += c.getGreen() * kernel[x][y];
                            b += c.getBlue() * kernel[x][y];

                            x++;
                            if(x>2){
                                x = 0;
                                y++;
                            }
                        }
                        if(y>2) {
                            y = 0;
                        }
                    }
                    if(sumKernel==0) sumKernel = 1;
                    r = r / sumKernel;
                    g = g / sumKernel;
                    b = b / sumKernel;


                    if(r > 255) r = 255;
                    else if(r < 0) r = 0;
                    if(g > 255) g = 255;
                    else if(g < 0) g = 0;
                    if(b > 255) b = 255;
                    else if(b < 0) b = 0;

                    image.setRGB(j-1,i-1,new Color(r,g,b).getRGB());
                }
            }

            File output = new File("src/PengolahanCitra/Konvolusi/kovolusi-" + name + ".png");
            ImageIO.write(image, "PNG", output);

            System.out.println(name + " Berhasil");

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    static void konvolusiColorFloat(String img, float[][] kernel, String name){
        BufferedImage image = LoadImage(img);
        int width = image.getWidth();
        int height = image.getHeight();
        int sumKernel = 0;
        for (int i = 0; i <kernel.length ; i++) {
            for (int j = 0; j < kernel[0].length; j++) {
                sumKernel = sumKernel + (int)kernel[i][j];
            }
        }
        try{
            for (int i = 1; i <height-1 ; i++) {
                for (int j = 1; j <width-1 ; j++) {
                    int x = 0;
                    int y =0;
                    float r = 0,g =0 ,b = 0;
                    for (int k = i-1; k <= i+1 ; k++) {
                        for (int l = j-1 ; l <= j+1; l++) {
                            Color c = new Color(image.getRGB(l,k));
                            r += c.getRed() * kernel[x][y];
                            g += c.getGreen() * kernel[x][y];
                            b += c.getBlue() * kernel[x][y];

                            x++;
                            if(x>2){
                                x = 0;
                                y++;
                            }
                        }
                        if(y>2) {
                            y = 0;
                        }
                    }

                    r = (int)r;
                    g = (int)g;
                    b = (int)b;

                    if(r > 254) r = 255;
                    else if(r < 0) r = 0;
                    if(g > 254) g = 255;
                    else if(g < 0) g = 0;
                    if(b > 254) b = 255;
                    else if(b < 0) b = 0;



                    image.setRGB(j-1,i-1,new Color((int)r,(int)g,(int)b).getRGB());
                }
            }

            File output = new File("src/PengolahanCitra/Konvolusi/kovolusi-" + name + ".png");
            ImageIO.write(image, "PNG", output);

            System.out.println("Berhasil-Float");

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    static void konvolusiMedian(String img) {
        BufferedImage image = LoadImage(img);
        int width = image.getWidth();
        int height = image.getHeight();

        try {
            for (int i = 1; i < height - 1; i++) {
                for (int j = 1; j < width - 1; j++) {
                    int x = 0;
                    int r1 = 0, g1 = 0, b1 = 0;
                    int r[] = new int[9], g[] = new int[9], b[] = new int[9];
                    for (int k = i - 1; k <= i + 1; k++) {
                        for (int l = j - 1; l <= j + 1; l++) {
                            Color c = new Color(image.getRGB(l, k));
                            r[x] = c.getRed();
                            g[x] = c.getGreen();
                            b[x] = c.getBlue();

                            x++;

                            if (x > 9) x = 0;
                        }
                        for (int l = 0; l < r.length; l++) {
                            for (int m = 0; m < r.length; m++) {
                                int tempr, tempg, tempb = 0;
                                if (r[l] > r[m]) {
                                    tempr = r[l];
                                    r[l] = r[m];
                                    r[m] = tempr;
                                }

                                if (g[l] > g[m]) {
                                    tempg = g[l];
                                    g[l] = g[m];
                                    g[m] = tempg;

                                }
                                if (b[l] > b[m]) {
                                    tempb = b[l];
                                    b[l] = b[m];
                                    b[m] = tempb;
                                }
                            }
//                            System.out.println(r[4] +"," + g[4] + "," + b[4]);
                        }

                        r1 = r[4];
                        g1 = g[4];
                        b1 = b[4];

                        if (r1 > 255) r1 = 255;
                        else if (r1 < 0) r1 = 0;
                        if (g1 > 255) g1 = 255;
                        else if (g1 < 0) g1 = 0;
                        if (b1 > 255) b1 = 255;
                        else if (b1 < 0) b1 = 0;

                        image.setRGB(j - 1, i - 1, new Color(r1, g1, b1).getRGB());
                    }
                }

            }
            File output = new File("src/PengolahanCitra/Konvolusi/kovolusi-median.png");
            ImageIO.write(image, "PNG", output);
            System.out.println("Konvolusi median berhasil");

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    static void konvolusiColorRobert(String img, int[][] kernel, String name){
        BufferedImage image = LoadImage(img);
        int width = image.getWidth();
        int height = image.getHeight();
        int sumKernel = 0;
        for (int i = 0; i <kernel.length ; i++) {
            for (int j = 0; j < kernel[0].length; j++) {
                sumKernel = sumKernel + kernel[i][j];
            }
        }
        try{
            //konvolusi
            for (int i = 1; i <height-1 ; i++) {
                for (int j = 1; j <width-1 ; j++) {
                    int x = 0;
                    int y =0;
                    int r = 0,g =0 ,b = 0;

                    // perhitunngan perframe kernel
                    for (int k = i-1; k <= i ; k++) {
                        for (int l = j-1 ; l <= j; l++) {
                            Color c = new Color(image.getRGB(l,k));
                            r += c.getRed() * kernel[x][y];
                            g += c.getGreen() * kernel[x][y];
                            b += c.getBlue() * kernel[x][y];

                            x++;
                            if(x>1){
                                x = 0;
                                y++;
                            }
                        }
                        if(y>1) {
                            y = 0;
                        }
                    }

                    if(r > 255) r = 255;
                    else if(r < 0) r = 0;
                    if(g > 255) g = 255;
                    else if(g < 0) g = 0;
                    if(b > 255) b = 255;
                    else if(b < 0) b = 0;

                    image.setRGB(j-1,i-1,new Color(r,g,b).getRGB());
                }
            }

            File output = new File("src/PengolahanCitra/Konvolusi/kovolusi-" + name + ".png");
            ImageIO.write(image, "PNG", output);

            System.out.println(name + " Berhasil");

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
//                    System.out.println(grayScale);

                    image.setRGB(y,x,new Color(grayScale,grayScale,grayScale).getRGB());
                }
            }
            File output = new File("src/PengolahanCitra/2_Grayscale.png");
            ImageIO.write(image, "PNG", output);

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }

    }

    static void konvolusiColor5x5(String img, int[][] kernel){
        BufferedImage image = LoadImage(img);
        int width = image.getWidth();
        int height = image.getHeight();
        int temp = 0;
        int sumKernel = 0;
        for (int i = 0; i <kernel.length ; i++) {
            for (int j = 0; j < kernel[0].length; j++) {
                sumKernel = sumKernel + kernel[i][j];
            }
        }
        try{
            for (int i = 1; i <height-1 ; i++) {
                for (int j = 1; j <width-1 ; j++) {
                    int x = 0;
                    int y =0;
                    int r = 0,g =0 ,b = 0;
                    for (int k = i-2; k <= i+2 ; k++) {
                        for (int l = j-2 ; l <= j+2; l++) {
                            Color c = new Color(image.getRGB(l,k));
                            r += c.getRed() * kernel[x][y];
                            g += c.getGreen() * kernel[x][y];
                            b += c.getBlue() * kernel[x][y];

                            x++;
                            if(x>2){
                                x = 0;
                                y++;
                            }
                        }
                        if(y>2) {
                            y = 0;
                        }
                    }
                    if(sumKernel==0) sumKernel = 1;
                    r = r / sumKernel;
                    g = g / sumKernel;
                    b = b / sumKernel;

                    if(r > 255) r = 255;
                    else if(r < 0) r = 0;
                    if(g > 255) g = 255;
                    else if(g < 0) g = 0;
                    if(b > 255) b = 255;
                    else if(b < 0) b = 0;

                    image.setRGB(j-1,i-1,new Color(r,g,b).getRGB());
                }
            }

            File output = new File("src/PengolahanCitra/Konvolusi/kovolusi-5x5.png");
            ImageIO.write(image, "PNG", output);

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }


    static void konvolusi(String img, int[][] kernel, String name){
        BufferedImage image = LoadImage(img);
        int width = image.getWidth();
        int height = image.getHeight();
        int temp = 0;
        int sumKernel = 0;
        for (int i = 0; i <kernel.length ; i++) {
            for (int j = 0; j < kernel[0].length; j++) {
                sumKernel = sumKernel + kernel[i][j];
            }
        }
        try{
            for (int i = 1; i <height-1 ; i++) {
                for (int j = 1; j <width-1 ; j++) {
                    temp = 0;
                    int x = 0;
                    int y =0;
                    for (int k = i-1; k <= i+1 ; k++) {
                        for (int l = j-1 ; l <= j+1; l++) {
                            temp += image.getRGB(l,k) * kernel[x][y];
                            x++;
                            if(x>2){
                                x = 0;
                                y++;
                            }
                        }
                        if(y>2) {
                        y = 0;
                        }
                    }
//                    if(sumKernel==0) sumKernel = 1;
//                    temp = temp / sumKernel;

                    if(temp > 255) temp = 255;
                    else if(temp < 0) temp = 0;
                    image.setRGB(j-1,i-1,new Color(temp,temp,temp).getRGB());
                }
            }

            File output = new File("src/PengolahanCitra/Konvolusi/kovolusi-" + name + ".png");
            ImageIO.write(image, "PNG", output);

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    static void Penjumlahan2Citra (String img1,String img2, String nama){
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
            File output = new File("src/PengolahanCitra/Konvolusi/Penambahan-" + nama + ".png");
            ImageIO.write(image3, "PNG", output);

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static int[][] konvolusiArray(int[][] a, int[][] b){
        int temp = 0;
        int[][] c = new int[a.length-2][a[0].length-2];
        for (int i = 1; i < a.length-1; i++) {
            for (int j = 1; j < a[0].length-1; j++) {
                temp = 0;
                int x =0;
                int y =0;
                for (int k = i-1; k <= i+1; k++) {
                    for (int l = j-1; l <= j+1; l++) {
                        temp+= (a[k][l]*b[x][y]);
                        x++;
                        if(x>2) {
                            x=0;
                            y++;
                        }
                    }
                    if(y>2) {
                        y=0;
                    }
                }
                c[i-1][j-1] = temp;
            }

        }
        return c;
    }

//    Color c = new Color(image.getRGB(y,x));
//    int col = (int) ((c.getRed()+c.getBlue()+c.getGreen())/3);
//    int negatif = 255 - col;
//    image.setRGB(y,x,new Color(negatif,negatif,negatif).getRGB());

}
