package org.hs.controller;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class RoenController {

    @GetMapping(value = {"/leave/calendarTest"})
    public ResponseEntity<?> list() {
        log.info("request....");

        List<RoenVo> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(
                RoenVo.builder()
                    .exam1("exam1_" + i)
                    .exam2("exam2_" + i)
                    .exam3("exam3_" + i)
                    .exam4("exam4_" + i)
                    .build()
            );
        }
        return ResponseEntity.ok(list);
    }
    
    @Getter
    @Setter
    static class RoenVo {

        String exam1;
        String exam2;
        String exam3;
        String exam4;

        @Builder
        public RoenVo(String exam1, String exam2, String exam3, String exam4) {
            this.exam1 = exam1;
            this.exam2 = exam2;
            this.exam3 = exam3;
            this.exam4 = exam4;
        }
    }
}
