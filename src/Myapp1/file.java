package Myapp1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class file {
    private static String Path = "D:\\\\";
    private static String filename;
    private static Date nowdate;

    public static String createfile(String name) throws IOException {
        nowdate = new Date();
//        获取当前时间
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String dateString = formatter.format(nowdate);
        filename = Path+dateString+name+".txt" ;
//        生成文件名
        File file = new File(filename);
        if (!file.exists()){
            file.createNewFile();
        }
        return file.getPath();
    }
}