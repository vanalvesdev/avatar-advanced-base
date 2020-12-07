package com.vaanalvesr;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import io.micronaut.grpc.annotation.GrpcChannel;
import io.micronaut.grpc.server.GrpcServerChannel;

@Factory
public class Clients {

    @Bean
    AvatarSimpleBaseServiceGrpc.AvatarSimpleBaseServiceBlockingStub simpleStub() {
        ManagedChannel anotherChannel = ManagedChannelBuilder.forAddress("localhost", 8082)
                .usePlaintext().build();
        return AvatarSimpleBaseServiceGrpc.newBlockingStub(anotherChannel);
    }

    @Bean
    AvatarAdvancedBaseServiceGrpc.AvatarAdvancedBaseServiceBlockingStub advancedStub(
            @GrpcChannel(GrpcServerChannel.NAME) ManagedChannel channel) {
        return AvatarAdvancedBaseServiceGrpc.newBlockingStub(channel);
    }
}
