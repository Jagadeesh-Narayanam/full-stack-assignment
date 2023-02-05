import { Link, Outlet, useParams } from "react-router-dom";

function UserHome() {
    const params = useParams();
    const userId = params.userId;
  return (
    <>
      <h1>User HomePage</h1>
      <div className="links">
      <Link to="officeBearers">Office Bearers</Link>
      <Link to="products">Products</Link>
      <Link to={`${userId}/profile`}>Profile</Link>
      <Link to={`${userId}/profile/edit`}>Edit your Profile</Link>
      </div>
      <Outlet/>
    </>
  );
}
export default UserHome;
