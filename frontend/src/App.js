import './App.css';
import React  from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Register from "./components/Register";
import Login from "./components/Login";
import Home from "./components/Home";
import User from "./components/User";
import {Navigate} from "react-router";
import Employee from "./components/Employee";


function App() {
  return (

      <Router>
          <Routes>
              <Route path="/" element={<Navigate replace to="/home" />} />
              {/*<Route path="/admin/*" element={<Admin/>}/>*/}
              <Route path="/user/*" element={<User/>}/>
              <Route path="/employee/*" element={<Employee/>}/>
              <Route path="/home/" element={<Home/>}>
                  <Route path="login" element={<Login/>}/>
                  <Route path="user/register" element={<Register/>}/>
              </Route>

          </Routes>
      </Router>
  );
}

export default App;
