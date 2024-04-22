package dev.xxj.wechatapi.web.data;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "offer")
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "title", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String title;

    private String description;

    @Column(name = "deadline", nullable = false)
    private LocalDate deadline;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @Column(name = "amount", nullable = false)
    private Integer amount;

}