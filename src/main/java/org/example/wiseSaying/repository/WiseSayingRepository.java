package org.example.wiseSaying.repository;

import org.example.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {
    List<WiseSaying> wiseSayings = new ArrayList<>();
    long lastId = 0;

    public List<WiseSaying> getWiseSayingList() {
        return wiseSayings;
    }

    public long create(String author, String content) {
        lastId++;
        WiseSaying wiseSaying = new WiseSaying(lastId, author, content);
        wiseSayings.add(wiseSaying);
        return lastId;
    }
    public void remove(WiseSaying wiseSaying) {
        wiseSayings.remove(wiseSaying);
    }
    public void modify(WiseSaying wiseSaying, String author, String content) {
        wiseSaying.setAuthor(author);
        wiseSaying.setContent(content);
    }
    public WiseSaying getWiseSayingById(long id) {
        for (int i = 0; i < wiseSayings.size(); i++) {
            WiseSaying wiseSaying = wiseSayings.get(i);
            if (wiseSaying.getId() == id) {
                return wiseSaying;
            }
        }
        return null;
    }

}
