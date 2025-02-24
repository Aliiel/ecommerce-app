import { Route, Routes } from "react-router";
import ProductList from "./components/productList";
import Header from "./components/header";
import Authentication from "./components/authentication";
import Registration from "./components/registration";
import Footer from "./components/footer";
import ProductDetails from "./components/productDetails";

function App() {
  return (
    <>
<div className="flex flex-col min-h-screen">
<Header/>
<main className="flex-grow">
<Routes>
      <Route path="/" element={<ProductList/>} />
      <Route path="/product/:id" element={<ProductDetails />} />
      <Route path="/authentication" element={<Authentication />}/>
      <Route path="/registration" element={<Registration />}/>
    </Routes>
</main>
    <Footer />
</div>
  
    </>
    
    
  )
}

export default App;