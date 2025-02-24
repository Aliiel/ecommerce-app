import { Link } from "react-router";

function Footer() {
    return (
      <footer className="bg-purple-200 p-4 flex justify-center items-center shadow-md mt-8 fixed-bottom">
        <p className="text-sm text-black-700">
          &copy;LM. <Link to="/" className="text-purple-600 hover:text-purple-800">Cire & Sérénité.</Link> Tous droits réservés.
        </p>
      </footer>
    );
  }
  
  export default Footer;