import { useEffect, useState } from "react";
import { useParams } from "react-router";
import { getProductById } from "../../services/productService";


const ProductDetails = () => {
    const { id } = useParams();
    const [product, setProduct] = useState(null);
  
    useEffect(() => {
      const fetchProduct = async () => {
        try {
          const data = await getProductById(id);
          console.log("id :" + id);
          setProduct(data);
          console.log("produit recup : ", data)
        } catch (error) {
            console.log(error);
          console.error("Erreur lors du chargement du produit.");
        }
      };
      fetchProduct();
    }, [id]);
  
    if (!product) {
      return <div>Chargement...</div>;
    }
    
    return (
      <div className="max-w-2xl mx-auto p-6">
        <img 
        className="w-full h-64 object-cover" 
        src={`/${product.pictureUrl}`}
        alt={product.name} 
        />
        <h1 className="text-2xl font-bold text-center mt-4">{product.name}</h1>
        <p className="text-lg text-gray-700 mt-2">{product.price} €</p>
      </div>
    );
  };
  
  export default ProductDetails;