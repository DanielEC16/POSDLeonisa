import { useTitle } from "../../hooks/useTitle";
import "./Login.scss";

export const Login = () => {
  useTitle("Login");
  return (
    <>
      <div className="container-login">
        <div class="parent">
          <div class="img-container">Imagen</div>
          <div class="form-container">Form</div>
        </div>
      </div>
    </>
  );
};
