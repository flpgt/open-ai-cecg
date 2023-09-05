package br.com.open.ai.cecg.OpeinAi.http.impl;

import br.com.open.ai.cecg.OpeinAi.componente.ChatStreamComponent;
import br.com.open.ai.cecg.OpeinAi.http.data.request.ScienceFictionRequestDTO;
import br.com.open.ai.cecg.OpeinAi.servers.CallOpenAiService;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.completion.chat.ChatMessageRole;

import java.util.List;

public record CallOpenAiServiceimpl(ChatStreamComponent streamComponent) implements CallOpenAiService {

    public static final String SCIENCE_FICTION_PROMPT_MESSAGE =
            "Gere uma estoria de fcção científica de acordo com o " +
                    "seguinte cenário: %5";
    @Override
    public String generateScienceFiction(ScienceFictionRequestDTO requestDTO) {
        ChatCompletionRequest chatCompletionRequest =
                streamComponent.createChatStreamRequest(List.of(
                        new ChatMessage(ChatMessageRole.SYSTEM.value(),
                                String.format(SCIENCE_FICTION_PROMPT_MESSAGE, requestDTO.scenario()))
                ))
        return streamComponent.getChatStreamResult(chatCompletionRequest);
    }
}
