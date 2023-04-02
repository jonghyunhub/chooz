package com.cdg.chooz.controller.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/user")
@RestController
@RequiredArgsConstructor
public class UserController {
//    private final UserService userService;
//    private final VoteService voteService;
//    private final StatisticsService statisticsService;
//    private final CommentService commentService;



//    @Operation(description = "유저 정보 추가, 헤더에 토큰담고 바디에 AddInfoRequest 행태로 넣어주셔야 합나디.")
//    @PatchMapping("/addInfo")
//    public ResponseEntity<CommonResponse> addUserInfo(@Valid @RequestBody AddInfoRequest addInfoRequest, @RequestAttribute Claims claims) {
////        Integer userId = (int) claims.get("userId");
////        Long longId = Long.valueOf(userId);
////        try {
////             userService.addUserInfo(addInfoRequest, longId);
////        } catch (NotFoundException e) {
////            CommonResponse response = new CommonResponse("해당 아이디 값을 가진 유저가 없습니다. 아이디를 다시 한번 확인하세요.");
////            return new ResponseEntity(response, HttpStatus.NOT_FOUND);
////        }
////        CommonResponse response = new CommonResponse("유저 정보 추가에 성공했습니다.");
//        return new ResponseEntity(response, HttpStatus.OK);
//    }
//
//
//    @PatchMapping("/addInterestCategory")
//    public ResponseEntity<CommonResponse> AddInterestCategory(@RequestBody AddInterestCategoryRequest addInterestCategoryRequest, @RequestAttribute Claims claims) {
////        Integer userId = (int) claims.get("userId");
////        Long longId = Long.valueOf(userId);
////        try {
////            userService.addInterestCategory(addInterestCategoryRequest.getCategoryLists(), longId);
////        } catch (NotFoundException e) {
////            CommonResponse response = new CommonResponse("해당 아이디 값을 가진 유저가 없습니다. 아이디를 다시 한번 확인하세요.");
////            return new ResponseEntity(response, HttpStatus.NOT_FOUND);
////        }
////        CommonResponse response = new CommonResponse("유저 관심사 카테고리 추가에 성공했습니다.");
//        return new ResponseEntity(response, HttpStatus.OK);
//    }
//
//
//    @Operation(description = "마이페이지 타입별 voteList 요청 api")
//    @GetMapping("/mypage")
//    public ResponseEntity<Slice<MyPageResponse>> getVotesByUser(@Parameter(description = "created,participated,bookmarked", required = true) @RequestParam VoteType voteType, @RequestParam int page, @RequestParam int size, @RequestAttribute Claims claims) {
////        Integer userId = (int) claims.get("userId");
////        Long longId = Long.valueOf(userId);
////
////        List<MyPageResponse> responses = new ArrayList<>();
////
////        Slice<Vote> voteList = voteService.getVotesByUser(longId, voteType, page, size);
////
////        boolean isLast = voteList.getSize() < size;
////
////        for (Vote vote : voteList) {
////            MyPageResponse myPageResponse = MyPageResponse.builder()
////                    .voteId(vote.getId())
////                    .imageA(vote.getImageA())
////                    .imageB(vote.getImageB())
////                    .title(vote.getTitle())
////                    .countVoted(statisticsService.getTotalStatistics(vote.getId())) //총 투표인원  조회로 쿼리가 size 만큼 더 발생하는 문제
////                    .countComment(commentService.getCommentsCountByVote(vote.getId())) //comment 조회로 쿼리가 size 만큼 더 발생하는 문제
////                    .modifiedDate(vote.getModifiedDate())
////                    .build();
////            responses.add(myPageResponse);
////        }
////
////        Slice<MyPageResponse> sliceResponse = new SliceImpl<>(responses, voteList.getPageable(), isLast);
//
//
//        return new ResponseEntity<>(sliceResponse, HttpStatus.OK);
//
//    }
//
//    @Operation(description = "마이페이지 타입별 voteCount 요청 api")
//    @GetMapping("/mypage/count")
//    public ResponseEntity<MyPageCountResponse> getMyPageCount(@RequestAttribute Claims claims) {
////        Integer userId = (int) claims.get("userId");
////        Long longId = Long.valueOf(userId);
////
////        Map<String, Long> map = userService.getMyPageCount(longId);
////        Long countCreatedVote = map.get("CREATED_VOTE");
////        Long countParticipatedVote = map.get("PARTICIPATED_VOTE");
////        Long countBookmarkedVote = map.get("BOOKMARKED_VOTE");
////
////        MyPageCountResponse myPageCountResponse = new MyPageCountResponse(countCreatedVote, countParticipatedVote, countBookmarkedVote);
//
//
//        return new ResponseEntity(myPageCountResponse, HttpStatus.OK);
//
//    }
//
//    @Operation(description = "프로필 수정")
//    @PatchMapping("/mypage/edit")
//    public ResponseEntity<GetUserResponse> updateUser(@RequestBody UpdateUserRequest updateUserRequest, @RequestAttribute Claims claims) throws NotFoundException {
////        Integer userId = (int) claims.get("userId");
////        Long longId = Long.valueOf(userId);
////
////        User user = userService.updateUser(longId, updateUserRequest.getNickname(), updateUserRequest.getImage(), updateUserRequest.getMbti(), updateUserRequest.getCategoryList());
////
////        GetUserResponse getUserResponse = new GetUserResponse(user.getId(), user.getImageUrl(), user.getNickname(), user.getGender(), user.getAge(), user.classifyAge(user.getAge()), user.getMbti());
//
////        return new ResponseEntity(getUserResponse, HttpStatus.OK);
//        return new ResponseEntity(getUserResponse, HttpStatus.OK);
//    }


}
