package com.cdg.chooz.controller.statistics;

import com.cdg.chooz.controller.statistics.response.SelectStatisticsResponse;
import com.cdg.chooz.controller.statistics.response.TotalStatisticsResponse;
import com.cdg.chooz.domain.vote.AgeType;
import com.cdg.chooz.domain.vote.GenderType;
import com.cdg.chooz.domain.vote.MbtiType;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
@Slf4j
public class StatisticsController {

//    private final StatisticsService statisticsService;

    @Operation(description = "투표 참여 인원 통계")
    @GetMapping("/vote/{voteId}/total-statistics")
    public ResponseEntity<TotalStatisticsResponse> getTotalStatistics(@PathVariable("voteId") Long voteId) {

//        Long totalVoteCount = statisticsService.getTotalStatistics(voteId);

//        TotalStatisticsResponse totalStatisticsResponse = TotalStatisticsResponse.builder()
//                .voteId(voteId)
//                .totalVoteCount(totalVoteCount)
//                .message("해당 voteId 투표 참여 인원 통계 조회에 성공했습니다")
//                .build();

//        return new ResponseEntity(totalStatisticsResponse, HttpStatus.OK);
        return ResponseEntity.ok().body(null);

    }

    @Operation(description = "A, B 투표 참여 인원, 퍼센테이지 통계")
    @GetMapping("/vote/{voteId}/select-statistics")
    public ResponseEntity<SelectStatisticsResponse> getSelectStatistics(@PathVariable("voteId") Long voteId, @RequestParam(required = false) GenderType gender, @RequestParam(required = false) AgeType age, @RequestParam(required = false) MbtiType mbti) {

//        VoteSelectResultData voteSelectResultData  = statisticsService.getSelectedStatistics(voteId, gender, age, mbti);

//        SelectStatisticsResponse selectStatisticsResponse = new SelectStatisticsResponse(voteId, voteSelectResultData);

//        return new ResponseEntity(selectStatisticsResponse, HttpStatus.OK);
        return ResponseEntity.ok().body(null);

    }
}
