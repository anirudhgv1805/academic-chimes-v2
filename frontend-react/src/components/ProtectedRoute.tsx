import { Navigate, Outlet } from "react-router-dom";
import { useAuth } from "../context/useAuth";


interface ProtectedRouteRouteProps{
    redirect : string,
};


const ProtectedRoute : React.FC<ProtectedRouteRouteProps> = ({redirect = '/'}) =>{
    const {isAuthenticated} = useAuth();
    
    if(!isAuthenticated){
        return <Navigate to={redirect} replace/>
    }

    return <Outlet/>;

};

export default ProtectedRoute;