const Header: React.FC = () => {
  return (
    <header className="bg-slate-700 text-white w-full sticky top-0 z-50">
      <div className="mx-auto flex flex-grow items-center px-4 py-3 justify-center">
        <nav className="flex space-x-40 justify-center">
          <div className="hover:cursor-wait">Home</div>
          <div>Time Table</div>
          <div>Chats</div>
          <div>Notifications</div>
        </nav>
      </div>
    </header>
  );
};

export default Header;
