package com.academicchimes.app.models;

public enum RecipientType {
    INDIVIDUAL("individual"),
    GROUP("group");

    private final String recipientTypeName;

    RecipientType(String recipientTypeName){
        this.recipientTypeName=recipientTypeName;
    }

    public String getRecipientType(){
        return recipientTypeName;
    }

    public static RecipientType fromString(String recipientTypeName){
        for(RecipientType r : RecipientType.values()){
            if(r.recipientTypeName.equalsIgnoreCase(recipientTypeName)){
                return r;
            }
        }
        throw new IllegalArgumentException("Unexpected Role : " + recipientTypeName);
    }
    
}