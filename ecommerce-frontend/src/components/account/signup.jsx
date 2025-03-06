import { registration } from "../../services/accountService";
import AuthForm from "./authForm";
import { toastError, toastSuccess } from "../toastMessages";
import { useNavigate } from "react-router";
import { useAuth } from "./authContext";



const Signup = () => {

  const navigate = useNavigate();
  const { login } = useAuth();

  const handleSignup = async (values) => {
    try {
      const response = await registration(values); 
      toastSuccess("Votre compte a bien été créé. Bienvenue sur Cire & Sérénité !");
      console.log(response);
      login(response.data.access_token);
      navigate('/');
      
    } catch (error) {
      console.error("Erreur de connexion :", error);
      toastError(error);
    }
  };

  return <AuthForm title="S'inscrire" onSubmit={handleSignup} />;
}
  
export default Signup;