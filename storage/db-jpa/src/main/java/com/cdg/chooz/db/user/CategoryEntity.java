package com.cdg.chooz.db.user;

import com.cdg.chooz.domain.vote.VoteCategoryType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class CategoryEntity {

    @Id
    @GeneratedValue
    @Column(name = "CATEGORY_ID")
    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private VoteCategoryType category;

    public VoteCategoryType toCategory() {
        return this.getCategory();
    }

    public CategoryEntity(Long id, VoteCategoryType category){
        this.id = id;
        this.category = category;
    }
}
