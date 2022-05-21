import React, {useState, useEffect} from 'react';
import {Card, Col, Row, Button, Container, Nav, Navbar} from 'react-bootstrap';
import {Navigate, Outlet, useNavigate, Link} from 'react-router-dom';
import axios from "axios";


function goToDepartment(employee) {
    console.log(employee);
    return (
        <Link
            to={{
                pathname: "/user/make-appointment",
                state: employee
            }}
        />
    )
}

export default function UserHome(props) {

    const [employees, setEmployees] = useState([]);
    const [departments, setDepartments] = useState([]);
    const navigate = useNavigate();
    let selectedEmployee = "";

    const toMakeAppointment=(employee)=>
    {
        selectedEmployee = JSON.stringify(employee);
        console.log(selectedEmployee + " --------" + employee.username);

        localStorage.setItem('selectedEmployee',selectedEmployee);
        console.log("Asta a bagat: "+JSON.parse(localStorage.getItem("selectedEmployee")).username);

        navigate('/user/make-appointment');//,{state:{selectedEmployee}}
    }

    useEffect(() => {

        // localStorage.setItem("selectedEmployee",selectedEmployee);
        // localStorage.setItem("selectedEmployee",selectedEmployee);
        // console.log("useEffect:" + selectedEmployee);

        axios
            .get('http://localhost:8080/employee/getDepartments')
            .then(response => {
                localStorage.setItem('departments', JSON.stringify(response.data));
                setDepartments(response.data);
            });

        axios
            .get('http://localhost:8080/employee/getEmployees')
            .then(response => {
                localStorage.setItem('employees', JSON.stringify(response.data));
                setEmployees(response.data);
            });
    }, []);

    return (
        <div>
        <Navbar bg="dark" variant="dark">
            <Container>
                <Navbar.Brand href="/user/">Customer</Navbar.Brand>
                <Nav className="me-auto">
                    <Nav.Link href="/user/software-department">Software</Nav.Link>
                    <Nav.Link href="/user/consulting-department">Consulting</Nav.Link>
                    <Nav.Link href="/user/hardware-department">Hardware</Nav.Link>
                    <Nav.Link href="/user/department4-department">Dept4</Nav.Link>
                </Nav>
            </Container>
        </Navbar>
        <Outlet />
        {
            <Row xs={1} md={2} className="g-4">
                {
                    departments.map(department => {
                        return (
                            <div key={department.departmentName}>
                                    <Col>
                                        <Card border={'dark'}>
                                            <Card.Body>
                                                <Card.Title>{department.departmentName}</Card.Title>
                                                {
                                                    <Row xs={1} md={2} className="g-4">
                                                        {
                                                            employees.map(employee => {
                                                                if(employee.departmentEntity.departmentName === department.departmentName)
                                                                return (
                                                                    <div key={employee.name}>
                                                                        <Col>
                                                                            <Card bg={'dark'} text={'white'} >
                                                                                <Card.Body>
                                                                                    <Card.Title>{employee.name}</Card.Title>

                                                                                    {/*<Card.Text>*/}
                                                                                    {/*    ceva text*/}
                                                                                    {/*</Card.Text>*/}

                                                                                    <Button variant="secondary"
                                                                                            onClick={
                                                                                                () =>
                                                                                                {
                                                                                                    toMakeAppointment(employee);
                                                                                                }
                                                                                            }
                                                                                    >
                                                                                        Make an appointment
                                                                                    </Button>
                                                                                </Card.Body>
                                                                            </Card>
                                                                        </Col>
                                                                    </div>
                                                                );
                                                            })
                                                        }
                                                    </Row>
                                                }
                                                {/*<Button variant="primary">Go somewhere</Button>*/}
                                            </Card.Body>
                                        </Card>
                                    </Col>
                            </div>
                        );
                    })
                }
            </Row>
        }
        </div>
    );
}
