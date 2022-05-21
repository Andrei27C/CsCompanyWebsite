import React, {useEffect, useState} from "react";
import {Route, Routes } from 'react-router-dom';
import EmployeeHome from './employee/EmployeeHome';
import axios from "axios";



function Employee() {

    return (
        <Routes>
            <Route path="/" element={<EmployeeHome/>}>
                {/*<Route path="software-department" element={<UserSoftwareDepartment/>}/>*/}
            </Route>
        </Routes>
    );
}

export default Employee;