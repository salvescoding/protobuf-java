package com.github.salvescoding.protobuf;

import com.example.tutorial.AddressBook;
import com.example.tutorial.Person;
import com.sun.tools.javac.util.List;

import static com.example.tutorial.Person.*;

public class AddressBookMain {

    public static void main(String[] args) {

        Person personOne = createNewPerson(
                createPhoneNumber(PhoneType.WORK, "692048325"),
                "Sergio", 23, "salves@email.com");
        Person personTwo = createNewPerson(
                createPhoneNumber(PhoneType.MOBILE, "492480212"),
                "Lekker", 12, "lekker@email.com");

        personOne.getPhonesList().forEach(System.out::println);

        AddressBook addressBook = AddressBook.newBuilder().addAllPeople(List.of(personOne, personTwo)) .build();

        addressBook.getPeopleList().forEach(System.out::println);

    }


    private static Person createNewPerson(PhoneNumber phoneNumber, String name, int id, String email) {
        return newBuilder().setId(id)
                .setEmail(email)
                .setName(name)
                .addAllPhones(List.of(phoneNumber))
                .build();
    }

    private static PhoneNumber createPhoneNumber(PhoneType phoneType, String number) {
        return PhoneNumber.newBuilder().setNumber(number).setType(phoneType).build();
    }
}
