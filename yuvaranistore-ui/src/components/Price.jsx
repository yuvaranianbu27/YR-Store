import React from "react";

function Price({ currency, price }) {
  return (
    <>
      {currency}
      <span>{price}</span>
    </>
  );
}

export default Price;
