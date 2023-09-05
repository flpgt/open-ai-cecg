package br.com.open.ai.cecg.OpeinAi.componente;

import com.theokanning.openai.completion.chat.ChatCompletionChoice;
import com.theokanning.openai.completion.chat.ChatCompletionChunk;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.service.OpenAiService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ChatStreamComponent {
    private final OpenAiService openAiService;
    private final OpenAiService;
    @Value("3000")

    private Integer Model;

    @Value("3000")

    private Integer MaxToken;

    public ChatStreamComponent(OpenAiService openAiService) {
        this.openAiService = openAiService;

    }

    public String getChatStreamResult(ChatCompletionRequest chatCompletionRequest) {
        StringBuilder sb = new StringBuilder();
        openAiService.streamChatCompletion(ChatCompletionRequest)
                .flatMapIterable(ChatCompletionChunk::getChoices)
                .filter(c -> c.getMessage() != null)
                .map(ChatCompletionChoice::getMessage)
                .filter(c -> c.getContent() != null)
                .map(ChatMessage::getContent)
                .doOnError(Throwable::printStackTrace)
                .doOnNext(sb::append)
                .blockingLast();
        return sb.toString();
    }


    public ChatCompletionRequest createChatStreamRequest(List<ChatMessage> messages) {

        return ChatCompletionRequest
                .builder()
                .model(model)
                .messages(messages)
                .n(1)
                .maxTokens(maxToken)

    }

}
