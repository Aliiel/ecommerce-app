import axiosInstance from "./axiosApp";

export const registration = async (values) => {
    try {
        const response = await axiosInstance.post(`/account/registration`, values);
        return response;
    } catch (error) {
        console.log(error);
        const errorMessage = error.response?.data?.password 
        || error.response?.data
        || "Une erreur est survenue lors de l'inscription.";

        throw errorMessage;
    } 
}


export const authentication = async (values) => {
    try {
        const response = await axiosInstance.post(`/account/authentication`, values);
        return response;
    } catch (error) {
        console.log(error);
        const errorMessage = error.response?.data 
        || error.response?.data
        || "Une erreur est survenue lors de la connexion.";

        throw errorMessage;
    } 
}
