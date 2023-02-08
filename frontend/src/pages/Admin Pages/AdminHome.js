import { Form, Link, Outlet } from "react-router-dom";
import "./Admin CSS files/AdminHome.css";

function AdminHome() {
  function logoutHandler(){
    window.confirm("Are you sure to logout?");
  }
  return (
    <>
      <div>
        <h2>Admin Page</h2>
        <Form action="/logout" method="post">
          <button onClick={logoutHandler}>Logout</button>
        </Form>
      </div>
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
