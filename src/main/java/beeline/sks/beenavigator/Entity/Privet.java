package beeline.sks.beenavigator.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Privet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String author;
    private String code;
    private String genre;
    private String title;
}
