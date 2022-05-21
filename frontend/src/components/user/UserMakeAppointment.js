import React, {useState, useEffect} from 'react';
import {Card, Col, Row, Button, Container, Nav, Navbar} from 'react-bootstrap';
import {Navigate, Outlet, useLocation, useNavigate} from 'react-router-dom';
import axios from "axios";

export default function UserMakeAppointment()
{
    const [selectedEmployee, setSelectedEmployee] = useState(JSON.parse(localStorage.getItem("selectedEmployee")));
    const [currentUser, setCurrentUser] = useState(JSON.parse(localStorage.getItem("user")));
    let date = document.querySelector('input[type="date"]');
    const [appointment, setAppointment] = useState({
        startDate: "",
        employeeDTO: selectedEmployee,
        userDTO: currentUser
    })


    useEffect(() => {



    }, []);

    //todo add appointment, see if it's the correct format
    const addAppointment = async () => {
        await axios
            .post("http://localhost:8080/user/addAppointment", appointment);
    }

    function handleDateSubmit() {
        date = document.querySelector('input[type="date"]');
        setAppointment(prevState => {
            return{
                startDate: date.value,
                employeeDTO: selectedEmployee,
                userDTO: currentUser
            };
        })
        console.log(date.value);
        console.log("employee:" + selectedEmployee.name);
        console.log("user:" + currentUser.name);
        console.log(appointment);
        addAppointment()
            .then(console.log("appointment added"));
    }

    function validateDate()
    {
        return !!date;
    }

    return(
        <div>
            <Navbar bg="dark" variant="dark">
                <Container>
                    <Navbar.Brand href="/user/">Customer</Navbar.Brand>
                    <Navbar.Text> {selectedEmployee.name}</Navbar.Text>
                    <Nav className="me-auto">
                        <Nav.Link href="/user">Go Back</Nav.Link>
                    </Nav>
                </Container>
            </Navbar>
            <Outlet />
            {
                <div className="container text-center">
                    <div className="row justify-content-center">
                        <div className="col-lg-3 col-sm-6">
                            <label htmlFor="startDate">Choose a date</label>
                            <input id="startDate" className="form-control" type="date"/>
                            <br/>
                            <Button type={"submit"} size={"lg"} onClick={handleDateSubmit}>
                                Submit
                            </Button>
                        </div>
                    </div>
                </div>
            }
        </div>
    );
}