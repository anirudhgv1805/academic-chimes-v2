import React, { ReactNode, useEffect, useState} from "react";
import { User } from "../types/User";
import { AuthContext } from "./AuthContext";

interface AuthProviderProps{
    children:ReactNode;
}

export const AuthProvider : React.FC< AuthProviderProps > = ({ children }) => {
    const [jwtToken, setJwtToken] = useState<string | null>(localStorage.getItem('jwtToken'))
    const [user, setUser] = useState<User | null>(null);

    useEffect( () => {
        if(jwtToken){
            console.log("at auth provider" + jwtToken);
            const userDetails = JSON.parse(localStorage.getItem('user') || '{}')
            setUser(userDetails);
        }
    },[jwtToken]);

    const login = (jwtToken:string,userDetails:User) => {
        localStorage.setItem('jwtToken',jwtToken);
        localStorage.setItem('user',JSON.stringify(userDetails));
        setJwtToken(jwtToken);
        setUser(userDetails);
    };

    const logout = () =>{
        localStorage.removeItem('jwtToken');
        localStorage.removeItem('user');
        setJwtToken(null);
        setUser(null);
    };

    return(
        <AuthContext.Provider value={{isAuthenticated: !!jwtToken, jwtToken, user, login, logout}}>
            {children}
        </AuthContext.Provider>
    );
};