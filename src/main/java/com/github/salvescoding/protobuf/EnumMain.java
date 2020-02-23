package com.github.salvescoding.protobuf;

import example.enumerations.ExampleEnum;

import java.io.*;

import static example.enumerations.ExampleEnum.*;

public class EnumMain {

    public static void main(String[] args) {
        System.out.println("You are on the EnumMain");

        EnumMessage.Builder enumBuilder = EnumMessage.newBuilder();

        enumBuilder.setId(23)
                    .setDayOfTheWeek(DayOfTheWeek.SUNDAY);

        System.out.println(enumBuilder.toString());

        try (FileOutputStream fileOutputStream = new FileOutputStream("enum_message")) {
            System.out.println("writing on file enum message \n" + enumBuilder.build().toString());
            enumBuilder.build().writeTo(fileOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(FileInputStream fileInputStream = new FileInputStream("enum_message")) {
            System.out.println("Reading from input stream enum message");
            EnumMessage enumMessage = EnumMessage.parseFrom(fileInputStream);
            System.out.println(enumMessage.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
