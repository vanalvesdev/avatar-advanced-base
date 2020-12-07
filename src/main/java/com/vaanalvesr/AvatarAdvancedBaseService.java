package com.vaanalvesr;

import com.vaanalvesr.AvatarSimpleBaseServiceGrpc.AvatarSimpleBaseServiceBlockingStub;
import io.grpc.stub.StreamObserver;
import io.micronaut.grpc.annotation.GrpcService;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@GrpcService
public class AvatarAdvancedBaseService extends AvatarAdvancedBaseServiceGrpc.AvatarAdvancedBaseServiceImplBase {

    @Inject
    AvatarSimpleBaseServiceBlockingStub avatarSimpleBase;

    public void findAvatarByNation(AvatarByNationRequest request, StreamObserver<AvatarsReply> responseObserver) {
        AvatarsReply avatarsReply = avatarSimpleBase.findAllAvatars(Empty.newBuilder().build());
        List<AvatarReply> avatarsList =  avatarsReply.getAvatarsList();
        List<AvatarReply> filteredList = avatarsList.stream()
                .filter(it -> it.getNation().getName().equals(request.getNation()))
                .collect(Collectors.toList());

        responseObserver.onNext(AvatarsReply.newBuilder().addAllAvatars(filteredList).build());
        responseObserver.onCompleted();
    }
}
