package playlist.server.dto;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AccessTokenDetail {

    private final Long userId;
    private final String role;
}
