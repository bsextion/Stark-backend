package com.example.controllers;


import com.example.beans.Character;
import com.example.services.CharacterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/got")
public class CharacterController {



    @Autowired
    private CharacterService characterService;

    @GetMapping("character/{firstName}/{lastName}")
    public ResponseEntity<Character> getCharacterByName(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName) {
       Character character = characterService.getCharacterByFirstAndLastName(firstName, lastName);
        return new ResponseEntity<Character>(character, HttpStatus.OK);
    }

    @GetMapping("/character/{house}")
    public ResponseEntity<List<Character>> getHouse(@PathVariable("house") String house) {
        List<Character> list = characterService.getCharacterByHouse(house);
        return new ResponseEntity<List<Character>>(list, HttpStatus.OK);

    }


    @PostMapping("character")
    public ResponseEntity<Void> addCharacter(@RequestBody Character character, UriComponentsBuilder builder) {
        boolean flag = characterService.addCharacter(character);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();

        headers.setLocation(builder.path("character/{house}").buildAndExpand(character.getHouse()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }


    @PutMapping("character")
    public ResponseEntity<Character> updateCharacter(@RequestBody Character character) {
      characterService.updateCharacter(character);
      return new ResponseEntity<Character>(character, HttpStatus.OK);
    }

    @DeleteMapping("article/{firstName}&{LastName}")
    public ResponseEntity<Void> deleteArticle(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName ) {
        characterService.deleteCharacter(firstName, lastName);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
//
//
// @Autowired
//    public void setCharacterService(CharacterService characterService){
//        this.characterService = characterService;
//    }

//    @PostMapping(value = "/character/new")
//    public ResponseEntity<String> addCharacter(HttpServletRequest httpServletRequest, @RequestBody Character character)
//    {
//        try {
//            if(!characterService.saveCharacter(character))
//                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//            else
//                return new ResponseEntity<>(HttpStatus.OK);
//
//        }
//
//        catch (IOException ex)
//        {
//            log.error(ex.getMessage());
//            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
//        }
//    }
//
//
//    @GetMapping(value = "/character/{firstName}/{lastName}")
//    public ResponseEntity<Character> getCharacter(
//            HttpServletRequest httpServletRequest,
//            @PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName)
//    {
//        try {
//            Optional<Character> characterOptional = characterService.getCharacterByName(firstName, lastName);
//            if(!characterOptional.isPresent()){
//                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
//
//
//            }
//            else {
//                return new ResponseEntity<>(characterOptional.get(), HttpStatus.OK);
//            }
//
//        }
//
//        catch (IOException ex)
//        {
//            log.debug(ex.getMessage());
//            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
//        }
//    }
//
//    @GetMapping(value = "/characters/{house}")
//    public ResponseEntity getCharacters(HttpServletRequest httpServletRequest,
//                                        @PathVariable("house") String house) {
//
//        try {
//            Iterable<Character> characters = characterService.getCharactersHouses(house);
//            System.out.println("Success " + characters);
//            return new ResponseEntity (characters, HttpStatus.OK);
//
//        } catch (IOException ex) {
//            log.error(ex.getMessage());
//            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
//        }
//
//
//    }
}
