import React from "react";
import PageTitle from "./PageTitle";

function About() {
  const h3Style = "text-lg font-semibold text-primary dark:text-light mb-2";
  const pStyle = "text-gray-600 dark:text-lighter";

  return (
    <div className="max-w-[1152px] min-h-[852px] mx-auto px-6 py-8 font-primary">
      <PageTitle title="About Us" />
      {/* About Us Content */}
      <p className="leading-6 mb-8 text-gray-600 dark:text-lighter">
        <span className="text-lg font-semibold text-primary dark:text-light">
          YuvaRani Store
        </span>{" "}
        is your go-to destination for everyday essentials at unbeatable prices.
        Founded by{" "}
        <span className="text-lg font-semibold text-primary dark:text-light">
          Yuvarani Anbu
        </span>
        , we’re on a mission to make grocery shopping faster, smarter, and more
        affordable for everyone
      </p>

      <h2 className="text-2xl leading-[32px] font-bold text-primary dark:text-light mb-6">
        Why Shop at YR Store?
      </h2>

      <div className="space-y-8">
        <div>
          <h3 className={h3Style}>Fresh & Reliabley</h3>
          <p className={pStyle}>
            From pantry staples to daily produce, we stock quality groceries you
            can trust—sourced with care and delivered with speed.
          </p>
        </div>

        <div>
          <h3 className={h3Style}>Low Prices, Always</h3>
          <p className={pStyle}>
            Our vinyl stickers feature a premium matte or glossy finish
            lamination and are made with advanced adhesive technology. Designed
            to withstand all weather conditions and resist scratches, our
            stickers are gentle enough to preserve the surface of your beloved
            gadgets.
          </p>
        </div>

        <div>
          <h3 className={h3Style}>Fast & Easy Service</h3>

          <p className={pStyle}>
            Whether you’re shopping in-store or online, we make the experience
            seamless. Quick checkout, fast delivery, and friendly support are
            just the beginnin
          </p>
        </div>

        <div>
          <h3 className={h3Style}>Community First</h3>

          <p className={pStyle}>
            We’re more than just a store—we’re part of your neighborhood. YR
            Store is built to serve families, students, and busy professionals
            who want quality without the hassle.
          </p>
        </div>
      </div>
    </div>
  );
}

export default About;
