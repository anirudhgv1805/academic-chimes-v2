import ChatList from "../components/ChatList";

const ChatWindow: React.FC = () => {
  return (
    <div className="flex h-screen w-screen ">
      <div className="w-96 bg-green-400 border-r overflow-y-auto text-white">
        <ChatList />
      </div>
      <div className="flex-1 bg-black text-white">
        <h1>This is the chat window</h1>
      </div>
    </div>
  );
};

export { ChatWindow };
