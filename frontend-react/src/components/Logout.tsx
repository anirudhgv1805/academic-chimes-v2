import { useEffect } from "react";
import { useAuth } from "../context/AuthContext";


export const Logout : React.FC = () => {
    const {logout} = useAuth();

    useEffect(() => {
        logout();
    });

    return(
        <>
        <h1>Logout done</h1>
        </>
    );
};