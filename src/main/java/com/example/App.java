package com.example;

import com.example.grpc.GreetingServiceGrpc;
import com.example.grpc.GreetingServiceOuterClass;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class App {

	public static void main(String[] args) {
		ManagedChannel chanel = ManagedChannelBuilder.forTarget("localhost:8080").usePlaintext().build();

		GreetingServiceGrpc.GreetingServiceBlockingStub stub = GreetingServiceGrpc.newBlockingStub(chanel);

		GreetingServiceOuterClass.HelloRequest request = GreetingServiceOuterClass.HelloRequest.newBuilder()
				.setName("Mihail").build();

		GreetingServiceOuterClass.HelloResponse resptose = stub.greeting(request);

		System.out.println(resptose);

		chanel.shutdownNow();
	}

}
