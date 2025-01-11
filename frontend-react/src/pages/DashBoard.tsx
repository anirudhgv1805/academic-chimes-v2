import { useState } from "react";


export const DashBoard : React.FC = () =>{
    
    const [successMessage,setSuccessMessage] = useState<string | null>(null);
    const [errorMessage,setErrorMessage] = useState<string | null>(null);
    
    return(
        <>
            <h1>This is the dashboard</h1>
        </>
    );
}