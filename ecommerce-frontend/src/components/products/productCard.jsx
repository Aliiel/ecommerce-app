import Button from '../Button';
import PropTypes from 'prop-types';

const ProductCard = ({ product, onClick }) => {
    return (
      <div className="max-w-sm rounded overflow-hidden shadow-lg">
        <img
          className="w-full h-48 object-cover"
          src={product.pictureUrl}
          alt={product.name}
        />
        <div className="py-3 text-center">
          <div className="font-bold text-xl">{product.name}</div>
          <div className="mt-2">
            <p className="text-lg">{product.price} €</p>
          </div>
        </div>
        <div className="py-2 text-center">
          <Button onClick={onClick}>Voir le produit</Button>
        </div>
      </div>
    );
  };

  ProductCard.propTypes = {
    product: PropTypes.shape({
      id: PropTypes.number.isRequired,
      name: PropTypes.string.isRequired,
      price: PropTypes.number.isRequired,
      pictureUrl: PropTypes.string.isRequired
    }).isRequired,
    onClick: PropTypes.func.isRequired
  };
  
  export default ProductCard;