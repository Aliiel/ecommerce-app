import TokenService from "./tokenService.jsx";
import axiosInstance from "./axiosApp";

const CartService = {
    getCart: async () => {
        try {
            const headers = TokenService.getAuthHeaders();
            const response = await axiosInstance.get("/cart", { headers });
            console.log(response);
            return response.data.itemsDTO;
        } catch (error) {
            console.error("Erreur lors de la récupération du panier", error);
            throw error;
        }
    },
};

export default CartService;