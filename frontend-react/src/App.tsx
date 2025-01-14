import React from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import './index.css';
import { DashBoard } from './pages/DashBoard';
import Login from "./pages/Login";
import { Register } from "./pages/Register";


const App : React.FC = () => {
  return(
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Login/>}/>
          <Route path="/register" element={<Register/>}/>
          <Route path="/dashboard" element={<DashBoard/>}/>
          {/* <Route path="/dashboard" element={<ProtectedRoute><Dashboard/></ProtectedRoute>}/> */}
        </Routes>
      </BrowserRouter>
  );
};

export default App;