import React, { useState } from "react";
import {Form, Button,} from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import "../css/FormStyle.css";
import axios from "axios";

function Register() {
    const [userInfo, setUserInfo] = useState({
        name: "",
        phone: "",
        username: "",
        password: "",
        confirmPassword: "",
        email: ""
    });

    const [error, setError] = useState("");

    const navigate = useNavigate();

    function goToLogIn() {
        navigate("/home/login");
    }

    function validateForm() {
        return userInfo.username.length > 0 &&
            userInfo.password.length > 0 &&
            userInfo.name.length > 0 &&
            userInfo.password.length > 0 &&
            userInfo.email.length > 0 &&
            userInfo.confirmPassword === userInfo.password;
    }

    function handleChange(event) {
        const {name, value} = event.target
        setUserInfo(prevState => {
            return {
                ...prevState,
                [name]: value
            };
        })
        console.log(userInfo);
    }

    function handleChangeEmail(event) {
        console.log(event.target.value);
        const {name, value} = event.target
        setUserInfo(prevState => {
            return {
                ...prevState,
                [name]: value
            };
        })
        console.log(userInfo)
    }

    const registerCustomer = async(userInfo) => {
        await axios
            .post("http://localhost:8080/user/register", userInfo)
            .then((response) => {
                console.info(response);
                goToLogIn();
            })
            .catch((error) => {
                setError(error.response.data.message);
                console.error("There was an error!", error.response.data.message)
            });
    }

    function handleSubmit(event) {
        registerCustomer(userInfo);
        console.log(userInfo);
        event.preventDefault();
    }

    return (
        <div className="FormStyle">
            <Form onSubmit={handleSubmit}>
                <Form.Group size="lg" controlId="formBasicName" className="mb-3">
                    <Form.Label>Full Name</Form.Label>
                    <Form.Control autoFocus name="name" type="text" value={userInfo.name} onChange={handleChange} />
                </Form.Group>

                <Form.Group size="lg" controlId="formBasicPhone" className="mb-3">
                    <Form.Label>Phone</Form.Label>
                    <Form.Control name="phone" type="text" value={userInfo.phone} onChange={handleChange} />
                </Form.Group>

                <Form.Group size="lg" controlId="formBasicUsername" className="mb-3">
                    <Form.Label>Username</Form.Label>
                    <Form.Control name="username" type="username" value={userInfo.username} onChange={handleChange}/>
                </Form.Group>

                <Form.Group size="lg" className="mb-3" controlId="formBasicPassword">
                    <Form.Label>Password</Form.Label>
                    <Form.Control name="password" type="password" value={userInfo.password} onChange={handleChange}/>
                </Form.Group>

                <Form.Group size="lg" className="mb-3" controlId="formBasicConfirmPassword">
                    <Form.Label>Confirm Password</Form.Label>
                    <Form.Control name="confirmPassword" type="password" value={userInfo.confirmPassword} onChange={handleChange}/>
                </Form.Group>

                <Form.Group size="lg" className="mb-3" controlId="formBasicEmail">
                    <Form.Label>Email</Form.Label>
                    <Form.Control name="email" type="text" value={userInfo.email} onChange={handleChangeEmail}/>
                </Form.Group>

                {/*<div>*/}
                {/*    <select value={emailState.zone.idZone} onChange={handleSelect}>*/}
                {/*        {zones.map(zone =>*/}
                {/*            <option value={zone.idZone} key={zone.idZone}>{zone.name}</option>*/}
                {/*        )}*/}
                {/*    </select>*/}
                {/*</div>*/}

                <br/>

                <text style={{color: 'red', justifyContent: 'center', display: 'flex'}}>
                    {error}
                </text>

                <Button variant="button" block size="lg" type="submit" disabled={!validateForm()}>
                    Register
                </Button>
            </Form>
        </div>
    );
}

export default Register;