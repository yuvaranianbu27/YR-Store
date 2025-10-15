import React from "react";
import Price from "./Price";
import { Link } from "react-router-dom";

function ProductCard({ product }) {
  return (
    <div className="w-72 rounded-md mx-auto border border-gray-300 shadow-md overflow-hidden flex flex-col bg-white hover:shadow-lg transition">
      <div className="relative w-full h-72 border-b border-gray-300">
        <Link 
        to={`/products/${product.productId}`} 
        state={{ product }}>
          <img
            src={product.imageUrl}
            alt={product.name}
            className="w-full h-full object-cover transition-transform duration-500 ease-in-out hover:scale-110"
          />
        </Link>
      </div>
      <div className="relative h-48 p-4 flex flex-col font-primary">
        <h2 className="text-xl font-semibold text-primary mb-2">
          {product.name}
        </h2>
        <p className="text-base text-gray-600 mb-4">{product.description}</p>
        <div className="flex items-center justify-between mt-auto">
          <div className="bg-lighter text-primary font-medium text-sm py-2 px-4 rounded-tl-md">
            <Price currency="$" price={product.price} />
          </div>
        </div>
      </div>
    </div>
  );
}

export default ProductCard;
