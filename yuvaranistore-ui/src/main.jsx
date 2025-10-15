import { Profiler, StrictMode } from "react";
import { createRoot } from "react-dom/client";
import {
  createBrowserRouter,
  createRoutesFromElements,
  Route,
  RouterProvider,
} from "react-router-dom";

import { ToastContainer, Bounce } from "react-toastify";

import "./index.css";
import App from "./App.jsx";
import About from "./components/About.jsx";
import Login, { loginAction } from "./components/Login.jsx";
import Cart from "./components/Cart.jsx";
import Home, { productsLoader } from "./components/Home.jsx";
import Contact, { contactAction } from "./components/Contact.jsx";
import Errorpage from "./components/Errorpage.jsx";
import ProductDetail from "./components/ProductDetail.jsx";
import { CartProvider } from "./store/cart-context.jsx";
import Register, { registerAction } from "./components/Register.jsx";
import { AuthProvider } from "./store/auth-context.jsx";
import ProtectedRoute from "./components/ProtectedRoute.jsx";
import CheckoutForm from "./components/CheckoutForm.jsx";
import Profile, {
  profileAction,
  profileLoader,
} from "./components/Profile.jsx";
import Orders from "./components/Orders.jsx";
import AdminOrders from "./components/Admin/AdminOrders.jsx";
import Messages from "./components/Admin/Messages.jsx";
import { loadStripe } from "@stripe/stripe-js";
import { Elements } from "@stripe/react-stripe-js";
import OrderSuccess from "./components/OrderSuccess.jsx";
const stripePromise = loadStripe(
  "pk_test_51SBF7ZAQ0QW4fo1T01vWiBxaAkPCWq4ZyiZi6MZuvBF3wNaIktabwuVGvuoqiNGKoghbWD6SpwhG7XhFe54l42W700SXsMIMqg"
);

const routeDefinitions = createRoutesFromElements(
  <Route path="/" element={<App />} errorElement={<Errorpage />}>
    <Route index element={<Home />} loader={productsLoader} />
    <Route path="/home" element={<Home />} loader={productsLoader} />
    <Route path="/about" element={<About />} />
    <Route path="/contact" element={<Contact />} action={contactAction} />
    <Route path="/login" element={<Login />} action={loginAction} />
    <Route path="/cart" element={<Cart />} />
    <Route path="/register" element={<Register />} action={registerAction} />
    <Route path="/products/:productId" element={<ProductDetail />} />
    <Route path="/orders" element={<Orders />} />
    <Route path="/admin/orders" element={<AdminOrders />} />
    <Route path="/admin/messages" element={<Messages />} />
    <Route element={<ProtectedRoute />}>
      <Route path="/checkout" element={<CheckoutForm />} />
      <Route path="/order-success" element={<OrderSuccess />} />
      <Route
        path="/profile"
        element={<Profile />}
        loader={profileLoader}
        action={profileAction}
        shouldRevalidate={({ actionResult }) => {
          return !actionResult?.success;
        }}
      />
      <Route path="/orders" element={<Orders />} />
      <Route path="/admin/orders" element={<AdminOrders />} />
      <Route path="/admin/messages" element={<Messages />} />
    </Route>
  </Route>
);

const appRouter = createBrowserRouter(routeDefinitions);

createRoot(document.getElementById("root")).render(
  <StrictMode>
    <Elements stripe={stripePromise}>
      <AuthProvider>
        <CartProvider>
          <RouterProvider router={appRouter} />
        </CartProvider>
      </AuthProvider>

      <ToastContainer
        position="top-center"
        autoClose={3000}
        hideProgressBar={false}
        newestOnTop={false}
        draggable
        pauseOnHover
        theme={localStorage.getItem("theme") === "dark" ? "dark" : "light"}
        transition={Bounce}
      />
    </Elements>
  </StrictMode>
);
