import React from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import { AuthProvider } from "./context/AuthProvider";
import { Register } from "./pages/Register";
import './index.css';
import Login from "./pages/Login";


const App : React.FC = () => {
  return(
    <AuthProvider>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Login/>}/>
          <Route path="/register" element={<Register/>}/>
          {/* <Route path="/dashboard" element={<ProtectedRoute><Dashboard/></ProtectedRoute>}/> */}
        </Routes>
      </BrowserRouter>
    </AuthProvider>
  );
};

export default App;