package io_code;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class 加密解密 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
       int a=0;
       while (a==0)
       {   System.out.println("***加密器***");
           System.out.println("***1:加密");
           System.out.println("***2:解密");
           System.out.println("***3:退出");
           System.out.println("输入选择：");
           int check = scanner.nextInt();
           switch (check){
           case 1:
                jiami();
               break;
           case 2:
               jiemi();
               break;
           case 3:
               a=1;
               break;
           default:
               System.out.println("error");
           }

       }

    }
     public  static void jiami() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入需要加密文件的路径：例如：例如C:\\Users\\名称");
        String 加密前文件路径=scanner.nextLine();
        System.out.println("请输入需要加密后文件所在的路径及名称：例如C:\\Users\\名称");
        String 加密后文件路径=scanner.nextLine();
        FileInputStream fis = new FileInputStream(加密前文件路径);
        FileOutputStream os = new FileOutputStream(加密后文件路径);
        int len=0;
        byte [] data=new byte[1024];
        while ((len=fis.read(data)) != -1)
        {
            byte [] buffer =new byte[1024];
            for (int i=0; i<data.length; i++) {
               int b=data[i]^2;
               buffer[i] = (byte) b;
            }
            os.write(buffer);
        }
        fis.close();
        os.close();
    }
    public static void jiemi() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入需要解密的文件所在的路径及名称：例如C:\\Users\\名称");
        String 解密前文件路径=scanner.nextLine();
        System.out.println("请输入需要解密后文件所在的路径及名称：例如C:\\Users\\名称");
        String 解密后文件路径=scanner.nextLine();
        FileInputStream fis = new FileInputStream(解密前文件路径);
        FileOutputStream os = new FileOutputStream(解密后文件路径);
        int len=0;
        byte [] data=new byte[1024];
        while ((len=fis.read(data)) != -1)
        {
            byte [] buffer =new byte[1024];
            for (int i=0; i<data.length; i++) {
                int b=data[i]^2;
                buffer[i] = (byte) b;
            }
            os.write(buffer);
        }
        fis.close();
        os.close();
    }
}
