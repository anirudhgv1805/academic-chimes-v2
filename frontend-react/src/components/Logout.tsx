import { useEffect } from "react";
import { useAuth } from "../context/AuthContext";
import { useNavigate } from "react-router-dom";

export const Logout: React.FC = () => {
  const navigate = useNavigate();
  const { logout } = useAuth();

  useEffect(() => {
    logout();
  });

  return (
    <div className="flex flex-col items-center justify-center h-screen">
      {/* wanted routing to dashboard to conform that there is no jwt present */}
      <button
        onClick={() => navigate("/dashboard")}
        className="bg-green-400 p-4 "
      >
        Login
      </button>

      <h1>Logout done</h1>
    </div>
  );
};
