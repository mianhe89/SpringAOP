package com.example.springaop.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
@NotBlank
public class ReqScheduleDto {
    //### 조건
    //
    //1. `할일 제목`, `할일 내용`, `담당자`, `비밀번호`, `작성일`을 저장할 수 있습니다.
    //    1. 저장된 일정 정보를 반환 받아 확인할 수 있습니다.
    private String title;
    private String content;
    private String manager;
    private Integer password;
}
