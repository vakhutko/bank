package com.bank.account.kafka;

import com.bank.account.mapper.AccountMapper;
import com.bank.account.service.AccountService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaConsumer {
    private final AccountService accountService;
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final AccountMapper accountMapper;

    @KafkaListener(topics = "bank")
    public void listen(ConsumerRecord<?, ?> record) {
        log.info(record.toString());
        accountService.getAccountByNumber(record.value().toString())
                .map(accountMapper::fromAccount)
                .<CompletableFuture<SendResult<String, String>>>handle((account, sink) -> {
                    ObjectWriter ow = new ObjectMapper().findAndRegisterModules()
                            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                            .writer().withDefaultPrettyPrinter();
                    try {
                        String json = ow.writeValueAsString(account);
                        sink.next(kafkaTemplate.send("account", json));
                    } catch (JsonProcessingException e) {
                        sink.error(new RuntimeException(e));
                    }
                })
                .subscribe();
    }
}
