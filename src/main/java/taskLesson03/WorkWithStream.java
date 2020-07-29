package taskLesson03;


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class WorkWithStream {


    public static void readFile(String path){
        try (FileInputStream inputStream = new FileInputStream(path)) {

            byte[] arrayBytes = new byte[64];
            int x;
            while ((x = inputStream.read(arrayBytes)) != -1) {
                System.out.print(new String(arrayBytes, 0, x));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void readListFile(SequenceInputStream sequenceInputStream) throws IOException{
        byte[] arrayBytes = new byte[512];
        int x;
        while ((x = sequenceInputStream.read(arrayBytes)) != -1) {
            System.out.print(new String(arrayBytes, 0, x));
        }
    }


    public static void main(String[] args) {
// 1. Прочитать файл (около 50 байт) в байтовый массив и вывести этот массив в консоль;
       String path1 = "files/fiftyByte.txt";
        readFile(path1);


// 2. Последовательно сшить 5 файлов в один (файлы примерно 100 байт).
// Может пригодиться следующая конструкция: ArrayList<InputStream> al = new ArrayList<>();
// ... Enumeration<InputStream> e = Collections.enumeration(al);

        ArrayList<InputStream> listInputStream = new ArrayList<>();
        SequenceInputStream sequenceInputStream = null;
        try {

            listInputStream.add(new FileInputStream("files/hundredByte1.txt"));
            listInputStream.add(new FileInputStream("files/hundredByte2.txt"));
            listInputStream.add(new FileInputStream("files/hundredByte3.txt"));
            listInputStream.add(new FileInputStream("files/hundredByte4.txt"));
            listInputStream.add(new FileInputStream("files/hundredByte5.txt"));

            sequenceInputStream = new SequenceInputStream(Collections.enumeration(listInputStream));

            readListFile(sequenceInputStream);
            sequenceInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                sequenceInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


// 3. Написать консольное приложение, которое умеет постранично читать текстовые файлы
// (размером > 10 mb). Вводим страницу (за страницу можно принять 1800 символов),
// программа выводит ее в консоль. Контролируем время выполнения:
// программа не должна загружаться дольше 10 секунд, а чтение – занимать свыше 5 секунд.

        String pathToFile = "files/moreTenMegabyte.txt";
        long time = System.currentTimeMillis();

        PageReader pageReader = new PageReader(pathToFile, 1, 1800);

        System.out.println("Время выполнения программы в миллисекундах: " + (System.currentTimeMillis() - time));

    }
}
