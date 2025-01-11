import React from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import { AuthProvider } from "./context/AuthProvider";
import './index.css'
import { Register } from "./pages/Register";
import Login from "./pages/Login";
import {DashBoard} from './pages/DashBoard'


const App : React.FC = () => {
  return(
    <AuthProvider>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Login/>}/>
          <Route path="/register" element={<Register/>}/>
          <Route path="/dashboard" element={<DashBoard/>}/>
          {/* <Route path="/dashboard" element={<ProtectedRoute><Dashboard/></ProtectedRoute>}/> */}
        </Routes>
      </BrowserRouter>
    </AuthProvider>
  );
};

export default App;