package Searching_for_files_in_folder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<File> fileList=new ArrayList<>(); //список файлів найдених
        searchFiles(new File("/Users/nazarvoynarovich/Desktop/"),fileList);
        for (File file:fileList){
            System.out.println(file.getAbsolutePath());
        }
    }
    private static void searchFiles(File rootFiles, List<File> fileList){
        if(rootFiles.isDirectory()){ //перевіряємо чи є це папка
//            System.out.println("Searching at: "+rootFiles.getAbsolutePath());
            File[] directoryFiles=rootFiles.listFiles();//отримуємо всі файли які лежать всередині папки
            if(directoryFiles!=null){ //якщо нам вдалося получити ці файли
                for (File file:directoryFiles){
                    if(file.isDirectory()){ //якщо цей файл є папкою
                        searchFiles(file,fileList);//тоді фунція викликає сама себе(рекурсія) для того щоб пошукати в цій підпапці
                        //до fileList додаються файли які находяться в даній підпапці
                    }else { //якщо файл не являється папкою
                        if(file.getName().toLowerCase().endsWith(".jpg")){
                            fileList.add(file);
                        }
                    }
                }
            }

        }
    }
}
