import logo from './logo.svg';
import './App.css';
import React, { Component }  from 'react';
import { BrowserRouter as Router, HashRouter, Route, Routes } from 'react-router-dom';
import Register from "./components/Register";
import Login from "./components/Login";
import Home from "./components/Home";
import User from "./components/User";
import {Navigate} from "react-router";
import Employee from "./components/Employee";


function App() {
  return (
    // <div className="App">
    //   <header className="App-header">
    //     <img src={logo} className="App-logo" alt="logo" />
    //     <p>
    //       Edit <code>src/App.js</code> and save to reload.
    //     </p>
    //     <a
    //       className="App-link"
    //       href="https://reactjs.org"
    //       target="_blank"
    //       rel="noopener noreferrer"
    //     >
    //       Learn React
    //     </a>
    //   </header>
    // </div>
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
