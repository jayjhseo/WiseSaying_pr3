package org.example;

import org.example.system.controller.SystemController;
import org.example.wiseSaying.controller.WiseSayingController;
import org.example.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;

public class App {

    public void run() {
        System.out.println("== 명언 앱 ==");
        WiseSayingController wiseSayingController = new WiseSayingController();
        while (true) {
            System.out.print("명령) ");
            String command = Container.getScanner().nextLine().trim();
            switch (command) {
                case "종료":
                    SystemController.exit();
                    return;
                case "등록":
                    wiseSayingController.write();
                    break;
                case "목록":
                    wiseSayingController.list();
                    break;
                case "삭제":
                    wiseSayingController.remove();
                    break;
                case "수정":
                    wiseSayingController.modify();
                    break;
            }
        }
    }
}
