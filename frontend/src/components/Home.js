import React from 'react';
import '../css/Home.css';
import { Container, Nav, Navbar, Card, NavLink } from 'react-bootstrap';
import {Outlet} from 'react-router-dom';
import logo from "../resources/images/logo.png"

export default function Home () {
    return (
        <div>
            <Navbar bg="dark" variant="dark">
                <Container>

                    <Navbar.Brand href="/home">CsCompany</Navbar.Brand>
                    <img
                        src = {logo}
                        width = "32"
                        height = "32"
                    />
                    <Nav className="me-auto">
                        <Nav.Link href="/home/user/register">Register</Nav.Link>
                        <Nav.Link eventKey={2} href="/home/login">Login</Nav.Link>
                    </Nav>
                </Container>
            </Navbar>

            <Card className="Home">
                <Card.Body>Bine ai venit la CsCompany</Card.Body>
            </Card>

            <Outlet />
        </div>
    );

}