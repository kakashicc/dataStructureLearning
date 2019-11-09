package com.daojia.datastructures.learn.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @Author: maosen
 * @Description:
 * @Date: Created in 2019/11/5 20:34.
 */
public class FileCopyTest {

    public static void main(String[] args) {
        String source = "C:\\Users\\maosen\\Desktop\\新建文件夹1";
        String target = "C:\\Users\\maosen\\Desktop\\新建文件夹2";
        try {
            copyFolder(source,target);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 复制文件目录
     * @param source 源路径
     * @param target 目标路径
     * @throws Exception
     */
    public static void copyFolder(String source,String target) throws Exception{

        File sourceFile = new File(source);
        File targetFile = new File(target,sourceFile.getName());
        if(!targetFile.exists()){
            targetFile.mkdir();
        }

        File[] files = sourceFile.listFiles();

        for (File file : files) {
            System.out.println("文件"+file.getName());
            System.out.println("targetFile"+targetFile.getAbsolutePath());
            if(!file.isDirectory()){
                copyFile(file,new File(targetFile.getAbsolutePath(),file.getName()));
            }else{
                copyFolder(file.getAbsolutePath(),targetFile.getAbsolutePath());
            }
        }

    }

    /**
     * 复制文件
     * @param source 源文件
     * @param target 目标文件
     * @throws Exception
     */
    public static void copyFile(File source, File target) throws Exception{
        FileInputStream fis = new FileInputStream(source);
        //BufferedInputStream bis = new BufferedInputStream(fis);

        FileOutputStream fos = new FileOutputStream(target);
        //BufferedOutputStream bos = new BufferedOutputStream(fos);

        byte[] bytes = new byte[1024];
        int len = 0;
        while((len = fis.read(bytes)) != -1){
            fos.write(bytes,0,len);
        }

        //bos.flush();

        //bis.close();
        //bos.close();

        fis.close();
        fos.close();
    }
}
