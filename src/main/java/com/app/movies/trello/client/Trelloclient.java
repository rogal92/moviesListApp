package com.app.movies.trello.client;

import com.app.movies.domain.CreatedTrelloCardDto;
import com.app.movies.domain.TrelloBoardDto;
import com.app.movies.domain.TrelloCardDto;
import com.app.movies.trello.config.TrelloConfig;
import com.sun.jndi.toolkit.url.Uri;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class Trelloclient {

    private static final Logger LOGGER = LoggerFactory.getLogger(Trelloclient.class);

    @Autowired
    TrelloConfig trelloConfig;

    @Autowired
    RestTemplate restTemplate;

    private URI url() {

        URI url = UriComponentsBuilder.fromHttpUrl(trelloConfig.getTrelloApiEndpoint() + "/members/" +
                trelloConfig.getTrelloAppUsername() + "/boards")
                .queryParam("key", trelloConfig.getTrelloAppKey())
                .queryParam("token", trelloConfig.getTrelloAppToken())
                .queryParam("username", trelloConfig.getTrelloAppUsername())
                .queryParam("fields","name,id")
                .queryParam("lists","all")
                .build().encode().toUri();
        return url;
    }

    public List<TrelloBoardDto> getTrelloBoards() {

        try {
            TrelloBoardDto[] boardsFromTrello = restTemplate.getForObject(url(), TrelloBoardDto[].class);
            return Arrays.asList(Optional.ofNullable(boardsFromTrello).orElse(new TrelloBoardDto[0]));
        } catch (RestClientException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return new ArrayList<>();
    }
    public CreatedTrelloCardDto createdNewCard(TrelloCardDto trelloCardDto) {
        URI url = UriComponentsBuilder.fromHttpUrl(trelloConfig.getTrelloApiEndpoint() + "/cards")
                .queryParam("key",trelloConfig.getTrelloAppKey())
                .queryParam("token", trelloConfig.getTrelloAppToken())
                .queryParam("name", trelloCardDto.getName())
                .queryParam("desc", trelloCardDto.getDescription())
                .queryParam("pos", trelloCardDto.getPos())
                .queryParam("idList", trelloCardDto.getListId())
                .build().encode().toUri();

        return restTemplate.postForObject(url, null, CreatedTrelloCardDto.class);
    }
}
