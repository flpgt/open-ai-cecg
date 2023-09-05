package br.com.open.ai.cecg.OpeinAi.http.impl;

import br.com.open.ai.cecg.OpeinAi.http.OpenAIController;
import br.com.open.ai.cecg.OpeinAi.http.data.request.ScienceFictionRequestDTO;
import br.com.open.ai.cecg.OpeinAi.servers.CallOpenAiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
 @RequestMapping(value = "/openai-cecg")
public record OpenAIControllerImpl(CallOpenAiService service ) implements OpenAIController {

    @Autowired
    private CallOpenAiService service;

    @Override
    @RequestMapping(value = "/science-fiction")
    @ResponseStatus(HttpStatus.OK)
    public String generataScinceFiction(@RequestBody ScienceFictionRequestDTO requestDTO) {
        return service.generateScienceFiction(requestDTO);
    }
}
