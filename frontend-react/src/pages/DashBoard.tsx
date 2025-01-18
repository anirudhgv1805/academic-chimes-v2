import React, { useEffect, useState } from "react";
import { useAuth } from "../context/AuthContext";
import WebSocketService from "../services/WebSocketService";
import { useAxiosInstance } from "../utils/axiosInstance";

export const DashBoard : React.FC = () =>{
    
    const [successMessage,setSuccessMessage] = useState<string | null>(null);
    const [errorMessage,setErrorMessage] = useState<string | null>(null);

    const {user,jwtToken,logout} = useAuth();
    const axiosInstance = useAxiosInstance();
    const webSocketService = new WebSocketService(jwtToken);

    // logout();
    // useEffect(() => {
    //         FetchAllData();
    // });

    // const FetchAllData = async () => {
    //         const response = await axiosInstance.post('/chat/fetchAll');
    //         console.log(response.data);
    // };

        return(
            <>
                <h1>Hello user, This is the dashboard</h1>
                <h1>{user?.userId}</h1>
            </>
        );
}