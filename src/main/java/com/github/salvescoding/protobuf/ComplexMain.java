package com.github.salvescoding.protobuf;

import com.sun.tools.javac.util.List;

import static example.complex.Complex.ComplexMessage;
import static example.complex.Complex.DummyMessage;

public class ComplexMain {

    public static void main(String[] args) {
        System.out.println("Complex Example");

        DummyMessage dummyMessage = createNewDummyWith(23, "Salves");
        DummyMessage dummyMessageTwo = createNewDummyWith(92, "VDK");

        ComplexMessage.Builder complexMessage = ComplexMessage.newBuilder();
        // single complex message field
        complexMessage.setOneDummy(dummyMessage);

        // add multiple messages
        complexMessage.addAllMultipleDummy(List.of(createNewDummyWith(33, "sergio"), dummyMessageTwo));

        System.out.println("Printing single dummy message \n" + complexMessage.build().getOneDummy());

        System.out.println("Printing list of dummy message");
        complexMessage.build().getMultipleDummyList().forEach(System.out::println);
    }

    private static DummyMessage createNewDummyWith(int id, String name) {
        return DummyMessage.newBuilder().setId(id).setName(name).build();
    }
}
