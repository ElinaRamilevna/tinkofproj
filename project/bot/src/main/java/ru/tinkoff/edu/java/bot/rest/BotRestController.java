package ru.tinkoff.edu.java.bot.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.tinkoff.edu.java.bot.dto.LinkUpdate;
import ru.tinkoff.edu.java.bot.service.UpdateService;
import ru.tinkoff.edu.java.bot.service.UpdateServiceImpl;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BotRestController {


    private final UpdateService updateService;


    public BotRestController(UpdateService updateService) {
        this.updateService = updateService;
    }

    @PostMapping("updates")
    public void sendUpdate(@RequestBody LinkUpdate request) {
        updateService.updateLink(request);
    }


}