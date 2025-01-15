import { createBrowserRouter } from "react-router-dom";
import Home from "../features/Home"
import Appointment from "../features/Appointment"
import LadingPage from "../features/LadingPage"
import Login from "../features/Login"
import Register from "../features/Register"
import NotFound from "../features/NotFound";
import ProtectedRoute from "./ProtectedRoute";

const router = createBrowserRouter([
  {
    path: "/",
    element: <LadingPage />,
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
    element: <ProtectedRoute/>,
    children: [
      {
        path: "/home",
        element: <Home />,
      },
      {
        path: "/appointment",
        element: <Appointment />,
      },
    ],
  },
  {
    path: "*",
    element: <NotFound />,
    index: true,
  },
]);

export default router;
