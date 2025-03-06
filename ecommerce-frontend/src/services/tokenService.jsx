import { jwtDecode } from "jwt-decode";
import { toastError } from "../components/toastMessages";

const TokenService = {
    getToken: () => localStorage.getItem("access-token"),
  
    setToken: (token) => localStorage.setItem("access-token", token),
  
    removeToken: () => localStorage.removeItem("access-token"),
  
    decodeToken: () => {
      const token = TokenService.getToken();
      if (!token) return null;
      
      try {
        return jwtDecode(token);
      } catch (error) {
        console.error("Erreur lors du décodage du token", error);
        toastError(error);
        TokenService.removeToken();
        return null;
      }
    },
  
    isTokenValid: () => {
      const decodedToken = TokenService.decodeToken();
      if (!decodedToken) return false;
  
      return decodedToken.exp * 1000 > Date.now();
    },
  
    getAuthHeaders: () => {
      const token = TokenService.getToken();
      return token ? { Authorization: `Bearer ${token}` } : {};
    }
  };
  
export default TokenService;