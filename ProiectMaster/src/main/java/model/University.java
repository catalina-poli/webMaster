package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.data.annotation.Id;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "universities")
public class University {

    @Id
    @Column(name = "university_id")
    private int universityId;

    @Column(name = "name")
    private String name;

}