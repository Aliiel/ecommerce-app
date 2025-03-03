import { Route, Routes } from "react-router";
import Header from "./components/header";
import Footer from "./components/footer";
import ProductList from "./components/products/productList";
import ProductDetails from "./components/products/productDetails";
import Login from "./components/account/login";
import Signup from "./components/account/signup";
import { ToastContainer } from "react-toastify";
import { AuthProvider } from "./components/account/authContext";

function App() {
  return (
    <AuthProvider>
    <div className="flex flex-col min-h-screen">
      <Header />
      <ToastContainer/>
      <main className="flex-grow">
        <Routes>
          <Route path="/" element={<ProductList />} />
          <Route path="/product/:id" element={<ProductDetails />} />
          <Route path="/login" element={<Login />} />
          <Route path="/signup" element={<Signup />} />
        </Routes>
      </main>
      <Footer />
    </div>
    </AuthProvider>
  );
}

export default App;