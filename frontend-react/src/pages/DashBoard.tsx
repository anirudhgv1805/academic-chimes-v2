import React, { useState } from "react";
import { useAuth } from "../context/AuthContext";

export const DashBoard : React.FC = () =>{
    
    const [successMessage,setSuccessMessage] = useState<string | null>(null);
    const [errorMessage,setErrorMessage] = useState<string | null>(null);

    const {user} = useAuth();
    console.log(JSON.stringify(user));
    return(
        <>
            <h1>
                {user?.batch}
            </h1>
            <h1>Welcome {user?.username} dashboard</h1>
        </>
    );
}