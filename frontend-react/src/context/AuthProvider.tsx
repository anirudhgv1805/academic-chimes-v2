import React, { ReactNode, useEffect, useState } from "react";
import { User } from "../types/User";
import { useAxiosInstance } from "../utils/axiosInstance";
import { AuthContext } from "./AuthContext";
``;

interface AuthProviderProps {
  children: ReactNode;
}

export const AuthProvider: React.FC<AuthProviderProps> = ({ children }) => {
  const [jwtToken, setJwtToken] = useState<string | null>(
    localStorage.getItem("jwtToken")
  );
  const [user, setUser] = useState<User | null>(null);
  const [loading, setLoading] = useState<boolean>(false);

  const axiosInstance = useAxiosInstance();

  useEffect(() => {
    if (jwtToken) {
      const getUserData = async () => {
        try {
          setLoading(() => true);
          const response = await axiosInstance.post("/me");
          localStorage.setItem("user", JSON.stringify(response.data));
          setUser(response.data);
        } catch (err: unknown) {
          console.log("cannot fetch the user" + err);
        } finally {
          setLoading(() => false);
        }
      };
      getUserData();
    }
  }, [jwtToken]);

  const login = async (jwtToken: string) => {
    localStorage.setItem("jwtToken", jwtToken);
    setJwtToken(jwtToken);
  };

  const logout = () => {
    localStorage.removeItem("jwtToken");
    localStorage.removeItem("user");
    setJwtToken(null);
    setUser(null);
  };

  return (
    <AuthContext.Provider
      value={{
        isAuthenticated: !!jwtToken,
        jwtToken,
        user,
        loading,
        login,
        logout,
        setLoading,
      }}
    >
      {children}
    </AuthContext.Provider>
  );
};
