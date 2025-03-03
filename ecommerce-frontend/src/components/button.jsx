import PropTypes from "prop-types";

const Button = ({ children, onClick, className = "" }) => {

  
    return (
      <button 
      type="submit"
        onClick={onClick} 
        className={`bg-purple-200 text-black p-2 rounded-md transition-transform duration-300 hover:scale-110 ${className}`}
      >
        {children}
      </button>
    );
  };

  Button.propTypes = {
    children: PropTypes.node.isRequired,  
    onClick: PropTypes.func,  
    className: PropTypes.string  
  };
  
  export default Button;