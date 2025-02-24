import axiosInstance from "./axiosApp";

export const getAllProducts = async () => {
    try {
      const response = await axiosInstance.get('/products'); 
      return response.data; 
    } catch (error) {
      console.error("Erreur lors de la récupération des produits:", error);
      throw error;
    }
  };


  export const getProductById = async (id) => {
    try {
      const response = await axiosInstance.get(`/products/${id}`); 
      return response.data; 
    } catch (error) {
      console.error("Erreur lors de la récupération des produits:", error);
      throw error;
    }
  };