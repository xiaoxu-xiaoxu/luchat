package com.xiaoxu.bean;

import com.xiaoxu.base.BaseEntity;
import lombok.Data;


@Data
public class TalkOver extends BaseEntity{
    private Integer id;

    private String talkTopic;

    private Integer talkCount;

}