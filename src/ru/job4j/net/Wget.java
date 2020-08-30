package ru.job4j.net;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Wget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //хотя нам цикл не а может и нужен
        //while (scanner.hasNext()) {//что бы программа незаканчивалась
        String url = scanner.next(); //считываем строку 1 раз до пробела
        int speed = scanner.nextInt(); //считываем строку 1 раз до пробела
        //System.out.println(url);
        try (BufferedInputStream in = new BufferedInputStream(new URL(url).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream("pom_tmp.xml")) {
            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
                Thread.sleep(1000/speed);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        //}

    }

}
