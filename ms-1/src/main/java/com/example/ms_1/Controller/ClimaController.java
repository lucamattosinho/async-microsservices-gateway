package com.example.ms_1.Controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clima")
public class ClimaController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping
    public String sendClima(@RequestBody String clima) {
        rabbitTemplate.convertAndSend("climaExchange", "climaRoutingKey", clima);
        return "Clima salvo: " + clima;
    }
}
