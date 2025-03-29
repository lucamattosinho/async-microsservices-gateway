package com.example.ms_2;


import com.example.ms_2.Entities.Clima;
import com.example.ms_2.Repositories.ClimaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQListener {

    @Autowired
    private ClimaRepository climaRepository;

    @RabbitListener(queues = "climaQueue")
    public void receiveMessage(String clima) {
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            Clima climaObj = objectMapper.readValue(clima, Clima.class);
            System.out.println("Clima recebido: " + climaObj);
            climaRepository.save(climaObj);
            if(climaObj.getTemperatura() > 30) {
                System.out.println("Alerta de calor: " + climaObj.getTemperatura());
            }
            if(climaObj.getTemperatura() < 10) {
                System.out.println("Alerta de frio: " + climaObj.getTemperatura());
            }
            System.out.println("Clima recebido: " + clima);
        }
        catch (Exception e) {
            System.out.println("Erro ao processar mensagem: " + e.getMessage());
        }
    }
}
