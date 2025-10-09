import { jwtDecode } from "jwt-decode";

export const isTokenExpired = (token) => {
  try {
    const decoded = jwtDecode(token);
    const currentTime = Date.now() / 1000; // tiempo actual en segundos

    if (decoded.exp < currentTime) {
      console.warn("⚠️ Token expirado");
      return true;
    }
    return false; // token válido
  } catch (error) {
    console.error("Error en validar token:", error);
    return true;
  }
};
