package ma.xproce.spring_initial.dtos;



import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Builder

public class VideoRequest {
    private String title;
    private String url;
    private String description;
    private String datePublication;
    private CreatorRequest creator; // Matches "creator" in GraphQL schema
}