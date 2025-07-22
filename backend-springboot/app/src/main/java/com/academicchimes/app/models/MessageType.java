package com.academicchimes.app.models;

public enum MessageType {

    TEXT("text"),
    URL("url"),
    PDF("pdf"),
    AUDIO("audio"),
    VIDEO("video");

    private final String messageTypeName;

    MessageType(String messageTypeName){
        this.messageTypeName=messageTypeName;
    }

    public String getMessageType(){
        return messageTypeName;
    }

    public static MessageType fromString(String MessageTypeName){
        for(MessageType m : MessageType.values()){
            if(m.messageTypeName.equalsIgnoreCase(MessageTypeName)){
                return m;
            }
        }
        throw new IllegalArgumentException("Unexpected Type : " + MessageTypeName);
    }

}
