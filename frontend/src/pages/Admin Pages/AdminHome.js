import { Link, Outlet } from "react-router-dom";
import "./Admin CSS files/AdminHome.css";

function AdminHome() {
  return (
    <>
      <h2>Admin Page</h2>
      <div className="links">
        <Link to="users">All Users</Link>
        <Link to="new_requests">New Registration Requests</Link>
        <Link to="add_new_products">Add new products</Link>
        <Link to="add_new_office_bearer">Add new office bearer</Link>
      </div>
      <main>
        <Outlet />
      </main>
    </>
  );
}
export default AdminHome;
