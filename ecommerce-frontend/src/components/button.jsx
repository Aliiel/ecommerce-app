const Button = ({ children, onClick, className = "" }) => {
    return (
      <button 
        onClick={onClick} 
        className={`bg-purple-200 text-black p-2 rounded-md transition-transform duration-300 hover:scale-110 ${className}`}
      >
        {children}
      </button>
    );
  };
  
  export default Button;