package playlist.server.exception;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

import lombok.AllArgsConstructor;
import lombok.Getter;
import playlist.server.dto.ErrorDetail;

@Getter
@AllArgsConstructor
public enum GlobalException implements BaseErrorCode {
    EXAMPLE_ERROR(BAD_REQUEST.value(), "400-0", "에러 예시 입니다."),
    METHOD_ARGUMENT_ERROR(
            BAD_REQUEST.value(), "400-1", "메서드 인자가 유효하지 않거나 @Valid를 통과하지 못하여 발생하는 예외입니다."),
    INTERNAL_SERVER_ERRORS(INTERNAL_SERVER_ERROR.value(), "500-1", "서버 내부 오류입니다."),
    EXPIRED_TOKEN_ERROR(UNAUTHORIZED.value(), "401-1", "토큰이 만료되었습니다."),
    EXPIRED_REFRESH_TOKEN_ERROR(UNAUTHORIZED.value(), "401-1", "리프레시 토큰이 만료되었습니다."),
    INVALID_TOKEN_ERROR(UNAUTHORIZED.value(), "401-2", "올바르지 않은 토큰입니다."),
    DATE_FORMAT_ERROR(BAD_REQUEST.value(), "400-2", "날짜 형식을 확인해주세요."),
    SECURITY_CONTEXT_NOT_FOUND_ERROR(
            INTERNAL_SERVER_ERROR.value(), "500-2", "Security Context 에러입니다.");

    private final Integer statusCode;
    private final String errorCode;
    private final String reason;

    @Override
    public ErrorDetail getErrorDetail() {
        return ErrorDetail.of(statusCode, errorCode, reason);
    }
}
