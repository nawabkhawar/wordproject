package com.example.springlogin;

import com.example.springlogin.processor.WordMeaningProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StartupListener {

    @Autowired
    WordMeaningProcessor wordMeaningProcessor;

    private static List<WordMeaning> totalWordMeanings;

    private static List<WordMeaning> totalRatedWordMeanings;

    @EventListener(classes = ApplicationStartedEvent.class )
    public void listenToStart(ApplicationStartedEvent event) {
        System.out.println("Listener called");
        List<WordMeaning> wordMeaningList = wordMeaningProcessor.findAllWords();
        System.out.println("total words size:" + wordMeaningList.size() );
        setTotalWordMeanings(wordMeaningList);

        List<WordMeaning> ratedWords = wordMeaningProcessor.findAllRatedWords(wordMeaningList);
        System.out.println("total filtered words size:" + ratedWords.size() );
        setTotalRatedWordMeanings(ratedWords);
        //this.repo.findByCodeValue("100");
    }

    public static List<WordMeaning> getTotalWordMeanings() {
        return totalWordMeanings;
    }

    public static void setTotalWordMeanings(List<WordMeaning> totalWordMeanings) {
        StartupListener.totalWordMeanings = totalWordMeanings;
    }

    public static List<WordMeaning> getTotalRatedWordMeanings() {
        return totalRatedWordMeanings;
    }

    public static void setTotalRatedWordMeanings(List<WordMeaning> totalRatedWordMeanings) {
        StartupListener.totalRatedWordMeanings = totalRatedWordMeanings;
    }
}

/*
interface CodeCategoryRepository extends JpaRepository<CodeCategory, Long>{

    @Cacheable(value = "codeValues")
    List<String> findByCodeValue(String code);
}
*/

