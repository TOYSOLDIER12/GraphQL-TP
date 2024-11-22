package ma.xproce.spring_initial.dtos;

import lombok.*;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class CreatorRequest {
    private String name;
    private String email;
    //private List<VideoRequest> videos;
}
