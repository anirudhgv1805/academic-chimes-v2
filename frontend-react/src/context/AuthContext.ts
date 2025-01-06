import { createContext, useContext } from "react";
import { User } from "../types/User";

export interface AuthContextType{
    isAuthenticated:boolean;
    jwtToken: string | null;
    user : User | null;
    login : (arg0:string,arg1:User)=>void;
    logout : () =>void;
}

export const AuthContext = createContext<AuthContextType | undefined>(undefined);

export const useAuth = () : AuthContextType => {
    const context = useContext(AuthContext);
    if(!context) throw new Error('useAuth must be used within the AuthProvider');
    return context;
};