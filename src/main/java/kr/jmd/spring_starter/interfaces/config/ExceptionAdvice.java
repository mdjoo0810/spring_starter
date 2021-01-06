package kr.jmd.spring_starter.interfaces.config;

import kr.jmd.spring_starter.interfaces.config.advice.CAuthenticationEntryPointException;
import kr.jmd.spring_starter.interfaces.config.advice.CUserNotFoundException;
import kr.jmd.spring_starter.interfaces.resource.CommonResult;
import kr.jmd.spring_starter.interfaces.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@RestControllerAdvice
public class ExceptionAdvice {

    private final ResponseUtil responseUtil;
    private final MessageSource messageSource;

    @ExceptionHandler(CAuthenticationEntryPointException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public CommonResult authenticationEntryPointException(HttpServletRequest request, CAuthenticationEntryPointException e) {
        return responseUtil.getFailResult(Integer.parseInt(getMessage("entryPointException.code")), getMessage("entryPointException.msg"));
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public CommonResult AccessDeniedException(HttpServletRequest request, AccessDeniedException e) {
        return responseUtil.getFailResult(Integer.parseInt(getMessage("accessDenied.code")), getMessage("accessDenied.msg"));
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected CommonResult defaultException(HttpServletRequest request, Exception e) {
        // 예외 처리의 메시지를 MessageSource에서 가져오도록 수정
        return responseUtil.getFailResult(Integer.parseInt(getMessage("unKnown.code")), getMessage("unKnown.msg"));
    }

    @ExceptionHandler(CUserNotFoundException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected CommonResult userNotFoundException(HttpServletRequest request, CUserNotFoundException e) {
        // 예외 처리의 메시지를 MessageSource에서 가져오도록 수정
        return responseUtil.getFailResult(Integer.parseInt(getMessage("userNotFound.code")), getMessage("userNotFound.msg"));
    }

    private String getMessage(String code) {
        return getMessage(code, null);
    }
    private String getMessage(String code, Object[] args) {
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }

}
