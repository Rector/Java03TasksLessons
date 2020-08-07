package taskLesson03.serializationAndDeserialization;

import java.io.*;

public class Client {
    public static void main(String[] args) {
        Magazine magazine = new Magazine("Around the World", 150);

//        try {
//
//            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("magazine.ser"));
//            outputStream.writeObject(magazine);
//            outputStream.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


//        try {
//            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("magazine.ser"));
//            Magazine magazine2 = (Magazine) inputStream.readObject();
//            inputStream.close();
//            magazine2.info();
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }


    }
}
