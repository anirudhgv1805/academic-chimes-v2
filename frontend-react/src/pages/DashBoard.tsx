import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { useAuth } from "../context/AuthContext";
import { useAxiosInstance } from "../utils/axiosInstance";
import Header from "../components/Header";

export const DashBoard: React.FC = () => {
  const navigate = useNavigate();

  const [successMessage, setSuccessMessage] = useState<string | null>(null);
  const [errorMessage, setErrorMessage] = useState<string | null>(null);

  const { user, jwtToken, logout, loading, setLoading } = useAuth();
  const axiosInstance = useAxiosInstance();

  return (
    <>
      <Header />
      <div className="flex-grow flex flex-col items-center justify-center">
        <h1>Hello user, This is the dashboard</h1>
        <h1>{user?.userId}</h1>
      </div>
    </>
  );
};
