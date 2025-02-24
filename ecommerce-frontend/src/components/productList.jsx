import { useState, useEffect } from "react";
import { useNavigate } from "react-router";
import { getAllProducts } from "./productService";
import ProductCard from "./productCard";

const ProductList = () => {
    const [products, setProducts] = useState([]);
    const [error, setError] = useState(null);
    const navigate = useNavigate();
  
    useEffect(() => {
      const fetchProducts = async () => {
        try {
          const productsData = await getAllProducts();
          setProducts(productsData); 
          console.log(productsData);
        } catch (error) {
          setError("Erreur de chargement des produits");
        } 
      };
  
      fetchProducts();
    }, []); 
  
    if (error) {
      return <div>{error}</div>;
    }
  
    return (
      <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-6 p-6">
      {products.map((product) => (
        <ProductCard
          key={product.id}
          product={product}
          onClick={() => navigate(`/product/${product.id}`)}
        />
      ))}
    </div>
    );
  };
  
  export default ProductList;