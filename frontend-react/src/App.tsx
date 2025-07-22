import React from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import { DashBoard } from "./pages/DashBoard";
import Login from "./pages/Login";
import { Register } from "./pages/Register";
import ProtectedRoute from "./components/ProtectedRoute";
import { Logout } from "./components/Logout";
import PrivateRoute from "./components/PrivateRoute";
import { ChatWindow } from "./pages/ChatWindow";

const App: React.FC = () => {
  return (
    <div className="flex-grow flex flex-col items-center justify-center min-h-screen">
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Login />} />
          <Route path="/register" element={<Register />} />

          <Route path="/dashboard" element={<ProtectedRoute redirect="/" />}>
            <Route path="/dashboard" element={<DashBoard />} />
          </Route>
          <Route
            path="/chat"
            element={
              <PrivateRoute>
                <ChatWindow />
              </PrivateRoute>
            }
          />
          <Route path="/logout" element={<Logout />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
};

export default App;
