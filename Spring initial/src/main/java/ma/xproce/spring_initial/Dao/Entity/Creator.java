package ma.xproce.spring_initial.Dao.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.net.ProtocolFamily;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Builder

public class Creator {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    @OneToMany (mappedBy = "creator", fetch = FetchType.LAZY)
    private List<Video> videos;

}
