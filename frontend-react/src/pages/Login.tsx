import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { useAuth } from "../context/useAuth";
import { LoginDTO } from "../types/LoginDTO";
import { useAxiosInstance } from "../utils/axiosInstance";
// import {AuthProvider} from "../context/AuthProvider"
// import {AuthContext} from "../context/AuthContext"

const Login: React.FC = () => {
  const navigate = useNavigate();

  const { login } = useAuth();

  const axiosInstance = useAxiosInstance();

  const [loginData, setLoginData] = useState<LoginDTO>({
    userId: "",
    password: "",
  });

  const [loading, setLoading] = useState<boolean>(false);
  const [errorMessage, setErrorMessage] = useState<string | null>("");
  const [successMessage, setSuccessMessage] = useState<string | null>("");

  const handleChange = (
    e: React.ChangeEvent<HTMLInputElement | HTMLSelectElement>
  ) => {
    const { name, value } = e.target;
    setLoginData((prevLoginData) => ({
      ...prevLoginData,
      [name]: value,
    }));
  };

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    setLoading(true);
    setErrorMessage(null);
    setSuccessMessage(null);

    try {
      const response = await axiosInstance.post("/auth/login", loginData);
      const data = response.data;
      if (data.statusCodeValue === 200) {
        const token = response.data.body;
        login(token);
        setSuccessMessage("Login is successfull");
        navigate("/dashboard");
      } else if (data.statusCodeValue === 401) {
        setErrorMessage(data.body);
      }
    } catch (err: unknown) {
      setErrorMessage("An error occurred: " + err);
    } finally {
      setLoading(false);
    }
  };

  return (
    <>
      <div className="flex justify-center items-centeral
       bg-gray-100">
        <div className="bg-white p-8 rounded-lg shadow-lg w-full max-w-md">
          <h2 className="text-2xl font-bold text-center text-gray-800 mb-6">
            Login In
          </h2>
          <form onSubmit={handleSubmit} className="space-y-6">
            <div>
              <label
                htmlFor="userId"
                className="block text-sm font-medium text-gray-700"
              >
                User ID
              </label>
              <input
                type="text"
                name="userId"
                value={loginData.userId}
                onChange={handleChange}
                required
                placeholder="Enter UserID"
                className="mt-1 w-full px-4 py-2 border-gray-400 rounded-md shadow-sm focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-transparent"
              />
            </div>
            <div>
              <label
                htmlFor="Password"
                className="block text-sm font-medium text-gray-700"
              >
                Password
              </label>
              <input
                type="password"
                name="password"
                value={loginData.password}
                onChange={handleChange}
                required
                placeholder="Enter Your Password"
                className="mt-1 w-full px-4 py-2 border-gray-400 rounded-md shadow-sm focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-transparent"
              />
            </div>
            {errorMessage && (
              <div className="text-red-500 text-sm mt-2">{errorMessage}</div>
            )}
            {successMessage && (
              <div className="text-green-500 text-sm mt-2">
                {successMessage}
              </div>
            )}

            <div>
              <button
                type="submit"
                disabled={loading}
                className={`w-full bg-blue-600 text-white py-2 px-4 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500 disabled:bg-blue-400`}
              >
                {loading ? "Logging In..." : "Login"}
              </button>
            </div>

            <div className="text-center text-sm text-gray-500">
              Don't have an account?{" "}
              <a href="/register" className="text-blue-500 hover:underline">
                Register here
              </a>
            </div>
          </form>
        </div>
      </div>
    </>
  );
};

export default Login;
