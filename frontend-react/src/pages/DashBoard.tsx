import React, { useState } from "react";
import { useAuth } from "../context/AuthContext";

export const DashBoard : React.FC = () =>{
    
    const [successMessage,setSuccessMessage] = useState<string | null>(null);
    const [errorMessage,setErrorMessage] = useState<string | null>(null);

    const {user,logout} = useAuth();
    //console.log(JSON.stringify(user));
    // logout();
    return(
        <>
            <h1>{user!=null ? `hi data is here` :  `nothing is here` }</h1>
            <h1>{user?.userId}</h1>
        </>
    );
}