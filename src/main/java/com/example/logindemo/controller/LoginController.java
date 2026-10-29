package com.example.logindemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    // Hardcoded sample credentials. Replace with real authentication
    // (e.g. Spring Security + a UserDetailsService backed by a database)
    // for anything beyond a demo.
    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "password123";

    /**
     * Landing page on application start: shows the login form.
     */
    @GetMapping("/")
    public String index() {
        return "login";
    }

    /**
     * Explicit /login GET in case someone navigates here directly
     * (e.g. after logging out).
     */
    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    /**
     * Handles the login form submission.
     */
    @PostMapping("/login")
    public String doLogin(@RequestParam("username") String username,
                           @RequestParam("password") String password,
                           HttpSession session,
                           Model model) {

        if (VALID_USERNAME.equals(username) && VALID_PASSWORD.equals(password)) {
            session.setAttribute("loggedInUser", username);
            return "redirect:/success";
        }

        model.addAttribute("error", "Invalid username or password. Please try again.");
        return "login";
    }

    /**
     * Success page shown after a valid login.
     */
    @GetMapping("/success")
    public String success(HttpSession session, Model model) {
        Object user = session.getAttribute("loggedInUser");

        if (user == null) {
            // No active session -> send back to login instead of showing success
            return "redirect:/";
        }

        model.addAttribute("username", user);
        return "success";
    }

    /**
     * Simple logout: clears the session and returns to login.
     */
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
