package com.academicchimes.app.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Role {

    STUDENT("student"),
    ADMIN("administrator"),
    GUEST("guest"),
    HOD("hod"),
    ASSISTANTPROFESSOR("assisstantProfessor"),
    ASSOCIATEPROFESSOR("associateProfessor"),
    PROFESSOR("professor"),
    LABASST("labAsst"),
    CLUB("club");

    private final String roleName;
    
    Role(String roleName){
        this.roleName = roleName;
    }

    @JsonValue
    public String getRole(){
        return roleName;
    }
    
    @JsonCreator
    public static Role fromString(String role){
        for(Role r : Role.values()){
            if(r.roleName.equalsIgnoreCase(role)){
                return r;
            }
        }
        throw new IllegalArgumentException("Unexpected Role : " + role);
    }
}
