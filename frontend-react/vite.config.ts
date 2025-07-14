import { defineConfig } from "vite";
import react from "@vitejs/plugin-react";

const backendTarget = "https://fxv5h1rj-8080.inc1.devtunnels.ms:8080/api/";
// https://vite.dev/config/
export default defineConfig({
  plugins: [react()],
  server: {
    proxy: {
      "/api": {
        target: backendTarget,
        changeOrigin: true,
        secure: false,
      },
    },
  },
});
