package com.example.repos;

import com.example.beans.Character;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CharacterRepo extends CrudRepository<Character, Integer> {
    boolean existsByFirstNameAndLastName(String firstName, String lastName);

//    Optional<Character> findByFirstNameAndLastName(String firstName, String lastName);
    Character findByFirstNameAndLastName(String firstName, String lastName);
    List<Character> findById(int id);
    List<Character> findByFirstName(String first);
    Iterable<Character> findAllByHouse(String house);
    Character deleteByFirstNameAndLastName(String firstName, String lastName);

}
