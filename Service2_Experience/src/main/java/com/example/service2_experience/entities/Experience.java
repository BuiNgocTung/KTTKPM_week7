package com.example.service2_experience.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "experiences")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exp_id")
    private long id;

    @Column(name = "companny", columnDefinition = "varchar(120)")
    private String compannyName;
    @Column
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate fromDate;
    @Column
    private LocalDate toDate;
    @ManyToOne
    @JoinColumn(name = "use_id")
    private User user;

    public Experience(long id, String compannyName, LocalDate fromDate, LocalDate toDate) {
        this.id = id;
        this.compannyName = compannyName;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }
}
