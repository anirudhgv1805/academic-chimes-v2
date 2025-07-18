import { createContext, useContext } from "react";
import { User } from "../types/User";

export interface AuthContextType{
    isAuthenticated:boolean;
    jwtToken: string | null;
    user : User | null;
    login : (arg0:string)=>void;
    logout : () =>void;
    loading : boolean;
    setLoading : (value: boolean | ((prevState: boolean) => boolean)) => void
}

export const AuthContext = createContext<AuthContextType | undefined>(undefined);

export const useAuth = () : AuthContextType => {
    const context = useContext(AuthContext);
    if(!context) throw new Error('useAuth must be used within the AuthProvider');
    return context;
};