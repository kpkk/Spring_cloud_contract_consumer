package com.org.carrental;

import org.assertj.core.api.BDDAssertions;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.StubTrigger;
import org.springframework.cloud.contract.stubrunner.junit.StubRunnerRule;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
/*@AutoConfigureStubRunner(
        //workOffline=true,
        ids="com.example:fraud-detection"
)*/
public class FraudListenerTests {

    @Rule
    public StubRunnerRule stubRunnerRule=new StubRunnerRule().downloadStub("com.example","fraud-detection")
            .withPort(6544);

    @Autowired FraudListener listener;
    @Autowired Sink sink;
    @Autowired StubTrigger stubTrigger;

    @Test
    public void should_receive_a_message(){
        //given a fraud
      //  Fraud fraud=new Fraud("m");


        //when a message is sent
     //   sink.input().send(MessageBuilder.withPayload(fraud).build());
        //then stores the fraud name

        stubTrigger.trigger("trigger_fraud");
        BDDAssertions.then(listener.name).isEqualTo("m");
    }
}
