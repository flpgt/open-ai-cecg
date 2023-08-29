package br.com.open.ai.cecg.OpeinAi.config;

import com.theokanning.openai.service.OpenAiService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class openAIconfig {

    @Value("${open.secret}")
    private String openAIsecret;

    @Bean
    public OpenAiService getOpenAIBean() {
        return new OpenAiService(openAIsecret);


       }
    }

