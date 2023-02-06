import { createBrowserRouter, RouterProvider } from "react-router-dom";
import "./App.css";
import AddNewOfficeBearer, { addOfficeBearerAction } from "./pages/Admin Pages/AddNewOfficeBearer";
import AddNewProducts, { addNewProductsAction } from "./pages/Admin Pages/AddNewProducts";
import AdminHome from "./pages/Admin Pages/AdminHome";
import AllUsers, { usersLoader } from "./pages/Admin Pages/AllUsers";
import NewRequests, { requestsAction, requestsLoader } from "./pages/Admin Pages/NewRequests";
import RequestApproved, { requestApprovedLoader } from "./pages/Admin Pages/RequestApproved";
import RequestDeclined, { requestDeclinedLoader } from "./pages/Admin Pages/RequestDeclined";
import RegistrationPage, {
  action as registrationAction,
} from "./pages/RegistrationPage";
import Success from "./pages/Success";
import EditProfile, { editProfileAction } from "./pages/User Pages/EditProfile";
import OfficeBearers, { officeBearersLoader } from "./pages/User Pages/OfficeBearers";
import Products, { productsLoader } from "./pages/User Pages/Products";
import Profile, { profileLoader } from "./pages/User Pages/Profile";
import UserHome from "./pages/User Pages/UserHome";
import Welcome from "./pages/Welcome";

const router = createBrowserRouter([
  { path: "/", element: <Welcome /> },
  {
    path: "/register",
    element: <RegistrationPage />,
    action: registrationAction,
  },
  { path: "/registration_success", element: <Success /> },
  {
    path: "/admin",
    element: <AdminHome />,
    children: [
      { path: "users",element:<AllUsers/>,loader: usersLoader},
      { path: "new_requests",element:<NewRequests/>,loader:requestsLoader,action:requestsAction },
      {path:"new_requests/:requestId/accept",element:<RequestApproved/>,loader:requestApprovedLoader},
      {path:"new_requests/:requestId/decline",element:<RequestDeclined/>,loader:requestDeclinedLoader},
      { path: "add_new_products",element:<AddNewProducts/>,action:addNewProductsAction},
      { path: "add_new_office_bearer",element:<AddNewOfficeBearer/>,action:addOfficeBearerAction },
    ],
  },
  {path:"/user",element:<UserHome/>,children:[
    {path:"officeBearers",element:<OfficeBearers/>,loader:officeBearersLoader},
    {path:"products",element:<Products/>,loader:productsLoader},
    {path:":userId/profile",loader:profileLoader,id:"profile",children:[
      {index:true,element:<Profile/>},
      {path:"edit",element:<EditProfile/>,action:editProfileAction}
    ]}
  ]}
]);
function App() {
  return (
    <>
      <RouterProvider router={router} />
    </>
  );
}

export default App;
