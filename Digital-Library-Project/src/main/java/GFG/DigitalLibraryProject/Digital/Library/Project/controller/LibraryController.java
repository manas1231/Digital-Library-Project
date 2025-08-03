package GFG.DigitalLibraryProject.Digital.Library.Project.controller;

import jakarta.servlet.http.HttpServletRequest;
//import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LibraryController {

    @GetMapping("/")
    public String homePage()
    {
        return "Welcome to Digital Library Project";
    }
//    @GetMapping("/csrf")
//    public CsrfToken getCsrfToken(HttpServletRequest request) {
//        return (CsrfToken) request.getAttribute("_csrf");
//    }

}
