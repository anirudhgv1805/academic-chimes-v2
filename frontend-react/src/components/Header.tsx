import { Link } from "react-router-dom";
import { useAuth } from "../context/useAuth";

const Header: React.FC = () => {
  const { logout } = useAuth();

  return (
    <header className="bg-slate-700 text-white w-full sticky top-0 z-50">
      <div className="flex">
        <nav className="w-[80%] flex justify-around p-5">
          <div>Home</div>
          <div>Time Table</div>
          <div><Link to="/chat">Chat</Link></div>
          <div>Notifications</div>
        </nav>
        <div className="w-[20%] flex justify-end items-center align-middle">
          <button
            className="bg-black text-white mr-5 p-2 rounded-lg"
            onClick={() => {
              logout();
            }}
          >
            Logout
          </button>
        </div>
      </div>
    </header>
  );
};

export default Header;
