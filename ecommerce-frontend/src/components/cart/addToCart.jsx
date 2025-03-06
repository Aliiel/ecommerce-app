import { useDispatch } from "react-redux";
import Button from '../Button';

// eslint-disable-next-line react/prop-types
const AddToCart = ({ product }) => {
    const dispatch = useDispatch();

    const handleAddToCart = () => {
        dispatch(addToCart(product));
    };

    return (
        <Button onClick={handleAddToCart}>Ajouter au panier</Button>
    );
};

export default AddToCart;