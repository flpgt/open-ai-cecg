package br.com.open.ai.cecg.OpeinAi.servers;

import br.com.open.ai.cecg.OpeinAi.http.data.request.ScienceFictionRequestDTO;

public interface CallOpenAiService {
    String generateScienceFiction(ScienceFictionRequestDTO requestDTO);
}
