package com.cdg.chooz.db.user;

import com.cdg.chooz.db.common.BaseTimeEntity;
import com.cdg.chooz.db.vote.BookmarkEntity;
import com.cdg.chooz.domain.user.ProviderType;
import com.cdg.chooz.domain.user.RoleType;
import com.cdg.chooz.domain.user.User;
import com.cdg.chooz.domain.vote.GenderType;
import com.cdg.chooz.domain.vote.MbtiType;
import com.cdg.chooz.entity.comment.CommentEmotion;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class UserEntity extends BaseTimeEntity {
    @Id
    @GeneratedValue
    @Column(name = "USER_ID")
    private Long id;

    @Column
    private String nickname;

    @Column
    private String email;

    private String imageUrl;

    private String password;

    @Enumerated(EnumType.STRING)
    private ProviderType provider;    // oauth2를 이용할 경우 어떤 플랫폼을 이용하는지

    private String providerId;  // oauth2를 이용할 경우 아이디값

    @Enumerated(EnumType.STRING)
    private RoleType role;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private GenderType gender;

    @Enumerated(EnumType.STRING)
    private MbtiType mbti;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, orphanRemoval = true)
    @JoinColumn(name = "USER_ID")
    private List<CategoryEntity> categoryLists = new ArrayList<>();

    @Column(name = "modified_MBTI_Date")
    private LocalDateTime modifiedMBTIDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<BookmarkEntity> bookmarkList = new ArrayList<>();

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.REMOVE)
//    private List<CommentEmotion> commentEmotionList = new ArrayList<>();


//    public void mappingCommentLike(CommentEmotion commentEmotion) {
//        this.commentEmotionList.add(commentEmotion);
//    }

    public void mappingBookmark(BookmarkEntity bookmark) {
        this.bookmarkList.add(bookmark);
    }

    public void updateProfile(String nickname, String image) {
        this.nickname = nickname;
        this.imageUrl = image;
    }

//    public void updateMbti(MBTI mbti, LocalDateTime modifiedMBTIDate) {
//        this.mbti = mbti;
//        this.modifiedMBTIDate = modifiedMBTIDate;
//    }
//
    @Builder
    public UserEntity(User user) {
        this.nickname = nickname;
        this.email = email;
        this.imageUrl = imageUrl;
        this.password = password;
    }
//
//    public Age classifyAge(Integer age){
//        Age ageGroup;
//        switch (age/10){
//            case 1:
//                ageGroup = Age.teenager;
//                break;
//            case 2:
//                ageGroup = Age.twenties;
//                break;
//            case 3:
//                ageGroup = Age.thirties;
//                break;
//            case 4:
//                ageGroup = Age.fourties;
//                break;
//            case 5:
//                ageGroup = Age.fifties;
//                break;
//            default:
//                ageGroup = Age.NULL;
//                break;
//        }
//        return ageGroup;
//    }
    public void clearCategoryList(){
        this.categoryLists.clear();
    }

    public User toDomain() {
        User user = User.builder()
                .id(id)
                .name(nickname)
                .email(email)
                .age(age)
                .gender(gender)
                .mbti(mbti)
                .provider(provider)
                .providerId(providerId)
                .build();
        return user;
    }
}
