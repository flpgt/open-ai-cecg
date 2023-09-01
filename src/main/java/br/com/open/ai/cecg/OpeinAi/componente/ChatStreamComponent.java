package br.com.open.ai.cecg.OpeinAi.componente;

import com.theokanning.openai.service.OpenAiService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ChatStreamComponent {
    private final OpenAiService;
    @Value("3000")
    private Integer maxToken;

    @Value("${open.max-tokens:500")
    private Integer MaxToken;


}
