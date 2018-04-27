package com.app.movies.Service;

import com.app.movies.domain.CreatedTrelloCardDto;
import com.app.movies.domain.TrelloBoardDto;
import com.app.movies.domain.TrelloCardDto;
import com.app.movies.trello.client.Trelloclient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrelloService {

    @Autowired
    private Trelloclient trelloclient;

    public List<TrelloBoardDto> callToTrelloBoards() {
        return trelloclient.getTrelloBoards();
    }

    public CreatedTrelloCardDto createdTrelloCard(final TrelloCardDto trelloCardDto) {
        CreatedTrelloCardDto newCard = trelloclient.createdNewCard(trelloCardDto);

        return newCard;
    }
}
