import { BrowserRouter, Route, Routes } from "react-router-dom";
import { Suspense, useState, useEffect } from "react";
import Home from "./pages/Home";
import AboutUs from "./pages/AboutUs";
import NavBar from "./components/NavBar";
import Login from "./pages/Login";
import './App.css';
import Register from "./pages/Register";
import Dashboard from "./pages/Dashboard";
import YourProfile from "./pages/YourProfile";
import YourWishlist from "./pages/YourWishlist";
import AdminDashboard from "./pages/AdminDashboard";
import ContactUs from "./pages/ContactUs";
import BoatHouse from "./pages/BoatHouse";
import Statistics from "./pages/Statistics";
import AdminAllUsers from "./pages/AdminAllUsers";
import AdminAllBoats from "./pages/AdminAllBoats";
import AdminViewOfUser from "./pages/AdminViewOfUser";
import AdminViewOfBoatHouse from "./pages/AdminViewOfBoatHouse";
import { useUserContext } from "./pages/UserContext";
import YourBookings from "./pages/YourBooking";

function App() {
  const { isLoggedIn, adminOrUser } = useUserContext();
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const timeout = setTimeout(() => {
      setLoading(false);
    }, 2000); // 2 seconds delay
    return () => clearTimeout(timeout);
  }, []);

  return (
    <div className="entire">
      <Suspense fallback={<div>Loading...</div>}>
        <BrowserRouter>
          {loading ? (
            <div className="loading-spinner">
              <img src="https://upload.wikimedia.org/wikipedia/commons/b/b1/Loading_icon.gif" alt="Loading..." />
            </div>
          ) : (
            <>
              {adminOrUser !== "admin" && (
                <>
                  <NavBar />
                  <Routes>
                    <Route path="/" element={<Home />} />
                    <Route path="/aboutus" element={<AboutUs />} />
                    <Route path="/contact-us" element={<ContactUs />} />
                    <Route path="/signin" element={<Login />} />
                    <Route path="/signup" element={<Register />} />
                    <Route path="/boat-house" element={<BoatHouse />} />
                    {isLoggedIn && adminOrUser === "user" && (
                      <>
                        <Route
                          path="/dashboard/your-book"
                          element={<Dashboard rightContent={<YourBookings />} />}
                        />
                        <Route
                          path="/dashboard/your-profile"
                          element={<Dashboard rightContent={<YourProfile />} />}
                        />
                        <Route
                          path="/dashboard/your-stays"
                          element={<Dashboard rightContent={<YourWishlist />} />}
                        />
                        <Route
                          path="/dashboard/your-wishlist"
                          element={<Dashboard rightContent={<YourWishlist />} />}
                        />
                      </>
                    )}
                  </Routes>
                </>
              )}

              {isLoggedIn && adminOrUser === "admin" && (
                <Routes>
                  <Route
                    path="/admin-dashboard/statistics"
                    element={<AdminDashboard rightContent={<Statistics />} />}
                  />
                  <Route
                    path="/admin-dashboard/all-users"
                    element={<AdminDashboard rightContent={<AdminAllUsers />} />}
                  />
                  <Route
                    path="/admin-dashboard/all-users/user*"
                    element={<AdminDashboard rightContent={<AdminViewOfUser />} />}
                  />
                  <Route
                    path="/admin-dashboard/all-boats"
                    element={<AdminDashboard rightContent={<AdminAllBoats />} />}
                  />
                  <Route
                    path="/admin-dashboard/all-boats/boat*"
                    element={<AdminDashboard rightContent={<AdminViewOfBoatHouse />} />}
                  />
                </Routes>
              )}
            </>
          )}
        </BrowserRouter>
      </Suspense>
    </div>
  );
}

export default App;
