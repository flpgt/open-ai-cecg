package br.com.open.ai.cecg.OpeinAi.http.impl;

import br.com.open.ai.cecg.OpeinAi.http.OpenAIController;
import br.com.open.ai.cecg.OpeinAi.http.data.request.ScienceFictionRequestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
 @RequestMapping(value = "/openai-cecg")
public class OpenAIControllerImpl implements OpenAIController {
    @Override
    @RequestMapping(value = "/science-fiction")
    @ResponseStatus(HttpStatus.OK)
    public String generataScinceFiction(ScienceFictionRequestDTO requestDTO) {
        return null;
    }
}
