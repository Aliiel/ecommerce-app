import { registration } from "../../services/accountService";
import AuthForm from "./authForm";
import { toastError, toastSuccess } from "../toastMessages";

const Signup = () => {

  const handleSignup = async (values) => {
    try {
      const response = await registration(values); 
      toastSuccess(response);
      console.log("Connexion réussie :", response);
      
    } catch (error) {
      console.error("Erreur de connexion :", error);
      toastError(error);
    }
  };

  return <AuthForm title="S'inscrire" onSubmit={handleSignup} />;
}
  
export default Signup;