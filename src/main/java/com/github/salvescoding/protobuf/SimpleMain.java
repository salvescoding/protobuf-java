package com.github.salvescoding.protobuf;

import com.sun.tools.javac.util.List;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static example.simple.Simple.SimpleMessage;

public class SimpleMain {

    public static void main(String[] args) {
        System.out.println("Hello World again...");

        // simple fields
        SimpleMessage.Builder builder = SimpleMessage.newBuilder()
                                        .setId(92)
                                        .setIsSimple(true)
                                        .setName("VDK");

        // repeated fields
        builder.addAllSampleList(List.of(2,23, 24, 9));


        System.out.println("Printing the builder of SimpleMessage" + builder.toString());

        SimpleMessage message = builder.build();

        // write the protobuf message to a file
        try(FileOutputStream out = new FileOutputStream("simple_message.bin")) {
            message.writeTo(out);
        } catch (IOException e) {
            e.printStackTrace();
        }


        // read from file protobuf message
        try(FileInputStream inputStream = new FileInputStream("simple_message.bin")) {
            SimpleMessage messageFromFile = SimpleMessage.parseFrom(inputStream);
            System.out.println("Reading from file " + messageFromFile.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
