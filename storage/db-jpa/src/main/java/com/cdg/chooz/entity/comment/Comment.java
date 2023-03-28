package com.cdg.chooz.entity.comment;

import com.cdg.chooz.domain.comment.Emotion;
import com.cdg.chooz.domain.vote.AgeType;
import com.cdg.chooz.domain.vote.GenderType;
import com.cdg.chooz.domain.vote.MbtiType;
import com.cdg.chooz.entity.common.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column
    private Long id;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "USER_ID")
//    private User commentUser;

    @Column
    private Long voteId;
    @Column
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID")
    private Comment parent;

    @OneToMany(mappedBy = "parent", orphanRemoval = true)
    private List<Comment> children = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @Column
    private AgeType age;

    @Enumerated(EnumType.STRING)
    @Column
    private MbtiType mbti;

    @Enumerated(EnumType.STRING)
    @Column
    private GenderType gender;
    @Column
    private Long likeCount;
    @Column
    private Long hateCount;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "comment")
    private List<CommentEmotion> commentEmotionList = new ArrayList<>();

    public void mappingCommentEmotion(CommentEmotion commentEmotion) {
        this.commentEmotionList.add(commentEmotion);
    }

    public void updateLikeHateCount() {
        int likecnt = 0;
        int hatecnt = 0;
        for (CommentEmotion commentEmotion : commentEmotionList) {
            if (commentEmotion.getEmotion().equals(Emotion.LIKE)) {
                likecnt += 1;
            } else {
                hatecnt += 1;
            }
        }
        this.likeCount = (long) likecnt;
        this.hateCount = (long) hatecnt;
    }

    public void removeEmotion(CommentEmotion commentEmotion) {
        this.commentEmotionList.remove(commentEmotion);
    }

//    public void update(CommentUpdateRequest commentUpdateRequest) {
//        this.content = commentUpdateRequest.getContent();
//    }

    public void updateParent(Comment parent) {
        this.parent = parent;
    }


}