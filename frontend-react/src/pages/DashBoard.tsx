import React, { useState } from "react";
import { useAuth } from "../context/AuthContext";

export const DashBoard : React.FC = () =>{
    
    const [successMessage,setSuccessMessage] = useState<string | null>(null);
    const [errorMessage,setErrorMessage] = useState<string | null>(null);

    const {user,logout} = useAuth();
    console.log(JSON.stringify(user));
    return(
        <>
            <h1> hello
                {user?.userId}<br></br>
                {user?.username}<br></br>
                {user?.email}<br></br>
                {user?.dept}<br></br>
                {user?.role}<br></br>
                {user?.batch}<br></br>
            </h1>
        </>
    );
}