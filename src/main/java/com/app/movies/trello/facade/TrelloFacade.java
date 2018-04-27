package com.app.movies.trello.facade;

import com.app.movies.Mapper.TrelloMapper;
import com.app.movies.Service.TrelloService;
import com.app.movies.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TrelloFacade {

    @Autowired
    TrelloService trelloService;

    @Autowired
    TrelloMapper trelloMapper;

    public List<TrelloBoardDto> callForTrelloBoards() {
        List<TrelloBoard> trelloBoards = trelloMapper.mapToBoards(trelloService.callToTrelloBoards());
        return trelloMapper.mapToBoardsDto(trelloBoards);
    }

    public CreatedTrelloCardDto createdTrelloCard(final TrelloCardDto trelloCardDto) {
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);
        return trelloService.createdTrelloCard(trelloMapper.mapToCardDto(trelloCard));
    }
}
