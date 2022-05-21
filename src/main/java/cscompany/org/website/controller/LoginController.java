package cscompany.org.website.controller;

import cscompany.org.website.model.dto.LoginDTO;
import cscompany.org.website.model.dto.UserDataDTO;
import cscompany.org.website.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserDataService userDataService;

    @PostMapping("")
    public ResponseEntity<UserDataDTO> login(@RequestBody(required = false) LoginDTO loginDTO) throws Exception {
        System.out.println("a ajuns aici");
        return new ResponseEntity<>(userDataService.logIn(loginDTO), HttpStatus.CREATED);
    }
}
