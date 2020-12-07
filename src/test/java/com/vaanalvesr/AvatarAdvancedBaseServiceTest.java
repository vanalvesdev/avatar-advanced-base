package com.vaanalvesr;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@MicronautTest
public class AvatarAdvancedBaseServiceTest {

    @Inject
    AvatarAdvancedBaseServiceGrpc.AvatarAdvancedBaseServiceBlockingStub stub;

    @Test
    void getAvatarTest() {
        AvatarsReply reply = stub.findAvatarByNation(AvatarByNationRequest.newBuilder().setNation("Tribo da Agua").build());
//        assertEquals(8, reply.getAvatarsCount());
//        assertEquals("Aang", reply.getAvatars(1).getName());
//        assertTrue(!reply.getAvatars(0).getElementsList().isEmpty());
        System.out.println(reply.toString());
    }
}
