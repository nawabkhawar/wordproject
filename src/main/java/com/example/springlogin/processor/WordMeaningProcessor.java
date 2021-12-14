package com.example.springlogin.processor;

import com.example.springlogin.WordMeaning;
import com.example.springlogin.dao.WordMeaningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WordMeaningProcessor {

    @Autowired
    WordMeaningRepository wordMeaningRepository;

    public long saveWordMeaning(WordMeaning wordMeaning){
        WordMeaning id = wordMeaningRepository.save(wordMeaning);
        return wordMeaning.getId();
    }

    public List<WordMeaning> findAllWords(){
        List<WordMeaning> wordMeaningList = (List<WordMeaning>) wordMeaningRepository.findAll();
        return wordMeaningList;
    }

    public List<WordMeaning> findAllRatedWords(List<WordMeaning> fullWordList){
        List<WordMeaning> filteredWordList = new ArrayList<>();
        for(WordMeaning wordMeaning:fullWordList){
            if(wordMeaning.getRating()>5){
                filteredWordList.add(wordMeaning);
            }
        }
        return filteredWordList;
    }

}
