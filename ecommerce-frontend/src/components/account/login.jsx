import AuthForm from "./authForm";
import { toastError } from "../toastMessages";
import { authentication } from "../../services/accountService";
import { useAuth } from "./authContext";

const Login = () => {
    const { login } = useAuth();

    const handleLogin = async (values) => {
      try {
        const response = await authentication(values); 
        console.log(response);
        login(response.data.access_token);        
      } catch (error) {
        console.error("Erreur de connexion :", error);
        toastError(error);
      }
    };
  
    return <AuthForm title="Se connecter" onSubmit={handleLogin} />;
  };
  
  export default Login;