package com.cdg.chooz.db.vote;


import com.cdg.chooz.db.common.BaseTimeEntity;
import com.cdg.chooz.db.user.UserEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class BookmarkEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private UserEntity user;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "VOTE_ID")
//    private Vote vote;
//
//    public void mappingVote(Vote vote) {
//        this.vote = vote;
//        vote.mappingBookmark(this);
//    }
//
//    public void mappingUser(User user) {
//        this.user = user;
//        user.mappingBookmark(this);
//    }


}
