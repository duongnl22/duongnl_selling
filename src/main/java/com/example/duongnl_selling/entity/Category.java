package com.example.duongnl_selling.entity;

import com.example.duongnl_selling.entity.base.PrimaryEntity;
import jakarta.persistence.*;
import lombok.*;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "category")
public class Category extends PrimaryEntity {

    @Column(name = "category_name")
    private String name;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

}
