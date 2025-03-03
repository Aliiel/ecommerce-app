import { createContext, useState, useEffect, useContext } from "react";
import { useNavigate } from "react-router";
import { toastError, toastInfo, toastSuccess } from "../toastMessages";
import { jwtDecode } from "jwt-decode";

const AuthContext = createContext();

export const AuthProvider = ({ children }) => {
  const [user, setUser] = useState(null);
  const navigate = useNavigate();
  

  useEffect(() => {
    const token = localStorage.getItem("access_token");

    if (token) {

        try {
          const decodedToken = jwtDecode(token);
          setUser({
            id: decodedToken.id,
            email: decodedToken.email,
            roles: decodedToken.roles,
          });
          console.log("user : ", user)

        } catch (error) {
          toastError(error);
          console.error("Token invalide ou expiré");
          localStorage.removeItem("access_token"); 
        }
      }
    }, []);

  const login = (token) => {
    
    const decodedToken = jwtDecode(token);

    setUser({
        id:decodedToken.id,
        email: decodedToken.email
    });

    localStorage.setItem("access_token", token);
    toastSuccess("Vous êtes bien connecté");
    navigate('/');
  };



  const logout = () => {
    setUser(null);
    localStorage.removeItem("access_token");
    toastInfo("Vous êtes déconnecté");
    navigate("/");
  };


  return (
    <AuthContext.Provider value={{ user, login, logout }}>
      {children}
    </AuthContext.Provider>
  );
};

// Hook pour utiliser l'authentification
export const useAuth = () => useContext(AuthContext);