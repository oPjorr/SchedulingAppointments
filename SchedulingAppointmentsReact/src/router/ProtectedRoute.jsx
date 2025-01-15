import { Navigate, Outlet } from "react-router-dom";
import checkToken from "../service/auth/checkToken";

const ProtectedRoute = () => {
  return checkToken() ? <Outlet/> : <Navigate to="/" replace />;
}

export default ProtectedRoute;
