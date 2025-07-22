import { useAuth } from "../context/useAuth";

const ChatList: React.FC = () => {

  const {user} = useAuth();

  return (
    <div className="flex flex-col h-screen">
      <div className="border-b p-4 bg-green-800 text-lg font-semibold">
        Academic Chimes Welcome : {user?.userId.toUpperCase()}
      </div>
      <div className="flex-1 overflow-y-auto p-2 custom-scrollbar">
        <ul className="space-y-2">
          {Array.from({ length: 30 }).map((_, i) => (
            <li
              key={i}
              className="p-4 bg-white shadow rounded text-balance text-black"
            >
              Chat Conversation {i + 1}
            </li>
          ))}
        </ul>
      </div>
    </div>
  );
};

export default ChatList;
