package org.example.task12.service;

import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;

@Component
public class MyFile {
    File fileInit;

    File fileWithEncode;

    @Value("#{springApplicationArguments.sourceArgs[0]}")
    private String inputFilePath;

    @Value("#{springApplicationArguments.sourceArgs[1]}")
    private String hashFilePath;

    @PostConstruct
    public void init() {

      /*  inputFilePath = "file1";
        hashFilePath = "file2";*/
        try {
            System.out.println("INIT");

            fileInit = new File(
                    "task12/src/main/java/org/example/task12/" + inputFilePath +
                            ".txt");
            fileWithEncode = new File(
                    "task12/src/main/java/org/example/task12/" + hashFilePath +
                            ".txt");

            //Записыываем в 1 файл строку
            FileWriter writer =
                    new FileWriter(fileInit.getAbsolutePath(), false);
            writer.write("Hello world");
            writer.close();

            FileWriter writer2 =
                    new FileWriter(fileWithEncode.getAbsolutePath(), false);
            FileReader reader = new FileReader(fileInit.getAbsolutePath());

            int symbol;
            StringBuilder s = new StringBuilder();
            while ((symbol = reader.read()) != -1) {
                s.append((char) symbol);
            }

            //Генерируем уникальный ключ, чтобы хеш-код был разным, при каждом запуске
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(128);
            SecretKey key = kgen.generateKey();

            //Хешируем строку s по формату sha256
            String sha256hex = Hashing.hmacSha256(key)
                    .hashString(s.toString(), StandardCharsets.UTF_8)
                    .toString();

            writer2.write(sha256hex);

            reader.close();
            writer2.close();
        } catch (IOException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    @PreDestroy
    public void destroy() {
        if (fileInit.delete()) {
            System.out.println("DESTROY IS COMPLETE");
        } else {
            System.out.println("File is not deleted");
        }
    }
}
