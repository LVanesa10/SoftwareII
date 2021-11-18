import React from 'react'

export default function Navigation() {
    return (
        <Navbar bg="dark" variant="dark" expand="Ig">
            <Navbar.Brand>React Java</Navbar.Brand>
            <Navbar.Collapse id="main menu">
                <Nav className="mr-auto">
                    <Nav.Link>Create Post</Nav.Link>
                    <Nav></Nav>
                    <Nav.Link>Create Cuenta</Nav.Link>
                    <NavDropdown title="Vanessa Vanegas" id="menu-dropdown"></NavDropdown>
                </Nav>
            </Navbar.Collapse>
        </Navbar>
    )
}
