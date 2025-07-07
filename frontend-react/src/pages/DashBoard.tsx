import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { useAuth } from "../context/AuthContext";
import { useAxiosInstance } from "../utils/axiosInstance";

export const DashBoard: React.FC = () => {
  const navigate = useNavigate();

  const [successMessage, setSuccessMessage] = useState<string | null>(null);
  const [errorMessage, setErrorMessage] = useState<string | null>(null);

  const { user, jwtToken, logout, loading, setLoading } = useAuth();
  const axiosInstance = useAxiosInstance();

  return (
    <div className="flex items-center flex-col h-screen justify-center next">
      <button className="bg-red-500 p-4" onClick={() => navigate("/logout")}>
        Logout
      </button>

      <h1>Hello user, This is the dashboard</h1>
      <h1>{user?.userId}</h1>
    </div>
  );
};
