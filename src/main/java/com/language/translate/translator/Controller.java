package com.language.translate.translator;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class Controller {

    @Autowired
    private TranslationService translationService;

    @RequestMapping(value ="/translate", method = RequestMethod.POST)
    public void getPlayerData(@RequestBody String text) throws InterruptedException, IOException {
        translationService.sendText(text);
    }

}
