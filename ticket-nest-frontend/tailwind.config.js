/** @type {import('tailwindcss').Config} */
module.exports = {
    content: [
      "./src/**/*.{html,ts}"
    ],
    theme: {
      extend: {
        colors: {
          primary: "#e50914", // Netflix red, optional
          background: "#0f0f0f",
        },
      },
    },
    darkMode: 'class', // Optional: support for dark mode themes
    plugins: [],
  };
  