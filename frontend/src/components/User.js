import React from "react";
import {Route, Routes } from 'react-router-dom';
import UserHome from './user/UserHome';
import MakeAppointment from './user/UserMakeAppointment';

function User() {
    return (
        <Routes>
            <Route path="/" element={<UserHome/>}>
                {/*<Route path="software-department" element={<UserSoftwareDepartment/>}/>*/}
            </Route>
            <Route path="make-appointment" element={<MakeAppointment/>}/>
        </Routes>
    );
}

export default User;