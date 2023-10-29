package org.example.wiseSaying.controller;

import org.example.Container;
import org.example.wiseSaying.entity.WiseSaying;
import org.example.wiseSaying.service.WiseSayingService;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingController {


    WiseSayingService wiseSayingService = new WiseSayingService();
    public void write() {
        System.out.print("명언: ");
        String content = Container.getScanner().nextLine().trim();
        System.out.print("작가: ");
        String author = Container.getScanner().nextLine().trim();

        long id = wiseSayingService.create(author, content);
        System.out.printf("%d번째 명언이 등록되었습니다.\n", id);
    }
    public void list() {
        List<WiseSaying> wiseSayings = wiseSayingService.getWiseSayingList();
        if (wiseSayings.size() == 0) {
            System.out.println("명언이 존재하지 않습니다.");
            return;
        }
        System.out.println("번호 / 작가 / 명언");
        for (int i = 0; i < wiseSayings.size(); i++) {
            WiseSaying wiseSaying = wiseSayings.get(i);
            System.out.printf("%d, %s, %s\n", wiseSaying.getId(), wiseSaying.getAuthor(), wiseSaying.getContent());
        }
    }


    public void remove() {
        System.out.println("삭제할 명언의 ID값을 입력해주세요");
        long id = Long.parseLong(Container.getScanner().nextLine());

        WiseSaying wiseSaying = wiseSayingService.getWiseSayingById(id);

        if (wiseSaying == null) {
            System.out.printf("%d번째 명언이 존재하지 않습니다.\n", id);
            return;
        }
        System.out.printf("%d번째 명언이 삭제되었습니다.\n", id);
        wiseSayingService.remove(wiseSaying);

    }

    public void modify() {
        System.out.println("수정할 명언의 ID값을 입력해주세요");
        long id = Long.parseLong(Container.getScanner().nextLine());
        WiseSaying wiseSaying = wiseSayingService.getWiseSayingById(id);
        if (wiseSaying == null) {
            System.out.printf("%d번째 명언이 존재하지 않습니다.\n", id);
            return;
        }
        System.out.print("작가 수정: ");
        String author = Container.getScanner().nextLine();

        System.out.print("명언 수정: ");
        String content = Container.getScanner().nextLine();


        System.out.printf("%d번째 명언이 수정되었습니다.\n", id);
        wiseSayingService.modify(wiseSaying, author, content);
    }
}
