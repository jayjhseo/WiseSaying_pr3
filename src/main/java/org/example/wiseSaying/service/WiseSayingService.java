package org.example.wiseSaying.service;

import org.example.wiseSaying.entity.WiseSaying;
import org.example.wiseSaying.repository.WiseSayingRepository;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingService {
    WiseSayingRepository wiseSayingRepository = new WiseSayingRepository();

    public List<WiseSaying> getWiseSayingList() {
        return wiseSayingRepository.getWiseSayingList();
    }

    public long create(String author, String content) {
        return wiseSayingRepository.create(author, content);
    }

    public void remove(WiseSaying wiseSaying) {
        wiseSayingRepository.remove(wiseSaying);
    }

    public void modify(WiseSaying wiseSaying, String author, String content) {
        wiseSayingRepository.modify(wiseSaying, author, content);
    }

    public WiseSaying getWiseSayingById(long id) {
        return wiseSayingRepository.getWiseSayingById(id);
    }

}
