package com.ossapp.mainapp.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "users_tbl")
public class User extends BaseEntity {

    @Column(name = "phone_fld")
    @Pattern(regexp = "^((\\+7)+([0-9]){10})$")
    private String phone;

    @Column(name = "name_fld")
    private String name;

    @Column(name = "birth_date_fld")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "UTC")
    @NotNull
    private Date birthDate;

    @Column(name = "weight_fld")
    private Integer weight;

    @Column(name = "sex_fld")
    private Integer sex;

    @Column(name = "about_fld")
    private String about;

    @OneToMany(mappedBy = "userId", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<UserImages> images;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_styles_tbl",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "style_id"))
    private Collection<Style> styles;

    public void addImage(UserImages userImages) {
        if (userImages == null) {
            images = new ArrayList<>();
        }
        images.add(userImages);
    }

}