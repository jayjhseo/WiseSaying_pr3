package org.example;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public void run() {
        System.out.println("== 명언 앱 ==");
        List<WiseSaying> wiseSayings = new ArrayList<>();
        long lastId = 0;
        while (true) {
            System.out.print("명령) ");
            String command = Container.getScanner().nextLine().trim();
            if(command.equals("종료")) {
                break;
            } else if(command.equals("등록")) {
                lastId++;
                System.out.print("명언: ");
                String content = Container.getScanner().nextLine().trim();
                System.out.print("작가: ");
                String author = Container.getScanner().nextLine().trim();
                System.out.printf("%d번째 명언이 등록되었습니다.\n", lastId);
                WiseSaying wiseSaying = new WiseSaying(lastId, author, content);
                wiseSayings.add(wiseSaying);
            } else if(command.equals("목록")) {
                if (wiseSayings.size() == 0) {
                    System.out.println("명언이 존재하지 않습니다.");
                    continue;
                }
                System.out.println("번호 / 작가 / 명언");
                for (int i = 0; i < wiseSayings.size(); i++) {
                    WiseSaying wiseSaying = wiseSayings.get(i);
                    System.out.printf("%d, %s, %s\n", wiseSaying.getId(), wiseSaying.getAuthor(), wiseSaying.getContent());
                }
            } else if(command.equals("삭제")) {
                System.out.println("삭제할 명언의 ID값을 입력해주세요");
                long removeId = Long.parseLong(Container.getScanner().nextLine());
                boolean checkId = false;
                for (int i = 0; i < wiseSayings.size(); i++) {
                    WiseSaying wiseSaying = wiseSayings.get(i);
                    if (wiseSaying.getId() == removeId) {
                        checkId = true;
                        wiseSayings.remove(wiseSaying);
                    }
                } if (checkId) {
                    System.out.printf("%d번째 명언이 삭제되었습니다.\n", removeId);
                } else {
                    System.out.printf("%d번째 명언이 존재하지 않습니다.\n" , removeId);
                }
            } else if (command.equals("수정")) {
                System.out.println("수정할 명언의 ID값을 입력해주세요");
                long modifyId = Long.parseLong(Container.getScanner().nextLine());
                boolean checkId = false;
                for (int i = 0; i < wiseSayings.size(); i++) {
                    WiseSaying wiseSaying = wiseSayings.get(i);
                    if (wiseSaying.getId() == modifyId) {
                        checkId = true;
                        System.out.print("작가 수정: ");
                        String author = Container.getScanner().nextLine();
                        wiseSaying.setAuthor(author);
                        System.out.print("명언 수정: ");
                        String content = Container.getScanner().nextLine();
                        wiseSaying.setContent(content);
                    }
                } if (checkId == false) {
                    System.out.printf("%d번째 명언이 존재하지 않습니다.\n" , modifyId);
                    continue;
                }
                System.out.printf("%d번째 명언이 수정되었습니다.\n" , modifyId);
            }
        }
    }
}
