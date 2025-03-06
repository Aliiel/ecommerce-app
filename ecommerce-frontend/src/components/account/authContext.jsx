import { createContext, useState, useEffect, useContext } from "react";
import { useNavigate } from "react-router";
import { toastError, toastInfo, toastSuccess } from "../toastMessages";
import TokenService from "../../services/tokenService";

const AuthContext = createContext();

// eslint-disable-next-line react/prop-types
export const AuthProvider = ({ children }) => {
  const [user, setUser] = useState(null);
  const navigate = useNavigate();


  const loadUser = () => {
    const token = TokenService.getToken();

    if (!token) return;

    if (!TokenService.isTokenValid()) {
      if (user) {
        toastInfo("Veuillez vous reconnecter");
      }
      setUser(null);
      TokenService.removeToken();
      return;
    }

    const decodedToken = TokenService.decodeToken();
    if (decodedToken) {
      setUser({
        id: decodedToken.id,
        email: decodedToken.email,
        roles: decodedToken.roles,
      });
    }
  };
  

  useEffect(() => {
    loadUser();
  }, []);

  const login = (token) => {
    TokenService.setToken(token);
    loadUser();
    toastSuccess("Vous êtes bien connecté");
    navigate("/");
  };



  const logout = () => {
    setUser(null);
    TokenService.removeToken();
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
// eslint-disable-next-line react-refresh/only-export-components
export const useAuth = () => useContext(AuthContext);