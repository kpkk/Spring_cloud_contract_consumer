package com.org.carrental;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@SpringBootApplication
@EnableBinding(Sink.class)

public class CarRentalApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarRentalApplication.class, args);
	}

}
@Component
@Slf4j
class FraudListener{
	String name;
 	@StreamListener(Sink.INPUT)
     void listen(Fraud fraud){
//log.info
 		this.name=	fraud.getName();

		}


		}

@Data
//@AllArgsConstructor
//@NoArgsConstructor
class Fraud {
private String surname;

Fraud(String name){
	this.surname=name;
}

	public String getName() {
		return surname;
	}
}
