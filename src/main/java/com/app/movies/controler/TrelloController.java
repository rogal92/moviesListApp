package com.app.movies.controler;

import com.app.movies.domain.CreatedTrelloCardDto;
import com.app.movies.domain.TrelloBoardDto;
import com.app.movies.domain.TrelloCardDto;
import com.app.movies.trello.facade.TrelloFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/trello")
public class TrelloController {

    @Autowired
    TrelloFacade trelloFacade;

    @RequestMapping(method = RequestMethod.GET, value = "/boards")
    public List<TrelloBoardDto> getTrelloBoards() {
        return trelloFacade.callForTrelloBoards();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/cards")
    public CreatedTrelloCardDto createdTrelloCardDto(@RequestBody TrelloCardDto trelloCardDto) {
        return trelloFacade.createdTrelloCard(trelloCardDto);
    }
}
