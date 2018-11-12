package com.example.services;

import com.example.beans.Character;
import com.example.repos.CharacterRepo;
import com.sun.javafx.iio.ios.IosDescriptor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.message.StringFormattedMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CharacterService {

    @Autowired
    private CharacterRepo characterRepo;

    public Character getCharacterByFirstAndLastName(String firstName, String lastName){
        Character person = characterRepo.findByFirstNameAndLastName(firstName, lastName);
        return person;
    }

    public List<Character> getCharacterByHouse(String house){
        List<Character> list = new ArrayList<>();
        characterRepo.findAllByHouse(house).forEach(e -> list.add(e) );
        return list;
    }

    public void deleteCharacter(String firstName, String lastName) {
        characterRepo.deleteByFirstNameAndLastName(firstName, lastName);
    }

    public synchronized boolean addCharacter(Character character){
        List<Character> list = characterRepo.findByFirstName(character.getFirstName());
        if (list.size() > 0) {
            return false;
        } else {
            characterRepo.save(character);
            return true;
        }
        }

    public void updateCharacter(Character character)
    {
        characterRepo.save(character);
    }

//    public boolean saveCharacter(Character character)  throws IOException {
////            int id = character.getId();
////            Optional<Character> characterOptional = characterRepo.findById(id);
////            if(!characterOptional.isPresent())
////            {
////                log.debug(Boolean.toString(!characterOptional.isPresent()));
////                return false;
////            }
////            characterRepo.save(character);
////            return true;
//
//
//      }

//    public Iterable<Character> getCharactersHouses(String house)throws IOException {
////        return characterRepo.findAllByHouse(house);
//
//      }
//
//    public Optional <Character> getCharacterByName(String firstName, String lastName) throws IOException {
////       return characterRepo.findByFirstNameAndLastName(firstName, lastName);
//    }


    //    @Autowired
//    public void setCharacterRepo(CharacterRepo characterRepo){
//        this.characterRepo = characterRepo;
//    }

    //    public Article getArticleById(long articleId) {
//        Article obj = articleRepository.findById(articleId).get();
//        return obj;
//    }
}
