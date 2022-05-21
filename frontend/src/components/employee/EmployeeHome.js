import React, {useState, useEffect} from 'react';
import {Table, Container, Nav, Navbar} from 'react-bootstrap';
import axios from "axios";

export default function EmployeeHome(props) {

    const [appointments, setAppointments] = useState([]);
    const [user, setUser] = useState(JSON.parse(localStorage.getItem("user")));

    useEffect(()=>{
        axios
            .post('http://localhost:8080/employee/getAppointmentsByEmployee',user)
            .then(response => {
                console.log("userr:" + user.name);
                localStorage.setItem('appointments', JSON.stringify(response.data));
                setAppointments(response.data);
                console.log(response.data);
            });
        },
        []
    );

    return (
        <div>
            <Navbar bg="dark" variant="dark">
                <Container>
                    <Navbar.Brand href="/employee/">Employee</Navbar.Brand>
                    <Navbar.Text> {user.name}</Navbar.Text>
                    <Nav className="me-auto">
                        <Nav.Link href="/home/login">Go Back</Nav.Link>
                    </Nav>
                    <Nav className="me-auto">
                    </Nav>
                </Container>
            </Navbar>
            <div className="TableStyle">

                <br/>
                <br/>

                <Table striped bordered hover>
                    <thead>
                    <tr>
                        <th>User Name</th>
                        <th>Date</th>
                    </tr>
                    </thead>
                    <tbody>
                    {appointments.map(appointment => {
                        return (
                            <tr key={appointment.userDTO.name}>
                                <td key={appointment.userDTO.name}>{appointment.userDTO.name}</td>
                                <td key={appointment.startDate}>{appointment.startDate}</td>
                            </tr>
                        );
                    })}
                    </tbody>
                </Table>
            </div>
        </div>
    );
}
