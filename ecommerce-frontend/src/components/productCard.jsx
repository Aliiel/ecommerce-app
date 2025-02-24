import Button from './Button';

const ProductCard = ({ product, onClick }) => {
    return (
      <div className="max-w-sm rounded overflow-hidden shadow-lg">
        <img
          className="w-full h-48 object-cover"
          src={product.pictureUrl}
          alt={product.name}
        />
        <div className="px-6 py-4">
          <div className="font-bold text-xl mb-2">{product.name}</div>
          <div className="mt-4">
            <span className="text-lg">{product.price} €</span>
          </div>
        </div>
        <div className="px-6 py-4 text-center">
          <Button onClick={onClick}>Voir le produit</Button>
        </div>
      </div>
    );
  };
  
  export default ProductCard;