package ru.itmonopoly;

import java.io.*;
public class Files {
    public static void main(String[] args)  throws Exception {
        File dir = new File("C:/edb123/qwe/asd/xcvb");
        dir.mkdirs();
        boolean directory =dir.isDirectory();
        System.out.println("directory = " + directory);

        File file2 = new File(dir, "123.txt");
        boolean directory2 = file2.isDirectory();
        System.out.println("directory2 = " + directory2);
        FileOutputStream fos= null;
        ObjectOutputStream oos= null;
        try {
            fos = new FileOutputStream(file2);
            BufferedOutputStream bos = new BufferedOutputStream(fos,1024);
            oos= new ObjectOutputStream(bos);

            oos.writeLong(0x223456673458L);
            Zver obj = new Zver();
            oos.writeObject(obj);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        FileInputStream fis = new FileInputStream(file2);
        ObjectInputStream ois= new ObjectInputStream(fis);

        long l = ois.readLong();
        Object o = ois.readObject();
        System.out.println("o = " + o);



    }
}
