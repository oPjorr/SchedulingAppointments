import { createBrowserRouter } from "react-router-dom";
import Home from "../features/Home"
import Login from "../features/Login"
import Register from "../features/Register"
import NotFound from "../features/NotFound";
import ProtectedRoute from "./ProtectedRoute";

const router = createBrowserRouter([
  {
    path: "/",
    element: <Home />,
    index: true,
  },
  {
    path: "/login",
    element: <Login />,
    index: true,
  },
  {
    path: "/register",
    element: <Register />,
    index: true,
  },
  {
    path: "*",
    element: <NotFound />,
    index: true,
  },
]);

export default router;
