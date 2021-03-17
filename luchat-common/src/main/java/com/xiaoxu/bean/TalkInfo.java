package com.xiaoxu.bean;

import com.xiaoxu.base.BaseEntity;
import lombok.Data;


@Data
public class TalkInfo extends BaseEntity{
    private Integer id;

    private Integer talkId;

    private Integer userId;

    private String talkMessage;


}