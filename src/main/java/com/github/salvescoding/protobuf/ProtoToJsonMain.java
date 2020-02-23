package com.github.salvescoding.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import com.sun.tools.javac.util.List;
import example.simple.Simple;

public class ProtoToJsonMain {
    public static void main(String[] args) throws InvalidProtocolBufferException {
        Simple.SimpleMessage.Builder builder = Simple.SimpleMessage.newBuilder()
                .setId(92)
                .setIsSimple(true)
                .setName("VDK");

        // repeated fields
        builder.addAllSampleList(List.of(2,23, 24, 9));

        System.out.println(JsonFormat.printer().print(builder));
    }
}
